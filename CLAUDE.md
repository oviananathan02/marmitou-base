# marmitou-base

## O que é

Biblioteca compartilhada do ecossistema Marmitou. Publicada como artefato `.jar` versionado (repositório de artefatos) e consumida como dependência pelos módulos `marmitou-api` e `marmitou-model`. Não depende de nenhum dos outros dois módulos.

## Stack

- Java 21
- Maven
- Spring Boot 3 (quando aplicável, ex: auto-configurations reutilizáveis)

## Princípios gerais

O projeto deve priorizar:

```text
consistência + legibilidade + reutilização + baixo acoplamento + simplicidade
```

Não adicionar complexidade sem necessidade. Toda decisão de arquitetura deve considerar primeiro a consistência com os padrões já existentes no Marmitou e no `marmitou-base`.

## Nomenclatura Java

```text
Classes       → PascalCase
Métodos       → camelCase
Variáveis     → camelCase
Constantes    → UPPER_SNAKE_CASE
```

## Pacotes

`com.marmitou.base.<area>` (ex: `com.marmitou.base.util`, `com.marmitou.base.exception`).

## O que pertence ao base

Antes de criar algo novo em `marmitou-api` ou `marmitou-model`, verificar se já existe equivalente aqui. Só deve ir para o `marmitou-base` aquilo que:

- possui comportamento genérico;
- pode ser reutilizado por diferentes projetos/módulos;
- não depende de regras específicas do negócio;
- possui baixo acoplamento com a aplicação.

Não mover código de negócio para o `base` apenas para evitar duplicação. Checklist completo em [`.claude/skills/criterio-para-base`](.claude/skills/criterio-para-base/SKILL.md).

## Utilitários

Antes de criar um novo utilitário, verificar se já existe método equivalente aqui e reutilizar. Evitar duplicações que resolvem o mesmo problema com nomes diferentes (ex: `isNullOrEmpty` vs `isEmptyOrNull` vs `hasNoValue`).

## Exceptions compartilhadas

Toda hierarquia de exceptions de negócio usada por `marmitou-api` e `marmitou-model` nasce aqui, para que o `marmitou-api` consiga capturá-las de forma genérica no handler global. Ver [`.claude/skills/hierarquia-exceptions`](.claude/skills/hierarquia-exceptions/SKILL.md).

## Métodos

Preferir métodos pequenos, com uma única responsabilidade. Evitar métodos que acumulem múltiplas responsabilidades não relacionadas.

## Interfaces

Toda classe utilitária/serviço reutilizável exposta daqui segue o mesmo padrão dos outros módulos: interface separada da implementação quando fizer sentido ser consumida via injeção de dependência.

## Estado atual

`marmitou-base` começa vazio — será populado sob demanda conforme necessidades reais surgirem em `marmitou-api`/`marmitou-model`. Não antecipar utilitários especulativos.

## Regra principal

Ao adicionar algo aqui, sempre avaliar:

```text
1. Isso é realmente genérico ou é regra de negócio disfarçada?
2. Já existe algo equivalente?
3. O nome segue as convenções?
4. Isso adiciona complexidade desnecessária?
```
