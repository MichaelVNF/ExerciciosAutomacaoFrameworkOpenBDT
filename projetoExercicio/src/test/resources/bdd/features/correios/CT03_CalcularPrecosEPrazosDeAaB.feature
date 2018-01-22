Feature: Calcular Preços e prazos - de CEP A a CEP B

@calculoum
Scenario Outline: Calcular Endereco
  Given estou na pagina do site dos correios "<url>"
  When clico no link 'Precos e Prazos'
  And preencho o campo 'Data da postagem' "<dataPostagem>"
  And preencho o campo 'CEP de Origem' "<cepOrigem>"
  And preencho o campo 'CEP de Destino' "<cepDestino>"
  And seleciono a ddl 'Servico' "<servico>"
  And clico no ckb 'Comparar Servicos'
  And clico sobre o 'Formato' do objeto "<formato>"
  And seleciono na ddl o tipo de 'Embalagem' "<embalagem>"
  And clico no botao 'Selecionar esta' para escolher um tipo "<numTipoEmbalagem>"
  And seleciono a ddl 'Peso estimado' "<pesoEstimado>"
  And clico no ckb 'Mao Propria'
  And clico no ckb 'Aviso de Recebimento - AR'
  And clico no ckb 'Declaracao de Valor'
  And preencho o campo 'Declaracao de Valor' "<valorDeclarado>"
  And clico no botao 'Enviar'
  And verifico a abertura da nova janela
  Then verifco se houve resultado dos calculos
  
  
 Examples:
   | url                                     | dataPostagem |  cepOrigem | cepDestino | servico      | formato | embalagem                | numTipoEmbalagem | pesoEstimado |  valorDeclarado |
   | http://www.correios.com.br/para-voce    |   20/01/2018 |  07251-090 |  07713-190 |  SEDEX HOJE  | Caixa   |  Embalagem dos Correios  |            7     |    7         |    12000        |

