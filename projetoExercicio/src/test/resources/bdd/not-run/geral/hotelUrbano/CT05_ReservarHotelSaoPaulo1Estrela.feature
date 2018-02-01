Feature: CT05 - Reservar hotel 1 estrela São Paulo

@hotelUrbano
Scenario Outline: Reservar hotel
  Given estou na pagina do site do hotel urbano "<url>"
  When clico no menu 'Hoteis' na barra superior
  And preencho o campo de 'Pesquisa' "<pesquisa>"
  And clico no botao 'Buscar'
  And seleciono o nivel de 'Categoria' "<qtdEstrelas>"
  And clico no link 'Ver' "<nomeHotel>"
  And verifico o link do hotel clicado "<qtdEstrelas>"
  And preencho o campo 'Entrada' "<dataEntrada>"
  And preencho o campo 'Saida' "<dataSaida>"
  And seleciono a ddl 'Quartos' "<qtdQuartos>"
  And seleciono a ddl 'Adultos' "<qtdAdultos>"
  And seleciono a ddl 'Criancas' "<qtdCriancas>"
  And clicar botao 'Verificar Disponibilidade'
  And seleciono a ddl 'Numero de Quartos' "<posDdl>" "<qtdQuartos>"
  And clico no botao 'Reservar'
  And preencho o campo 'Email' "<email>"
  And preencher campos 'Responsavel do Quarto' "<qtdQuartos>" "<nomeResp>"
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
   | url                          | pesquisa        |qtdEstrelas | nomeHotel              | dataEntrada| dataSaida | qtdQuartos | qtdAdultos | qtdCriancas | posDdl | nomeResp       | email             | cpf         | dtNasc    | tel         |numCartao        | titular          | validade   | codSeg | qtdParcelas | armazenarDados |
   | https://www.hotelurbano.com/ | São Paulo       |1           | Balcony Hostel e Hotel | 13/03/2018 | 27/07/2018| 2          | 1          | 0           | 1      | Sr. Responsavel| usuario@email.com | 18277552530 | 02/02/2000| 11999999999 |4556905972222574 | Usuario de Testes| 10/19      | 300    |    4        |   true         |