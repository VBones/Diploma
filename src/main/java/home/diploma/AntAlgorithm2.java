/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Влад
 */
public class AntAlgorithm2 {
    public static final int ALPHA = 1;
    public static final int BETA = 1;
    int[] roadLength = {38, 74, 59, 45, 46, 61, 72, 49, 85, 42};
    int[] roadPheromone = {3, 2, 2, 2, 1, 1, 1, 2, 2, 1};
    static final int CITIES = 5;
    static final int ANTS = 5;
    static final int TIME = 200;
    
    static double rho = 0.01; // pheromone decrease factor
    static double Q = 2.0;   // pheromone increase factor
    
    
    public static void main(String[] args) {
        int[][] dists = makeGraphDistances();
        int[][] ants = initAnts();
        int[] bestTrail = BestTrail(ants, dists);
        double bestLength = Length(bestTrail, dists);
        double[][] pheromones = InitPheromones();
        int time = 0;
        while (time < TIME)
        {
          UpdateAnts(ants, pheromones, dists);
          UpdatePheromones(pheromones, ants, dists);

          int[] currBestTrail = BestTrail(ants, dists);
          double currBestLength = Length(currBestTrail, dists);
          if (currBestLength < bestLength)
          {
            bestLength = currBestLength;
            bestTrail = currBestTrail;
            //Console.WriteLine("New best length of " + bestLength.ToString("F1") + " found at time " + time);
          }
          ++time;
        }
        Display(bestTrail);
    }
    
    static void Display(int[] pheromones)
    {
      for (int i = 0; i < pheromones.length; ++i)
      {
          System.out.println(pheromones[i]);
      }

    }
    
    static void UpdatePheromones(double[][] pheromones, int[][] ants, int[][] dists)
    {
      for (int i = 0; i < pheromones.length; ++i)
      {
        for (int j = i + 1; j < pheromones[i].length; ++j)
        {
          for (int k = 0; k < ants.length; ++k)
          {
            double length = Length(ants[k], dists); // length of ant k trail
            double decrease = (1.0 - rho) * pheromones[i][j];
            double increase = 0.0;
            if (EdgeInTrail(i, j, ants[k]) == true) increase = (Q / length);

            pheromones[i][j] = decrease + increase;

            if (pheromones[i][j] < 0.0001)
              pheromones[i][j] = 0.0001;
            else if (pheromones[i][j] > 100000.0)
              pheromones[i][j] = 100000.0;

            pheromones[j][i] = pheromones[i][j];
          }
        }
      }
    }
    
    static boolean EdgeInTrail(int cityX, int cityY, int[] trail)
    {
      // are cityX and cityY adjacent to each other in trail[]?
      int lastIndex = trail.length - 1;
      int idx = IndexOfTarget(trail, cityX);

      if (idx == 0 && trail[1] == cityY) return true;
      else if (idx == 0 && trail[lastIndex] == cityY) return true;
      else if (idx == 0) return false;
      else if (idx == lastIndex && trail[lastIndex - 1] == cityY) return true;
      else if (idx == lastIndex && trail[0] == cityY) return true;
      else if (idx == lastIndex) return false;
      else if (trail[idx - 1] == cityY) return true;
      else if (trail[idx + 1] == cityY) return true;
      else return false;
    }
    
    void algorithm() {}
    
    static double[][] InitPheromones()
    {
      double[][] pheromones = new double[CITIES][];
      for (int i = 0; i < CITIES; ++i)
        pheromones[i] = new double[CITIES];
      for (int i = 0; i < pheromones.length; ++i)
        for (int j = 0; j < pheromones[i].length; ++j)
          pheromones[i][j] = 0.01; // otherwise first call to UpdateAnts -> BuiuldTrail -> NextNode -> MoveProbs => all 0.0 => throws
      return pheromones;
    }
//    void moveToTheCity(double reverseDistanceParam) {
//        double[] probability = new double[10];
//        for(int i = 0; i < 10; i++) {
//            probability[i] = 100*(Math.pow(BETA, 1/roadLength[i])*Math.pow(ALPHA, roadPheromone[i]))/
//                                 ()
//        }
//    }
    static int[][] makeGraphDistances() {
        Random rnd = new Random();
        int[][] dists = new int[CITIES][CITIES];
        for (int i = 0; i < dists.length; ++i) {
            dists[i] = new int[CITIES];
        }
        for (int i = 0; i < CITIES; ++i) {
            for (int j = i + 1; j < CITIES; ++j) {
                int d = rnd.nextInt(8) + 1;// [1,8]
                dists[i][j] = d;
                dists[j][i] = d;
            }
        }
        return dists;
    }
    
      static int[][] initAnts() {
          Random rnd = new Random();
      int[][] ants = new int[ANTS][];
      for (int k = 0; k < ANTS; ++k)
      {
        int start = rnd.nextInt(CITIES);
        ants[k] = RandomTrail(start, CITIES);
      }
      return ants;
    }
      
