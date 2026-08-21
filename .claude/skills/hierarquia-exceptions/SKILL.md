---
name: hierarquia-exceptions
description: Como definir e organizar a hierarquia de exceptions de negócio compartilhada entre marmitou-api e marmitou-model.
---

# Hierarquia de exceptions do Marmitou

Todas as exceptions de negócio lançadas deliberadamente por código em `if`/`catch` (validações, regras de domínio) devem estender uma classe base comum definida aqui no `marmitou-base`:

```java
public abstract class MarmitouException extends RuntimeException {
    // código do erro, status HTTP sugerido, mensagem, etc.
}
```

- Exceptions que estendem `MarmitouException` = erro **tratado** → o `marmitou-api` responde como `WARNING` (ver skill `tratamento-erros` em `marmitou-api`).
- Qualquer outra exception não prevista (NPE, falha de infra, bug) que suba sem ter sido capturada = **não tratado** → o `marmitou-api` responde como `ERROR` genérico.

## Convenção de subclasses

Criar uma exception específica por caso de negócio, nunca lançar `MarmitouException` direto nem `RuntimeException`:

```text
UserNotFoundException extends MarmitouException
InvalidUserException extends MarmitouException
UserAlreadyExistsException extends MarmitouException
```

Cada exception deve representar claramente o problema ocorrido. `marmitou-model` e `marmitou-api` lançam subclasses de `MarmitouException`; o `marmitou-api` é quem sabe traduzir isso em resposta HTTP.
