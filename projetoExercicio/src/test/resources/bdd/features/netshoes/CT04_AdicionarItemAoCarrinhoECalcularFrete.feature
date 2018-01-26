Feature: CT04 - Adicionar item ao carrinho e calcular frete atq o CEP da RSI Matriz

@produtoum
Scenario Outline: Adicionar Item
  Given estou na pagina do site do netshoes "<url>"
  When preencho o campo 'Busca' "<pesqProduto>"
  And clico no icone de busca
  And clico no link do produto "<nomeProduto>"
  And clico no rdb 'color' "<posCor>"
  And clico no botao 'Comprar'
  And verifico o produto no carrinho "<qtdProdComprados>"
  And preencho os campos do 'CPF' "<cpf>"
  And clico no botao 'Calcular Frete'
  Then verifico o calculo do frete
  
Examples:
   | url                         | pesqProduto				| nomeProduto                       | posCor | qtdProdComprados | cpf       |
   | http://www.netshoes.com.br/ | Bola de futebol de campo | Bola Futebol Campo Topper Cup III | 1      | 1                | 12345-000 |


