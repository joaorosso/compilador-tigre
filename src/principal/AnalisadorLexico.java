package principal;

import java.util.ArrayList;

public class AnalisadorLexico {

  public ArrayList<Tokens> analisador(String s) {

    ArrayList<Tokens> tokensList = new ArrayList<>();

    int token;
    int QuebraLinha = 1;
    String prov;
    int TAM = s.length();
    char[] c = s.toCharArray();

    for (int i = 0; i < TAM; i++) {
      Tokens t = new Tokens();
      prov = "";
      token = 0;

      if (c[i] == ' ') {
      } else if (c[i] == '\n' && i < TAM) {
        QuebraLinha++;

      } else if (Character.isAlphabetic(c[i]) && i < TAM) {

        while ((Character.isAlphabetic(c[i]) && i < TAM) || (Character.isDigit(c[i]) && i < TAM)) {
          if (c[i] == '$' && i + 1 == TAM) {
            System.out.println("Final");
            break;
          }

          prov += c[i];

          i++;
        }
        i--;

        token = t.tokenIDENT(prov);

      } else if (Character.isDigit(c[i]) && i < TAM) {

        while (Character.isDigit(c[i]) && i < TAM) {
          if (c[i] == '$' && i + 1 == TAM) {
            break;
          }

          prov += c[i];

          i++;
        }
        i--;
        token = 8;

      } else if (c[i] == ')' && i < TAM) {
        prov = ")";
        token = 40;

      } else if (c[i] == '(' && i < TAM) {
        prov = "(";
        token = 41;

      } else if (c[i] == '=' && i < TAM) {
        prov = "=";
        token = 28;

      } else if (c[i] == '+' && i < TAM) {
        prov = "+";
        token = 32;

      } else if (c[i] == '-' && i < TAM) {
        token = 43;
        prov = "-";

      } else if (c[i] == '>' && i < TAM) {
        token = 27;
        prov = ">";
        if (c[i + 1] == '=') {
          prov += "=";
          i++;
          token = 26;
        }
      } else if (c[i] == '.') {
        token = 37;
        prov = ".";
      } else if (c[i] == '<' && i < TAM) {
        token = 31;
        prov = "<";
        if (c[i + 1] == '=') {
          i++;
          prov += "=";
          token = 30;

        } else if (c[i + 1] == '>') {
          i++;
          prov += ">";
          token = 29;
        }
      } else if (c[i] == ';' && i < TAM) {
        token = 33;
        prov = ";";

      } else if (c[i] == '*' && i < TAM) {
        token = 39;
        prov = "*";

      } else if (c[i] == ':' && i < TAM) {
        token = 35;
        prov = ":";
        if (c[i + 1] == '=') {
          prov += "=";
          i++;
          token = 34;
        }
      } else if (c[i] == '\'' && i < TAM) {
        int cont = 0;

        while (c[i] != '\'' || cont == 0) {
          cont++;

          if (i >= TAM) {
            System.out.println("ERRO");
            break;
          } else {
            prov += c[i];
            i++;
          }
          if (c[i] == '$' && i + 1 == TAM) {
            Editor.campoErros.setText("ERRO, NÃO FECHADO LITERAL '");
            Editor.jTabbedPane1.setSelectedIndex(1);
            return tokensList;
          }
        }

        if (c[i] == '\'') {
          prov += c[i];
        }

        token = 10;

      } else if (c[i] == '/' && i < TAM) {

        if (c[i + 1] == '*') {
          prov += c[i];
          i++;
          prov += c[i];
          i++;

          while (c[i] != '*' && c[i + 1] != '/') {

            prov += c[i];
            i++;
            if (c[i] == '$' && i + 1 == TAM) {
              Editor.campoErros.setText("ERRO, NÃO FECHADO COMENTARIO DE BLOCO */");
              Editor.jTabbedPane1.setSelectedIndex(1);
              return tokensList;
            }
          }

          if (c[i] == '*' && c[i + 1] == '/') {
            prov += c[i];
            i++;
            prov += c[i];
          }

        } else {
          token = 36;
          prov += c[i];
        }
      } else if (c[i] == '#') {

        while (c[i] != '\n' && i < TAM) {
          i++;
        }
        i--;

      } else if (c[i] == '$' && i + 1 == TAM) {

        break;
      }

      if (token == 0) {
      } else {
        t.setToken(prov);
        t.setCodigo(token);
        t.setLinha(QuebraLinha);
        tokensList.add(t);
      }
    }

    Editor.jTabbedPane1.setSelectedIndex(0);
    return tokensList;
  }
}
