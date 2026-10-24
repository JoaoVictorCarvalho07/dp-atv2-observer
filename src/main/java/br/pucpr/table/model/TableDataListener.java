package br.pucpr.table.model;

/** Observador: quem implementa é avisado sempre que os dados de uma tabela mudam. */
@FunctionalInterface
public interface TableDataListener {
  void onTableChanged(TableChange change);
}
