package br.pucpr.table.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ColumnTableData<T> extends ObservableTableData {
  private final List<ColumnData<? super T>> columns;
  private final List<T> data;

  public ColumnTableData(
      Collection<? extends T> data, Collection<? extends ColumnData<? super T>> columns) {
    this.columns = new ArrayList<>(columns);
    this.data = new ArrayList<>(data);
  }

  @SafeVarargs
  public ColumnTableData(Collection<? extends T> data, ColumnData<? super T>... columns) {
    this(data, Arrays.asList(columns));
  }

  public void add(T item) {
    data.add(item);
    fire(TableChange.Kind.INSERTED, data.size() - 1);
  }

  public T remove(int row) {
    final var removed = data.remove(row);
    fire(TableChange.Kind.REMOVED, row);
    return removed;
  }

  public void set(int row, T item) {
    data.set(row, item);
    fire(TableChange.Kind.UPDATED, row);
  }

  public T item(int row) {
    return data.get(row);
  }

  @Override
  public int rowCount() {
    return data.size();
  }

  @Override
  public int colCount() {
    return columns.size();
  }

  @Override
  public String header(int col) {
    return columns.get(col).header();
  }

  @Override
  public String get(int row, int col) {
    var line = data.get(row);
    return columns.get(col).get(line);
  }
}
