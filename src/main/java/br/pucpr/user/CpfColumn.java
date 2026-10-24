package br.pucpr.user;

import br.pucpr.table.model.ColumnData;

/** Coluna com o CPF no formato 000.000.000-00. */
public class CpfColumn implements ColumnData<User> {
  private static final int TAMANHO_CPF = 11;

  @Override
  public String header() {
    return "CPF           ";
  }

  @Override
  public String get(User user) {
    final var cpf = user.cpf() == null ? "" : user.cpf().replaceAll("\\D", "");
    if (cpf.isEmpty()) {
      return "(vazio)";
    }
    if (cpf.length() != TAMANHO_CPF) {
      return "?? " + cpf;
    }
    return cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
  }
}
