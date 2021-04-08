package principal;

import java.awt.Color;
import java.util.Stack;
import javax.swing.JOptionPane;

public class AnalisadorSintatico {

  public static Integer[][] tabParsing = new Integer[73][44];
  Stack pilha = new Stack();
  int x;
  int a;
  int regra;

  public AnalisadorSintatico() {
    TabelaParsing();
  }

  public void analise() {
    Editor.campoErros.setForeground(Color.getHSBColor(101, 71, 55));
    pilha.push(42);
    pilha.push(44);

    int tamanhoTabela = Editor.tabelaLexico.getRowCount();

    int[] tabela = new int[tamanhoTabela];
    int[] linha = new int[tamanhoTabela];

    for (int i = 0; i < tamanhoTabela; i++) {
      linha[i] = (int) Editor.tabelaLexico.getValueAt(i, 2);
      tabela[i] = (int) Editor.tabelaLexico.getValueAt(i, 1);
    }

    int posicao = 0;

    if (tamanhoTabela == 0) {
      JOptionPane.showMessageDialog(null, "O código ainda não foi escrito!");
      Editor.jTabbedPane1.setSelectedIndex(1);
      return;
    }
    a = tabela[posicao];
    x = (int) pilha.peek();

    do {
      if (x == 15) {
        pilha.pop();
        x = (int) pilha.peek();
      } else {
        if (x < 44) {
          if (x == a) {
            pilha.pop();
            x = (int) pilha.peek();

            if (posicao + 1 == tamanhoTabela) {
              if (x == 42) {
                Editor.campoErros.setForeground(Color.BLUE);
                Editor.campoErros.append("CONSTRUÍDO COM SUCESSO ");
                Editor.jTabbedPane1.setSelectedIndex(1);
                break;
              }

              Editor.campoErros.setText("ERRO ANALISADOR SINTATICO NA LINHA " + linha[posicao]);
              Editor.jTabbedPane1.setSelectedIndex(1);
              break;
            }
            posicao++;
            a = tabela[posicao];

          } else {

            Editor.campoErros.setText("ERRO ANALISADOR SINTATICO NA LINHA " + linha[posicao]);
            Editor.jTabbedPane1.setSelectedIndex(1);
            break;
          }
        } else {
          if (tabParsing[x][a] != null) {
            pilha.pop();
            regra = tabParsing[x][a];
            regra();
            x = (int) pilha.peek();
          } else {
            Editor.campoErros.setText("Erro Sintático na linha " + linha[posicao]);
            Editor.jTabbedPane1.setSelectedIndex(1);
            break;
          }
        }
      }
    } while (x != 42);
  }

