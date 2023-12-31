/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author alu10191634
 */
public class ScoreBoard extends javax.swing.JPanel implements Incrementer {

    private int score;

    /**
     * Creates new form Scoreboard
     */
    public ScoreBoard() {
        initComponents();
        myInits();
    }

    private void myInits() {
        score = 0;
        jLNumScore.setText(String.valueOf(score));
        jLTextName.setText(ConfigData.instance.getName());
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void incrementScore(int increment) {
        score += increment;
        jLNumScore.setText(String.valueOf(score));
    }

    @Override
    public void resetScore() {
        score = 0;
        jLTextName.setText(ConfigData.instance.getName());
        jLNumScore.setText(String.valueOf(score));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLName = new javax.swing.JLabel();
        jLTextName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLScore = new javax.swing.JLabel();
        jLNumScore = new javax.swing.JLabel();

        setBackground(new java.awt.Color(93, 156, 89));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMinimumSize(new java.awt.Dimension(98, 28));
        setPreferredSize(new java.awt.Dimension(98, 28));

        jLName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLName.setText("Name:");
        add(jLName);

        jLTextName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add(jLTextName);

        jLabel3.setText("-");
        add(jLabel3);

        jLScore.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLScore.setText("Score:");
        add(jLScore);

        jLNumScore.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add(jLNumScore);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLNumScore;
    private javax.swing.JLabel jLScore;
    private javax.swing.JLabel jLTextName;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
