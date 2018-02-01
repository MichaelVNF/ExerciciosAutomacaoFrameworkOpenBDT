package br.com.rsi.exercicios.projetoExercicios.steps.definition;

import java.util.UUID;

import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import br.com.rsi.exercicios.projetoExercicios.steps.business.StepBusinessSouBarato;
import net.thucydides.core.annotations.Steps;

@ContextConfiguration("/appcontext.xml")
public class StepDefinitionSouBarato {

	@Steps
	StepBusinessSouBarato stepB;
	
	@Given("^estou na pagina do site do sou barato \"([^\"]*)\"$")
	public void estou_na_pagina_do_site_do_sou_barato(String url) throws Throwable {
	    stepB.abrirPagina(url);
	}

	//CT01(Adicionar ao carrinho um item da seção Produtos Reembalados)
	@When("^clico no menu superior \"([^\"]*)\"$")
	public void clico_no_menu_superior(String opcao) throws Throwable {
	    stepB.clicarMenuSuperior(opcao);
	}

	@When("^clico no link do produto especifico \"([^\"]*)\"$")
	public void clico_no_link_do_produto_especifico(String nomeProduto) throws Throwable {
		stepB.clicarLinkProdutoEspecifico(nomeProduto);
	   
	}
	
	@When("^clico no botao para 'Comprar'$")
	public void clico_no_botao_para_Comprar() throws Throwable {
	    stepB.clicarBtnComprar();
	}

	@When("^clico no rdb 'Garantia' \"([^\"]*)\"$")
	public void clico_no_rdb_Garantia(String anosGarantia) throws Throwable {
	    stepB.clicarRdbsGarantia(anosGarantia);
	}
	
	@Then("^verifico os produtos na sacola \"([^\"]*)\"$")
	public void verifico_os_produtos_na_sacola(String qtdComprados) throws Throwable {
	    stepB.verificarProdutosSacola(qtdComprados);
	}

	//CT02(Adicionar geladeira Brastemp ao carrinho (via Menu)
	@When("^clico no menu 'Menu'$")
	public void clico_no_menu_Menu() throws Throwable {
	    stepB.clicarMenuMenu();
	}

	@When("^sobreponho o mouse na categoria especifica \"([^\"]*)\"$")
	public void sobreponho_o_mouse_na_categoria_especifica(String categoria) throws Throwable {
	    stepB.sobreporMenuCatergoria(categoria);
	}

	@When("^clico na subCategoria especifica \"([^\"]*)\"$")
	public void clico_na_subCategoria_especifica(String subCategoria) throws Throwable {
	    stepB.clicarSubmenuCatergoria(subCategoria);
	}

	//CT03(Adicionar Iphone ao carrinho (via campo busca)
	@When("^preencho o campo de 'Busca' \"([^\"]*)\"$")
	public void preencho_o_campo_de_Busca(String busca) throws Throwable {
	    stepB.preencherCampoBusca(busca);
	}
	
	@When("^clico no botao para 'Buscar'$")
	public void clico_no_botao_para_Buscar() throws Throwable {
	    stepB.clicarBtnBusca();
	}
	
	//CT04(Acessar aba das vantagens do cartão Sou Barato)
	@When("^clico na opcao do menu sou barato \"([^\"]*)\"$")
	public void clico_na_opcao_do_menu_sou_barato(String categoria) throws Throwable {
	    stepB.clicarMenuSouBarato(categoria);
	}
	
	@Then("^verifico a abertura da pagina \"([^\"]*)\"$")
	public void verifico_a_abertura_da_pagina(String comparativo) throws Throwable {
	    stepB.verificarAberturaPagina(comparativo);
	}
	
	//CT05(Adicionar item e Calcular frete)
	@When("^preencho o campo 'Cep' \"([^\"]*)\"$")
	public void preencho_o_campo_Cep(String cep) throws Throwable {
	    stepB.preencherCampoCep(cep);
	}

	@When("^clico no botao 'Ok' para calcular cep$")
	public void clicoc_no_botao_Ok_para_calcular_cep() throws Throwable {
	    stepB.clicarBtnCalcFrete();
	}

	@Then("^verifico o calculo do cep$")
	public void verifico_o_calculo_do_cep() throws Throwable {
	    stepB.verificarCalculoFrete();
	}

}
