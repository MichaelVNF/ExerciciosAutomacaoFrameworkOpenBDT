Feature: CT01 - Buscar CEP (por endereço)

@buscaCep
Scenario Outline: Buscar CEP
  Given estou na pagina do site dos correios "<url>"
  When preencho o campo 'Busca CEP ou Endereço' "<pesqEndereco>"
  And clico no botao para pesquisar
  And verifico a abertura da nova janela
  And verifico se foram encontrado dados
  Then pesquiso via endereco e verifico se a tebela contem o cep "<logradouro>" "<bairro>" "<localidade>" "<cepEsperado>"
  
Examples:
   | url                                     | pesqEndereco       | logradouro                                       | bairro     | localidade  | cepEsperado |
   | http://www.correios.com.br/para-voce    | Autonomistas       | Avenida dos Autonomistas - até 825 - lado ímpar  | Vila Yara  | Osasco/SP   | 06020-000   |

# As Variaveis logradouro, bairro e localidade são complementares à pesquisa. Representa o endereco unico e exato a partir do objetivo da pesquisa

#Examples:
#   | url                                     | pesqEndereco       | logradouro      | bairro        | localidade   | cepEsperado |
#   | http://www.correios.com.br/para-voce    |   Rua Covas        | Rua Mário Covas | Cidade Kemel  | São Paulo/SP |  08130-060  |