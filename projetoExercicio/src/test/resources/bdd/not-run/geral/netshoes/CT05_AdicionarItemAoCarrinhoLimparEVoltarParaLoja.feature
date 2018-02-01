Feature: CT05 - Adicionar item no carrinho, Limpar Carrinho e voltar para loja

@netshoes
Scenario Outline: Adicionar item
  Given estou na pagina do site do netshoes "<url>"
  When preencho o campo 'Busca' "<pesqProduto>"
  And clico no icone de busca
  And clico no link do produto "<nomeProduto>"
  And clico no rdb 'color' "<posCor>"
  And clico no botao 'Comprar'
  And verifico o produto no carrinho "<qtdProdComprados>"
  And limpo o carrinho
  Then volto para para o inicio da loja

Examples:
   | url                         | pesqProduto | nomeProduto                          | posCor| qtdProdComprados |
   | http://www.netshoes.com.br/ |   Mochila   | Mochila Adidas Versatile 2 Masculina | 1     | 1                |


