Feature: Calcular Preços e prazos - de CEP A a CEP B

@enderecoum
Scenario Outline: Calcular Endereco
  Given estou na pagina do site dos correios "<url>"
  When clico sobre o link 'Precos e Prazos'
  And preencho o campo 'Data da postagem' "<dataPostagem>"
  And preencho o campo 'CEP de Origem' "<cepOrigem>"
  And preencho o campo 'CEP de Destino' "<cepDestino>"
  And seleciono a ddl 'Servico' "<servico>"
  
 Examples:
   | url                                     | dataPostagem |  cepOrigem | cepDestino | servico      | 
   | http://www.correios.com.br/para-voce    |   22/01/2018 |  13467-274 |  13085-393 |  SEDEX HOJE  |