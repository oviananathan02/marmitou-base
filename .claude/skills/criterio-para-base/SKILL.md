---
name: criterio-para-base
description: Checklist para decidir se um trecho de código deve ser movido/criado no marmitou-base ao invés de marmitou-api ou marmitou-model.
---

# Critério para mover código para o marmitou-base

Antes de adicionar algo ao `marmitou-base`, responda:

1. É genérico o suficiente para ser reutilizado por outro projeto, não só pelo Marmitou?
2. Não depende de regra de negócio específica (ex: regras de tenant, de restaurante, de pedido)?
3. Tem baixo acoplamento com a aplicação (não referencia Entities/DTOs específicos do domínio)?
4. Já existe um utilitário equivalente aqui? (buscar antes de criar)

Se a resposta para 1–3 for "sim", o código pertence ao `base`.
Se qualquer resposta for "não", o código fica no módulo (`api` ou `model`) onde é usado — não mover para o `base` só para "evitar duplicação".

## Evitar duplicação de utilitários equivalentes

Exemplos de métodos que devem ser reutilizados quando já existirem, ao invés de recriados com outro nome:

```text
isNull / isNotNull
isNullOrEmpty / isNotEmpty
nonNullAndNotEmpty
```

Não criar `isEmptyOrNull`, `hasNoValue`, `isEmptyValue` etc para resolver o mesmo problema que um utilitário existente já resolve.
