package br.pucpr.table.widget;

import br.pucpr.table.model.TableChange;
import br.pucpr.table.model.TableData;
import br.pucpr.table.model.TableDataListener;

/** Componente simples que mostra quantos registros existem e a última operação. */
public class RowCounter implements TableDataListener {
  private final String label;

  public RowCounter(String label) {
    this.label = label;
  }

  public void attachTo(TableData data) {
    data.addListener(this);
  }

  @Override
  public void onTableChanged(TableChange change) {
    final var verbo =
        switch (change.kind()) {
          case INSERTED -> "inserido";
          case REMOVED -> "removido";
          case UPDATED -> "alterado";
        };
    System.out.printf(
        ">> %s: %d registro(s) | último %s na linha %d%n",
        label, change.source().rowCount(), verbo, change.row());
  }
}
