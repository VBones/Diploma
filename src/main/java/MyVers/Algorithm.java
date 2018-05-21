package MyVers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Влад
 */
public class Algorithm {

    public static final double ALPHA = 1;//жадность, где 0 - выбор где поближе
    public static final double BETA = 1;//если = 0, то игнорируем расстояние
    public static final double P = 0.2;//коэфициент испарения феромонов
    public static final double Q = 300;//коэфициент для нахождения феромона нового
    static int CITIES;
    static final int TIME = 200;

    int[][] roadLength;
    double[][] roadPheromone;
    double[][] probabilities;
    double[] sumProbability;
    boolean[] visitedCities;
    ArrayList<Integer> travel;
    public int lengthOfWay;


    /**
     *
     * 1) РЕФАКТОРИТЬ КОД
     * 2) Поправить интерфейс
     * 3) Добавить сохранение матрицы в файл
     * 4) Вывод ошибок
     * 5) Создавать новый файл с датой(Готово)
     * 6) Перелопатить ввод с файла(Готово)
     */
    
    /**
     * Initializing array of visited cities with false value, length of way. 
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
//        System.out.println(probabsForChoose);

        Random random = new Random();
        int randomValue = random.nextInt(100);
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
        return 1200;
    }

    /**
     * Updating sums of probabilities to go to another unvisited city
     * Use after updating pheromones
     * @param currentCity текущий город
     */
    public void updateSumProbability(int currentCity) {
        visitedCities[currentCity] = true;//FOR EXAMPLE

        //System.out.println("Visited cities: " + Arrays.toString(visitedCities));
        for (int k = 0; k < CITIES; k++) {
            sumProbability[k] = 0;
        }
        int i = currentCity;
        for (int j = 0; j < CITIES; j++) {
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
        initialization();
        int selectedCity = startingCity;
        travel = new ArrayList<>();
        travel.add(startingCity);
        //System.out.println(Arrays.toString(visitedCities));
        while (hasMoreCitiesToGo()) {
            updateSumProbability(selectedCity);
            getProbabilityForCity(selectedCity);
            selectedCity = chooseCity(selectedCity);
            if (selectedCity == 999) {
                break;
            }
//            System.out.println("THE NEXT CITY IS: " + selectedCity + "[0-" + (CITIES - 1) + "]");
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
//        System.out.println("");
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
    
    public void inputMatrix(int[][] inputs, int size) {
        CITIES = size;
        Random rnd = new Random();
        roadLength = new int[size][size];
        roadPheromone = new double[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                roadLength[r][c] = inputs[r][c];
            }
        }
        for (int i = 0; i < size-1; i++) {
            for (int j = i + 1; j < size; j++) {
                roadPheromone[i][j] = rnd.nextInt(2) + 1;
                roadPheromone[j][i] = roadPheromone[i][j];
            }
        }
    }
    

    public Algorithm(int cities) {
        CITIES = cities;
        sumProbability = new double[CITIES];
        visitedCities = new boolean[CITIES];
        probabilities = new double[CITIES][CITIES];
    }
    
    public static StringBuilder getShortestWay(int[][] input, int size) {
        Algorithm algo;
        StringBuilder resultTravel;
        StringBuilder minWay = new StringBuilder();
        int minWayLength = Integer.MAX_VALUE;
//        ArrayList<StringBuilder> way = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            algo = new Algorithm(size);
            algo.inputMatrix(input, size);
            for (int j = 0; j < TIME; j++) {
                algo.runAlgorithm(0);
            }
            resultTravel = new StringBuilder();
            resultTravel.append("Длина пути: ").append(algo.lengthOfWay).append(" | Путь:");
            for (Integer city : algo.travel) {
                resultTravel.append(" -> ").append(city);
            }
            resultTravel.append(" -> ").append(algo.travel.get(0));
            if (algo.lengthOfWay < minWayLength) {
                minWayLength = algo.lengthOfWay;
                minWay = resultTravel;
            }
        }
        return minWay;
    }
}
