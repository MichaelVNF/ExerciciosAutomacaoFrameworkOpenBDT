Feature: CT05 - Adicionar item no carrinho, Limpar Carrinho e voltar para loja

@netshoes
Scenario Outline: Adicionar item
  Given estou na pagina do site do netshoes "<url>"
  When preencho o campo 'Busca' "<pesqProduto>"
  And clico no icone de busca
  And clico no link do produto "<nomeProduto>"
  And clico no rdb 'color' "<posCor>"
  And clico no rdb 'size' "<tamanhoMochila>"
  And clico no botao 'Comprar'
  And verifico o produto no carrinho "<qtdProdComprados>"
  And limpo o carrinho
  And volto para para o inicio da loja
  Then verifico se esta na pagina especifica "<url>"

Examples:
   | url                         | pesqProduto | nomeProduto                          | posCor| tamanhoMochila |qtdProdComprados |
   | http://www.netshoes.com.br/ |   Mochila   | Mochila Adidas Versatile 2 Masculina | 1     | M              | 1                |


