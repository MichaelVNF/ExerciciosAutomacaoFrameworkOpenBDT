Feature: CT02 - Adicionar geladeira Brastemp ao carrinho (via Menu)

@adicionaProdutoViaMenu
Scenario Outline: Adicionar Geladeira
  Given estou na pagina do site do sou barato "<url>"
  When clico no menu 'Menu'
  And sobreponho o mouse na categoria especifica "<categoria>"
  And clico na subCategoria especifica "<subCategoria>"
  And clico no link da marca do produto "<marca>"
  And clico no link do produto especifico "<nomeProduto>"
  And clico no botao para 'Comprar' 
  And clico no rdb 'Garantia' "<anosGarantia>"
  Then verifico os produtos na sacola "<qtdProdComprados>"

Examples:
   | url                          | nomeProduto | categoria       | subCategoria           | marca    | anosGarantia | qtdProdComprados |
   | http://www.soubarato.com.br/ | Geladeira   | Eletrodomésticos| Geladeiras e Freezeres | Brastemp | 1            | 1                |

