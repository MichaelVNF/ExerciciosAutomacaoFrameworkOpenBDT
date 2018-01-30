Feature: CT05 - Calcular frete de qualquer item ate o CEP da RSI Matriz (Osasco)

@calculaFrete
Scenario Outline: Calcular Frete
  Given estou na pagina do site do sou barato "<url>"
  When preencho o campo de 'Busca' "<pesqProduto>"
  And clico no botao para 'Buscar'
  And clico no link do produto especifico "<nomeProduto>"
  And clico no botao para 'Comprar'
  And clico no rdb 'Garantia' "<anosGarantia>"
  And verifico os produtos na sacola "<qtdProdComprados>"
  And preencho o campo 'Cep' "<cep>"
  And clico no botao 'Ok' para calcular cep
  Then verifico o calculo do cep

Examples:
   | url                          | pesqProduto |nomeProduto                                                                       | anosGarantia | qtdProdComprados | cep      |
   | http://www.soubarato.com.br/ | Computador  |Computador All in One LG 24V550-BJ31P1 Intel Core i5 4GB 500GB LED 23,8 Windows 10| Sem          | 1                | 06020-000|