  public void TabelaParsing() {
    tabParsing[44][13] = 1;
    tabParsing[45][33] = 2;
    tabParsing[45][37] = 2;
    tabParsing[46][1] = 3;
    tabParsing[46][5] = 4;
    tabParsing[46][23] = 4;
    tabParsing[46][33] = 4;
    tabParsing[46][37] = 4;
    tabParsing[47][5] = 10;
    tabParsing[47][23] = 11;
    tabParsing[48][23] = 14;
    tabParsing[49][14] = 5;
    tabParsing[50][5] = 9;
    tabParsing[50][14] = 8;
    tabParsing[50][33] = 9;
    tabParsing[50][37] = 9;
    tabParsing[51][34] = 7;
    tabParsing[51][35] = 7;
    tabParsing[51][38] = 6;
    tabParsing[52][1] = 13;
    tabParsing[52][5] = 13;
    tabParsing[52][23] = 13;
    tabParsing[52][41] = 12;
    tabParsing[53][2] = 23;
    tabParsing[53][3] = 15;
    tabParsing[53][4] = 17;
    tabParsing[53][11] = 18;
    tabParsing[53][14] = 22;
    tabParsing[53][16] = 23;
    tabParsing[53][18] = 20;
    tabParsing[53][20] = 16;
    tabParsing[53][21] = 19;
    tabParsing[53][22] = 21;
    tabParsing[53][24] = 23;
    tabParsing[53][33] = 23;
    tabParsing[53][37] = 23;
    tabParsing[54][16] = 27;
    tabParsing[54][33] = 26;
    tabParsing[55][8] = 46;
    tabParsing[55][9] = 46;
    tabParsing[55][14] = 46;
    tabParsing[55][32] = 46;
    tabParsing[55][41] = 46;
    tabParsing[55][43] = 46;
    tabParsing[56][2] = 33;
    tabParsing[56][16] = 33;
    tabParsing[56][24] = 33;
    tabParsing[56][33] = 33;
    tabParsing[56][37] = 33;
    tabParsing[57][14] = 34;
    tabParsing[58][38] = 35;
    tabParsing[58][40] = 36;
    tabParsing[59][2] = 29;
    tabParsing[59][16] = 29;
    tabParsing[59][24] = 29;
    tabParsing[59][33] = 29;
    tabParsing[59][37] = 29;
    tabParsing[59][41] = 28;
    tabParsing[60][8] = 38;
    tabParsing[60][9] = 38;
    tabParsing[60][10] = 37;
    tabParsing[60][14] = 38;
    tabParsing[60][32] = 38;
    tabParsing[60][41] = 38;
    tabParsing[60][43] = 38;
    tabParsing[61][38] = 39;
    tabParsing[61][40] = 40;
    tabParsing[62][8] = 41;
    tabParsing[63][8] = 24;
    tabParsing[63][14] = 25;
    tabParsing[64][38] = 30;
    tabParsing[64][40] = 31;
    tabParsing[65][35] = 43;
    tabParsing[65][38] = 42;
    tabParsing[66][16] = 45;
    tabParsing[66][33] = 44;
    tabParsing[67][8] = 49;
    tabParsing[67][9] = 49;
    tabParsing[67][14] = 49;
    tabParsing[67][32] = 47;
    tabParsing[67][41] = 49;
    tabParsing[67][43] = 48;
    tabParsing[68][2] = 56;
    tabParsing[68][7] = 56;
    tabParsing[68][16] = 56;
    tabParsing[68][17] = 56;
    tabParsing[68][19] = 56;
    tabParsing[68][24] = 56;
    tabParsing[68][26] = 53;
    tabParsing[68][27] = 52;
    tabParsing[68][28] = 50;
    tabParsing[68][29] = 55;
    tabParsing[68][30] = 54;
    tabParsing[68][31] = 51;
    tabParsing[68][33] = 56;
    tabParsing[68][37] = 56;
    tabParsing[68][38] = 56;
    tabParsing[68][40] = 56;
    tabParsing[69][8] = 57;
    tabParsing[69][9] = 57;
    tabParsing[69][14] = 57;
    tabParsing[69][41] = 57;
    tabParsing[70][2] = 61;
    tabParsing[70][6] = 60;
    tabParsing[70][7] = 61;
    tabParsing[70][16] = 61;
    tabParsing[70][17] = 61;
    tabParsing[70][19] = 61;
    tabParsing[70][24] = 61;
    tabParsing[70][26] = 61;
    tabParsing[70][27] = 61;
    tabParsing[70][28] = 61;
    tabParsing[70][29] = 61;
    tabParsing[70][30] = 61;
    tabParsing[70][31] = 61;
    tabParsing[70][32] = 58;
    tabParsing[70][33] = 61;
    tabParsing[70][37] = 61;
    tabParsing[70][38] = 61;
    tabParsing[70][40] = 61;
    tabParsing[70][43] = 59;
    tabParsing[71][8] = 66;
    tabParsing[71][9] = 68;
    tabParsing[71][14] = 69;
    tabParsing[71][41] = 67;
    tabParsing[72][2] = 65;
    tabParsing[72][6] = 65;
    tabParsing[72][7] = 65;
    tabParsing[72][16] = 65;
    tabParsing[72][17] = 65;
    tabParsing[72][19] = 65;
    tabParsing[72][24] = 65;
    tabParsing[72][25] = 64;
    tabParsing[72][26] = 65;
    tabParsing[72][27] = 65;
    tabParsing[72][28] = 65;
    tabParsing[72][29] = 65;
    tabParsing[72][30] = 65;
    tabParsing[72][31] = 65;
    tabParsing[72][32] = 65;
    tabParsing[72][33] = 65;
    tabParsing[72][36] = 63;
    tabParsing[72][37] = 65;
    tabParsing[72][38] = 65;
    tabParsing[72][39] = 62;
    tabParsing[72][40] = 65;
    tabParsing[72][43] = 65;
    tabParsing[50][23] = 14;
    tabParsing[53][14] = 22;
    tabParsing[45][1] = 2;
    tabParsing[45][5] = 2;
    tabParsing[46][5] = 4;
    tabParsing[46][23] = 4;
    tabParsing[47][23] = 11;
    tabParsing[48][23] = 14;
    tabParsing[50][23] = 14;
    tabParsing[53][16] = 23;
    tabParsing[54][16] = 23;
    tabParsing[47][37] = 11;
    tabParsing[48][37] = 11;
  }

