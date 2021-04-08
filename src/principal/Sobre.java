package principal;

public class Sobre extends javax.swing.JFrame {

  public Sobre() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTextPane1 = new javax.swing.JTextPane();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    btnSair = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Sobre");
    setResizable(false);

    jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jLabel1.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/principal/logo.png"))); // NOI18N

    jLabel2.setFont(new java.awt.Font("Tekton Pro Ext", 0, 36)); // NOI18N
    jLabel2.setText("Tigre");

    jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(102, 102, 102));
    jLabel3.setText("v2.0");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(27, 27, 27)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)
                    .addContainerGap(26, Short.MAX_VALUE)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                    .addGap(31, 31, 31))
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(
                        jLabel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        79,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    jTextPane1.setEditable(false);
    jTextPane1.setText(
        "\t\tSobre\n\n     Tigre é um ambiente de desenvolvimento integrado (IDE)  para \ndesenvolvedores da linguagem Tigre.\n     Foi  desenvolvido  como  trabalho,  proposto   pela  professora \nChristine Vieira para a disciplina de Compiladores, da instituição de \nensino UNESC.");
    jScrollPane2.setViewportView(jTextPane1);

    jTextArea1.setColumns(20);
    jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
    jTextArea1.setRows(5);
    jTextArea1.setText(
        "\t\t  Acadêmicos\n\n\tJoão Carlos Rosso - joaorosso@unesc.net\n\tTúlio Cardoso Tramontin - tulio@unesc.net");
    jScrollPane1.setViewportView(jTextArea1);

    btnSair.setText("Sair");
    btnSair.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSairActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(
                                        jScrollPane1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        328,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(275, 275, 275)
                                    .addComponent(
                                        btnSair,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        64,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(
                                                jPanel1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                jScrollPane2,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(
                        jPanel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(
                        jScrollPane2,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(
                        jScrollPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(btnSair)));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void btnSairActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnSairActionPerformed
    dispose();
  } // GEN-LAST:event_btnSairActionPerformed

  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Sobre.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Sobre.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Sobre.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Sobre.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new Sobre().setVisible(true);
          }
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnSair;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JTextPane jTextPane1;
  // End of variables declaration//GEN-END:variables
}
