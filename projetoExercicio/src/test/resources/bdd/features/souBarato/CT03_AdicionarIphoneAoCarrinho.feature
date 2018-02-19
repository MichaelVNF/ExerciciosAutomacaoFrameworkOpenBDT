Feature: CT03 - Adicionar Iphone ao carrinho (via campo pesquisa)

@adicionaProdutoViaCampoPesquisa
Scenario Outline: Adicionar Iphone
  Given estou na pagina do site do sou barato "<url>"
  When preencho o campo de 'Busca' "<pesqProduto>"
  And clico no botao para 'Buscar'
  And clico no link do produto especifico "<nomeProduto>"
  And clico no botao para 'Comprar'
  And clico no rdb 'Garantia' "<anosGarantia>"
  Then verifico os produtos na sacola "<qtdProdComprados>"

Examples:
   | url                          | pesqProduto | nomeProduto    | anosGarantia | qtdProdComprados |
   | http://www.soubarato.com.br/ | Iphone      | Iphone 6       | 1            | 1                | 
