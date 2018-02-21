Feature: CT03 - Escolher um calçado na secao outlet com valor abaixo de 150 reais

@escolheCalcadoSecao
Scenario Outline: Escolher Calcado
  Given estou na pagina do site do netshoes "<url>"
  When preencho o campo 'Busca' "<pesqProduto>"
  And clico no icone de busca
  And clico no link em 'Outlet' "<linkOutlet>"
  And clico na ckb 'Preco' "<precoAte>"
  And clico no link do produto "<nomeProduto>"
  And clico no rdb 'color' "<posCor>"
  And clico no rdb 'size' "<tamanhoTenis>"
  And clico no botao 'Comprar'
  Then verifico o produto no carrinho "<qtdProdComprados>"

Examples:
   | url                         | pesqProduto | linkOutlet          |precoAte | nomeProduto          | posCor | tamanhoTenis | qtdProdComprados |
   | http://www.netshoes.com.br/ |   Ofertas   | Calçados Masculinos |  150    | Tênis Kappa Impact   | 4      | 38           | 1                |


