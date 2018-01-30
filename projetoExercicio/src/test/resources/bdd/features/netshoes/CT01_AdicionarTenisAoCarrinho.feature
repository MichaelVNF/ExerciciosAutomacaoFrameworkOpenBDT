Feature: CT01 - Adicionar tenis ao carrinho (qualquer um)

@adicionaTenis
Scenario Outline: Adicionar Tenis
  Given estou na pagina do site do netshoes "<url>"
  When preencho o campo 'Busca' "<pesqProduto>"
  And clico no icone de busca
  And clico no link do produto "<nomeProduto>"
  And clico no rdb 'color' "<posCor>"
  And clico no rdb 'size' "<tamanhoTenis>"
  And clico no botao 'Comprar'
  Then verifico o produto no carrinho "<qtdProdComprados>"

Examples:
   | url                         | pesqProduto | nomeProduto                      | posCor| tamanhoTenis | qtdProdComprados |
   | http://www.netshoes.com.br/ |   Tênis     | Tênis Nike Flex Bijoux Feminino  | 1     | 34           | 1                |


