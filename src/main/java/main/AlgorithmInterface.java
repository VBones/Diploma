package main;

import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Интерфейс для муравьиного алгоритма
 * @author Влад
 */
public final class AlgorithmInterface extends javax.swing.JFrame {

    private boolean checkBoxFlag = false;
    private ArrayList<JTextField> inputFields;
    private ArrayList<JTextField> dependedFields;
    private JTextField[][] tFieldArr;
    private int[][] matrixValues;
    private StringBuilder way;
    private StringBuilder way2;
    private boolean isFirstDone;
    private boolean isSecondDone;
    private int[][] randomMatrix;
    private boolean isDone;
    
    
    /**
     * Creates new form AlgorithmInterface
     */
    public AlgorithmInterface() {
        setLocationRelativeTo(null);
        initComponents();
        fillArrayLists();
        disablePaste();
        addDocumentListenersToFields();
    }
    /**
     * Заполняет ArrayList-ы полями
     */
    public void fillArrayLists() {
        inputFields = new ArrayList<>();
        dependedFields = new ArrayList<>();
        tFieldArr = new JTextField[10][10];
        
        tFieldArr[0][0] = fieldNumber00;
        tFieldArr[0][1] = fieldNumber01;
        tFieldArr[0][2] = fieldNumber02;
        tFieldArr[0][3] = fieldNumber03;
        tFieldArr[0][4] = fieldNumber04;
        tFieldArr[0][5] = fieldNumber05;
        tFieldArr[0][6] = fieldNumber06;
        tFieldArr[0][7] = fieldNumber07;
        tFieldArr[0][8] = fieldNumber08;
        tFieldArr[0][9] = fieldNumber09;
        tFieldArr[1][0] = fieldNumber10;
        tFieldArr[1][1] = fieldNumber11;
        tFieldArr[1][2] = fieldNumber12;
        tFieldArr[1][3] = fieldNumber13;
        tFieldArr[1][4] = fieldNumber14;
        tFieldArr[1][5] = fieldNumber15;
        tFieldArr[1][6] = fieldNumber16;
        tFieldArr[1][7] = fieldNumber17;
        tFieldArr[1][8] = fieldNumber18;
        tFieldArr[1][9] = fieldNumber19;
        tFieldArr[2][0] = fieldNumber20;
        tFieldArr[2][1] = fieldNumber21;
        tFieldArr[2][2] = fieldNumber22;
        tFieldArr[2][3] = fieldNumber23;
        tFieldArr[2][4] = fieldNumber24;
        tFieldArr[2][5] = fieldNumber25;
        tFieldArr[2][6] = fieldNumber26;
        tFieldArr[2][7] = fieldNumber27;
        tFieldArr[2][8] = fieldNumber28;
        tFieldArr[2][9] = fieldNumber29;
        tFieldArr[3][0] = fieldNumber30;
        tFieldArr[3][1] = fieldNumber31;
        tFieldArr[3][2] = fieldNumber32;
        tFieldArr[3][3] = fieldNumber33;
        tFieldArr[3][4] = fieldNumber34;
        tFieldArr[3][5] = fieldNumber35;
        tFieldArr[3][6] = fieldNumber36;
        tFieldArr[3][7] = fieldNumber37;
        tFieldArr[3][8] = fieldNumber38;
        tFieldArr[3][9] = fieldNumber39;
        tFieldArr[4][0] = fieldNumber40;
        tFieldArr[4][1] = fieldNumber41;
        tFieldArr[4][2] = fieldNumber42;
        tFieldArr[4][3] = fieldNumber43;
        tFieldArr[4][4] = fieldNumber44;
        tFieldArr[4][5] = fieldNumber45;
        tFieldArr[4][6] = fieldNumber46;
        tFieldArr[4][7] = fieldNumber47;
        tFieldArr[4][8] = fieldNumber48;
        tFieldArr[4][9] = fieldNumber49;
        tFieldArr[5][0] = fieldNumber50;
        tFieldArr[5][1] = fieldNumber51;
        tFieldArr[5][2] = fieldNumber52;
        tFieldArr[5][3] = fieldNumber53;
        tFieldArr[5][4] = fieldNumber54;
        tFieldArr[5][5] = fieldNumber55;
        tFieldArr[5][6] = fieldNumber56;
        tFieldArr[5][7] = fieldNumber57;
        tFieldArr[5][8] = fieldNumber58;
        tFieldArr[5][9] = fieldNumber59;
        tFieldArr[6][0] = fieldNumber60;
        tFieldArr[6][1] = fieldNumber61;
        tFieldArr[6][2] = fieldNumber62;
        tFieldArr[6][3] = fieldNumber63;
        tFieldArr[6][4] = fieldNumber64;
        tFieldArr[6][5] = fieldNumber65;
        tFieldArr[6][6] = fieldNumber66;
        tFieldArr[6][7] = fieldNumber67;
        tFieldArr[6][8] = fieldNumber68;
        tFieldArr[6][9] = fieldNumber69;
        tFieldArr[7][0] = fieldNumber70;
        tFieldArr[7][1] = fieldNumber71;
        tFieldArr[7][2] = fieldNumber72;
        tFieldArr[7][3] = fieldNumber73;
        tFieldArr[7][4] = fieldNumber74;
        tFieldArr[7][5] = fieldNumber75;
        tFieldArr[7][6] = fieldNumber76;
        tFieldArr[7][7] = fieldNumber77;
        tFieldArr[7][8] = fieldNumber78;
        tFieldArr[7][9] = fieldNumber79;
        tFieldArr[8][0] = fieldNumber80;
        tFieldArr[8][1] = fieldNumber81;
        tFieldArr[8][2] = fieldNumber82;
        tFieldArr[8][3] = fieldNumber83;
        tFieldArr[8][4] = fieldNumber84;
        tFieldArr[8][5] = fieldNumber85;
        tFieldArr[8][6] = fieldNumber86;
        tFieldArr[8][7] = fieldNumber87;
        tFieldArr[8][8] = fieldNumber88;
        tFieldArr[8][9] = fieldNumber89;
        tFieldArr[9][0] = fieldNumber90;
        tFieldArr[9][1] = fieldNumber91;
        tFieldArr[9][2] = fieldNumber92;
        tFieldArr[9][3] = fieldNumber93;
        tFieldArr[9][4] = fieldNumber94;
        tFieldArr[9][5] = fieldNumber95;
        tFieldArr[9][6] = fieldNumber96;
        tFieldArr[9][7] = fieldNumber97;
        tFieldArr[9][8] = fieldNumber98;
        tFieldArr[9][9] = fieldNumber99;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                inputFields.add(tFieldArr[i][j]);
                dependedFields.add(tFieldArr[j][i]);
            }
        }
    }
    /**
     * Добавляет слушателей событий для полей ввода
     */
    public void addDocumentListenersToFields() {
        for (int i = 0; i < inputFields.size(); i++) {
            addDocumentUpdate(inputFields.get(i), dependedFields.get(i));
        }
    }
    /**
     * Добавляет слушатель для поля, который при вводе значения дублирует его 
     * в зеркальном поле матрицы
     * @param changingField поле, в которое вводится значение
     * @param dependedField поле, зависящее от вводимого значения
     */
    public void addDocumentUpdate(JTextField changingField, JTextField dependedField) {
        changingField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
//                dependedField.setText(changingField.getText());
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
//                dependedField.setText(changingField.getText());
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }
    /**
     * Отключает вставку для полей ввода
     */
    public void disablePaste() {
        for(JTextField field : inputFields){
            field.setTransferHandler(null);
        }
    }
    
    /**
     * Обработчик события ввода значений, запрещает ввод не цифровых значений
     * @param evt событие ввода
     */
    public void keyTypedEvent(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        functionalPanel = new javax.swing.JPanel();
        chooseFileButton = new javax.swing.JButton();
        random100Button = new javax.swing.JButton();
        matrixBox = new javax.swing.JComboBox<>();
        startButton = new javax.swing.JButton();
        randomNumber = new javax.swing.JTextField();
        resultPanel = new javax.swing.JPanel();
        resultLabel = new javax.swing.JLabel();
        saveResultButton = new javax.swing.JButton();
        doneLabel = new javax.swing.JLabel();
        expectedLabel = new javax.swing.JLabel();
        matrixPanel = new javax.swing.JPanel();
        fieldNumber00 = new javax.swing.JTextField();
        fieldNumber01 = new javax.swing.JTextField();
        fieldNumber02 = new javax.swing.JTextField();
        fieldNumber10 = new javax.swing.JTextField();
        fieldNumber11 = new javax.swing.JTextField();
        fieldNumber12 = new javax.swing.JTextField();
        fieldNumber03 = new javax.swing.JTextField();
        fieldNumber13 = new javax.swing.JTextField();
        fieldNumber20 = new javax.swing.JTextField();
        fieldNumber21 = new javax.swing.JTextField();
        fieldNumber22 = new javax.swing.JTextField();
        fieldNumber23 = new javax.swing.JTextField();
        fieldNumber33 = new javax.swing.JTextField();
        fieldNumber32 = new javax.swing.JTextField();
        fieldNumber31 = new javax.swing.JTextField();
        fieldNumber30 = new javax.swing.JTextField();
        fieldNumber04 = new javax.swing.JTextField();
        fieldNumber14 = new javax.swing.JTextField();
        fieldNumber24 = new javax.swing.JTextField();
        fieldNumber34 = new javax.swing.JTextField();
        fieldNumber40 = new javax.swing.JTextField();
        fieldNumber41 = new javax.swing.JTextField();
        fieldNumber42 = new javax.swing.JTextField();
        fieldNumber43 = new javax.swing.JTextField();
        fieldNumber44 = new javax.swing.JTextField();
        fieldNumber05 = new javax.swing.JTextField();
        fieldNumber15 = new javax.swing.JTextField();
        fieldNumber25 = new javax.swing.JTextField();
        fieldNumber35 = new javax.swing.JTextField();
        fieldNumber45 = new javax.swing.JTextField();
        fieldNumber55 = new javax.swing.JTextField();
        fieldNumber54 = new javax.swing.JTextField();
        fieldNumber53 = new javax.swing.JTextField();
        fieldNumber52 = new javax.swing.JTextField();
        fieldNumber50 = new javax.swing.JTextField();
        fieldNumber51 = new javax.swing.JTextField();
        fieldNumber65 = new javax.swing.JTextField();
        fieldNumber64 = new javax.swing.JTextField();
        fieldNumber63 = new javax.swing.JTextField();
        fieldNumber62 = new javax.swing.JTextField();
        fieldNumber61 = new javax.swing.JTextField();
        fieldNumber60 = new javax.swing.JTextField();
        fieldNumber06 = new javax.swing.JTextField();
        fieldNumber16 = new javax.swing.JTextField();
        fieldNumber26 = new javax.swing.JTextField();
        fieldNumber36 = new javax.swing.JTextField();
        fieldNumber46 = new javax.swing.JTextField();
        fieldNumber56 = new javax.swing.JTextField();
        fieldNumber66 = new javax.swing.JTextField();
        fieldNumber74 = new javax.swing.JTextField();
        fieldNumber76 = new javax.swing.JTextField();
        fieldNumber75 = new javax.swing.JTextField();
        fieldNumber70 = new javax.swing.JTextField();
        fieldNumber71 = new javax.swing.JTextField();
        fieldNumber72 = new javax.swing.JTextField();
        fieldNumber73 = new javax.swing.JTextField();
        fieldNumber77 = new javax.swing.JTextField();
        fieldNumber67 = new javax.swing.JTextField();
        fieldNumber57 = new javax.swing.JTextField();
        fieldNumber47 = new javax.swing.JTextField();
        fieldNumber37 = new javax.swing.JTextField();
        fieldNumber27 = new javax.swing.JTextField();
        fieldNumber17 = new javax.swing.JTextField();
        fieldNumber07 = new javax.swing.JTextField();
        fieldNumber86 = new javax.swing.JTextField();
        fieldNumber87 = new javax.swing.JTextField();
        fieldNumber80 = new javax.swing.JTextField();
        fieldNumber81 = new javax.swing.JTextField();
        fieldNumber82 = new javax.swing.JTextField();
        fieldNumber83 = new javax.swing.JTextField();
        fieldNumber84 = new javax.swing.JTextField();
        fieldNumber85 = new javax.swing.JTextField();
        fieldNumber88 = new javax.swing.JTextField();
        fieldNumber09 = new javax.swing.JTextField();
        fieldNumber19 = new javax.swing.JTextField();
        fieldNumber29 = new javax.swing.JTextField();
        fieldNumber39 = new javax.swing.JTextField();
        fieldNumber49 = new javax.swing.JTextField();
        fieldNumber59 = new javax.swing.JTextField();
        fieldNumber69 = new javax.swing.JTextField();
        fieldNumber79 = new javax.swing.JTextField();
        fieldNumber78 = new javax.swing.JTextField();
        fieldNumber68 = new javax.swing.JTextField();
        fieldNumber58 = new javax.swing.JTextField();
        fieldNumber48 = new javax.swing.JTextField();
        fieldNumber38 = new javax.swing.JTextField();
        fieldNumber28 = new javax.swing.JTextField();
        fieldNumber18 = new javax.swing.JTextField();
        fieldNumber08 = new javax.swing.JTextField();
        fieldNumber89 = new javax.swing.JTextField();
        fieldNumber90 = new javax.swing.JTextField();
        fieldNumber91 = new javax.swing.JTextField();
        fieldNumber92 = new javax.swing.JTextField();
        fieldNumber93 = new javax.swing.JTextField();
        fieldNumber94 = new javax.swing.JTextField();
        fieldNumber95 = new javax.swing.JTextField();
        fieldNumber96 = new javax.swing.JTextField();
        fieldNumber97 = new javax.swing.JTextField();
        fieldNumber98 = new javax.swing.JTextField();
        fieldNumber99 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(465, 500));
        setResizable(false);

        functionalPanel.setBackground(new java.awt.Color(204, 204, 204));
        functionalPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        functionalPanel.setMinimumSize(new java.awt.Dimension(465, 0));
        functionalPanel.setPreferredSize(new java.awt.Dimension(472, 40));

        chooseFileButton.setText("Выбрать файл");
        chooseFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileButtonActionPerformed(evt);
            }
        });

        random100Button.setText("Сгенерировать");
        random100Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                random100ButtonActionPerformed(evt);
            }
        });

        matrixBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5х5", "10х10" }));
        matrixBox.setSelectedIndex(1);
        matrixBox.setToolTipText("");
        matrixBox.setMinimumSize(new java.awt.Dimension(65, 32));
        matrixBox.setPreferredSize(new java.awt.Dimension(65, 32));
        matrixBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                matrixBoxItemStateChanged(evt);
            }
        });

        startButton.setText("СТАРТ");
        startButton.setMaximumSize(new java.awt.Dimension(90, 32));
        startButton.setMinimumSize(new java.awt.Dimension(88, 32));
        startButton.setPreferredSize(new java.awt.Dimension(88, 32));
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        randomNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout functionalPanelLayout = new javax.swing.GroupLayout(functionalPanel);
        functionalPanel.setLayout(functionalPanelLayout);
        functionalPanelLayout.setHorizontalGroup(
            functionalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionalPanelLayout.createSequentialGroup()
                .addComponent(chooseFileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(randomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(random100Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matrixBox, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        functionalPanelLayout.setVerticalGroup(
            functionalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, functionalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(random100Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(chooseFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(randomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(matrixBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        resultPanel.setBackground(new java.awt.Color(204, 204, 204));
        resultPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        resultPanel.setMaximumSize(new java.awt.Dimension(1000, 300));
        resultPanel.setMinimumSize(new java.awt.Dimension(465, 110));
        resultPanel.setPreferredSize(new java.awt.Dimension(465, 110));

        resultLabel.setForeground(new java.awt.Color(0, 0, 0));
        resultLabel.setMaximumSize(new java.awt.Dimension(470, 16));
        resultLabel.setMinimumSize(new java.awt.Dimension(470, 16));
        resultLabel.setPreferredSize(new java.awt.Dimension(470, 16));

        saveResultButton.setText("Сохранить результат");
        saveResultButton.setEnabled(false);
        saveResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveResultButtonActionPerformed(evt);
            }
        });

        expectedLabel.setForeground(new java.awt.Color(0, 0, 0));
        expectedLabel.setMaximumSize(new java.awt.Dimension(470, 16));
        expectedLabel.setMinimumSize(new java.awt.Dimension(470, 16));
        expectedLabel.setPreferredSize(new java.awt.Dimension(470, 16));

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanelLayout.createSequentialGroup()
                .addGroup(resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(expectedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(saveResultButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addGroup(resultPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(expectedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveResultButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(doneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        matrixPanel.setFocusable(false);
        matrixPanel.setRequestFocusEnabled(false);

        fieldNumber00.setEditable(false);
        fieldNumber00.setText("0");
        fieldNumber00.setFocusable(false);
        fieldNumber00.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber00.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber00.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber00.setRequestFocusEnabled(false);

        fieldNumber01.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber01.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber01.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber01.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber02.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber02.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber02.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber02.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber10.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber10.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber10.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber11.setEditable(false);
        fieldNumber11.setText("0");
        fieldNumber11.setFocusable(false);
        fieldNumber11.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber11.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber11.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber11.setRequestFocusEnabled(false);

        fieldNumber12.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber12.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber12.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber03.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber03.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber03.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber03.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber13.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber13.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber13.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber20.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber20.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber20.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber21.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber21.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber21.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber22.setEditable(false);
        fieldNumber22.setText("0");
        fieldNumber22.setFocusable(false);
        fieldNumber22.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber22.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber22.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber22.setRequestFocusEnabled(false);

        fieldNumber23.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber23.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber23.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber33.setEditable(false);
        fieldNumber33.setText("0");
        fieldNumber33.setFocusable(false);
        fieldNumber33.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber33.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber33.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber33.setRequestFocusEnabled(false);

        fieldNumber32.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber32.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber32.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber32.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber31.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber31.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber31.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber31.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber30.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber30.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber30.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber30.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber04.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber04.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber04.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber04.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber14.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber14.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber14.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber24.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber24.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber24.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber34.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber34.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber34.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber34.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber40.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber40.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber40.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber40.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber41.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber41.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber41.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber41.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber42.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber42.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber42.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber42.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber43.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber43.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber43.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber43.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber44.setEditable(false);
        fieldNumber44.setText("0");
        fieldNumber44.setFocusable(false);
        fieldNumber44.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber44.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber44.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber44.setRequestFocusEnabled(false);

        fieldNumber05.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber05.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber05.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber05.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber15.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber15.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber15.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber25.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber25.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber25.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber35.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber35.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber35.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber35.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber45.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber45.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber45.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber45.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber55.setEditable(false);
        fieldNumber55.setText("0");
        fieldNumber55.setFocusable(false);
        fieldNumber55.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber55.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber55.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber55.setRequestFocusEnabled(false);

        fieldNumber54.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber54.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber54.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber54.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber53.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber53.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber53.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber53.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber52.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber52.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber52.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber52.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber50.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber50.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber50.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber50.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber51.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber51.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber51.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber51.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber65.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber65.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber65.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber65.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber64.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber64.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber64.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber64.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber63.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber63.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber63.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber63.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber62.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber62.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber62.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber62.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber61.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber61.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber61.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber61.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber60.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber60.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber60.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber60.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber06.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber06.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber06.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber06.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber16.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber16.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber16.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber26.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber26.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber26.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber36.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber36.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber36.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber36.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber46.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber46.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber46.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber46.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber56.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber56.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber56.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber56.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber66.setEditable(false);
        fieldNumber66.setText("0");
        fieldNumber66.setFocusable(false);
        fieldNumber66.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber66.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber66.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber66.setRequestFocusEnabled(false);

        fieldNumber74.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber74.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber74.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber74.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber76.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber76.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber76.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber76.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber75.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber75.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber75.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber75.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber70.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber70.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber70.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber70.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber71.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber71.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber71.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber71.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber72.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber72.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber72.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber72.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber73.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber73.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber73.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber73.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber77.setEditable(false);
        fieldNumber77.setText("0");
        fieldNumber77.setFocusable(false);
        fieldNumber77.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber77.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber77.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber77.setRequestFocusEnabled(false);

        fieldNumber67.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber67.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber67.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber67.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber57.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber57.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber57.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber57.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber47.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber47.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber47.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber47.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber37.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber37.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber37.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber37.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber27.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber27.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber27.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber17.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber17.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber17.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber07.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber07.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber07.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber07.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber86.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber86.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber86.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber86.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber87.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber87.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber87.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber87.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber80.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber80.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber80.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber80.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber81.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber81.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber81.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber81.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber82.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber82.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber82.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber82.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber83.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber83.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber83.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber83.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber84.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber84.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber84.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber84.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber85.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber85.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber85.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber85.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber88.setEditable(false);
        fieldNumber88.setText("0");
        fieldNumber88.setFocusable(false);
        fieldNumber88.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber88.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber88.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber88.setRequestFocusEnabled(false);

        fieldNumber09.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber09.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber09.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber09.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber19.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber19.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber19.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber29.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber29.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber29.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber39.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber39.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber39.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber39.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber49.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber49.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber49.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber49.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber59.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber59.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber59.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber59.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber69.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber69.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber69.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber69.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber79.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber79.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber79.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber79.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber78.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber78.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber78.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber78.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber68.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber68.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber68.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber68.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber58.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber58.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber58.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber58.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber48.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber48.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber48.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber48.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber38.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber38.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber38.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber38.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber28.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber28.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber28.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber18.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber18.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber18.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber08.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber08.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber08.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber08.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber89.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber89.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber89.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber89.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber90.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber90.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber90.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber90.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber91.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber91.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber91.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber91.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber92.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber92.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber92.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber92.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber93.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber93.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber93.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber93.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber94.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber94.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber94.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber94.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber95.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber95.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber95.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber95.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber96.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber96.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber96.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber96.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber97.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber97.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber97.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber97.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber98.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber98.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber98.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber98.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumberKeyTyped(evt);
            }
        });

        fieldNumber99.setEditable(false);
        fieldNumber99.setText("0");
        fieldNumber99.setFocusable(false);
        fieldNumber99.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber99.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber99.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber99.setRequestFocusEnabled(false);

        javax.swing.GroupLayout matrixPanelLayout = new javax.swing.GroupLayout(matrixPanel);
        matrixPanel.setLayout(matrixPanelLayout);
        matrixPanelLayout.setHorizontalGroup(
            matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matrixPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addComponent(fieldNumber40, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber41, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber42, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addComponent(fieldNumber50, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber51, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(fieldNumber52, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addComponent(fieldNumber43, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber44, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addComponent(fieldNumber53, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(fieldNumber54, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addComponent(fieldNumber00, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber01, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber02, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber03, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber04, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addComponent(fieldNumber10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addComponent(fieldNumber20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber21, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber22, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber23, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addComponent(fieldNumber80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber82, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber83, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber84, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addComponent(fieldNumber30, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber31, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber32, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber33, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber34, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addComponent(fieldNumber60, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(fieldNumber61, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber62, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(fieldNumber63, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(fieldNumber64, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addComponent(fieldNumber70, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber71, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber74, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addComponent(fieldNumber90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber92, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber93, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber94, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNumber35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(fieldNumber45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldNumber55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNumber05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNumber06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber66, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fieldNumber07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber67, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fieldNumber77, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addComponent(fieldNumber85, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber86, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber87, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fieldNumber08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber58, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber68, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fieldNumber78, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fieldNumber09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber69, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fieldNumber79, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber88, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber89, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addComponent(fieldNumber75, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber76, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addComponent(fieldNumber95, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(fieldNumber96, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber97, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber98, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber99, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        matrixPanelLayout.setVerticalGroup(
            matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, matrixPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addComponent(fieldNumber05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNumber15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNumber25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNumber35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addComponent(fieldNumber06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldNumber46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldNumber56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addComponent(fieldNumber07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addComponent(fieldNumber09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNumber77, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber79, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(matrixPanelLayout.createSequentialGroup()
                                        .addGap(180, 180, 180)
                                        .addComponent(fieldNumber65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(fieldNumber75, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fieldNumber76, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                            .addComponent(fieldNumber08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fieldNumber18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fieldNumber28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fieldNumber38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fieldNumber48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fieldNumber58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fieldNumber68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(matrixPanelLayout.createSequentialGroup()
                                            .addGap(210, 210, 210)
                                            .addComponent(fieldNumber78, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNumber85, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fieldNumber86, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber87, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber88, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber89, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNumber99, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber97, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber95, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber96, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber98, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNumber00, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber01, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber02, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber03, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber04, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNumber10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNumber20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNumber33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(matrixPanelLayout.createSequentialGroup()
                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldNumber44, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber43, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber42, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber41, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber40, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldNumber54, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber53, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber52, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber51, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber50, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(matrixPanelLayout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fieldNumber63, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber64, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fieldNumber60, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber62, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber61, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fieldNumber70, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber71, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fieldNumber74, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNumber80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fieldNumber82, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber83, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber84, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNumber90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fieldNumber92, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldNumber91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldNumber93, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldNumber94, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(functionalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
            .addComponent(matrixPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(resultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(functionalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matrixPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(resultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Считывает матрицу с файла и вызывает алгоритм
     * @param evt событие
     */
    private void chooseFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileButtonActionPerformed
        saveResultButton.setEnabled(false);
        expectedLabel.setVisible(false);
        int[][] matrix;
        int elementsTaken = 0;
        int size;
        JFileChooser fileOpener = new JFileChooser();
        
        int openFileResult = fileOpener.showDialog(null, "Открыть файл");
        
        if (openFileResult == JFileChooser.APPROVE_OPTION) {
            File file = fileOpener.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String[] line = reader.readLine().split(" ");
                size = line.length;
                matrix = new int[line.length][line.length];

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
                matrixValues = matrix;
                way = Algorithm.getShortestWay(matrix, size);
                saveResultButton.setEnabled(true);
                resultLabel.setText(way.toString());
                doneLabel.setText("");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AlgorithmInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AlgorithmInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException | NullPointerException ex) {
                resultLabel.setText("Указанный файл содержит неверные данные!");
            } catch (Exception ex) {
                resultLabel.setText(ex.getMessage());
            }
        }
    }//GEN-LAST:event_chooseFileButtonActionPerformed

    private void random100ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_random100ButtonActionPerformed
        try {
            doneLabel.setText("");
            expectedLabel.setText("");
            expectedLabel.setVisible(true);
            int inSize = Integer.parseInt(randomNumber.getText());
            if (inSize < 5) {
                inSize = 5;
            }
            Random rnd = new Random();
            randomMatrix = new int[inSize][inSize];
            boolean[] used = new boolean[inSize];
            //Заполняем матрицу рандомными большими числами
            for (int i = 0; i < randomMatrix.length; i++) {
                for (int j = 0; j < randomMatrix.length; j++) {
                    if (i != j) {
                        randomMatrix[i][j] = rnd.nextInt(500) + 500;
                    } else {
                        randomMatrix[i][j] = 0;
                    }
                }
            }
            StringBuilder expectedWay = new StringBuilder();
            int to = 0;
            //Генерируем случайный путь
            expectedWay.append("Подготовленный заранее путь: "+(to + 1)+" -> ");
            for (int i = 0; i < inSize; i++) {
                if (i == inSize - 1) {
                    randomMatrix[to][0] = 1;
                    expectedWay.append((to + 1));
                    break;
                }
                while (true) {
                    int number = rnd.nextInt(inSize - 1) + 1;
                    if (randomMatrix[to][number] != 0 && used[number] == false && randomMatrix[number][to] != 1) {
                        randomMatrix[to][number] = 1;
                        used[number] = true;
                        expectedWay.append((number + 1)+" -> ");
                        to = number;
                        break;
                    }
                }
            }
//            System.out.println(expectedWay.toString());
            way = Algorithm.getShortestWay(randomMatrix, inSize);
//            System.out.println(way.toString());
            isDone = true;
//            
//            ArrayList<Integer> listTravel = Algorithm.getLiTravel();
//            for (int i = 0; i < listTravel.size(); i++) {
//                if (i == listTravel.size() - 1) {
//                    randomMatrix[listTravel.get(i)][listTravel.get(0)] = 1;
//                } else {
//                    randomMatrix[listTravel.get(i)][listTravel.get(i + 1)] = 1;
//                }
//            }ssss




            matrixValues = randomMatrix;
//            way = Algorithm.getShortestWay(matrixValues, inSize);
            resultLabel.setText(expectedWay.toString());
            expectedLabel.setText(way.toString());
            saveResultButton.setEnabled(true);
        } catch (Exception e) {
            resultLabel.setText(e.getMessage());
        }
    }//GEN-LAST:event_random100ButtonActionPerformed
    /**
     * Оставляет видимыми выбранные поля
     * @param evt 
     */
    private void matrixBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_matrixBoxItemStateChanged
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
    }//GEN-LAST:event_matrixBoxItemStateChanged

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
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
    }//GEN-LAST:event_startButtonActionPerformed

    private void fieldNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumberKeyTyped
        keyTypedEvent(evt);
    }//GEN-LAST:event_fieldNumberKeyTyped
    /**
     * Сохраняет результат работы алгоритма в отдельный файл
     * @param evt 
     */
    private void saveResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveResultButtonActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy' 'hh-mm-ss a");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        saveWayToFile(currentDate);
        saveMatrixToFile(currentDate);
    }//GEN-LAST:event_saveResultButtonActionPerformed

    private void saveMatrixToFile(String currentDate) {
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

    private void saveWayToFile(String currentDate) {
        try (FileOutputStream output = new FileOutputStream(new File("Решение " + currentDate + ".txt"))) {
            output.write(way.toString().getBytes());
            doneLabel.setText("Готово!");
        } catch (IOException e) {
            doneLabel.setText("Произошла ошибка =(");
        }
    }
   
    /**
     * Заполняет массив tFieldArr значениями с полей ввода и вызывает алгоритм
     * @param rowscols размерность матрицы
     * @throws NumberFormatException если не удастся преобразовать String в Integer
     */
    public void runAlgorithm(int rowscols) {
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
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlgorithmInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlgorithmInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlgorithmInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlgorithmInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlgorithmInterface().setVisible(true);
            }
        });
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseFileButton;
    private javax.swing.JLabel doneLabel;
    private javax.swing.JLabel expectedLabel;
    private javax.swing.JTextField fieldNumber00;
    private javax.swing.JTextField fieldNumber01;
    private javax.swing.JTextField fieldNumber02;
    private javax.swing.JTextField fieldNumber03;
    private javax.swing.JTextField fieldNumber04;
    private javax.swing.JTextField fieldNumber05;
    private javax.swing.JTextField fieldNumber06;
    private javax.swing.JTextField fieldNumber07;
    private javax.swing.JTextField fieldNumber08;
    private javax.swing.JTextField fieldNumber09;
    private javax.swing.JTextField fieldNumber10;
    private javax.swing.JTextField fieldNumber11;
    private javax.swing.JTextField fieldNumber12;
    private javax.swing.JTextField fieldNumber13;
    private javax.swing.JTextField fieldNumber14;
    private javax.swing.JTextField fieldNumber15;
    private javax.swing.JTextField fieldNumber16;
    private javax.swing.JTextField fieldNumber17;
    private javax.swing.JTextField fieldNumber18;
    private javax.swing.JTextField fieldNumber19;
    private javax.swing.JTextField fieldNumber20;
    private javax.swing.JTextField fieldNumber21;
    private javax.swing.JTextField fieldNumber22;
    private javax.swing.JTextField fieldNumber23;
    private javax.swing.JTextField fieldNumber24;
    private javax.swing.JTextField fieldNumber25;
    private javax.swing.JTextField fieldNumber26;
    private javax.swing.JTextField fieldNumber27;
    private javax.swing.JTextField fieldNumber28;
    private javax.swing.JTextField fieldNumber29;
    private javax.swing.JTextField fieldNumber30;
    private javax.swing.JTextField fieldNumber31;
    private javax.swing.JTextField fieldNumber32;
    private javax.swing.JTextField fieldNumber33;
    private javax.swing.JTextField fieldNumber34;
    private javax.swing.JTextField fieldNumber35;
    private javax.swing.JTextField fieldNumber36;
    private javax.swing.JTextField fieldNumber37;
    private javax.swing.JTextField fieldNumber38;
    private javax.swing.JTextField fieldNumber39;
    private javax.swing.JTextField fieldNumber40;
    private javax.swing.JTextField fieldNumber41;
    private javax.swing.JTextField fieldNumber42;
    private javax.swing.JTextField fieldNumber43;
    private javax.swing.JTextField fieldNumber44;
    private javax.swing.JTextField fieldNumber45;
    private javax.swing.JTextField fieldNumber46;
    private javax.swing.JTextField fieldNumber47;
    private javax.swing.JTextField fieldNumber48;
    private javax.swing.JTextField fieldNumber49;
    private javax.swing.JTextField fieldNumber50;
    private javax.swing.JTextField fieldNumber51;
    private javax.swing.JTextField fieldNumber52;
    private javax.swing.JTextField fieldNumber53;
    private javax.swing.JTextField fieldNumber54;
    private javax.swing.JTextField fieldNumber55;
    private javax.swing.JTextField fieldNumber56;
    private javax.swing.JTextField fieldNumber57;
    private javax.swing.JTextField fieldNumber58;
    private javax.swing.JTextField fieldNumber59;
    private javax.swing.JTextField fieldNumber60;
    private javax.swing.JTextField fieldNumber61;
    private javax.swing.JTextField fieldNumber62;
    private javax.swing.JTextField fieldNumber63;
    private javax.swing.JTextField fieldNumber64;
    private javax.swing.JTextField fieldNumber65;
    private javax.swing.JTextField fieldNumber66;
    private javax.swing.JTextField fieldNumber67;
    private javax.swing.JTextField fieldNumber68;
    private javax.swing.JTextField fieldNumber69;
    private javax.swing.JTextField fieldNumber70;
    private javax.swing.JTextField fieldNumber71;
    private javax.swing.JTextField fieldNumber72;
    private javax.swing.JTextField fieldNumber73;
    private javax.swing.JTextField fieldNumber74;
    private javax.swing.JTextField fieldNumber75;
    private javax.swing.JTextField fieldNumber76;
    private javax.swing.JTextField fieldNumber77;
    private javax.swing.JTextField fieldNumber78;
    private javax.swing.JTextField fieldNumber79;
    private javax.swing.JTextField fieldNumber80;
    private javax.swing.JTextField fieldNumber81;
    private javax.swing.JTextField fieldNumber82;
    private javax.swing.JTextField fieldNumber83;
    private javax.swing.JTextField fieldNumber84;
    private javax.swing.JTextField fieldNumber85;
    private javax.swing.JTextField fieldNumber86;
    private javax.swing.JTextField fieldNumber87;
    private javax.swing.JTextField fieldNumber88;
    private javax.swing.JTextField fieldNumber89;
    private javax.swing.JTextField fieldNumber90;
    private javax.swing.JTextField fieldNumber91;
    private javax.swing.JTextField fieldNumber92;
    private javax.swing.JTextField fieldNumber93;
    private javax.swing.JTextField fieldNumber94;
    private javax.swing.JTextField fieldNumber95;
    private javax.swing.JTextField fieldNumber96;
    private javax.swing.JTextField fieldNumber97;
    private javax.swing.JTextField fieldNumber98;
    private javax.swing.JTextField fieldNumber99;
    private javax.swing.JPanel functionalPanel;
    private javax.swing.JComboBox<String> matrixBox;
    private javax.swing.JPanel matrixPanel;
    private javax.swing.JButton random100Button;
    private javax.swing.JTextField randomNumber;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JButton saveResultButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
