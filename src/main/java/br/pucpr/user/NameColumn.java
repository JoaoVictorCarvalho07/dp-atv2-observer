package br.pucpr.user;

import br.pucpr.table.model.ColumnData;

/** Coluna com o nome do usuário; nomes vazios aparecem como "(sem nome)". */
public class NameColumn implements ColumnData<User> {
  @Override
  public String header() {
    return "NOME COMPLETO                  ";
  }

  @Override
  public String get(User user) {
    final var nome = user.name();
    return nome == null || nome.isBlank() ? "(sem nome)" : nome.strip();
  }
}
