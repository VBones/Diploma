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
public abstract class TemplateAlgorithm {
    final void algorithm() {
        getProbabilityForCity(0);
        chooseCity(0);
        updatePheromones();
        buildWay();
    }
    
    abstract void getProbabilityForCity(int city);
    abstract int chooseCity(int currentCity);
    abstract void updatePheromones();
    abstract void buildWay();
    
}
