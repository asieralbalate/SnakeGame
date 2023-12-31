/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author alu10191634
 */
public class ConfigDialog extends javax.swing.JDialog {

    public InitGamer initGamer;

    /**
     * Creates new form ConfigDialog
     *
     * @param parent
     * @param modal
     */
    public ConfigDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
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
        jButtonReady = new javax.swing.JButton();
        jComboBoxLevel = new javax.swing.JComboBox<>();
        jTextFieldName = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jLabelLevel = new javax.swing.JLabel();
        jLabelBackgroud = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonReady.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playagainbutton.png"))); // NOI18N
        jButtonReady.setContentAreaFilled(false);
        jButtonReady.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadyActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonReady, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, -1, 50));

        jComboBoxLevel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBoxLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beginner", "Normal", "Expert" }));
        jComboBoxLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLevelActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, -1, -1));

        jTextFieldName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNameFocusLost(evt);
            }
        });
        jPanel1.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 110, 30));

        jLabelName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelName.setText("Name");
        jPanel1.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, -1, -1));

        jLabelLevel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelLevel.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLevel.setText("Difficulty");
        jPanel1.add(jLabelLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, -1, -1));

        jLabelBackgroud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/configdialogbackground.jpg"))); // NOI18N
        jPanel1.add(jLabelBackgroud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 510));

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

    private void jComboBoxLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLevelActionPerformed
        ConfigData.instance.setLevel(jComboBoxLevel.getSelectedIndex());
    }//GEN-LAST:event_jComboBoxLevelActionPerformed

    private void jButtonReadyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReadyActionPerformed
        dispose();
        initGamer.initGame();
    }//GEN-LAST:event_jButtonReadyActionPerformed

    private void jTextFieldNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNameFocusLost
        ConfigData.instance.setName(jTextFieldName.getText());
    }//GEN-LAST:event_jTextFieldNameFocusLost

    public void setInitGamer(InitGamer initGamer) {
        this.initGamer = initGamer;
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
            java.util.logging.Logger.getLogger(ConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfigDialog dialog = new ConfigDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReady;
    private javax.swing.JComboBox<String> jComboBoxLevel;
    private javax.swing.JLabel jLabelBackgroud;
    private javax.swing.JLabel jLabelLevel;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
