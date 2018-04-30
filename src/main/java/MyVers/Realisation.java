package MyVers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Этот класс будет наследоваться от TemplateAlgorithm и будет применен паттерн
 * "Template(Шаблон)"
 * 
 * @author Влад
 * @version 0.05 New: 
 *                   - добавлен метод runAlgorithm
 *                   - добавлен метод hasMoreCitiesToGo
 *                   - готова первая версия цикла алгоритма(одноразовая)
 * TO DO: 1) refactoring
 *        2) обновление феромонов
 */
public class Realisation {

    public static final int ALPHA = 1;//жадность, где 0 - выбор где поближе
    public static final int BETA = 1;//если = 0, то игнорируем расстояние
    int[][] roadLength = {
    {0, 38, 74, 59, 45},
    {38, 0, 46, 61, 72},
    {74, 46, 0, 49, 85},
    {59, 61, 49, 0, 42},
    {45, 72, 85, 42, 0}};
    int[][] roadPheromone = {
    {0, 3, 2, 2, 2},
    {3, 0, 1, 1, 1},
    {2, 1, 0, 2, 2},
    {2, 1, 2, 0, 1},
    {2, 1, 2, 1, 0}};
    static final int CITIES = 5;
    static final int ANTS = 5;
    static final int TIME = 200;
    double[] sumProbability = new double[CITIES];
    static boolean[] visitedCities = new boolean[CITIES];
    static double[][] probabilities = new double[CITIES][CITIES];

    /**
     *
     * 1) Сделать поиск вероятностей только для одного города(текущего)(DONE)
     * 2) Реализовать выбор города из вероятностей (DONE)
     * 3) Реализовать проверку города, посетил ли муравей его, 
     *    держать массив для каждого муравья (HALF DONE)
     */
    
    /**
     * Initializing array of visited cities. Default with false
     */
    public void initialization() {
        for (int i = 0; i < visitedCities.length; i++) {
            visitedCities[i] = false;
        }
    }

    /**
     * Метод расчитывает вероятность попасть в каждый из городов
     *
     * @param currentCity текущий город 
     */
    public void getProbabilityForCity(int currentCity) {
//        for (int i = 0; i < CITIES; i++) {
        visitedCities[currentCity] = true;//?IDK

        for (int j = 0; j < CITIES; j++) {
            if (visitedCities[j] == false) {
                probabilities[currentCity][j] = 100 * ((Math.pow(roadPheromone[currentCity][j], ALPHA) / (Math.pow(roadLength[currentCity][j], BETA)))
                        / (sumProbability[currentCity]));
            } else {
                probabilities[currentCity][j] = 0;
            }
            System.out.print(probabilities[currentCity][j] + " ");
        }
        System.out.println("");
    }

    /**
     * Выбирается следующий город для посещения
     *
     * @param currentCity текущий город, отсчет с нуля
     * @return возвращает номер города, отсчет с нуля 
     */
    public int chooseCity(int currentCity) {
        ArrayList<Double> probabsForChoose = new ArrayList<>();
        for (int i = 0; i < CITIES; i++) {
            probabsForChoose.add(probabilities[currentCity][i]);
        }
        Collections.sort(probabsForChoose);
        System.out.println(probabsForChoose);

        Random random = new Random();
        int randomValue = random.nextInt(100);
        //System.out.println("Random value: " + randomValue);
        double city = Collections.max(probabsForChoose);
        double ender = probabsForChoose.get(1);
        //System.out.println("first ender : "+ender);
        for (int i = 0; i < CITIES; i++) {
            //System.out.println("текущий i: "+i);
            //Если i = последнему, выбираем последний город
            //System.out.println(probabsForChoose.get(i)+" and "+ender);
            if (i == CITIES - 1) {
                city = probabsForChoose.get(probabsForChoose.size() - 1);
                break;
            //Если случайное число попадает в отрезок
            } else if (randomValue > probabsForChoose.get(i) && randomValue < ender) {
                city = probabsForChoose.get(i + 1);
                break;
            }
            //Правый край отрезка для сравнения
            ender = ender + probabsForChoose.get(i + 2);
            //System.out.println("ENDER: "+ender);
        }
        //System.out.println("Value of city: " + city);
        for (int i = 0; i < CITIES; i++) {
            //Ищем город по вероятности
            //Если вероятность совпала, выбираем этот город
            if (probabilities[currentCity][i] == city) {
                visitedCities[i]=true;
                return i;
            }
        }

        return 12;
    }

//    }
    /**
     * Updating sums of probabilities to go to another unvisited city
     * Use after updating pheromones
     */
    public void updateSumProbability(int currentCity) {
        visitedCities[currentCity] = true;//FOR EXAMPLE
        
        System.out.println("Visited cities: " + Arrays.toString(visitedCities));
        for(int k=0;k<5;k++){
            sumProbability[k]=0;
        }
        int i = currentCity;
        for (int j = 0; j < 5; j++) {
                if (visitedCities[j] != true) {
                    sumProbability[i] = sumProbability[i] + (Math.pow(roadPheromone[i][j], ALPHA) / Math.pow(roadLength[i][j], BETA));
                }
            }
        //Для дебага
//            for (i = 0; i < CITIES; i++) {
//                System.out.println("Summary probabilities to visit " + i + " city: " + sumProbability[i]);
//            }
        
    }
    /**
     * Запускает полный цикл алгоритма по поиску города
     * @param startingCity начальный город
     */
    public static void runAlgorithm(int startingCity) {
        Realisation mv = new Realisation();
        mv.initialization();
        int i = 0;
        int selectedCity = startingCity;
        ArrayList<Integer> travel = new ArrayList<>();
        travel.add(startingCity + 1);
        while (hasMoreCitiesToGo()) {

            mv.updateSumProbability(selectedCity);
            mv.getProbabilityForCity(selectedCity);
            selectedCity = mv.chooseCity(selectedCity);
            if (selectedCity == 12) {
                break;
            }
            System.out.println("THE NEXT CITY IS: " + selectedCity + "[0-" + (CITIES - 1) + "]");
            travel.add(selectedCity + 1);
            System.out.println("-----------------------------------------------------------------");
        }
        System.out.print("THE TRAVEL IS:");
        for (Integer city : travel) {
            System.out.print(" -> "+ city);
        }
    }
    /**
     * Проверяем, остались ли еще непосещенные города
     * @return true или false
     */
    public static boolean hasMoreCitiesToGo() {
        for (int i = 0; i < visitedCities.length; i++) {
            if (visitedCities[i] == false) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        runAlgorithm(0);
    }
}
