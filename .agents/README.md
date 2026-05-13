# wedigi-ia-centralization

## Estrutura de pastas (o que cada uma faz)

- `skills/`
  - Biblioteca principal de skills do projeto.
  - Cada pasta representa uma skill independente com suas instruções (`SKILL.md`) e, quando necessário, arquivos de apoio (`references`, `scripts`).

- `tracks/`
  - Trilhas temáticas que organizam skills por domínio (ex.: `payment`, `vtex-io`, `faststore`).
  - Servem como curadoria: mostram agrupamento, ordem recomendada e contexto de uso.

- `rules/`
  - Regras em formato de tooling (ex.: `.mdc`), prontas para motores que suportam auto-attach por contexto/glob.
  - Foco em aplicação operacional de guardrails e padrões durante o desenvolvimento.

- `exports/`
  - Saídas geradas para diferentes plataformas/agentes (`agents-md`, `claude`, `cursor`, `copilot`, `kiro`, `opencode`).
  - É a camada de distribuição/compatibilidade: mesmo conhecimento em formatos diferentes para cada ferramenta.

- `agents/`
  - Personas/agentes do projeto (ex.: especialista backend, frontend, QA, etc.).
  - Define comportamento, foco e forma de atuação dos agentes; não é export de skill.

- `workflows/`
  - Fluxos e receitas de execução para tarefas recorrentes usando skills/rules/agents.

- `scripts/`
  - Automações utilitárias para manutenção, sincronização e operações do repositório.

- `skills-vtex/`
  - Área de origem/importação usada para trazer pacotes VTEX (skills, tracks, rules, exports).
  - Pode ser mantida como referência ou removida após consolidação no repositório principal.

### Comandos principais

```bash
npm run agents:add
npm run agents:remove
npm run agents:init
npm run agents:update
npm run agents:status
npm run agents:new
npm run agents:publish
npm run agents:save-ref
npm run agents:sync
```

## Scripts disponíveis

`npm run agents:add`

- Adiciona o submodule `.agents` apontando para `git@github.com:wedigibrasil/wedigi-ia-centralization.git`

`npm run agents:remove`

- Remove completamente o submodule `.agents` e limpa referências locais (`.gitmodules`, `.git/modules/.agents` e config de submodule)

`npm run agents:init`

- Inicializa o submodule e seus submódulos recursivamente para quem clonou o projeto

`npm run agents:update`

- Atualiza o submodule remoto e faz merge das mudanças em `.agents`

`npm run agents:status`

- Mostra o status atual do submodule

`npm run agents:new`

- Muda para `main` dentro de `.agents` e puxa a última versão de `origin/main`

`npm run agents:publish`

- Dentro de `.agents`, adiciona, comita e envia as mudanças para `origin main`

`npm run agents:save-ref`

- Atualiza a referência do submodule no projeto principal e comita essa mudança

`npm run agents:sync`

- Atualiza `.agents` e salva o novo ponteiro no projeto principal

## Exemplo de package.json opcional

O arquivo `package.json` não está adicionado neste repositório. Abaixo está um exemplo de como você pode definir os scripts localmente ou em outro projeto que consuma este fluxo:

```json
{
  "scripts": {
    "agents:add": "git submodule add git@github.com:wedigibrasil/wedigi-ia-centralization.git .agents",
    "agents:remove": "git submodule deinit -f .agents 2>/dev/null || true && git rm -f .agents 2>/dev/null || true && git rm --cached -f .gitmodules 2>/dev/null || true && rm -rf .git/modules/.agents .agents && git config --remove-section submodule..agents 2>/dev/null || true && git config --remove-section submodule.\".agents\" 2>/dev/null || true && rm -f .gitmodules",
    "agents:init": "git submodule update --init --recursive",
    "agents:update": "git submodule update --remote --merge .agents",
    "agents:status": "git submodule status .agents",
    "agents:new": "cd .agents && git checkout main && git pull origin main",
    "agents:publish": "cd .agents && git add . && git commit -m \"docs: update agents\" && git push origin main",
    "agents:save-ref": "git add .agents && git commit -m \"chore: update agents reference\"",
    "agents:sync": "npm run agents:update && npm run agents:save-ref"
  }
}
```

## Fluxo recomendado para adicionar algo novo

1. Atualize o submodule local:

```bash
npm run agents:new
```

2. Crie ou edite arquivos dentro de `.agents`

```bash
cd .agents
# editar arquivos ou criar uma nova regra
```

3. Envie as mudanças para o repo central de `.agents`

```bash
npm run agents:publish
```

4. No projeto principal, atualize a referência do submodule:

```bash
npm run agents:save-ref
```

## Exemplo de uso

Para quem clonou o projeto e quer baixar o submodule:

```bash
npm run agents:init
```

Para atualizar com o repo central:

```bash
npm run agents:update
```

Para atualizar e salvar o novo ponteiro no repo principal:

```bash
npm run agents:sync
```

Para adicionar um submodule novo se ainda não existir:

```bash
npm run agents:add
```

Para remover completamente o submodule:

```bash
npm run agents:remove
```

## Observação

Também existe a opção de `subtree`, mas a recomendação aqui é usar `submodule` para manter controle de versão mais claro e evitar atualizações automáticas inesperadas.
