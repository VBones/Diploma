package MyVers;

import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.util.ArrayList;
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
    private  JTextField[][] arr;
    
    
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
        arr = new JTextField[5][5];
        
        arr[0][0] = fieldNumber00;
        arr[0][1] = fieldNumber01;
        arr[0][2] = fieldNumber02;
        arr[0][3] = fieldNumber03;
        arr[0][4] = fieldNumber04;
        arr[1][0] = fieldNumber10;
        arr[1][1] = fieldNumber11;
        arr[1][2] = fieldNumber12;
        arr[1][3] = fieldNumber13;
        arr[1][4] = fieldNumber14;
        arr[2][0] = fieldNumber20;
        arr[2][1] = fieldNumber21;
        arr[2][2] = fieldNumber22;
        arr[2][3] = fieldNumber23;
        arr[2][4] = fieldNumber24;
        arr[3][0] = fieldNumber30;
        arr[3][1] = fieldNumber31;
        arr[3][2] = fieldNumber32;
        arr[3][3] = fieldNumber33;
        arr[3][4] = fieldNumber34;
        arr[4][0] = fieldNumber40;
        arr[4][1] = fieldNumber41;
        arr[4][2] = fieldNumber42;
        arr[4][3] = fieldNumber43;
        arr[4][4] = fieldNumber44;
        
        inputFields.add(fieldNumber01);
        inputFields.add(fieldNumber02);
        inputFields.add(fieldNumber03);
        inputFields.add(fieldNumber04);
        inputFields.add(fieldNumber12);
        inputFields.add(fieldNumber13);
        inputFields.add(fieldNumber14);
        inputFields.add(fieldNumber23);
        inputFields.add(fieldNumber24);
        inputFields.add(fieldNumber34);
        
        dependedFields.add(fieldNumber10);
        dependedFields.add(fieldNumber20);
        dependedFields.add(fieldNumber30);
        dependedFields.add(fieldNumber40);
        dependedFields.add(fieldNumber21);
        dependedFields.add(fieldNumber31);
        dependedFields.add(fieldNumber41);
        dependedFields.add(fieldNumber32);
        dependedFields.add(fieldNumber42);
        dependedFields.add(fieldNumber43);
        
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
        jProgressBar1 = new javax.swing.JProgressBar();
        fieldNumber04 = new javax.swing.JTextField();
        fieldNumber14 = new javax.swing.JTextField();
        fieldNumber24 = new javax.swing.JTextField();
        fieldNumber34 = new javax.swing.JTextField();
        fieldNumber40 = new javax.swing.JTextField();
        fieldNumber41 = new javax.swing.JTextField();
        fieldNumber42 = new javax.swing.JTextField();
        fieldNumber43 = new javax.swing.JTextField();
        fieldNumber44 = new javax.swing.JTextField();
        wayLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        fieldNumber00.setEditable(false);
        fieldNumber00.setText("0");
        fieldNumber00.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber00.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber00.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber01.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber01.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber01.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber01.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumber01KeyTyped(evt);
            }
        });

        fieldNumber02.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber02.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber02.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber02.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumber02KeyTyped(evt);
            }
        });

        fieldNumber10.setEditable(false);
        fieldNumber10.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber10.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber10.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber11.setEditable(false);
        fieldNumber11.setText("0");
        fieldNumber11.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber11.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber11.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber12.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber12.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber12.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumber12KeyTyped(evt);
            }
        });

        fieldNumber03.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber03.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber03.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber03.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumber03KeyTyped(evt);
            }
        });

        fieldNumber13.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber13.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber13.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumber13KeyTyped(evt);
            }
        });

        fieldNumber20.setEditable(false);
        fieldNumber20.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber20.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber20.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber21.setEditable(false);
        fieldNumber21.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber21.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber21.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber22.setEditable(false);
        fieldNumber22.setText("0");
        fieldNumber22.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber22.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber22.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber23.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber23.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber23.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumber23KeyTyped(evt);
            }
        });

        fieldNumber33.setEditable(false);
        fieldNumber33.setText("0");
        fieldNumber33.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber33.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber33.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber32.setEditable(false);
        fieldNumber32.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber32.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber32.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber31.setEditable(false);
        fieldNumber31.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber31.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber31.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber30.setEditable(false);
        fieldNumber30.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber30.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber30.setPreferredSize(new java.awt.Dimension(34, 24));

        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StartButtonIcon.png"))); // NOI18N
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        matrixBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4x4", "5х5", "6х6", "7х7", "8х8", "9х9", "10х10", "11х11", "12х12", "13х13", "14х14", "15х15" }));
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
                fieldNumber04KeyTyped(evt);
            }
        });

        fieldNumber14.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber14.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber14.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumber14KeyTyped(evt);
            }
        });

        fieldNumber24.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber24.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber24.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumber24KeyTyped(evt);
            }
        });

        fieldNumber34.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber34.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber34.setPreferredSize(new java.awt.Dimension(34, 24));
        fieldNumber34.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNumber34KeyTyped(evt);
            }
        });

        fieldNumber40.setEditable(false);
        fieldNumber40.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber40.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber40.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber41.setEditable(false);
        fieldNumber41.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber41.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber41.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber42.setEditable(false);
        fieldNumber42.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber42.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber42.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber43.setEditable(false);
        fieldNumber43.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber43.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber43.setPreferredSize(new java.awt.Dimension(34, 24));

        fieldNumber44.setEditable(false);
        fieldNumber44.setText("0");
        fieldNumber44.setMaximumSize(new java.awt.Dimension(34, 24));
        fieldNumber44.setMinimumSize(new java.awt.Dimension(34, 24));
        fieldNumber44.setPreferredSize(new java.awt.Dimension(34, 24));

        wayLabel.setText("WAY");

        jLabel1.setText("RESULT SET:");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldNumber40, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber41, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber42, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber43, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(148, 148, 148)
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber44, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(fieldNumber30, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber31, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber32, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber33, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber34, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(fieldNumber00, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber01, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber02, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber03, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber04, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(fieldNumber10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(fieldNumber20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber21, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber22, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber23, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNumber24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(matrixBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNumber00, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber01, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber02, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber03, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber04, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNumber10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNumber20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNumber33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldNumber42, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldNumber43, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldNumber44, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldNumber40, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldNumber41, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(matrixBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
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

    private void fieldNumber01KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber01KeyTyped
        keyTypedEvent(evt);
    }//GEN-LAST:event_fieldNumber01KeyTyped

    private void fieldNumber02KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber02KeyTyped
        keyTypedEvent(evt);
    }//GEN-LAST:event_fieldNumber02KeyTyped

    private void fieldNumber03KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber03KeyTyped
        keyTypedEvent(evt);
    }//GEN-LAST:event_fieldNumber03KeyTyped

    private void fieldNumber12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber12KeyTyped
        keyTypedEvent(evt);
    }//GEN-LAST:event_fieldNumber12KeyTyped

    private void fieldNumber13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber13KeyTyped
        keyTypedEvent(evt);
    }//GEN-LAST:event_fieldNumber13KeyTyped

    private void fieldNumber23KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber23KeyTyped
        keyTypedEvent(evt);
    }//GEN-LAST:event_fieldNumber23KeyTyped
   
    /**
     * Недоработанный метод показа матрицы в зависимости от выбранного размера
     * в чекбосе
     * @param evt событие чекбокса
     */
    private void matrixBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_matrixBoxItemStateChanged
        // TODO add your handling code here:
        if (checkBoxFlag == true) {
            if (matrixBox.getSelectedIndex() == 0) {
                for (JTextField field : fields5x5) {
                    field.setVisible(false);
                    field.setText("");
                    field.setEditable(false);
                }
            }else if (matrixBox.getSelectedIndex() == 1) {
                for (JTextField field : fields5x5) {
                    field.setVisible(true);
                    field.setEditable(true);
                }
                    fieldNumber44.setText("0");
                    fieldNumber44.setEditable(false);
            }
            setSize(new Dimension(this.getWidth()+1,this.getHeight()+1));
            setSize(new Dimension(this.getWidth()-1,this.getHeight()-1));
        } 
        checkBoxFlag = checkBoxFlag != true;
    }//GEN-LAST:event_matrixBoxItemStateChanged

    private void fieldNumber04KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber04KeyTyped
        keyTypedEvent(evt);
    }//GEN-LAST:event_fieldNumber04KeyTyped

    private void fieldNumber14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber14KeyTyped
        keyTypedEvent(evt);
    }//GEN-LAST:event_fieldNumber14KeyTyped

    private void fieldNumber24KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber24KeyTyped
        keyTypedEvent(evt);
    }//GEN-LAST:event_fieldNumber24KeyTyped

    private void fieldNumber34KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber34KeyTyped
        keyTypedEvent(evt);
    }//GEN-LAST:event_fieldNumber34KeyTyped
    /**
     * Запускает алгоритм. Выводит в wayLabel самые краткие пути
     * @param evt ивент кнопки
     */
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        if (matrixBox.getSelectedIndex() == 0) {
            runAlgo(4);
        } else if (matrixBox.getSelectedIndex() == 1) {
            runAlgo(5);
        }
    }//GEN-LAST:event_startButtonActionPerformed

    public void runAlgo(int rowscols) throws NumberFormatException {
        int[][] inputes = new int[rowscols][rowscols];
        for (int r = 0; r < rowscols; r++) {
            for (int c = 0; c < rowscols; c++) {
                if ((r == c) | (arr[r][c].getText().length() != 0 && Integer.parseInt(arr[r][c].getText()) != 0)) {
                    inputes[r][c] = Integer.parseInt(arr[r][c].getText());
                } else {
                    inputes[r][c] = 1;
                }
            }
        }
        ArrayList way = Realisation.go(inputes, rowscols);
        wayLabel.setText(way.toString());
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
    private javax.swing.JTextField fieldNumber00;
    private javax.swing.JTextField fieldNumber01;
    private javax.swing.JTextField fieldNumber02;
    private javax.swing.JTextField fieldNumber03;
    private javax.swing.JTextField fieldNumber04;
    private javax.swing.JTextField fieldNumber10;
    private javax.swing.JTextField fieldNumber11;
    private javax.swing.JTextField fieldNumber12;
    private javax.swing.JTextField fieldNumber13;
    private javax.swing.JTextField fieldNumber14;
    private javax.swing.JTextField fieldNumber20;
    private javax.swing.JTextField fieldNumber21;
    private javax.swing.JTextField fieldNumber22;
    private javax.swing.JTextField fieldNumber23;
    private javax.swing.JTextField fieldNumber24;
    private javax.swing.JTextField fieldNumber30;
    private javax.swing.JTextField fieldNumber31;
    private javax.swing.JTextField fieldNumber32;
    private javax.swing.JTextField fieldNumber33;
    private javax.swing.JTextField fieldNumber34;
    private javax.swing.JTextField fieldNumber40;
    private javax.swing.JTextField fieldNumber41;
    private javax.swing.JTextField fieldNumber42;
    private javax.swing.JTextField fieldNumber43;
    private javax.swing.JTextField fieldNumber44;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JComboBox<String> matrixBox;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel wayLabel;
    // End of variables declaration//GEN-END:variables
}
