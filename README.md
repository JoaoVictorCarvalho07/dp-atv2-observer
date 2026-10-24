# Atividade 1 – ColumnData de usuários

Termine de implementar as interfaces `ColumnData` para exibir a tabela de usuários.

## Padrão utilizado: Strategy

A `Table` não conhece a classe `User`. Ela só sabe trabalhar com `ColumnData<T>`, que diz
o cabeçalho da coluna e como transformar um objeto em texto. Cada coluna é uma estratégia
diferente de extração/formatação:

| Classe        | O que faz                                                         |
|---------------|-------------------------------------------------------------------|
| `IdColumn`    | código com zeros à esquerda (`#00101`)                            |
| `NameColumn`  | nome sem espaços extras; vazio vira `(sem nome)`                  |
| `CpfColumn`   | aceita CPF com ou sem pontuação e formata como `000.000.000-00`   |
| `EmailColumn` | normaliza para minúsculas; marca e-mails vazios ou inválidos      |

Para criar uma coluna nova basta implementar `ColumnData<User>`, sem alterar a tabela
(princípio aberto/fechado).

## Como executar

Requer JDK 21.

```bash
./gradlew build   # compila, roda spotless e spotbugs
./gradlew run     # imprime as tabelas
```
