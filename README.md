# Refatoração - Teste Prático Prothera

Esta branch (`refatoracao`) contém uma versão revisada da solução original, feita **após** a entrega oficial do teste, por iniciativa própria e para fins de estudo/portfólio. A branch `main` permanece intocada, exatamente como foi entregue.

## Por que essa branch existe

Depois de enviar o teste, revisei o código e identifiquei pontos de organização e precisão que valiam a pena corrigir. Como o processo seletivo já havia sido finalizado, optei por isolar essas mudanças numa branch separada, sem alterar o que já foi avaliado.

## O que mudou em relação à `main`

O comportamento do programa é **idêntico** ao da versão original — mesma entrada, mesma saída. As mudanças são de qualidade interna do código:

### `Pessoa.java`
- Campo `nome` passou a ser `private` (antes tinha visibilidade padrão/package), ficando consistente com `dataNascimento`.
### `Funcionario.java`
- `aumentaSalario` e `calculaSalariosMinimos` agora operam diretamente com `BigDecimal.multiply`/`divide`, sem converter para `float` no meio do cálculo. Na versão original, esse caminho por `float` reintroduzia o problema de precisão que o uso de `BigDecimal` deveria evitar.
- `calculaSalariosMinimos()` não recebe mais um parâmetro redundante — usa o próprio salário do objeto.
### `Principal.java`
- A lógica que antes estava toda dentro do `main()` foi separada em métodos privados, um por regra de negócio (`removerFuncionario`, `exibirFuncionarios`, `aumentarSalarios`, `exibirPorFuncao`, `exibirAniversariantesOutubroDezembro`, `exibirMaisVelho`, `exibirNomesEmOrdemAlfabetica`, `exibirSalarioTotal`, `exibirSalariosMinimos`), com `main()` apenas orquestrando as chamadas.
- Removida a inicialização frágil de "mais velho" baseada em `idadeAnterior = 0` (que dependia de idades sempre positivas); agora a comparação usa o primeiro funcionário da lista como ponto de partida.
## Como executar

Igual à `main`:

```bash
cd src
javac -d ../bin module-info.java prothera/*.java
java -p ../bin -m TestePraticoProthera/prothera.Principal
```

## Status

Refatoração feita apenas para aprendizado pessoal — **não representa uma nova entrega** para o processo seletivo da Prothera, que já foi concluído com o conteúdo da branch `main`.