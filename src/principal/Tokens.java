package principal;

public class Tokens {

  String token;
  int codigo;
  int linha;

  public void setToken(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setLinha(int linha) {
    this.linha = linha;
  }

  public int getLinha() {
    return linha;
  }

  public int tokenIDENT(String palavra) {

    switch (palavra) {
      case "integer":
        return 12;
      case "var":
        return 1;
      case "senao":
        return 2;
      case "se":
        return 3;
      case "repita":
        return 4;
      case "procedure":
        return 5;
      case "or":
        return 6;
      case "of":
        return 7;
      case "nao":
        return 9;
      case "le":
        return 11;
      case "inicio":
        return 13;
      case "ident":
        return 14;
      case "faca":
        return 17;
      case "fim":
        return 16;
      case "escreve":
        return 18;
      case "entao":
        return 19;
      case "enquanto":
        return 20;
      case "chama":
        return 21;
      case "caso":
        return 22;
      case "begin":
        return 23;
      case "ate":
        return 24;
      case "and":
        return 25;
      default:
        return 14;
    }
  }
}
