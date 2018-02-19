Feature: CT04 - Consultar promoção trajeto Angra dos Reis - Rio de Janeiro

@consultaPromocao
Scenario Outline: Consultar Promocao
  Given estou na pagina do site do hotel urbano "<url>"
  When clico no menu 'Promocoes' na barra superior
  Then verifico se existe promocoa para o trajeto "<trajeto>"

Examples:
   | url                            | trajeto                       |
   | https://www.hotelurbano.com/   | Mangaratiba/Rio de Janeiro    |