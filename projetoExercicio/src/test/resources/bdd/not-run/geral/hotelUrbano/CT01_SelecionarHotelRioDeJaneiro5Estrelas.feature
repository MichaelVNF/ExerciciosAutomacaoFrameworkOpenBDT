Feature: CT01 - Selecionar hotel 5 estrelas Rio de Janeiro

@hotelUrbano
Scenario Outline: Selecionar hotel
  Given estou na pagina do site do hotel urbano "<url>"
  When clico no menu 'Hoteis' na barra superior
  And preencho o campo de 'Pesquisa' "<pesquisa>"
  And clico no botao 'Buscar'
  And seleciono o nivel de 'Categoria' "<qtdEstrelas>"
  And clico no link 'Ver' "<nomeHotel>"
  Then verifico o link do hotel clicado "<qtdEstrelas>"
 
Examples:
   | url                          | pesquisa        | nomeHotel                          |qtdEstrelas | posLink |
   | https://www.hotelurbano.com/ | Rio de Janeiro  | Pullman Rio de Janeiro São Conrado |5           | 1       |

