Feature: CT02 -  Consultar vôo economico para Bahia 

@hotelUrbano
Scenario Outline: Consultar vôo
  Given estou na pagina do site do hotel urbano "<url>"
  When clico no menu 'Aereos' na barra superior
  And preencho o campo de 'Origem' "<origem>"
  And preencho o campo de 'Destino' "<destino>"
  And seleciono a ddl 'Classe' "<classe>"
  And clico no link para 'Buscar'
  Then verifico existencia dos resultados para busca do voo

Examples:
   | url                          | origem      | destino | classe          |
   | https://www.hotelurbano.com/ | São Paulo   | Bahia   | Econômica       |