  public void regra() {
    switch (regra) {
      case 1:
        pilha.push(37);
        pilha.push(45);
        pilha.push(33);
        pilha.push(14);
        pilha.push(13);
        break;
      case 2:
        pilha.push(48);
        pilha.push(47);
        pilha.push(46);
        break;
      case 3:
        pilha.push(50);
        pilha.push(33);
        pilha.push(12);
        pilha.push(35);
        pilha.push(49);
        pilha.push(1);
        break;
      case 4:
        pilha.push(15);
        break;
      case 5:
        pilha.push(51);
        pilha.push(14);
        break;
      case 6:
        pilha.push(51);
        pilha.push(14);
        pilha.push(38);
        break;
      case 7:
        pilha.push(15);
        break;
      case 8:
        pilha.push(50);
        pilha.push(33);
        pilha.push(12);
        pilha.push(35);
        pilha.push(49);
        break;
      case 9:
        pilha.push(15);
        break;
      case 10:
        pilha.push(47);
        pilha.push(33);
        pilha.push(45);
        pilha.push(52);
        pilha.push(14);
        pilha.push(5);
        break;
      case 11:
        pilha.push(15);
        break;
      case 12:
        pilha.push(40);
        pilha.push(12);
        pilha.push(35);
        pilha.push(49);
        pilha.push(41);
        break;
      case 13:
        pilha.push(15);
        break;
      case 14:
        pilha.push(16);
        pilha.push(54);
        pilha.push(53);
        pilha.push(23);
        break;
      case 15:
        pilha.push(56);
        pilha.push(48);
        pilha.push(19);
        pilha.push(55);
        pilha.push(3);
        break;
      case 16:
        pilha.push(53);
        pilha.push(17);
        pilha.push(55);
        pilha.push(20);
        break;
      case 17:
        pilha.push(55);
        pilha.push(24);
        pilha.push(53);
        pilha.push(4);
        break;
      case 18:
        pilha.push(40);
        pilha.push(58);
        pilha.push(57);
        pilha.push(41);
        pilha.push(11);
        break;
      case 19:
        pilha.push(59);
        pilha.push(14);
        pilha.push(21);
        break;
      case 20:
        pilha.push(40);
        pilha.push(61);
        pilha.push(60);
        pilha.push(41);
        pilha.push(18);
        break;
      case 21:
        pilha.push(16);
        pilha.push(62);
        pilha.push(7);
        pilha.push(55);
        pilha.push(22);
        break;
      case 22:
        pilha.push(33);
        pilha.push(63);
        pilha.push(34);
        pilha.push(51);
        pilha.push(14);
        break;
      case 23:
        pilha.push(15);
        break;
      case 24:
        pilha.push(8);
        break;
      case 25:
        pilha.push(14);
        break;
      case 26:
        pilha.push(54);
        pilha.push(53);
        pilha.push(33);
        break;
      case 27:
        pilha.push(15);
        break;
      case 28:
        pilha.push(40);
        pilha.push(64);
        pilha.push(55);
        pilha.push(41);
        break;
      case 29:
        pilha.push(15);
        break;
      case 30:
        pilha.push(64);
        pilha.push(55);
        pilha.push(38);
        break;
      case 31:
        pilha.push(15);
        break;
      case 32:
        pilha.push(53);
        pilha.push(2);
        break;
      case 33:
        pilha.push(15);
        break;
      case 34:
        pilha.push(14);
        break;
      case 35:
        pilha.push(58);
        pilha.push(57);
        pilha.push(38);
        break;
      case 36:
        pilha.push(15);
        break;
      case 37:
        pilha.push(10);
        break;
      case 38:
        pilha.push(55);
        break;
      case 39:
        pilha.push(61);
        pilha.push(60);
        pilha.push(38);
        break;
      case 40:
        pilha.push(15);
        break;
      case 41:
        pilha.push(66);
        pilha.push(53);
        pilha.push(35);
        pilha.push(35);
        pilha.push(8);
        break;
      case 42:
        pilha.push(65);
        pilha.push(8);
        pilha.push(38);
        break;
      case 43:
        pilha.push(15);
        break;
      case 44:
        pilha.push(66);
        pilha.push(33);
        break;
      case 45:
        pilha.push(15);
        break;
      case 46:
        pilha.push(68);
        pilha.push(67);
        break;
      case 47:
        pilha.push(70);
        pilha.push(69);
        pilha.push(32);
        break;
      case 48:
        pilha.push(70);
        pilha.push(69);
        pilha.push(43);
        break;
      case 49:
        pilha.push(70);
        pilha.push(69);
        break;
      case 50:
        pilha.push(67);
        pilha.push(28);
        break;
      case 51:
        pilha.push(67);
        pilha.push(31);
        break;
      case 52:
        pilha.push(67);
        pilha.push(27);
        break;
      case 53:
        pilha.push(67);
        pilha.push(26);
        break;
      case 54:
        pilha.push(67);
        pilha.push(30);
        break;
      case 55:
        pilha.push(67);
        pilha.push(29);
        break;
      case 56:
        pilha.push(15);
        break;
      case 57:
        pilha.push(72);
        pilha.push(71);
        break;
      case 58:
        pilha.push(70);
        pilha.push(69);
        pilha.push(32);
        break;
      case 59:
        pilha.push(70);
        pilha.push(69);
        pilha.push(43);
        break;
      case 60:
        pilha.push(70);
        pilha.push(69);
        pilha.push(6);
        break;
      case 61:
        pilha.push(15);
        break;
      case 62:
        pilha.push(72);
        pilha.push(71);
        pilha.push(39);
        break;
      case 63:
        pilha.push(72);
        pilha.push(71);
        pilha.push(36);
        break;
      case 64:
        pilha.push(72);
        pilha.push(71);
        pilha.push(25);
        break;
      case 65:
        pilha.push(15);
        break;
      case 66:
        pilha.push(8);
        break;
      case 67:
        pilha.push(40);
        pilha.push(55);
        pilha.push(41);
        break;
      case 68:
        pilha.push(71);
        pilha.push(9);
        break;
      case 69:
        pilha.push(57);
        break;
    }
  }
}
