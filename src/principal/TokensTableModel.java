package principal;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TokensTableModel extends AbstractTableModel {

  private static final long serialVersionUID = 1L;

  private List<Tokens> linhas;

  private String[] colunas = new String[] {"Token", "Codigo", "Linha"};

  public TokensTableModel() {
    linhas = new ArrayList<>();
  }

  public TokensTableModel(List<Tokens> listaDeTokens) {
    linhas = new ArrayList<>(listaDeTokens);
  }

  @Override
  public int getColumnCount() {
    return colunas.length;
  }

  @Override
  public int getRowCount() {
    return linhas.size();
  }

  @Override
  public String getColumnName(int columnIndex) {
    return colunas[columnIndex];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return String.class;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Tokens cliente = linhas.get(rowIndex);

    switch (columnIndex) {
      case 0:
        return cliente.getToken();
      case 1:
        return cliente.getCodigo();
      case 2:
        return cliente.getLinha();
      default:
        throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Tokens cliente = linhas.get(rowIndex);

    switch (columnIndex) {
      case 0:
        cliente.setToken(aValue.toString());
      case 1:
        cliente.setCodigo(Integer.parseInt(aValue.toString()));
      case 2:
        cliente.setLinha(Integer.parseInt(aValue.toString()));
    }
    fireTableCellUpdated(rowIndex, columnIndex);
  }

  public void setValueAt(Tokens aValue, int rowIndex) {
    Tokens cliente = linhas.get(rowIndex);

    cliente.setToken(aValue.getToken());
    cliente.setCodigo(aValue.getCodigo());
    cliente.setLinha(aValue.getLinha());

    fireTableCellUpdated(rowIndex, 0);
    fireTableCellUpdated(rowIndex, 1);
    fireTableCellUpdated(rowIndex, 2);
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return false;
  }

  public Tokens getTokens(int indiceLinha) {
    return linhas.get(indiceLinha);
  }

  public void addTokens(Tokens m) {
    linhas.add(m);

    int ultimoIndice = getRowCount() - 1;

    fireTableRowsInserted(ultimoIndice, ultimoIndice);
  }

  public void removeTokens(int indiceLinha) {
    linhas.remove(indiceLinha);

    fireTableRowsDeleted(indiceLinha, indiceLinha);
  }

  public void addListaDeTokens(List<Tokens> cliente) {
    int tamanhoAntigo = getRowCount();

    linhas.addAll(cliente);

    fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
  }

  public void limpar() {
    linhas.clear();

    fireTableDataChanged();
  }

  public boolean isEmpty() {
    return linhas.isEmpty();
  }
}
