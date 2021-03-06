package main;

import java.util.Random;

/**
 * Содержит методы для тестирования алгоритма сгенерироваными матрицами
 *
 * @author Влад Сморода
 */
class RandomTest {

    /**
     * Заполняет матрицу случайными числами от 500 до 1000
     *
     * @param rnd генератор чисел
     */
    static void randomFillMatrix(Random rnd, int[][] randomMatrix) {
        //Заполняем матрицу рандомными большими числами
        for (int i = 0; i < randomMatrix.length; i++) {
            for (int j = 0; j < randomMatrix.length; j++) {
                if (i != j) {
                    randomMatrix[i][j] = rnd.nextInt(200) + 500;
                } else {
                    randomMatrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Случайно преобразует обычную матрицу в матрицу, с заранее известным
     * решением
     *
     * @param inSize размерность матрицы
     * @param rnd генератор чисел
     * @param used массив с использоваными позициями для пути
     * @return подготовленый путь
     */
    static StringBuilder prepareMatrix(int[][] randomMatrix, int inSize, boolean[] used, Random rnd) {
        StringBuilder expectedWay = new StringBuilder();
        StringBuilder expectedWay1 = new StringBuilder();
        int to = 0;
        int expWay = 0;
        //Генерируем случайный путь
        expectedWay1.append("| Путь: " + (to + 1) + " -> ");
        for (int i = 0; i < inSize; i++) {
            if (i == inSize - 1) {
                randomMatrix[to][0] = rnd.nextInt(9) + 1;
                expWay += randomMatrix[to][0];
                expectedWay1.append(1);
                break;
            }
            while (true) {
                int number = rnd.nextInt(inSize - 1) + 1;
                if (randomMatrix[to][number] != 0 && used[number] == false && randomMatrix[number][to] != 1) {
                    randomMatrix[to][number] = rnd.nextInt(9) + 1;
                    expWay += randomMatrix[to][number];
                    used[number] = true;
                    expectedWay1.append((number + 1) + " -> ");
                    to = number;
                    break;
                }
            }
        }
        expectedWay.append("Ожидаемая длина: " + expWay).append(expectedWay1);
        return expectedWay;
    }
}
