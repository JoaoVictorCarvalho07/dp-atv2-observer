# Atividade 2 – Redesenhar a tabela quando os dados mudam

Redesenhar a tabela (ou outros componentes) sempre que os dados da tabela mudarem.
Implemente uma solução que permita a esses componentes saberem que a mudança ocorreu.

## Padrão utilizado: Observer

- **Sujeito:** `ObservableTableData` guarda a lista de observadores e dispara um
  `TableChange` (tipo `INSERTED`, `REMOVED` ou `UPDATED` + linha) a cada mudança.
  `ColumnTableData` herda dela e ganhou `add`, `remove` e `set`.
- **Observador:** a interface `TableDataListener` (`onTableChanged`).
- **Componentes que observam:**
  - `Table`: com `watch()` se inscreve e se redesenha sozinha; `stopWatching()` cancela.
  - `RowCounter`: um segundo componente, que mostra o total de registros e a última operação.

`TableData` recebeu `addListener`/`removeListener` como métodos `default` vazios, então
implementações antigas (imutáveis) continuam funcionando sem mudança.

Esta atividade parte da atividade 1 (colunas `ColumnData` de usuário, padrão Strategy).

## Como executar

Requer JDK 21.

```bash
./gradlew build   # compila, roda spotless e spotbugs
./gradlew run
```
