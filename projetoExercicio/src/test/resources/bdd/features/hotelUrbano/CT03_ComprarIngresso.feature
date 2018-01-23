Feature: CT03 - Comprar ingresso

@cepum
Scenario Outline: Comprar ingresso
  Given estou na pagina do site do hotel urbano "<url>"
  When clico no menu 'Ingressos' na barra superior
  And clico na div 'Ingresso' dos mais vendidos "<posIngresso>"
  And seleciono a qtd de 'Pessoas' "<qtdPessoas>"
  And clico no link 'Comprar' ingresso "<posLink>"
#  And clico no botao 'Buscar'
#  And seleciono o nivel de 'Categoria' "<qtdEstrelas>"
#  And clico no link 'Ver Hotel' "<posLink>"
#  And verifico a abertura da nova janela
#  Then verifico o link do hotel clicado "<qtdEstrelas>"
 
Examples:
   | url                          | posIngresso | qtdPessoas |posLink |
   | https://www.hotelurbano.com/ | 3           | 2          | 2      |