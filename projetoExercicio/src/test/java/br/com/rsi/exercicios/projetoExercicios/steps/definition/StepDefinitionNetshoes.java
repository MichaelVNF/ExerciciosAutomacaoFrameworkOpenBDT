package br.com.rsi.exercicios.projetoExercicios.steps.definition;

import java.util.UUID;

import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import br.com.rsi.exercicios.projetoExercicios.steps.business.StepBusinessNetshoes;
import net.thucydides.core.annotations.Steps;

@ContextConfiguration("/appcontext.xml")
public class StepDefinitionNetshoes {

	@Steps
	StepBusinessNetshoes stepB;
	
	@Given("^estou na pagina do site do netshoes \"([^\"]*)\"$")
	public void estou_na_pagina_do_site_do_netshoes(String url) throws Throwable {
	    stepB.abrirPagina(url);
	}

	//CT01 e CT02 - (Adicionar item ao carrinho) 
	@When("^preencho o campo 'Busca' \"([^\"]*)\"$")
	public void preencho_o_campo_Busca(String busca) throws Throwable {
	    stepB.preencherCampoBusca(busca);
	}

	@When("^clico no icone de busca$")
	public void clico_no_icone_de_busca() throws Throwable {
	    stepB.clicarIconeBusca();
	}

	@When("^clico no link do produto \"([^\"]*)\"$")
	public void clico_no_link_do_produto(String nomeProduto) throws Throwable {
	    stepB.clicarLinkProduto(nomeProduto);
	}

	@When("^clico no rdb 'color' \"([^\"]*)\"$")
	public void clico_no_rdb_color(int pos) throws Throwable {
	   stepB.clicarRdbCores(pos);
	}

	@When("^clico no rdb 'size' \"([^\"]*)\"$")
	public void clico_no_rdb_size(String numTam) throws Throwable {
	   stepB.clicarRdbTamanho(numTam);
	}

	@When("^clico no botao 'Comprar'$")
	public void clico_no_botao_Comprar() throws Throwable {
	   stepB.clicarBotaoComprar();
	}
	
	@Then("^verifico o produto no carrinho \"([^\"]*)\"$")
	public void verifico_o_produto_no_carrinho(int qtd) throws Throwable {
	    stepB.verificarProdutoNoCarrinho(qtd);
	}
	
	//CT03(Escolher um calçado na secao outlet com valor abaixo de 150 reais)
	@When("^clico no link em 'Outlet' \"([^\"]*)\"$")
	public void clico_no_link_calcados_masculinos_em_Outlet(String link) throws Throwable {
	    stepB.clicarLinkOutlet(link);
	}

	@When("^clico na ckb 'Preco' \"([^\"]*)\"$")
	public void clico_na_ckb_Preco(double valor) throws Throwable {
	    stepB.clicarCkbsPrecos(valor);
	}
	
	//CT04(Adicionar item ao carrinho e calcular frete)
	@When("^preencho o campos do 'CEP' \"([^\"]*)\"$")
	public void preencho_o_campos_do_CEP(String cep) throws Throwable {
	    stepB.preencherCampoCep(cep);
	}

	@When("^clico no botao 'Calcular Frete'$")
	public void clico_no_botao_Calcular_Frete() throws Throwable {
	   stepB.clicarBtnCalcularFrete();
	}
	
	@Then("^verifico o calculo do frete$")
	public void verifico_o_calculo_do_frete() throws Throwable {
	    stepB.verificarCalculoFrete();
	}

	//CT05(Adicionar item no carrinho, Limpar Carrinho e voltar para loja)
	@When("^clico no link 'limpar carrinho'$")
	public void clico_no_link_limpar_carrinho() throws Throwable {
	    stepB.clicarLinkLimparCarrinho();
	}

	@When("^clico no link 'voltar para a loja'$")
	public void clico_no_link_voltar_para_a_loja() throws Throwable {
	    stepB.clicarLinkVoltarLoja();
	}
	
	@Then("^verifico se esta na pagina especifica \"([^\"]*)\"$")
	public void verifico_se_esta_na_pagina_especifica(String url) throws Throwable {
	    stepB.verificarPaginaCorrespondente(url);
	}
	
}
