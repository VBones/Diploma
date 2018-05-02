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
 * @version 0.07 New: 
 *                   - настроены значения, проведены тесты, вроде более менее работает
 *                     50-60% самые короткие пути
 * TO DO: 1) ants(multi-threading)
 *        2) refactoring
 *        3) matrix input from keyboard into command line
 */
public class Realisation {

    public static final double ALPHA = 1;//жадность, где 0 - выбор где поближе
    public static final double BETA = 1;//если = 0, то игнорируем расстояние
    public static final double P = 0.2;//коэфициент испарения феромонов
    public static final double Q = 300;//коэфициент для нахождения феромона нового
    static final int CITIES = 5;
    static final int ANTS = 5;
    static final int TIME = 200;

    int[][] roadLength = {
        {0, 38, 74, 59, 45},
        {38, 0, 46, 61, 72},
        {74, 46, 0, 49, 85},
        {59, 61, 49, 0, 42},
        {45, 72, 85, 42, 0}};
    
    double[][] roadPheromone = {
        {0, 3, 2, 2, 2},
        {3, 0, 1, 1, 1},
        {2, 1, 0, 2, 2},
        {2, 1, 2, 0, 1},
        {2, 1, 2, 1, 0}};
    
    public int lengthOfWay;
    ArrayList<Integer> travel;
    double[] sumProbability = new double[CITIES];
    boolean[] visitedCities = new boolean[CITIES];
    double[][] probabilities = new double[CITIES][CITIES];

    /**
     *
     * 1) Сделать поиск вероятностей только для одного города(текущего)(DONE)
     * 2) Реализовать выбор города из вероятностей (DONE)
     * 3) Реализовать проверку города, посетил ли муравей его, 
     *    держать массив для каждого муравья (HALF DONE, bc ants is not added)
     */
    
    /**
     * Initializing array of visited cities. Default with false
     * +initialisation of lengthOfWay
     */
    public void initialization() {
        for (int i = 0; i < visitedCities.length; i++) {
            visitedCities[i] = false;
        }
        lengthOfWay = 0;
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
            //System.out.print(probabilities[currentCity][j] + " ");
        }
        //System.out.println("");
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
        //System.out.println(probabsForChoose);

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
            if (i == CITIES - 2) {
                ender = ender + probabsForChoose.get(probabsForChoose.size() - 1);
            } else {
                ender = ender + probabsForChoose.get(i + 2);
            }
            //System.out.println("ENDER: "+ender);
        }//end for
        //System.out.println("Value of city: " + city);
        for (int i = 0; i < CITIES; i++) {
            //Ищем город по вероятности
            //Если вероятность совпала, выбираем этот город
            if (probabilities[currentCity][i] == city) {
                visitedCities[i] = true;
                lengthOfWay += roadLength[currentCity][i];
                return i;
            }
        }//end for
        return 12;
    }

    /**
     * Updating sums of probabilities to go to another unvisited city
     * Use after updating pheromones
     * @param currentCity текущий город
     */
    public void updateSumProbability(int currentCity) {
        visitedCities[currentCity] = true;//FOR EXAMPLE

        //System.out.println("Visited cities: " + Arrays.toString(visitedCities));
        for (int k = 0; k < 5; k++) {
            sumProbability[k] = 0;
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
     * Запускает полный цикл алгоритма по поиску города и обновлению феромонов
     * @param startingCity начальный город
     */
    public void runAlgorithm(int startingCity) {
//        Realisation mv = new Realisation();
        initialization();
        int i = 0;
        int selectedCity = startingCity;
        travel = new ArrayList<>();
        travel.add(startingCity);
        while (hasMoreCitiesToGo()) {
            updateSumProbability(selectedCity);
            getProbabilityForCity(selectedCity);
            selectedCity = chooseCity(selectedCity);
            if (selectedCity == 12) {
                break;
            }
            //System.out.println("THE NEXT CITY IS: " + selectedCity + "[0-" + (CITIES - 1) + "]");
            travel.add(selectedCity);
            //System.out.println("-----------------------------------------------------------------");
        }
        getCompletedLength(travel.get(0), travel.get(travel.size() - 1));
//        System.out.print("THE TRAVEL IS:");
//        for (Integer city : travel) {
//            System.out.print(" -> " + city);
//        }
//        System.out.print(" -> " + travel.get(0));
        updatePheromones();
        //System.out.println("");
        //System.out.println("PHEROMONES:");
//        for (int k = 0; k < CITIES; k++) {
//            for (int j = 0; j < CITIES; j++) {
//                System.out.printf("%.2f\t", roadPheromone[k][j]);
//            }
//            System.out.println("");
//        }
        //System.out.println("LENGTH OF WAY: "+ lengthOfWay);
    }
    
    /**
     * Обновляет значения феромонов
     */
    public void updatePheromones() {
        double pieceOfPheromone = Q / lengthOfWay;
        for (int i = 0; i < CITIES; i++) {
            for (int j = 0; j < CITIES; j++) {
                roadPheromone[i][j] = roadPheromone[i][j] * (1 - P);
            }
        }
        int first = 0;
        int last = 1;
        for (int i = 0; i < CITIES; i++) {
            if (i == CITIES - 1) {
                roadPheromone[travel.get(travel.size() - 1)][travel.get(0)] += pieceOfPheromone;
            } else {
                roadPheromone[travel.get(first)][travel.get(last)] += pieceOfPheromone;
                first++;
                last++;
            }
        }
    }
    
    /**
     * Получаем длинну полного путя муравья. В будущем удалить метод, причина: быдло-код.
     * @param firstCity первый город
     * @param lastCity последний город
     */
    public void getCompletedLength(int firstCity, int lastCity) {
        lengthOfWay += roadLength[firstCity][lastCity];
    }
    
    /**
     * Проверяем, остались ли еще непосещенные города
     * @return true или false
     */
    public boolean hasMoreCitiesToGo() {
        for (int i = 0; i < visitedCities.length; i++) {
            if (visitedCities[i] == false) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Realisation mv = new Realisation();
        for(int i=0;i<300;i++){
            mv.runAlgorithm(0);
        }
        System.out.println(mv.lengthOfWay+"    mv1-100");
        Realisation mv2 = new Realisation();
        for(int i=0;i<300;i++){
            mv2.runAlgorithm(0);
        }
        System.out.println(mv2.lengthOfWay+"    mv2-100");
        Realisation mv3 = new Realisation();
        for(int i=0;i<300;i++){
            mv3.runAlgorithm(0);
        }
        System.out.println(mv3.lengthOfWay+"    mv3-100");
        Realisation mv4 = new Realisation();
        for(int i=0;i<300;i++){
            mv4.runAlgorithm(0);
        }
        System.out.println(mv4.lengthOfWay+"    mv4-100");
        Realisation mv5 = new Realisation();
        for(int i=0;i<300;i++){
            mv5.runAlgorithm(0);
        }
        System.out.println(mv5.lengthOfWay+"    mv5-100");
    }
}
