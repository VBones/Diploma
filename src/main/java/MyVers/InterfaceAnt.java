/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVers;

import com.sun.glass.events.KeyEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Влад
 */
public final class InterfaceAnt extends javax.swing.JFrame {

    private boolean checkBoxFlag = false;
    /**
     * Creates new form InterfaceAnt
     */
    public InterfaceAnt() {
        setLocationRelativeTo(null);
        initComponents();
        setTransferHandlers();
        fieldNumberKeyTypedSettings();
    }

    public void fieldNumberKeyTypedSettings() {
        fieldNumber01.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fieldNumber10.setText(fieldNumber01.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fieldNumber10.setText(fieldNumber01.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        fieldNumber02.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fieldNumber20.setText(fieldNumber02.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fieldNumber20.setText(fieldNumber02.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        fieldNumber03.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fieldNumber30.setText(fieldNumber03.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fieldNumber30.setText(fieldNumber03.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        fieldNumber04.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fieldNumber40.setText(fieldNumber04.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fieldNumber40.setText(fieldNumber04.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        fieldNumber12.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fieldNumber21.setText(fieldNumber12.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fieldNumber21.setText(fieldNumber12.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        fieldNumber13.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fieldNumber31.setText(fieldNumber13.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fieldNumber31.setText(fieldNumber13.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        fieldNumber14.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fieldNumber41.setText(fieldNumber14.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fieldNumber41.setText(fieldNumber14.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        fieldNumber23.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fieldNumber32.setText(fieldNumber23.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fieldNumber32.setText(fieldNumber23.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        fieldNumber24.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fieldNumber42.setText(fieldNumber24.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fieldNumber42.setText(fieldNumber24.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        fieldNumber34.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fieldNumber43.setText(fieldNumber34.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fieldNumber43.setText(fieldNumber34.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    public void setTransferHandlers() {
        fieldNumber00.setTransferHandler(null);
        fieldNumber01.setTransferHandler(null);
        fieldNumber02.setTransferHandler(null);
        fieldNumber03.setTransferHandler(null);
        fieldNumber04.setTransferHandler(null);
        fieldNumber10.setTransferHandler(null);
        fieldNumber11.setTransferHandler(null);
        fieldNumber12.setTransferHandler(null);
        fieldNumber13.setTransferHandler(null);
        fieldNumber14.setTransferHandler(null);
        fieldNumber20.setTransferHandler(null);
        fieldNumber21.setTransferHandler(null);
        fieldNumber22.setTransferHandler(null);
        fieldNumber23.setTransferHandler(null);
        fieldNumber24.setTransferHandler(null);
        fieldNumber30.setTransferHandler(null);
        fieldNumber31.setTransferHandler(null);
        fieldNumber32.setTransferHandler(null);
        fieldNumber33.setTransferHandler(null);
        fieldNumber34.setTransferHandler(null);
        fieldNumber40.setTransferHandler(null);
        fieldNumber41.setTransferHandler(null);
        fieldNumber42.setTransferHandler(null);
        fieldNumber43.setTransferHandler(null);
        fieldNumber44.setTransferHandler(null);
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

        startButton.setText("jButton1");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(matrixBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldNumber30, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber31, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber32, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber33, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber34, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldNumber00, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber01, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber02, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber03, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber04, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldNumber10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldNumber20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber21, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber22, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber23, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldNumber40, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber41, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber42, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber43, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNumber44, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(294, Short.MAX_VALUE))
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
                        .addComponent(fieldNumber44, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldNumber40, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldNumber41, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(matrixBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNumber01KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber01KeyTyped
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldNumber01KeyTyped

    private void fieldNumber02KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber02KeyTyped
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldNumber02KeyTyped

    private void fieldNumber03KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber03KeyTyped
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldNumber03KeyTyped

    private void fieldNumber12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber12KeyTyped
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldNumber12KeyTyped

    private void fieldNumber13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber13KeyTyped
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldNumber13KeyTyped

    private void fieldNumber23KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber23KeyTyped
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldNumber23KeyTyped

    private void matrixBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_matrixBoxItemStateChanged
        // TODO add your handling code here:
        if (checkBoxFlag == true) {
            if (matrixBox.getSelectedIndex() == 0) {
                fieldNumber04.setVisible(false);
                System.out.println("DONE1");
            }else if (matrixBox.getSelectedIndex() == 1) {
                fieldNumber04.setVisible(true);
                System.out.println("DONE2");
                
            }
        } 
        checkBoxFlag = checkBoxFlag != true;
    }//GEN-LAST:event_matrixBoxItemStateChanged

    private void fieldNumber04KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber04KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldNumber04KeyTyped

    private void fieldNumber14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber14KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldNumber14KeyTyped

    private void fieldNumber24KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber24KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldNumber24KeyTyped

    private void fieldNumber34KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNumber34KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldNumber34KeyTyped

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JComboBox<String> matrixBox;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
