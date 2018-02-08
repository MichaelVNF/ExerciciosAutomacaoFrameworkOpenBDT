Feature: CT02 - Adicionar geladeira Brastemp ao carrinho (via Menu)

@souBarato
Scenario Outline: Adicionar Geladeira
  Given estou na pagina do site do sou barato "<url>"
  When clico no menu 'Menu'
  And sobreponho o mouse na categoria especifica "<categoria>"
  And clico na subCategoria especifica "<subCategoria>"
  And clico no link do produto especifico "<nomeProduto>"
  And clico no botao para 'Comprar' 
  Then verifico os produtos na sacola "<qtdProdComprados>"

Examples:
   | url                          | nomeProduto                                                          | categoria       | subCategoria           | qtdProdComprados |
   | http://www.soubarato.com.br/ | USADO: Refrigerador Brastemp Clean BRM39 352 Litros Compartimento... | Eletrodomésticos| Geladeiras e Freezeres | 1                |


