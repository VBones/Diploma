package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Класс реализует муравьиный алгоритм, а также вспомогательные методы
 *
 * @author Влад Сморода
 */
public class Algorithm {

    private static final double ALPHA = 1;//жадность, где 0 - выбор где поближе
    private static final double BETA = 1;//если = 0, то игнорируем расстояние
    private static final double P = 0.2;//коэфициент испарения феромонов
    private static final double Q = 300;//коэфициент для нахождения феромона нового
    private static final int TIME = 200;
    private static int CITIES;
    
    private int[][] roadLength;
    private double[][] roadPheromone;
    private double[][] probabilities;
    private double[] sumProbability;
    private ArrayList<Integer> travel;
    private int lengthOfWay;
    private static ArrayList<Integer> listTravel;
    boolean[] visitedCities;

    public Algorithm(int cities) {
        CITIES = cities;
        sumProbability = new double[CITIES];
        visitedCities = new boolean[CITIES];
        probabilities = new double[CITIES][CITIES];
    }

    /**
     * Находит кратчайший путь
     *
     * @param input введенная матрица
     * @param size размерность матрицы
     * @return кратчайший путь
     */
    static StringBuilder getShortestWay(int[][] input, int size) {
        Algorithm algo;
        StringBuilder resultTravel;
        StringBuilder minWay = new StringBuilder();
        int minWayLength = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            algo = new Algorithm(size);
            algo.inputMatrix(input, size);
            for (int j = 0; j < TIME; j++) {
                algo.runAlgorithm(0);
            }
            resultTravel = new StringBuilder();
            resultTravel.append("Длина пути: ").append(algo.lengthOfWay).append(" | Путь:");
            for (Integer city : algo.travel) {
                resultTravel.append(" -> ").append(city + 1);
            }
            resultTravel.append(" -> ").append(algo.travel.get(0) + 1);
            if (algo.lengthOfWay < minWayLength) {
                minWayLength = algo.lengthOfWay;
                listTravel = algo.travel;
                minWay = resultTravel;
            }
        }
        return minWay;
    }

    /**
     * Запускает полный цикл алгоритма по поиску города и обновлению феромонов
     *
     * @param startingCity начальный город
     */
    private void runAlgorithm(int startingCity) {
        initializeVisitedCities();
        int selectedCity = startingCity;
        travel = new ArrayList<>();
        travel.add(startingCity);

        while (hasMoreCitiesToGo()) {
            updateSumProbability(selectedCity);
            getProbabilityForCity(selectedCity);
            selectedCity = chooseCity(selectedCity);
            if (selectedCity > 2000) {
                break;
            }
            travel.add(selectedCity);
        }
        setCompletedLength(travel.get(0), travel.get(travel.size() - 1));
        updatePheromones();
    }

    /**
     * Инциализирует массив посещенных городов 'false' значениями, а также длину пути
     * Initializing array of visited cities with false value, length of way.
     */
    public void initializeVisitedCities() {
        for (int i = 0; i < visitedCities.length; i++) {
            visitedCities[i] = false;
        }
        lengthOfWay = 0;
    }

    /**
     * Проверяем, остались ли еще непосещенные города
     *
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

    /**
     * Обновляет массив с сумарными вероятностями пойти в другой непосещенный город
     *
     * @param currentCity текущий город
     */
    private void updateSumProbability(int currentCity) {
        visitedCities[currentCity] = true;

        for (int k = 0; k < CITIES; k++) {
            sumProbability[k] = 0;
        }
        int i = currentCity;
        for (int j = 0; j < CITIES; j++) {
            if (visitedCities[j] != true) {
                sumProbability[i] = sumProbability[i] + (Math.pow(roadPheromone[i][j], ALPHA) / Math.pow(roadLength[i][j], BETA));
            }
        }
    }

    /**
     * Метод расчитывает вероятность попасть в каждый из городов
     *
     * @param currentCity текущий город
     */
    private void getProbabilityForCity(int currentCity) {
        for (int j = 0; j < CITIES; j++) {
            if (visitedCities[j] == false) {
                probabilities[currentCity][j] = 100 * ((Math.pow(roadPheromone[currentCity][j], ALPHA) / (Math.pow(roadLength[currentCity][j], BETA)))
                        / (sumProbability[currentCity]));
            } else {
                probabilities[currentCity][j] = 0;
            }
        }
    }

    /**
     * Выбирается следующий город для посещения
     *
     * @param currentCity текущий город, отсчет с нуля
     * @return возвращает номер города, отсчет с нуля
     */
    private int chooseCity(int currentCity) {
        ArrayList<Double> probabsForChoose = new ArrayList<>();
        for (int i = 0; i < CITIES; i++) {
            probabsForChoose.add(probabilities[currentCity][i]);
        }
        Collections.sort(probabsForChoose);

        Random random = new Random();
        int randomValue = random.nextInt(100);
        double city = Collections.max(probabsForChoose);
        double ender = probabsForChoose.get(1);
        for (int i = 0; i < CITIES; i++) {
            //Если i = последнему, выбираем последний город
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
        for (int i = 0; i < CITIES; i++) {
            //Ищем город по вероятности
            //Если вероятность совпала, выбираем этот город
            if (probabilities[currentCity][i] == city) {
                visitedCities[i] = true;
                lengthOfWay += roadLength[currentCity][i];
                return i;
            }
        }//end for
        return 2200;
    }

    /**
     * Назначаем длинну полного пути муравья.
     *
     * @param firstCity первый город
     * @param lastCity последний город
     */
    private void setCompletedLength(int firstCity, int lastCity) {
        lengthOfWay += roadLength[lastCity][firstCity];
    }

    /**
     * Обновляет значения феромонов
     */
    private void updatePheromones() {
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
     * Создаеются массивы длин и феромонов на основании введенной матрицы Массив
     * феромонов заполняется случайными значениями от 1 до 3
     *
     * @param matrix заданная матрица
     * @param size размерность матрицы
     */
    private void inputMatrix(int[][] matrix, int size) {
        CITIES = size;
        Random rnd = new Random();
        roadLength = new int[size][size];
        roadPheromone = new double[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                roadLength[r][c] = matrix[r][c];
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                roadPheromone[i][j] = rnd.nextInt(2) + 1;
            }
        }
    }

    static ArrayList getListTravel() {
        return listTravel;
    }
}
