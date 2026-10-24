package br.pucpr.table.model;

public interface TableData {
  int rowCount();

  int colCount();

  String header(int col);

  String get(int row, int col);

  /** Inscreve um observador. Por padrão, dados imutáveis não emitem eventos. */
  default void addListener(TableDataListener listener) {}

  default void removeListener(TableDataListener listener) {}
}
