Feature: CT03 - Comprar ingresso

@compraIngresso
Scenario Outline: Comprar ingresso
  Given estou na pagina do site do hotel urbano "<url>"
  When clico no menu 'Ingressos' na barra superior
  And preencho o campo de 'Pesquisa' "<pesquisa>"
  And clico na sugestao "<posSugestao>"
  And clico no botao 'Buscar'
  And clico no link 'Ver' "<posLink>"
  And verifico a abertura da nova janela
  And seleciono a ddl 'Pessoas' "<qtdPessoas>"
  And clico no link 'Comprar' ingresso "<posLink2>"
  And preencho o campo 'Email' "<email>"
  And preencho o campo 'Cpf' "<cpf>"
  And preencho o campo 'Data de Nascimento' "<dtNasc>"
  And preencho o campo 'Telefone' "<tel>"
  And preencho o campo 'Numero do Cartao' "<numCartao>"
  And preencho o campo 'Titular' "<titular>"
  And preencho o campo 'Validade' "<validade>"
  And preencho o campo 'Codigo de Seguranca' "<codSeg>"
  And seleciono o numero de 'Parcelas' "<qtdParcelas>"
  Then clico na ckb 'Armazenar dados' "<armazenarDados>"

Examples:
   | url                            | pesquisa              | posSugestao |posLink    |posIngresso |qtdPessoas | posLink2 | email             | cpf         | dtNasc    | tel         |numCartao        | titular          | validade   | codSeg | qtdParcelas | armazenarDados |
   | https://www.hotelurbano.com/   | Thermas dos Laranjais | 1           | 1         |3           |4          |  3       | usuario@email.com | 18277552530 | 02/02/2000| 11999999999 |4556905972222574 | Usuario de Testes| 10/19      | 300    |    4        |   true         |


