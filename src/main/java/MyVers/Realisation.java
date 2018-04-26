/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Этот класс будет наследоваться от TemplateAlgorithm и будет применен паттерн "Template(Шаблон)"
 * @author Влад
 * @version 0.02
 * New:
 *     - добавлен метод выбора следующего города(в стадии разработки ещё)
 *     - выбран паттерн Шаблон для реализации в этом файле
 */
public class Realisation {

    public static final int ALPHA = 1;//жадность, где 0 - выбор где поближе
    public static final int BETA = 1;//если = 0, то игнорируем расстояние
    int[][] roadLength = {{0, 38, 74, 59, 45},
    {38, 0, 46, 61, 72},
    {74, 46, 0, 49, 85},
    {59, 61, 49, 0, 42},
    {45, 72, 85, 42, 0}};
    int[][] roadPheromone = {{0, 3, 2, 2, 2},
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
    * 1) Сделать поиск вероятностей только для одного города(текущего)
    * 2) Реализовать выбор города из вероятностей
    * 3) Реализовать проверку города, посетил ли муравей его, держать массив для каждого муравья
     */
    public void start() {
        visitedCities[0] = true;
        getProbabilityForCity(0);
    }
    /**
     * Метод расчитывает вероятность попасть в каждый из городов
     * @param city текущий город
     * ДОДЕЛАТЬ: опять же зависимость от List-а посещенных городов(булевский)
     */
    public void getProbabilityForCity(int city) {
//        for (int i = 0; i < CITIES; i++) {
        for (int j = 0; j < CITIES; j++) {
            if (city != j) {
                probabilities[city][j] = 100 * ((Math.pow(roadPheromone[city][j], ALPHA) / (Math.pow(roadLength[city][j], BETA)))
                        / (sumProbability[city]));
            }
            System.out.print(probabilities[city][j] + " ");
        }
        System.out.println("");
    }

    /**
     * Выбирается следующий город для посещения
     *
     * @param currentCity текущий город, отсчет с нуля
     * @return возвращает номер города, отсчет с нуля ДОДЕЛАТЬ: динамическое
     * количество городов, которое зависит от посещенных городов т.е. сделать
     * List булевский с городами, и тут его заюзать!
     */
    public int chooseCity(int currentCity) {
        ArrayList<Double> listOfProbs = new ArrayList<>();
        for (int i = 0; i < CITIES; i++) {
            listOfProbs.add(probabilities[currentCity][i]);
        }
        Collections.sort(listOfProbs);
        //System.out.println(listOfProbs);

        Random random = new Random();
        int value = random.nextInt(100);
        System.out.println("Random value: " + value);
        double city = Collections.max(listOfProbs);
        double summer = listOfProbs.get(1);
        for (int i = 0; i < CITIES; i++) {
            if (i == CITIES - 1) {
                city = listOfProbs.get(listOfProbs.size() - 1);
                break;
            } else if (value > listOfProbs.get(i) && value < summer) {
                city = listOfProbs.get(i + 1);
                break;
            }
            summer = summer + listOfProbs.get(i + 1);
        }
        System.out.println("Value of city: " + city);
        for (int i = 0; i < CITIES; i++) {
            if (probabilities[currentCity][i] == city) {
                return i;
            }
        }

        return 0;
    }

//    }
    /**
     * Обновляет суммы вероятностей перехода в каждый город Использовать после
     * обновления феромонов
     */
    public void updateSumProbability() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i != j) {
                    sumProbability[i] = sumProbability[i] + Math.pow(roadPheromone[i][j], ALPHA) / Math.pow(roadLength[i][j], BETA);
                }
            }
            for (i = 0; i < CITIES; i++) {
                System.out.println(sumProbability[i]);
            }
        }
    }

    public static void main(String[] args) {

        Realisation mv = new Realisation();
        mv.updateSumProbability();
        mv.getProbabilityForCity(0);
        int whatDatCity = mv.chooseCity(0);
        System.out.println("THE CITY IS: " + (whatDatCity));

    }
}
