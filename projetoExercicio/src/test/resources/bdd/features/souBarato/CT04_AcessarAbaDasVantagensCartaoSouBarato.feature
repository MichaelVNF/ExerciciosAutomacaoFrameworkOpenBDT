Feature: CT04 - Acessar aba das vantagens do cartão Sou Barato

@acessaAbaCartao
Scenario Outline: Acessar Aba
  Given estou na pagina do site do sou barato "<url>"
  When clico no menu superior "<opcao>"
  And clico na opcao do menu sou barato "<opcaoMenuSouBarato>"
  And clico na opcao do menu sou barato "<opcaoSubMenuSouBarato>"
  Then verifico a abertura da pagina "<comparativo>" 
  
Examples:
   | url                          | opcao               | opcaoMenuSouBarato | opcaoSubMenuSouBarato | comparativo          |
   | http://www.soubarato.com.br/ | Cartão Sou Barato   | VANTAGENS          | Conheça vantagens     | CONHEÇA AS VANTAGENS |

