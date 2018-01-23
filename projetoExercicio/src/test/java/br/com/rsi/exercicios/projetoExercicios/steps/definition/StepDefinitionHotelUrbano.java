package br.com.rsi.exercicios.projetoExercicios.steps.definition;

import java.util.UUID;

import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import br.com.rsi.exercicios.projetoExercicios.steps.business.StepBusinessHotelUrbano;
import net.thucydides.core.annotations.Steps;

@ContextConfiguration("/appcontext.xml")
public class StepDefinitionHotelUrbano {

	@Steps
	StepBusinessHotelUrbano stepB;
	
	@Given("^estou na pagina do site do hotel urbano \"([^\"]*)\"$")
	public void estou_na_pagina_inicial_do_site(String url) throws Throwable {
	    stepB.abrirPagina(url);
	}
	
	@When("^clico no menu 'Hoteis' na barra superior$")
	public void clico_no_menu_Hoteis_na_barra_superior() throws Throwable {
		stepB.clicarMenuHoteis();
	}
	
	@When("^preencho o campo de 'Pesquisa' \"([^\"]*)\"$")
	public void preencho_o_campo_de_Pesquisa(String pesquisa) throws Throwable {
	    stepB.preencherCampoPesquisa(pesquisa);
	}

	@When("^clico no botao 'Buscar'$")
	public void clico_no_botao_pesquisar() throws Throwable {
	    stepB.clicarBotaoBuscar();
	}

	@When("^seleciono o nivel de 'Categoria' \"([^\"]*)\"$")
	public void seleciono_o_nivel_de_Categoria(int qtdEstrelas) throws Throwable {
	    stepB.selecionarCkbCategoria(qtdEstrelas);
	}
	
	@When("^clico no link 'Ver Hotel' \"([^\"]*)\"$")
	public void clico_no_link_Ver_Hotel(int pos) throws Throwable {
	    stepB.clicarLinkVerHotel(pos);
	}

	@Then("^verifico o link do hotel clicado \"([^\"]*)\"$")
	public void verifico_o_link_do_hotel_clicado(int qtdEstrelas) throws Throwable {
	    stepB.verificarHotelClicado(qtdEstrelas);
	}
	
	
	//CT02(Selecionar Passagem aerea)
	@When("^clico no menu 'Aereos' na barra superior$")
	public void clico_no_menu_Aereos_na_barra_superior() throws Throwable {
	    stepB.clicarMenuAereos();
	}

	@When("^preencho o campo de 'Origem' \"([^\"]*)\"$")
	public void preencho_o_campo_de_Origem(String origem) throws Throwable {
	    stepB.preencherCampoOrigem(origem);
	}

	@When("^preencho o campo de 'Destino' \"([^\"]*)\"$")
	public void preencho_o_campo_de_Destino(String destino) throws Throwable {
	    stepB.preencherCampoDestino(destino);
	}

	@When("^seleciono a ddl 'Classe' \"([^\"]*)\"$")
	public void seleciono_a_ddl_Classe(String classe) throws Throwable {
	    stepB.selecionarDdlClasse(classe);
	}
	
	@When("^clico no link para 'Buscar'$")
	public void clico_no_link_para_Buscar() throws Throwable {
	    stepB.clicarLinkBuscar();
	}

	@Then("^verifico existencia dos resultados para busca do voo$")
	public void verifico_existencia_dos_resultados_para_busca_do_voo() throws Throwable {
	    stepB.verificarResultadosBuscaVoo();
	}
	
	
	//CT03(Comprar Ingresso)
	@When("^clico no menu 'Ingressos' na barra superior$")
	public void clico_no_menu_Ingressos_na_barra_superior() throws Throwable {
	    stepB.clicarMenuIngressos();
	}

	@When("^clico na div 'Ingresso' dos mais vendidos \"([^\"]*)\"$")
	public void clico_na_div_Ingresso_dos_mais_vendidos(int pos) throws Throwable {
	    stepB.clicarDivIngresso(pos);
	}
	
	@When("^seleciono a qtd de 'Pessoas' \"([^\"]*)\"$")
	public void seleciono_a_qtd_de_Pessoas(String qtd) throws Throwable {
	    stepB.selecionarDdlQtdPessoas(qtd);
	}

	@When("^clico no link 'Comprar' ingresso \"([^\"]*)\"$")
	public void clico_no_link_Comprar_ingresso(int pos) throws Throwable {
	    stepB.clicarLinkComprarIngresso(pos);
	}


}
