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
public class Ant {
    boolean[] cities;

    public Ant(int numOfCities, int startCity) {
        this.cities = new boolean[numOfCities];
        fillCities(startCity);
    }
    boolean isVisited(int i) {
        return cities[i];
    }
    private void fillCities(int startCity) {
        for(boolean city : cities) {
            city = false;
        }
        cities[startCity] = true;
    }
}
