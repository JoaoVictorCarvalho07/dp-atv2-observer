package br.pucpr.table.model;

/**
 * Descreve uma mudança nos dados de uma tabela.
 *
 * @param source tabela de dados que mudou
 * @param kind tipo da mudança
 * @param row linha afetada
 */
public record TableChange(TableData source, Kind kind, int row) {
  /** Tipos de mudança possíveis. */
  public enum Kind {
    INSERTED,
    REMOVED,
    UPDATED
  }
}
