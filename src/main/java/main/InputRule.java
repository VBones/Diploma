package main;

import com.sun.glass.events.KeyEvent;
import javax.swing.JTextField;

/**
 * Содержит методы, которые устанавливают правила для ввода матрицы
 *
 * @author Влад Сморода
 */
class InputRule {

    /**
     * Обработчик события ввода значений, запрещает ввод не цифровых значений
     *
     * @param evt событие ввода
     */
    static void keyTypedEvent(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    /**
     * Отключает вставку для полей ввода
     */
    static void disablePaste(JTextField[][] tFieldArr) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tFieldArr[i][j].setTransferHandler(null);
            }
        }
    }
}
