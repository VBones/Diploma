/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVers;
/**
 *
 * @author Влад
 */
public class MyVers {
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
    /*
    *
    * 1) Сделать поиск вероятностей только для одного города(текущего)
    * 2) Реализовать выбор города из вероятностей
    * 3) Реализовать проверку города, посетил ли муравей его, держать массив для каждого муравья
    */
    public void algorithm() {

        getProbabilityForCity();
    }

    public void getProbabilityForCity() {
        double[][] probabilities = new double[CITIES][CITIES];
        for (int i = 0; i < CITIES; i++) {
            for (int j = 0; j < CITIES; j++) {
                if (i == j) {
                } else {
                    probabilities[i][j] = 100 * ((Math.pow(roadPheromone[i][j], ALPHA) / (Math.pow(roadLength[i][j], BETA)))
                            / (sumProbability[i]));
                }
                System.out.print(probabilities[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public void setSumProbability() {

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

        MyVers mv = new MyVers();
        mv.setSumProbability();
        mv.algorithm();
        System.out.println(visitedCities[1]);
    }
}
