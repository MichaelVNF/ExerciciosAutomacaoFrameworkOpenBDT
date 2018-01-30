Feature: CT01 - Selecionar hotel 5 estrelas Rio de Janeiro

@selecionaHotel
Scenario Outline: Selecionar hotel
  Given estou na pagina do site do hotel urbano "<url>"
  When clico no menu 'Hoteis' na barra superior
  And preencho o campo de 'Pesquisa' "<pesquisa>"
  And clico no botao 'Buscar'
  And seleciono o nivel de 'Categoria' "<qtdEstrelas>"
  And clico no link 'Ver' "<posLink>"
  And verifico a abertura da nova janela
  Then verifico o link do hotel clicado "<qtdEstrelas>"
 
Examples:
   | url                          | pesquisa        |qtdEstrelas | posLink |
   | https://www.hotelurbano.com/ | Rio de Janeiro  |5           | 1       |

