package br.pucpr.user;

import br.pucpr.table.model.ColumnData;
import java.util.Locale;

/** Coluna de e-mail: normaliza para minúsculas e sinaliza valores vazios ou malformados. */
public class EmailColumn implements ColumnData<User> {
  @Override
  public String header() {
    return "E-MAIL                    ";
  }

  @Override
  public String get(User user) {
    final var email = user.email() == null ? "" : user.email().strip();
    if (email.isEmpty()) {
      return "(vazio)";
    }
    final var arroba = email.indexOf('@');
    final var valido =
        arroba > 0 && arroba == email.lastIndexOf('@') && arroba < email.length() - 1;
    return valido ? email.toLowerCase(Locale.ROOT) : "(inválido) " + email;
  }
}
