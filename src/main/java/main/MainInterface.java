package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 * Интерфейс для муравьиного алгоритма
 *
 * @author Влад Сморода
 */
public final class MainInterface extends javax.swing.JFrame {

    private JButton chooseFileButton;
    private JLabel doneLabel;
    private JLabel expectedLabel;
    private JPanel functionalPanel;
    private JComboBox<String> matrixBox;
    private JPanel matrixPanel;
    private JButton random100Button;
    private JTextField randomNumber;
    private JLabel resultLabel;
    private JPanel resultPanel;
    private JButton saveResultButton;
    private JButton startButton;
    
    private boolean checkBoxFlag = false;
    final JTextField[][] tFieldArr = new JTextField[10][10];
    int[][] matrixValues;
    StringBuilder way;
    protected int[][] randomMatrix;

    /**
     * Создает новую форму интерфейса
     */
    public MainInterface() {
        setLocationRelativeTo(null);
        initComponents();
        InputRule.disablePaste(tFieldArr);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        functionalPanel = new JPanel();
        chooseFileButton = new JButton();
        random100Button = new JButton();
        matrixBox = new JComboBox<>();
        startButton = new JButton();
        randomNumber = new JTextField();
        resultPanel = new JPanel();
        resultLabel = new JLabel();
        saveResultButton = new JButton();
        doneLabel = new JLabel();
        expectedLabel = new JLabel();
        matrixPanel = new JPanel();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tFieldArr[i][j] = new JTextField();
            }
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(465, 500));
        setResizable(false);

        functionalPanel.setBackground(new java.awt.Color(204, 204, 204));
        functionalPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        functionalPanel.setMinimumSize(new Dimension(465, 0));
        functionalPanel.setPreferredSize(new Dimension(472, 40));

        chooseFileButton.setText("Выбрать файл");
        chooseFileButton.addActionListener((ActionEvent evt) -> {
            chooseFileButtonActionPerformed(evt);
        });

        random100Button.setText("Сгенерировать");
        random100Button.addActionListener((ActionEvent evt) -> {
            randomButtonActionPerformed(evt);
        });

        matrixBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"5х5", "10х10"}));
        matrixBox.setSelectedIndex(1);
        matrixBox.setToolTipText("");
        matrixBox.setMinimumSize(new Dimension(65, 32));
        matrixBox.setPreferredSize(new Dimension(65, 32));
        matrixBox.addItemListener((java.awt.event.ItemEvent evt) -> {
            matrixBoxItemStateChanged(evt);
        });

        startButton.setText("СТАРТ");
        startButton.setMaximumSize(new Dimension(90, 32));
        startButton.setMinimumSize(new Dimension(88, 32));
        startButton.setPreferredSize(new Dimension(88, 32));
        startButton.addActionListener((ActionEvent evt) -> {
            startButtonActionPerformed(evt);
        });

        randomNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        GroupLayout functionalPanelLayout = new GroupLayout(functionalPanel);
        functionalPanel.setLayout(functionalPanelLayout);
        functionalPanelLayout.setHorizontalGroup(
                functionalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(functionalPanelLayout.createSequentialGroup()
                                .addComponent(chooseFileButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(randomNumber, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(random100Button)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(matrixBox, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addContainerGap())
        );
        functionalPanelLayout.setVerticalGroup(
                functionalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, functionalPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(random100Button, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(chooseFileButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(randomNumber, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(matrixBox, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
        );

        resultPanel.setBackground(new Color(204, 204, 204));
        resultPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        resultPanel.setMaximumSize(new Dimension(1000, 300));
        resultPanel.setMinimumSize(new Dimension(465, 110));
        resultPanel.setPreferredSize(new Dimension(465, 110));

        resultLabel.setForeground(new Color(0, 0, 0));
        resultLabel.setMaximumSize(new Dimension(470, 16));
        resultLabel.setMinimumSize(new Dimension(470, 16));
        resultLabel.setPreferredSize(new Dimension(470, 16));

        saveResultButton.setText("Сохранить результат");
        saveResultButton.setEnabled(false);
        saveResultButton.addActionListener((ActionEvent evt) -> {
            saveResultButtonActionPerformed(evt);
        });

        expectedLabel.setForeground(new Color(0, 0, 0));
        expectedLabel.setMaximumSize(new Dimension(470, 16));
        expectedLabel.setMinimumSize(new Dimension(470, 16));
        expectedLabel.setPreferredSize(new Dimension(470, 16));

        GroupLayout resultPanelLayout = new GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
                resultPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(resultPanelLayout.createSequentialGroup()
                                .addGroup(resultPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(expectedLabel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                                                .addGap(146, 146, 146)
                                                .addComponent(saveResultButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(doneLabel, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                                        .addGroup(resultPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(resultLabel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        resultPanelLayout.setVerticalGroup(
                resultPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(resultLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(expectedLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(resultPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(saveResultButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(doneLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        matrixPanel.setFocusable(false);
        matrixPanel.setRequestFocusEnabled(false);
        KeyAdapter keyListener = new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        };
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    tFieldArr[i][j].setEditable(false);
                    tFieldArr[i][j].setText("0");
                    tFieldArr[i][j].setFocusable(false);
                    tFieldArr[i][j].setRequestFocusEnabled(false);
                } else {
                    tFieldArr[i][j].addKeyListener(keyListener);
                }
                tFieldArr[i][j].setMaximumSize(new Dimension(34, 24));
                tFieldArr[i][j].setMinimumSize(new Dimension(34, 24));
                tFieldArr[i][j].setPreferredSize(new Dimension(34, 24));
            }
        }

        GroupLayout matrixPanelLayout = new GroupLayout(matrixPanel);
        matrixPanel.setLayout(matrixPanelLayout);
        matrixPanelLayout.setHorizontalGroup(
                matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addComponent(tFieldArr[4][0], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tFieldArr[4][1], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tFieldArr[4][2], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addComponent(tFieldArr[5][0], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tFieldArr[5][1], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(tFieldArr[5][2], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(12, 12, 12)
                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addComponent(tFieldArr[4][3], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tFieldArr[4][4], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addComponent(tFieldArr[5][3], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(tFieldArr[5][4], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addComponent(tFieldArr[0][0], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[0][1], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[0][2], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[0][3], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[0][4], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addComponent(tFieldArr[1][0], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[1][1], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[1][2], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[1][3], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[1][4], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addComponent(tFieldArr[2][0], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[2][1], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[2][2], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[2][3], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[2][4], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addComponent(tFieldArr[8][0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[8][1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[8][2], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[8][3], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[8][4], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addComponent(tFieldArr[3][0], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[3][1], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[3][2], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[3][3], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[3][4], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addComponent(tFieldArr[6][0], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(tFieldArr[6][1], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[6][2], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(tFieldArr[6][3], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(tFieldArr[6][4], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addComponent(tFieldArr[7][0], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[7][1], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[7][2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[7][3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[7][4], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addComponent(tFieldArr[9][0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[9][1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[9][2], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[9][3], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[9][4], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(tFieldArr[3][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tFieldArr[6][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(tFieldArr[4][5], GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tFieldArr[5][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tFieldArr[0][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[1][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[2][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tFieldArr[0][6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[1][6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[2][6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[3][6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[4][6], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[5][6], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[6][6], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(tFieldArr[0][7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[1][7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[2][7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[3][7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[4][7], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[5][7], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[6][7], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(tFieldArr[7][7], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addComponent(tFieldArr[8][5], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tFieldArr[8][6], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tFieldArr[8][7], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addGap(13, 13, 13)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(tFieldArr[0][8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[1][8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[2][8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[3][8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[4][8], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[5][8], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[6][8], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(tFieldArr[7][8], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(tFieldArr[0][9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[1][9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[2][9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[3][9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[4][9], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[5][9], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[6][9], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(tFieldArr[7][9], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tFieldArr[8][8], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tFieldArr[8][9], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addComponent(tFieldArr[7][5], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[7][6], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addComponent(tFieldArr[9][5], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(tFieldArr[9][6], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[9][7], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[9][8], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tFieldArr[9][9], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(10, Short.MAX_VALUE))
        );
        matrixPanelLayout.setVerticalGroup(
                matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, matrixPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addComponent(tFieldArr[0][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tFieldArr[1][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tFieldArr[2][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tFieldArr[3][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addComponent(tFieldArr[0][6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[1][6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[2][6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[3][6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(tFieldArr[4][6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[4][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(tFieldArr[5][6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[5][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[6][6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addComponent(tFieldArr[0][7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[1][7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[2][7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[3][7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[4][7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[5][7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[6][7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addComponent(tFieldArr[0][9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[1][9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[2][9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[3][9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[4][9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[5][9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tFieldArr[6][9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addGap(210, 210, 210)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tFieldArr[7][7], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[7][9], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                                .addGap(180, 180, 180)
                                                                                .addComponent(tFieldArr[6][5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(tFieldArr[7][5], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(tFieldArr[7][6], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                                        .addComponent(tFieldArr[0][8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(tFieldArr[1][8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(tFieldArr[2][8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(tFieldArr[3][8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(tFieldArr[4][8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(tFieldArr[5][8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(tFieldArr[6][8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                                        .addGap(210, 210, 210)
                                                                                        .addComponent(tFieldArr[7][8], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tFieldArr[8][5], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(tFieldArr[8][6], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[8][7], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[8][8], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[8][9], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tFieldArr[9][9], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[9][7], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[9][5], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[9][6], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[9][8], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tFieldArr[0][0], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[0][1], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[0][2], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[0][3], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[0][4], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tFieldArr[1][0], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[1][1], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[1][2], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[1][3], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[1][4], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tFieldArr[2][0], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[2][1], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[2][2], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[2][3], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[2][4], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tFieldArr[3][3], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[3][2], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[3][1], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[3][0], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tFieldArr[3][4], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addGap(120, 120, 120)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(tFieldArr[4][4], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[4][3], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[4][2], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[4][1], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[4][0], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(tFieldArr[5][4], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[5][3], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[5][2], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[5][1], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tFieldArr[5][0], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                                                .addGap(180, 180, 180)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(tFieldArr[6][3], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[6][4], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(tFieldArr[6][0], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[6][2], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[6][1], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(tFieldArr[7][0], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[7][1], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[7][2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(tFieldArr[7][4], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[7][3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tFieldArr[8][0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(tFieldArr[8][2], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[8][1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[8][3], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tFieldArr[8][4], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(tFieldArr[9][0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(matrixPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(tFieldArr[9][2], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(tFieldArr[9][1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(tFieldArr[9][3], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(tFieldArr[9][4], GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(functionalPanel, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                        .addComponent(matrixPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(resultPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(functionalPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(matrixPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(resultPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Считывает матрицу с файла и вызывает алгоритм
     *
     * @param evt событие
     */
    private void chooseFileButtonActionPerformed(ActionEvent evt) {
        saveResultButton.setEnabled(false);
        expectedLabel.setVisible(false);
        int[][] matrix;
        int size;
        JFileChooser fileOpener = new JFileChooser();

        int openFileResult = fileOpener.showDialog(null, "Открыть файл");

        if (openFileResult == JFileChooser.APPROVE_OPTION) {
            File file = fileOpener.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String[] line = reader.readLine().split(" ");
                size = line.length;
                matrix = new int[line.length][line.length];

                FileAction.readFromFile(matrix, line, reader, size);

                matrixValues = matrix;
                way = Algorithm.getShortestWay(matrix, size);
                saveResultButton.setEnabled(true);
                resultLabel.setText(way.toString());
                doneLabel.setText("");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException | NullPointerException ex) {
                resultLabel.setText("Указанный файл содержит неверные данные!");
            } catch (Exception ex) {
                resultLabel.setText(ex.getMessage());
            }
        }
    }

    /**
     * Создает матрицу указанной размерности, случайно заполняет её, и
     * генерирует кратчайший путь для неё.
     *
     * @param evt
     */
    private void randomButtonActionPerformed(ActionEvent evt) {
        try {
            doneLabel.setText("");
            expectedLabel.setText("");
            expectedLabel.setVisible(true);

            int inSize = 0;
            try {
                inSize = Integer.parseInt(randomNumber.getText());
            } catch (NumberFormatException ex) {
                throw new Exception("Введите размерность матрицы!");
            }
            if (inSize < 5) {
                inSize = 5;
            }
            Random rnd = new Random();
            randomMatrix = new int[inSize][inSize];
            boolean[] used = new boolean[inSize];

            RandomTest.randomFillMatrix(rnd, randomMatrix);
            StringBuilder expectedWay = RandomTest.prepareMatrix(randomMatrix, inSize, used, rnd);

            way = Algorithm.getShortestWay(randomMatrix, inSize);
            matrixValues = randomMatrix;
            resultLabel.setText(expectedWay.toString());
            expectedLabel.setText(way.toString());
            saveResultButton.setEnabled(true);
        } catch (Exception e) {
            resultLabel.setText(e.getMessage());
        }
    }

    /**
     * Оставляет видимыми выбранные поля
     *
     * @param evt
     */
    private void matrixBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        if (checkBoxFlag == true) {
            if (matrixBox.getSelectedIndex() == 0) {
                for (int r = 0; r < 10; r++) {
                    for (int c = 5; c < 10; c++) {
                        tFieldArr[r][c].setVisible(false);
                        tFieldArr[c][r].setVisible(false);
                        tFieldArr[r][c].setText("");
                    }
                }
                doneLabel.setText("");
            } else if (matrixBox.getSelectedIndex() == 1) {
                for (int r = 0; r < 10; r++) {
                    for (int c = 5; c < 10; c++) {
                        if (r != c) {
                            tFieldArr[r][c].setVisible(true);
                            tFieldArr[c][r].setVisible(true);
                            tFieldArr[r][c].setText("");
                        } else {
                            tFieldArr[r][c].setVisible(true);
                            tFieldArr[r][c].setText("0");
                            tFieldArr[r][c].setEditable(false);
                        }
                    }
                }
                doneLabel.setText("");
            }
            setSize(new Dimension(this.getWidth() + 1, this.getHeight() + 1));
            setSize(new Dimension(this.getWidth() - 1, this.getHeight() - 1));
        }
        checkBoxFlag = checkBoxFlag != true;
    }

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            expectedLabel.setVisible(false);
            doneLabel.setText("");
            if (matrixBox.getSelectedIndex() == 0) {
                runAlgorithm(5);
            } else if (matrixBox.getSelectedIndex() == 1) {
                runAlgorithm(10);
            }
        } catch (Exception e) {
            resultLabel.setText(e.getMessage());
        }
    }

    private void fieldNumberKeyTyped(java.awt.event.KeyEvent evt) {
        InputRule.keyTypedEvent(evt);
    }

    /**
     * Сохраняет результат работы алгоритма в отдельный файл
     *
     * @param evt
     */
    private void saveResultButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy' 'hh-mm-ss a");
        String currentDate = dateFormat.format(new Date());
        FileAction.saveWayToFile(currentDate, way, doneLabel);
        FileAction.saveMatrixToFile(currentDate, matrixValues, doneLabel);
    }

    /**
     * Заполняет массив tFieldArr значениями с полей ввода и вызывает алгоритм
     *
     * @param rowscols размерность матрицы
     * @throws NumberFormatException если не удастся преобразовать String в
     * Integer
     */
    void runAlgorithm(int rowscols) {
        int[][] matrix = new int[rowscols][rowscols];
        int r = 0;
        int c = 0;
        try {
            for (r = 0; r < rowscols; r++) {
                for (c = 0; c < rowscols; c++) {
                    if ((r == c) | (tFieldArr[r][c].getText().length() != 0 && Integer.parseInt(tFieldArr[r][c].getText()) != 0)) {
                        matrix[r][c] = Integer.parseInt(tFieldArr[r][c].getText());
                    } else {
                        matrix[r][c] = 1;
                    }
                }
            }
            matrixValues = matrix;
            way = Algorithm.getShortestWay(matrix, rowscols);
            saveResultButton.setEnabled(true);
            resultLabel.setText(way.toString());
        } catch (NumberFormatException e) {
            resultLabel.setText("Слишком большое значение в ячейке [" + (r + 1) + "][" + (c + 1) + "]");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Создание и отображение формы */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainInterface antinterface = new MainInterface();
                ImageIcon icon = new ImageIcon(getClass().getResource("/res/ant-icon.png"));
                antinterface.setIconImage(icon.getImage());
                antinterface.setTitle("Ant Algorithm");
                antinterface.setVisible(true);
            }
        });

    }
}
