Feature: CT04 - Buscar Agencia

@correios
Scenario Outline: Buscar Agencia
  Given estou na pagina do site dos correios "<url>"
  When clico no link 'Rede de atendimento' 
  And seleciono o tipo da busca "<tipoBusca>"
  And seleciono a ddl 'Estado' "<estado>"
  And seleciono a ddl 'Municipio' "<municipio>"
  And seleciono a ddl 'Bairro' "<bairro>"
  Then verifico a presenca da agencia na lista "<ruaAgencia>" 

Examples:
   | url                                     | tipoBusca       | estado      | municipio   | bairro  | ruaAgencia        |  
   | http://www.correios.com.br/para-voce    |  Localidade     | SÃO PAULO   | SAO PAULO   | CENTRO  | RUA BOA VISTA     |


