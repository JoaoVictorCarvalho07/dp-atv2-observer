package br.pucpr.user;

import br.pucpr.table.model.ColumnData;

/** Coluna com o identificador do usuário, com zeros à esquerda. */
public class IdColumn implements ColumnData<User> {
  @Override
  public String header() {
    return "CÓDIGO";
  }

  @Override
  public String get(User user) {
    return user.id() == null ? "------" : "#%05d".formatted(user.id());
  }
}
