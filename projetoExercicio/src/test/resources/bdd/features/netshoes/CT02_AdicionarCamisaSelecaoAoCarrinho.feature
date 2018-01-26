Feature: CT02 - Adicionar ao carrinho camisa selecao brasileira 

@produtoum
Scenario Outline: Adicionar Camisa
  Given estou na pagina do site do netshoes "<url>"
  When preencho o campo 'Busca' "<pesqProduto>"
  And clico no icone de busca
  And clico no link do produto "<nomeProduto>"
  And clico no rdb 'color' "<posCor>"
  And clico no rdb 'size' "<tamanhoCamisa>"
  And clico no botao 'Comprar'
  Then verifico o produto no carrinho "<qtdProdComprados>"

Examples:
   | url                         | pesqProduto				 | nomeProduto                                               | posCor| tamanhoCamisa | qtdProdComprados |
   | http://www.netshoes.com.br/ | Camisa Seleção Brasileira | Camisa Seleção Brasil I 2016 s/nº Torcedor Nike Masculina | 1     | G             | 1                |


