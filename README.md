# Teste Prático - Prothera

Teste do processo seletivo da Prothera. O projeto simula o cadastro e a gestão de uma lista de funcionários, aplicando conceitos de orientação a objetos, coleções e manipulação de datas em Java.

## Tecnologias

- Java 17+ (uso de `Locale.of`, `LocalDate`, `Period`)
- Sem dependências externas — projeto puro Java (Eclipse)

## Estrutura do projeto

```
src/
└── prothera/
    ├── Pessoa.java        # Classe base: nome, data de nascimento e idade
    ├── Funcionario.java   # Herda de Pessoa: salário, função e regras de negócio
    └── Principal.java     # Classe main: monta a lista e executa as regras pedidas
```

- **Pessoa**: encapsula os dados pessoais e calcula a idade a partir da data de nascimento.
- **Funcionario**: estende `Pessoa`, adicionando salário (`BigDecimal`) e função, além dos métodos de aumento de salário e formatação.
- **Principal**: ponto de entrada da aplicação, onde a lista de funcionários é criada e todas as regras abaixo são executadas em sequência.

## Funcionalidades implementadas

A partir da lista de funcionários cadastrada em `Principal`, o programa:

1. Remove o funcionário "Joao" da lista.
2. Exibe todos os funcionários (nome, data de nascimento, salário formatado e função).
3. Aumenta o salário de todos os funcionários em 10% e exibe a lista atualizada.
4. Agrupa e lista os funcionários por função, em ordem alfabética das funções.
5. Lista os funcionários que fazem aniversário em outubro ou dezembro.
6. Identifica e exibe o funcionário mais velho.
7. Lista os nomes de todos os funcionários em ordem alfabética.
8. Calcula e exibe o salário total da equipe.
9. Calcula e exibe, para cada funcionário, quantos salários mínimos seu salário representa.

## Como executar

### Via Eclipse
1. Importe o projeto como "Existing Projects into Workspace".
2. Rode a classe `prothera.Principal` como Java Application.

### Via linha de comando
```bash
cd src
javac -d ../bin module-info.java prothera/*.java
java -p ../bin -m TestePraticoProthera/prothera.Principal
```

## Observações

- O salário mínimo usado no cálculo de "salários mínimos" está fixado em `1212` (valor de referência usado no exercício).
- A formatação numérica segue o padrão `pt-BR` (vírgula como separador decimal).
