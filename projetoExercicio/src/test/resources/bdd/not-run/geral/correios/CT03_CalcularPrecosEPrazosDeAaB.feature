Feature: CT03 - Calcular Preços e prazos - de CEP A a CEP B

@correios
Scenario Outline: Calcular Precos e Prazos
  Given estou na pagina do site dos correios "<url>"
  When clico no link 'Precos e Prazos'
  And preencho o campo 'Data da postagem' "<dataPostagem>"
  And preencho o campo 'CEP de Origem' "<cepOrigem>"
  And preencho o campo 'CEP de Destino' "<cepDestino>"
  And seleciono a ddl 'Servico' "<servico>"
  And clico no ckb 'Comparar Servicos' "<ckbCompararServ>"
  And clico sobre o 'Formato' do objeto "<formato>"
  And seleciono na ddl o tipo de 'Embalagem' "<embalagem>"
  And clico no botao 'Selecionar esta' para escolher um tipo "<numTipoEmbalagem>"
  And seleciono a ddl 'Peso estimado' "<pesoEstimado>"
  And clico no ckb 'Mao Propria' "<ckbMaoPropria>"
  And clico no ckb 'Aviso de Recebimento - AR' "<ckbAvisoRecebimento>"
  And clico no ckb 'Declaracao de Valor' "<ckbDeclaracaoValor>" "<valorDeclarado>"
  And clico no botao 'Enviar'
  And verifico a abertura da nova janela
  Then verifco se houve resultado dos calculos
  
  
 Examples:
   | url                                     | dataPostagem |  cepOrigem | cepDestino | servico | ckbCompararServ |formato | embalagem                | numTipoEmbalagem | pesoEstimado | ckbMaoPropria | ckbAvisoRecebimento | ckbDeclaracaoValor |valorDeclarado |
   | http://www.correios.com.br/para-voce    |   20/01/2018 |  06273-200 |  06020-000 |  SEDEX  | false           |Caixa   |  Embalagem dos Correios  |            7     |    7         | true          |  true               | true               |  12000        |

