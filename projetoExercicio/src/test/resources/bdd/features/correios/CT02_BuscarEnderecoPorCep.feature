Feature: CT02 - Buscar Endereco (por CEP)

@buscaEndereco
Scenario Outline: Buscar Endereco
  Given estou na pagina do site dos correios "<url>"
  When preencho o campo 'Busca CEP ou Endereço' "<pesquisaCep>"
  And clico no botao para pesquisar
  And verifico a abertura da nova janela
  And verifico se foram encontrado dados
  Then pesquiso via cep e verifico se a tebela contem o endereco "<logradouroEsperado>" "<bairroEsperado>" "<localidadeEsperada>"
  
Examples:
   | url                                     | pesquisaCep        |  logradouroEsperado                              | bairroEsperado | localidadeEsperada |                             
   | http://www.correios.com.br/para-voce    |   06020-000        |  Avenida dos Autonomistas - até 825 - lado ímpar | Vila Yara      | Osasco/SP          |              


#Examples:
#   | url                                     | pesquisaCep        |  logradouroEsperado | bairroEsperado | localidadeEsperada |                            | 
#   | http://www.correios.com.br/para-voce    |   08130-060        |  Rua Mário Covas    | Cidade Kemel   | São Paulo/SP       |  