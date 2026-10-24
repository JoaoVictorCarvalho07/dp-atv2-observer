package br.pucpr.table.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/** Base para dados de tabela que avisam seus observadores (sujeito do padrão Observer). */
public abstract class ObservableTableData implements TableData {
  private final List<TableDataListener> listeners = new CopyOnWriteArrayList<>();

  @Override
  public void addListener(TableDataListener listener) {
    if (listener != null && !listeners.contains(listener)) {
      listeners.add(listener);
    }
  }

  @Override
  public void removeListener(TableDataListener listener) {
    listeners.remove(listener);
  }

  protected void fire(TableChange.Kind kind, int row) {
    final var change = new TableChange(this, kind, row);
    for (var listener : listeners) {
      listener.onTableChanged(change);
    }
  }
}
