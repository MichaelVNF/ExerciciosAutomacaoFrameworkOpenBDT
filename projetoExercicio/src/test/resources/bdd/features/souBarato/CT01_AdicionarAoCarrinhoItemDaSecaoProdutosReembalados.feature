Feature: CT01 - Adicionar ao carrinho um item da seção Produtos Reembalados

@adicionaProdutoReembalado
Scenario Outline: Adicionar Produto
  Given estou na pagina do site do sou barato "<url>"
  When clico no menu superior "<opcao>"
  And clico no link do produto especifico "<nomeProduto>"
  And clico no botao para 'Comprar' 
  And clico no rdb 'Garantia' "<anosGarantia>"
  Then verifico os produtos na sacola "<qtdProdComprados>"

Examples:
   | url                          | opcao                | nomeProduto     | anosGarantia | qtdProdComprados |
   | http://www.soubarato.com.br/ | Produtos Reembalados | Smart TV LED 49 | 2            | 1                |


