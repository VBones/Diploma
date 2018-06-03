package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JLabel;

/**
 * Класс для работы с файлами
 *
 * @author Влад Сморода
 */
class FileAction {

    /**
     * Читает матрицу из файла
     *
     * @param matrix матрица, в которую будет записана матрица из файла
     * @param line строка в файле
     * @param reader поток для чтения данных из файла
     * @param size размерность матрицы из файла
     * @throws Exception
     */
    static void readFromFile(int[][] matrix, String[] line, final BufferedReader reader, int size) throws Exception {
        int elementsTaken = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (elementsTaken < line.length) {
                    matrix[i][j] = Integer.parseInt(line[elementsTaken]);
                    elementsTaken++;
                }
            }
            //Если это была последняя строка, то выходим из цикла
            if (i == matrix.length - 1) {
                break;
            }
            line = reader.readLine().split(" ");
            if (line.length != size) {
                throw new Exception("<html>Неверное количество элементов матрицы!"
                        + "<br>Требуется " + size + " элементов! У вас: " + line.length + "!</html>");
            }
            elementsTaken = 0;
        }
    }

    /**
     * Сохраняет матрицу в файл
     *
     * @param currentDate текущая дата
     */
    static void saveMatrixToFile(String currentDate, int[][] matrixValues, JLabel doneLabel) {
        try (FileOutputStream output = new FileOutputStream(new File("Матрица решения " + currentDate + ".txt"))) {
            for (int i = 0; i < matrixValues.length; i++) {
                for (int j = 0; j < matrixValues.length; j++) {
                    output.write(((Integer.toString(matrixValues[i][j])) + "\t").getBytes());
                }
                output.write(System.getProperty("line.separator").getBytes());
            }
            doneLabel.setText("Готово!");
        } catch (IOException e) {
            doneLabel.setText("Произошла ошибка =(");
        }
    }

    /**
     * Сохраняет путь в файл
     *
     * @param currentDate текущая дата
     */
    static void saveWayToFile(String currentDate, StringBuilder way, JLabel doneLabel) {
        try (FileOutputStream output = new FileOutputStream(new File("Решение " + currentDate + ".txt"))) {
            output.write(way.toString().getBytes());
            doneLabel.setText("Готово!");
        } catch (IOException e) {
            doneLabel.setText("Произошла ошибка =(");
        }
    }
}
