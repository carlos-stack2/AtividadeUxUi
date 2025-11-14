# AtividadeUxUi

## NOTAÇÃO DE GRAFO DE FLUXO

NÓS

Nó 1 -  Início do método

Nó 2 - Montagem do SQL 

Nó 3 - Conexão com BD (`conectarBD()`)  

Nó 4 - Início do `try`  

Nó 5 - Criação de `Statement`  

Nó 6 - Execução da consulta (`executeQuery`) 

Nó 7 - Decisão: `if(rs.next())` 

Nó 8 - Atribui `result = true` e captura `nome` 

Nó 9 -  Bloco `catch`

Nó 10 - return result` / Fim

Fluxo entre os nós

1→2

2→3

3→4

4→5

5→6

6→7

7→8 (se verdadeiro)

7→10 (se falso)

8→10

4→9 (exceção)

9→10


## COMPLEXIDADE CICLOMÁTICA

Fórmula

M = E − N + 2P

M = 11-10 +2(1) = 3

Complexidade ciclomática = 3

## CAMINHOS BÁSICOS 

Caminho básico 1 - Usuário não encontrado


1 → 2 → 3 → 4 → 5 → 6 → 7(False) → 10


Caminho básico 2 - Usuário encontrado

1 → 2 → 3 → 4 → 5 → 6 → 7(True) → 8 → 10

Caminho básico 3 - Fluxo com excessão(cai no catch)

1 → 2 → 3 → 4 → 9 → 10



