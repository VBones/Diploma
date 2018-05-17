package MyVers;

import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
public final class InterfaceAnt extends javax.swing.JFrame {

    private boolean checkBoxFlag = false;
    private ArrayList<JTextField> inputFields;
    private ArrayList<JTextField> dependedFields;
    private ArrayList<JTextField> fields5x5;
    private ArrayList<JTextField> fields10x10;
    private  JTextField[][] tFieldArr;
    
    
    /**
     * Creates new form InterfaceAnt
     */
    public InterfaceAnt() {
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
        fields5x5 = new ArrayList<>();
        fields10x10 = new ArrayList<>();
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
//        inputFields.add(fieldNumber01);
//        inputFields.add(fieldNumber02);
//        inputFields.add(fieldNumber03);
//        inputFields.add(fieldNumber04);
//        inputFields.add(fieldNumber12);
//        inputFields.add(fieldNumber13);
//        inputFields.add(fieldNumber14);
//        inputFields.add(fieldNumber23);
//        inputFields.add(fieldNumber24);
//        inputFields.add(fieldNumber34);
        
//        dependedFields.add(fieldNumber10);
//        dependedFields.add(fieldNumber20);
//        dependedFields.add(fieldNumber30);
//        dependedFields.add(fieldNumber40);
//        dependedFields.add(fieldNumber21);
//        dependedFields.add(fieldNumber31);
//        dependedFields.add(fieldNumber41);
//        dependedFields.add(fieldNumber32);
//        dependedFields.add(fieldNumber42);
//        dependedFields.add(fieldNumber43);
        
        fields5x5.add(fieldNumber04);
        fields5x5.add(fieldNumber14);
        fields5x5.add(fieldNumber24);
        fields5x5.add(fieldNumber34);
        fields5x5.add(fieldNumber44);
        fields5x5.add(fieldNumber40);
        fields5x5.add(fieldNumber41);
        fields5x5.add(fieldNumber42);
        fields5x5.add(fieldNumber43);
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
                dependedField.setText(changingField.getText());
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                dependedField.setText(changingField.getText());
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
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE) || (vchar == '0')) {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
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
        startButton = new javax.swing.JButton();
        matrixBox = new javax.swing.JComboBox<>();
        fieldNumber04 = new javax.swing.JTextField();
        fieldNumber14 = new javax.swing.JTextField();
        fieldNumber24 = new javax.swing.JTextField();
        fieldNumber34 = new javax.swing.JTextField();
        fieldNumber40 = new javax.swing.JTextField();
        fieldNumber41 = new javax.swing.JTextField();
        fieldNumber42 = new javax.swing.JTextField();
        fieldNumber43 = new javax.swing.JTextField();
        fieldNumber44 = new javax.swing.JTextField();
        wayLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        random100Button = new javax.swing.JButton();
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
        chooseFileButton = new javax.swing.JButton();
        wayLabel3 = new javax.swing.JLabel();
        wayLabel4 = new javax.swing.JLabel();
        wayLabel2 = new javax.swing.JLabel();
        wayLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setFocusable(false);
        jPanel2.setRequestFocusEnabled(false);

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

        fieldNumber10.setEditable(false);
        fieldNumber10.setFocusable(false);
        fieldNumber10.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber10.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber10.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber10.setRequestFocusEnabled(false);

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

        fieldNumber20.setEditable(false);
        fieldNumber20.setFocusable(false);
        fieldNumber20.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber20.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber20.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber20.setRequestFocusEnabled(false);

        fieldNumber21.setEditable(false);
        fieldNumber21.setFocusable(false);
        fieldNumber21.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber21.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber21.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber21.setRequestFocusEnabled(false);

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

        fieldNumber32.setEditable(false);
        fieldNumber32.setFocusable(false);
        fieldNumber32.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber32.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber32.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber32.setRequestFocusEnabled(false);

        fieldNumber31.setEditable(false);
        fieldNumber31.setFocusable(false);
        fieldNumber31.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber31.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber31.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber31.setRequestFocusEnabled(false);

        fieldNumber30.setEditable(false);
        fieldNumber30.setFocusable(false);
        fieldNumber30.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber30.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber30.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber30.setRequestFocusEnabled(false);

        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StartButtonIcon.png"))); // NOI18N
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        matrixBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5х5", "10х10", " " }));
        matrixBox.setSelectedIndex(1);
        matrixBox.setToolTipText("");
        matrixBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                matrixBoxItemStateChanged(evt);
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

        fieldNumber40.setEditable(false);
        fieldNumber40.setFocusable(false);
        fieldNumber40.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber40.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber40.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber40.setRequestFocusEnabled(false);

        fieldNumber41.setEditable(false);
        fieldNumber41.setFocusable(false);
        fieldNumber41.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber41.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber41.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber41.setRequestFocusEnabled(false);

        fieldNumber42.setEditable(false);
        fieldNumber42.setFocusable(false);
        fieldNumber42.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber42.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber42.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber42.setRequestFocusEnabled(false);

        fieldNumber43.setEditable(false);
        fieldNumber43.setFocusable(false);
        fieldNumber43.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber43.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber43.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber43.setRequestFocusEnabled(false);

        fieldNumber44.setEditable(false);
        fieldNumber44.setText("0");
        fieldNumber44.setFocusable(false);
        fieldNumber44.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber44.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber44.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber44.setRequestFocusEnabled(false);

        wayLabel1.setText("WAY");
        wayLabel1.setMaximumSize(new java.awt.Dimension(400, 16));
        wayLabel1.setMinimumSize(new java.awt.Dimension(400, 16));
        wayLabel1.setPreferredSize(new java.awt.Dimension(400, 16));

        jLabel1.setText("RESULT SET:");

        random100Button.setText("GET100RANDOM");
        random100Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                random100ButtonActionPerformed(evt);
            }
        });

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

        fieldNumber54.setEditable(false);
        fieldNumber54.setFocusable(false);
        fieldNumber54.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber54.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber54.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber54.setRequestFocusEnabled(false);

        fieldNumber53.setEditable(false);
        fieldNumber53.setFocusable(false);
        fieldNumber53.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber53.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber53.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber53.setRequestFocusEnabled(false);

        fieldNumber52.setEditable(false);
        fieldNumber52.setFocusable(false);
        fieldNumber52.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber52.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber52.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber52.setRequestFocusEnabled(false);

        fieldNumber50.setEditable(false);
        fieldNumber50.setFocusable(false);
        fieldNumber50.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber50.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber50.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber50.setRequestFocusEnabled(false);

        fieldNumber51.setEditable(false);
        fieldNumber51.setFocusable(false);
        fieldNumber51.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber51.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber51.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber51.setRequestFocusEnabled(false);

        fieldNumber65.setEditable(false);
        fieldNumber65.setFocusable(false);
        fieldNumber65.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber65.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber65.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber65.setRequestFocusEnabled(false);

        fieldNumber64.setEditable(false);
        fieldNumber64.setFocusable(false);
        fieldNumber64.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber64.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber64.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber64.setRequestFocusEnabled(false);

        fieldNumber63.setEditable(false);
        fieldNumber63.setFocusable(false);
        fieldNumber63.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber63.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber63.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber63.setRequestFocusEnabled(false);

        fieldNumber62.setEditable(false);
        fieldNumber62.setFocusable(false);
        fieldNumber62.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber62.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber62.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber62.setRequestFocusEnabled(false);

        fieldNumber61.setEditable(false);
        fieldNumber61.setFocusable(false);
        fieldNumber61.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber61.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber61.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber61.setRequestFocusEnabled(false);

        fieldNumber60.setEditable(false);
        fieldNumber60.setFocusable(false);
        fieldNumber60.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber60.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber60.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber60.setRequestFocusEnabled(false);

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

        fieldNumber74.setEditable(false);
        fieldNumber74.setFocusable(false);
        fieldNumber74.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber74.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber74.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber74.setRequestFocusEnabled(false);

        fieldNumber76.setEditable(false);
        fieldNumber76.setFocusable(false);
        fieldNumber76.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber76.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber76.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber76.setRequestFocusEnabled(false);

        fieldNumber75.setEditable(false);
        fieldNumber75.setFocusable(false);
        fieldNumber75.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber75.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber75.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber75.setRequestFocusEnabled(false);

        fieldNumber70.setEditable(false);
        fieldNumber70.setFocusable(false);
        fieldNumber70.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber70.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber70.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber70.setRequestFocusEnabled(false);

        fieldNumber71.setEditable(false);
        fieldNumber71.setFocusable(false);
        fieldNumber71.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber71.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber71.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber71.setRequestFocusEnabled(false);

        fieldNumber72.setEditable(false);
        fieldNumber72.setFocusable(false);
        fieldNumber72.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber72.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber72.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber72.setRequestFocusEnabled(false);

        fieldNumber73.setEditable(false);
        fieldNumber73.setFocusable(false);
        fieldNumber73.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber73.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber73.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber73.setRequestFocusEnabled(false);

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

        fieldNumber86.setEditable(false);
        fieldNumber86.setFocusable(false);
        fieldNumber86.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber86.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber86.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber86.setRequestFocusEnabled(false);

        fieldNumber87.setEditable(false);
        fieldNumber87.setFocusable(false);
        fieldNumber87.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber87.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber87.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber87.setRequestFocusEnabled(false);

        fieldNumber80.setEditable(false);
        fieldNumber80.setFocusable(false);
        fieldNumber80.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber80.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber80.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber80.setRequestFocusEnabled(false);

        fieldNumber81.setEditable(false);
        fieldNumber81.setFocusable(false);
        fieldNumber81.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber81.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber81.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber81.setRequestFocusEnabled(false);

        fieldNumber82.setEditable(false);
        fieldNumber82.setFocusable(false);
        fieldNumber82.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber82.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber82.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber82.setRequestFocusEnabled(false);

        fieldNumber83.setEditable(false);
        fieldNumber83.setFocusable(false);
        fieldNumber83.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber83.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber83.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber83.setRequestFocusEnabled(false);

        fieldNumber84.setEditable(false);
        fieldNumber84.setFocusable(false);
        fieldNumber84.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber84.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber84.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber84.setRequestFocusEnabled(false);

        fieldNumber85.setEditable(false);
        fieldNumber85.setFocusable(false);
        fieldNumber85.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber85.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber85.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber85.setRequestFocusEnabled(false);

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

        fieldNumber90.setEditable(false);
        fieldNumber90.setFocusable(false);
        fieldNumber90.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber90.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber90.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber90.setRequestFocusEnabled(false);

        fieldNumber91.setEditable(false);
        fieldNumber91.setFocusable(false);
        fieldNumber91.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber91.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber91.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber91.setRequestFocusEnabled(false);

        fieldNumber92.setEditable(false);
        fieldNumber92.setFocusable(false);
        fieldNumber92.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber92.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber92.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber92.setRequestFocusEnabled(false);

        fieldNumber93.setEditable(false);
        fieldNumber93.setFocusable(false);
        fieldNumber93.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber93.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber93.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber93.setRequestFocusEnabled(false);

        fieldNumber94.setEditable(false);
        fieldNumber94.setFocusable(false);
        fieldNumber94.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber94.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber94.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber94.setRequestFocusEnabled(false);

        fieldNumber95.setEditable(false);
        fieldNumber95.setFocusable(false);
        fieldNumber95.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber95.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber95.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber95.setRequestFocusEnabled(false);

        fieldNumber96.setEditable(false);
        fieldNumber96.setFocusable(false);
        fieldNumber96.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber96.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber96.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber96.setRequestFocusEnabled(false);

        fieldNumber97.setEditable(false);
        fieldNumber97.setFocusable(false);
        fieldNumber97.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber97.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber97.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber97.setRequestFocusEnabled(false);

        fieldNumber98.setEditable(false);
        fieldNumber98.setFocusable(false);
        fieldNumber98.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber98.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber98.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber98.setRequestFocusEnabled(false);

        fieldNumber99.setEditable(false);
        fieldNumber99.setText("0");
        fieldNumber99.setFocusable(false);
        fieldNumber99.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber99.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber99.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber99.setRequestFocusEnabled(false);

        chooseFileButton.setText("Выбрать файл");
        chooseFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileButtonActionPerformed(evt);
            }
        });

        wayLabel3.setText("WAY");
        wayLabel3.setMaximumSize(new java.awt.Dimension(400, 16));
        wayLabel3.setMinimumSize(new java.awt.Dimension(400, 16));
        wayLabel3.setPreferredSize(new java.awt.Dimension(400, 16));

        wayLabel4.setText("WAY");
        wayLabel4.setMaximumSize(new java.awt.Dimension(400, 16));
        wayLabel4.setMinimumSize(new java.awt.Dimension(400, 16));
        wayLabel4.setPreferredSize(new java.awt.Dimension(400, 16));

        wayLabel2.setText("WAY");
        wayLabel2.setMaximumSize(new java.awt.Dimension(400, 16));
        wayLabel2.setMinimumSize(new java.awt.Dimension(400, 16));
        wayLabel2.setPreferredSize(new java.awt.Dimension(400, 16));

        wayLabel5.setText("WAY");
        wayLabel5.setMaximumSize(new java.awt.Dimension(400, 16));
        wayLabel5.setMinimumSize(new java.awt.Dimension(400, 16));
        wayLabel5.setPreferredSize(new java.awt.Dimension(400, 16));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(fieldNumber40, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldNumber41, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldNumber42, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(fieldNumber50, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(fieldNumber51, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldNumber52, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(fieldNumber43, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldNumber44, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldNumber45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(fieldNumber53, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(fieldNumber54, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldNumber55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(matrixBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(fieldNumber00, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber01, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber02, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber03, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber04, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(fieldNumber10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(fieldNumber20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber21, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber22, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber23, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(fieldNumber25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(fieldNumber06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fieldNumber16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fieldNumber26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fieldNumber36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fieldNumber46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fieldNumber56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fieldNumber66, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(fieldNumber07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber67, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(fieldNumber77, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(fieldNumber80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fieldNumber81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fieldNumber82, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fieldNumber83, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fieldNumber84, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(fieldNumber85, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fieldNumber86, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fieldNumber87, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(fieldNumber08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber58, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber68, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(fieldNumber78, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(fieldNumber09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fieldNumber69, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(fieldNumber79, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fieldNumber88, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fieldNumber89, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(fieldNumber70, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldNumber71, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldNumber72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldNumber73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldNumber74, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldNumber75, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldNumber76, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(wayLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(wayLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(wayLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(wayLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(wayLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(fieldNumber90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldNumber91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldNumber92, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldNumber93, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldNumber94, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(fieldNumber95, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(fieldNumber96, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldNumber97, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldNumber98, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldNumber99, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 220, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(random100Button)
                                    .addComponent(chooseFileButton))))
                        .addGap(7, 7, 7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(fieldNumber30, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber31, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber32, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber33, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber34, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(fieldNumber60, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(fieldNumber61, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber62, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(fieldNumber63, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(fieldNumber64, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNumber00, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber01, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber02, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber03, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber04, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNumber10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNumber20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNumber33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldNumber53, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber54, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldNumber40, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber41, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber42, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber43, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber44, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldNumber50, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber52, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber51, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(chooseFileButton)
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(random100Button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(fieldNumber06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldNumber46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNumber66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
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
                            .addGroup(jPanel2Layout.createSequentialGroup()
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
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNumber77, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNumber79, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(180, 180, 180)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(fieldNumber63, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fieldNumber64, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fieldNumber65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(fieldNumber60, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fieldNumber62, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fieldNumber61, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(fieldNumber70, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fieldNumber71, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fieldNumber72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(fieldNumber74, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fieldNumber73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fieldNumber75, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fieldNumber76, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
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
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(210, 210, 210)
                                            .addComponent(fieldNumber78, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNumber80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fieldNumber82, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber83, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber84, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber85, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fieldNumber86, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber87, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber88, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldNumber89, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNumber90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fieldNumber92, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldNumber91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldNumber93, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldNumber94, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldNumber99, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldNumber97, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldNumber95, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldNumber96, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldNumber98, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(matrixBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wayLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wayLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wayLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wayLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wayLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    /**
     * Недоработанный метод показа матрицы в зависимости от выбранного размера
     * в чекбосе
     * @param evt событие чекбокса
     */
    private void matrixBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_matrixBoxItemStateChanged
        // TODO add your handling code here:
        if (checkBoxFlag == true) {
            if (matrixBox.getSelectedIndex() == 0) {
                for(int r = 0; r < 10; r++) {
                    for (int c = 5; c < 10; c++) {
                        tFieldArr[r][c].setVisible(false);
                        tFieldArr[c][r].setVisible(false);

                        tFieldArr[r][c].setText("");

                    }
                }
//                for (JTextField field : fields5x5) {
//                    field.setVisible(false);
//                    field.setText("");
//                    field.setEditable(false);
//                }
            }else if (matrixBox.getSelectedIndex() == 1) {
                for(int r = 0; r < 10; r++) {
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
            }
            setSize(new Dimension(this.getWidth()+1,this.getHeight()+1));
            setSize(new Dimension(this.getWidth()-1,this.getHeight()-1));
        } 
        checkBoxFlag = checkBoxFlag != true;
    }//GEN-LAST:event_matrixBoxItemStateChanged
    /**
     * Запускает алгоритм. Выводит в wayLabel самые краткие пути
     * @param evt ивент кнопки
     */
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        if (matrixBox.getSelectedIndex() == 0) {
            runAlgo(5);
        } else if (matrixBox.getSelectedIndex() == 1) {
            runAlgo(10);
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void fieldNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumberKeyTyped
        // TODO add your handling code here:
        keyTypedEvent(evt);
    }//GEN-LAST:event_fieldNumberKeyTyped

    private void random100ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_random100ButtonActionPerformed
        // TODO add your handling code here:
        Random rnd = new Random();
        int[][] inputes = new int[100][100];
        for (int i = 0; i < 99; i++) {
            for (int j = i + 1; j < 100; j++) {
                inputes[i][j] = rnd.nextInt(200) + 1;
                inputes[j][i] = inputes[i][j];
            }
        }
        ArrayList way = Realisation.go(inputes, 100);
        wayLabel1.setText(way.get(0).toString());
        wayLabel2.setText(way.get(1).toString());
        wayLabel3.setText(way.get(2).toString());
        wayLabel4.setText(way.get(3).toString());
        wayLabel5.setText(way.get(4).toString());
    }//GEN-LAST:event_random100ButtonActionPerformed

    private void chooseFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fileopen = new JFileChooser();
        int[][] ints = {};
        int d =0;
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                
                String[] split = reader.readLine().split(" ");
                ints = new int[split.length][split.length];
                
                for (int i = 0; i < ints.length; i++) {
                    for (int j = 0; j < ints[i].length; j++) {
                        if (d < split.length) {
                            ints[i][j] = Integer.parseInt(split[d]);
                            d++;
                        }
                    }
                    if (i == ints.length - 1) {
                        break;
                    }
                    split = reader.readLine().split(" ");
                    d = 0;
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(InterfaceAnt.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InterfaceAnt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + "\t");
            }
            System.out.println();
        }
        ArrayList<StringBuilder> way = Realisation.go(ints, 5);
        wayLabel1.setText(way.get(0).toString());
        wayLabel2.setText(way.get(1).toString());
        wayLabel3.setText(way.get(2).toString());
        wayLabel4.setText(way.get(3).toString());
        wayLabel5.setText(way.get(4).toString());
    }//GEN-LAST:event_chooseFileButtonActionPerformed
    
    /**
     * Заполняет массив tFieldArr значениями с полей ввода и вызывает алгоритм
     * @param rowscols размерность матрицы
     * @throws NumberFormatException если не удастся преобразовать String в Integer
     */
    public void runAlgo(int rowscols) {
        int[][] inputes = new int[rowscols][rowscols];
        try {
            for (int r = 0; r < rowscols; r++) {
                for (int c = 0; c < rowscols; c++) {
                    if ((r == c) | (tFieldArr[r][c].getText().length() != 0 && Integer.parseInt(tFieldArr[r][c].getText()) != 0)) {
                        inputes[r][c] = Integer.parseInt(tFieldArr[r][c].getText());
                    } else {
                        inputes[r][c] = 1;
                    }
                }
            }
        } catch (NumberFormatException e) {
            
        }

        ArrayList way = Realisation.go(inputes, rowscols);
        wayLabel1.setText(way.get(0).toString());
        wayLabel2.setText(way.get(1).toString());
        wayLabel3.setText(way.get(2).toString());
        wayLabel4.setText(way.get(3).toString());
        wayLabel5.setText(way.get(4).toString());
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
            java.util.logging.Logger.getLogger(InterfaceAnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceAnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceAnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceAnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceAnt().setVisible(true);
            }
        });
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseFileButton;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> matrixBox;
    private javax.swing.JButton random100Button;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel wayLabel1;
    private javax.swing.JLabel wayLabel2;
    private javax.swing.JLabel wayLabel3;
    private javax.swing.JLabel wayLabel4;
    private javax.swing.JLabel wayLabel5;
    // End of variables declaration//GEN-END:variables
}
