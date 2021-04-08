package principal;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Editor extends javax.swing.JFrame {

  File dirFile;
  int returnVal;
  private TokensTableModel model;
  final JFileChooser fc = new JFileChooser();

  public Editor() {
    initComponents();
    setExtendedState(MAXIMIZED_BOTH);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    campoTxt = new javax.swing.JTextArea();
    jTabbedPane1 = new javax.swing.JTabbedPane();
    jScrollPane2 = new javax.swing.JScrollPane();
    tabelaLexico = new javax.swing.JTable();
    jScrollPane3 = new javax.swing.JScrollPane();
    campoErros = new javax.swing.JTextArea();
    barraMenu = new javax.swing.JMenuBar();
    menuArquivo = new javax.swing.JMenu();
    arquivoNovo = new javax.swing.JMenuItem();
    arquivoAbrir = new javax.swing.JMenuItem();
    arquivoSalvar = new javax.swing.JMenuItem();
    arquivoSalvarComo = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    arquivoSair = new javax.swing.JMenuItem();
    menuEditar = new javax.swing.JMenu();
    editarCopiar = new javax.swing.JMenuItem();
    editarColar = new javax.swing.JMenuItem();
    editarLocalizar = new javax.swing.JMenuItem();
    editarSubstituir = new javax.swing.JMenuItem();
    editarSelectAll = new javax.swing.JMenuItem();
    menuExecutar = new javax.swing.JMenu();
    executarCompilar = new javax.swing.JMenuItem();
    menuAjuda = new javax.swing.JMenu();
    ajudaManual = new javax.swing.JMenuItem();
    ajudaSobre = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Compilador Tigre");

    campoTxt.setColumns(20);
    campoTxt.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
    campoTxt.setRows(5);
    campoTxt.setTabSize(4);
    jScrollPane1.setViewportView(campoTxt);

    tabelaLexico.setModel(
        new javax.swing.table.DefaultTableModel(
            new Object[][] {}, new String[] {"Token", "Código", "Linha"}) {

          boolean[] canEdit = new boolean[] {false, false, false};

          public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
          }
        });
    tabelaLexico.setEnabled(false);
    jScrollPane2.setViewportView(tabelaLexico);

    jTabbedPane1.addTab("Saída Léxica", jScrollPane2);

    campoErros.setEditable(false);
    campoErros.setColumns(20);
    campoErros.setRows(5);
    jScrollPane3.setViewportView(campoErros);

    jTabbedPane1.addTab("Console de erros", jScrollPane3);

    menuArquivo.setText("Arquivo");

    arquivoNovo.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
    arquivoNovo.setText("Novo");
    arquivoNovo.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            arquivoNovoActionPerformed(evt);
          }
        });
    menuArquivo.add(arquivoNovo);

    arquivoAbrir.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
    arquivoAbrir.setText("Abrir");
    arquivoAbrir.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            arquivoAbrirActionPerformed(evt);
          }
        });
    menuArquivo.add(arquivoAbrir);

    arquivoSalvar.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
    arquivoSalvar.setText("Salvar");
    arquivoSalvar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            arquivoSalvarActionPerformed(evt);
          }
        });
    menuArquivo.add(arquivoSalvar);

    arquivoSalvarComo.setText("Salvar como...");
    arquivoSalvarComo.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            arquivoSalvarComoActionPerformed(evt);
          }
        });
    menuArquivo.add(arquivoSalvarComo);
    menuArquivo.add(jSeparator1);

    arquivoSair.setText("Sair");
    arquivoSair.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            arquivoSairActionPerformed(evt);
          }
        });
    menuArquivo.add(arquivoSair);

    barraMenu.add(menuArquivo);

    menuEditar.setText("Editar");

    editarCopiar.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
    editarCopiar.setText("Copiar");
    editarCopiar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            editarCopiarActionPerformed(evt);
          }
        });
    menuEditar.add(editarCopiar);

    editarColar.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
    editarColar.setText("Colar");
    editarColar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            editarColarActionPerformed(evt);
          }
        });
    menuEditar.add(editarColar);

    editarLocalizar.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
    editarLocalizar.setText("Localizar");
    editarLocalizar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            editarLocalizarActionPerformed(evt);
          }
        });
    menuEditar.add(editarLocalizar);

    editarSubstituir.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
    editarSubstituir.setText("Susbstituir");
    editarSubstituir.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            editarSubstituirActionPerformed(evt);
          }
        });
    menuEditar.add(editarSubstituir);

    editarSelectAll.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
    editarSelectAll.setText("Selecionar Tudo");
    editarSelectAll.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            editarSelectAllActionPerformed(evt);
          }
        });
    menuEditar.add(editarSelectAll);

    barraMenu.add(menuEditar);

    menuExecutar.setText("Executar");

    executarCompilar.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
    executarCompilar.setText("Compilar");
    executarCompilar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            executarCompilarActionPerformed(evt);
          }
        });
    menuExecutar.add(executarCompilar);

    barraMenu.add(menuExecutar);

    menuAjuda.setText("Ajuda");

    ajudaManual.setText("Manual");
    ajudaManual.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            ajudaManualActionPerformed(evt);
          }
        });
    menuAjuda.add(ajudaManual);

    ajudaSobre.setText("Sobre");
    ajudaSobre.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            ajudaSobreActionPerformed(evt);
          }
        });
    menuAjuda.add(ajudaSobre);

    barraMenu.add(menuAjuda);

    setJMenuBar(barraMenu);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(
                jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addComponent(
                        jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        jTabbedPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        146,
                        javax.swing.GroupLayout.PREFERRED_SIZE)));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void arquivoAbrirActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_arquivoAbrirActionPerformed
    int returnValor = fc.showOpenDialog(fc);
    File selFile = fc.getSelectedFile();
    if (returnValor == JFileChooser.APPROVE_OPTION) {
      campoTxt.setText(lerArquivo(selFile.getAbsolutePath()));
    } else if (returnValor == JFileChooser.CANCEL_OPTION) {

    } else if (returnValor == JFileChooser.UNDEFINED_CONDITION) {

    }
  } // GEN-LAST:event_arquivoAbrirActionPerformed

  private void arquivoSalvarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_arquivoSalvarActionPerformed
    saveFile();
  } // GEN-LAST:event_arquivoSalvarActionPerformed

  private void arquivoSairActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_arquivoSairActionPerformed
    System.exit(0);
  } // GEN-LAST:event_arquivoSairActionPerformed

  private void arquivoNovoActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_arquivoNovoActionPerformed
    campoTxt.setText("");
  } // GEN-LAST:event_arquivoNovoActionPerformed

  private void arquivoSalvarComoActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_arquivoSalvarComoActionPerformed
    saveFileAs();
  } // GEN-LAST:event_arquivoSalvarComoActionPerformed

  private void executarCompilarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_executarCompilarActionPerformed
    campoErros.setText("");
    ArrayList<Tokens> tokensList;
    AnalisadorLexico al = new AnalisadorLexico();

    TokensTableModel modelo = new TokensTableModel();
    tokensList = al.analisador(campoTxt.getText() + " $");

    Tokens t = new Tokens();

    modelo.addListaDeTokens(tokensList);

    tabelaLexico.setModel(modelo);

    AnalisadorSintatico as = new AnalisadorSintatico();
    as.analise();
  } // GEN-LAST:event_executarCompilarActionPerformed

  private void ajudaSobreActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_ajudaSobreActionPerformed
    Sobre sobre = new Sobre();
    sobre.setIconImage(
        new ImageIcon(getClass().getResource("icon.png")).getImage()); // seta o icone no sobre
    sobre.setVisible(true);
  } // GEN-LAST:event_ajudaSobreActionPerformed

  private void editarLocalizarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_editarLocalizarActionPerformed
    String texto = campoTxt.getText();
    Pattern p = Pattern.compile(JOptionPane.showInputDialog(null, "Localizar:"));
    Matcher m = p.matcher(texto);
    if (m.find()) {
      campoTxt.requestFocus();
      campoTxt.setCaretPosition(m.start());
    }
  } // GEN-LAST:event_editarLocalizarActionPerformed

  private void editarSubstituirActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_editarSubstituirActionPerformed
    String string1 = campoTxt.getText();
    String procurar = JOptionPane.showInputDialog(null, "Localizar:");
    String substituir = JOptionPane.showInputDialog(null, "Substituir:");

    campoTxt.setText(string1.replace(procurar, substituir));
  } // GEN-LAST:event_editarSubstituirActionPerformed

  private void editarCopiarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_editarCopiarActionPerformed
    campoTxt.copy();
  } // GEN-LAST:event_editarCopiarActionPerformed

  private void editarColarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_editarColarActionPerformed
    campoTxt.paste();
  } // GEN-LAST:event_editarColarActionPerformed

  private void editarSelectAllActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_editarSelectAllActionPerformed
    campoTxt.selectAll();
  } // GEN-LAST:event_editarSelectAllActionPerformed

  private void ajudaManualActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_ajudaManualActionPerformed
    File pdf = new File("manual.pdf");
    try {
      Desktop.getDesktop().open(pdf);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex);
      Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
    }
  } // GEN-LAST:event_ajudaManualActionPerformed

  private void saveFile() {
    if (dirFile == null) {
      saveFileAs();
    } else {
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        try {
          gravarArquivo(dirFile.getAbsolutePath() + ".txt", campoTxt.getText());
        } catch (Exception e) {
          JOptionPane.showMessageDialog(this, e.getMessage());
        }
      } else if (returnVal == JFileChooser.CANCEL_OPTION) {

      } else if (returnVal == JFileChooser.UNDEFINED_CONDITION) {

      }
    }
  }

  private void saveFileAs() {
    returnVal = fc.showSaveDialog(campoTxt);
    dirFile = fc.getSelectedFile();
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      try {
        gravarArquivo(dirFile.getAbsolutePath() + ".txt", campoTxt.getText());
      } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
      }
    } else if (returnVal == JFileChooser.CANCEL_OPTION) {

    } else if (returnVal == JFileChooser.UNDEFINED_CONDITION) {

    }
  }

  private String lerArquivo(String nomeArquivo) {
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    try {
      fileReader = new FileReader(nomeArquivo);
      bufferedReader = new BufferedReader(fileReader);
      StringBuilder sb = new StringBuilder();
      while (bufferedReader.ready()) {
        sb.append(bufferedReader.readLine());
        sb.append("\n");
      }
      return sb.toString();
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo: " + ex.getMessage());
    } finally {
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo: " + ex.getMessage());
        }
      }
      if (fileReader != null) {
        try {
          fileReader.close();
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo: " + ex.getMessage());
        }
      }
    }
    return null;
  }

  private void gravarArquivo(String nomeArquivo, String textoArquivo) {
    FileWriter fileWriter = null;
    BufferedWriter bufferedWriter = null;
    try {
      fileWriter = new FileWriter(nomeArquivo, false);
      bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write(textoArquivo);
      bufferedWriter.flush();
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: " + ex.getMessage());
    } finally {
      if (bufferedWriter != null) {
        try {
          bufferedWriter.close();
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: " + ex.getMessage());
        }
      }
      if (fileWriter != null) {
        try {
          fileWriter.close();
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: " + ex.getMessage());
        }
      }
    }
  }

  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Windows".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException
        | InstantiationException
        | IllegalAccessException
        | javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Editor.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(
        new Runnable() {

          @Override
          public void run() {

            Editor e = new Editor();
            e.setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
            e.setVisible(true);
          }
        });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuItem ajudaManual;
  private javax.swing.JMenuItem ajudaSobre;
  private javax.swing.JMenuItem arquivoAbrir;
  private javax.swing.JMenuItem arquivoNovo;
  private javax.swing.JMenuItem arquivoSair;
  private javax.swing.JMenuItem arquivoSalvar;
  private javax.swing.JMenuItem arquivoSalvarComo;
  private javax.swing.JMenuBar barraMenu;
  public static javax.swing.JTextArea campoErros;
  public javax.swing.JTextArea campoTxt;
  private javax.swing.JMenuItem editarColar;
  private javax.swing.JMenuItem editarCopiar;
  private javax.swing.JMenuItem editarLocalizar;
  private javax.swing.JMenuItem editarSelectAll;
  private javax.swing.JMenuItem editarSubstituir;
  public javax.swing.JMenuItem executarCompilar;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  public static javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JMenu menuAjuda;
  private javax.swing.JMenu menuArquivo;
  private javax.swing.JMenu menuEditar;
  public javax.swing.JMenu menuExecutar;
  public static javax.swing.JTable tabelaLexico;
  // End of variables declaration//GEN-END:variables
}