     static int[] RandomTrail(int start, int numCities) // helper for InitAnts
    {
         Random rnd = new Random();
        int[] trail = new int[CITIES];

        for (int i = 0; i < CITIES; ++i) {
            trail[i] = i;
        } // sequential

        for (int i = 0; i < CITIES; ++i) // Fisher-Yates shuffle
        {
            int r = rnd.nextInt(CITIES-i)+i;
            int tmp = trail[r];
            trail[r] = trail[i];
            trail[i] = tmp;
        }

        int idx = IndexOfTarget(trail, start); // put start at [0]
        int temp = trail[0];
        trail[0] = trail[idx];
        trail[idx] = temp;

        return trail;
    }
     
     static int IndexOfTarget(int[] trail, int target) // helper for RandomTrail
    {
      for (int i = 0; i < trail.length; ++i)
      {
        if (trail[i] == target)
          return i;
      }
      return 0;
     // throw new Exception("Target not found in IndexOfTarget");
    }
     
     static int[] BestTrail(int[][] ants, int[][] dists) // best trail has shortest total length
    {
      double bestLength = Length(ants[0], dists);
      int idxBestLength = 0;
      for (int k = 1; k < ants.length; ++k)
      {
        double len = Length(ants[k], dists);
        if (len < bestLength)
        {
          bestLength = len;
          idxBestLength = k;
        }
      }
      int numCities = ants.length;
      int[] bestTrail = new int[numCities];
      //ants[idxBestLength].CopyTo(bestTrail, 0);
      bestTrail = Arrays.copyOf(ants, ants.length-1);
      return bestTrail;
    }
     static double Length(int[] trail, int[][] dists) // total length of a trail
    {
      double result = 0.0;
      for (int i = 0; i < trail.length - 1; ++i)
        result += Distance(trail[i], trail[i + 1], dists);
      return result;
    }
     static double Distance(int cityX, int cityY, int[][] dists)
    {
      return dists[cityX][cityY];
    }
     
     static void UpdateAnts(int[][] ants, double[][] pheromones, int[][] dists)
    {
        Random rnd = new Random();
      int numCities = pheromones.length;
      for (int k = 0; k < ants.length; ++k)
      {
        int start = rnd.nextInt(numCities);
        int[] newTrail = BuildTrail(k, start, pheromones, dists);
        ants[k] = newTrail;
      }
    }
     static int[] BuildTrail(int k, int start, double[][] pheromones, int[][] dists)
    {
      int numCities = pheromones.length;
      int[] trail = new int[numCities];
      boolean[] visited = new boolean[numCities];
      trail[0] = start;
      visited[start] = true;
      for (int i = 0; i < numCities - 1; ++i)
      {
        int cityX = trail[i];
        int next = NextCity(k, cityX, visited, pheromones, dists);
        trail[i + 1] = next;
        visited[next] = true;
      }
      return trail;
    }
     
     static int NextCity(int k, int cityX, boolean[] visited, double[][] pheromones, int[][] dists)
    {
        Random rnd = new Random();
      // for ant k (with visited[]), at nodeX, what is next node in trail?
      double[] probs = MoveProbs(k, cityX, visited, pheromones, dists);

      double[] cumul = new double[probs.length + 1];
      for (int i = 0; i < probs.length; ++i)
        cumul[i + 1] = cumul[i] + probs[i]; // consider setting cumul[cuml.Length-1] to 1.00

      double p = rnd.nextDouble();

      for (int i = 0; i < cumul.length - 1; ++i)
        if (p >= cumul[i] && p < cumul[i + 1])
          return i;
      return 0;
      //throw new Exception("Failure to return valid city in NextCity");
    }
     
     static double[] MoveProbs(int k, int cityX, boolean[] visited, double[][] pheromones, int[][] dists)
    {
      // for ant k, located at nodeX, with visited[], return the prob of moving to each city
      int numCities = pheromones.length;
      double[] taueta = new double[numCities]; // inclues cityX and visited cities
      double sum = 0.0; // sum of all tauetas
      for (int i = 0; i < taueta.length; ++i) // i is the adjacent city
      {
        if (i == cityX)
          taueta[i] = 0.0; // prob of moving to self is 0
        else if (visited[i] == true)
          taueta[i] = 0.0; // prob of moving to a visited city is 0
        else
        {
          taueta[i] = Math.pow(pheromones[cityX][i], ALPHA) * Math.pow((1.0 / Distance(cityX, i, dists)), BETA); // could be huge when pheromone[][] is big
          if (taueta[i] < 0.0001){
            taueta[i] = 0.0001;
          }
          else if (taueta[i] > (Double.MAX_VALUE / (numCities * 100)))
            taueta[i] = Double.MAX_VALUE / (numCities * 100);
        }
        sum += taueta[i];
      }

      double[] probs = new double[numCities];
      for (int i = 0; i < probs.length; ++i)
        probs[i] = taueta[i] / sum; // big trouble if sum = 0.0
      return probs;
    }
}

