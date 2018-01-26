Feature: CT03 - Escolher um calçado na secao outlet com valor abaixo de 150 reais

@secaoum
Scenario Outline: Escolher Calcado
  Given estou na pagina do site do netshoes "<url>"
#  When preencho o campo 'Busca' "<pesqProduto>"
#  And clico no icone de busca
#  And clico no link do produto "<posLinkProduto>"
#  And clico no rdb 'color' "<posCor>"
#  And clico no rdb 'size' "<tamanhoCamisa>"
#  And clico no botao 'Comprar'
#  Then verifico o produto no carrinho "<qtdProdComprados>"

Examples:
   | url                         | pesqProduto				 | posLinkProduto | posCor| tamanhoCamisa | qtdProdComprados |
   | http://www.netshoes.com.br/ | Camisa Seleção Brasileira | 1              | 1     | G             | 1                |


