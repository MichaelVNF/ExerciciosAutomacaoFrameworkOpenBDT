package br.com.rsi.exercicios.projetoExercicios.steps.definition;

import java.util.UUID;

import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import br.com.rsi.exercicios.projetoExercicios.steps.business.StepBusinessCorreios;
import net.thucydides.core.annotations.Steps;

@ContextConfiguration("/appcontext.xml")
public class StepDefinitionCorreios {

	@Steps
	StepBusinessCorreios stepB;
	
	@Given("^estou na pagina do site dos correios \"([^\"]*)\"$")
	public void estou_na_pagina_inicial_do_site(String url) throws Throwable {
	    stepB.abrirPagina(url);
	}
	
	@When("^preencho o campo 'Busca CEP ou Endereço' \"([^\"]*)\"$")
	public void preencho_o_campo_Busca_CEP_ou_Endereço(String cepOuEndereco) throws Throwable {
	    stepB.preencherCampoCepOUEndereco(cepOuEndereco);
	}

	@When("^clico no botao para pesquisar$")
	public void clico_no_botao_para_pesquisar() throws Throwable {
	    stepB.clicarBtnPesquisar();
	}
	
	@When("^verifico a abertura da nova janela$")
	public void verifico_a_abertura_da_nova_guia() throws Throwable {
	    stepB.verificarAberturaGuia();
	}
	
	
	@When("^verifico se foram encontrado dados$")
	public void verifico_se_foram_encontrado_dados() throws Throwable {
	    stepB.verificarSeHouveDadosEncontrados();
	}

	//CT1
	@Then("^pesquiso via endereco e verifico se a tebela contem o cep \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void pesquiso_via_endereco_e_verifico_se_a_tebela_contem_o_cep(String logradouro, String bairro, String localidade, String cepEsperado) throws Throwable {
	    stepB.pesquisarEnderecoVerificarTabelaCep(logradouro, bairro, localidade, cepEsperado);
	}
    
	//CT2
	@Then("^pesquiso via cep e verifico se a tebela contem o endereco \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void pesquiso_via_cep_e_verifico_se_a_tebela_contem_o_endereco(String logradouroEsperado, String bairrooEsperado, String localidadeEsperada) throws Throwable {
	    stepB.pesquisarCepVerificarTabelaEndereco(logradouroEsperado,  bairrooEsperado,  localidadeEsperada);
	}

	//CT3
	@When("^clico sobre o link 'Precos e Prazos'$")
	public void clico_sobre_o_link_Precos_e_Prazos() throws Throwable {
	    stepB.clicarLinkPrecosPrazos();
	}
	

	@When("^preencho o campo 'Data da postagem' \"([^\"]*)\"$")
	public void preencho_o_campo_Data_da_postagem(String data) throws Throwable {
	    stepB.preencherCampoDataPostagem(data);
	}

	@When("^preencho o campo 'CEP de Origem' \"([^\"]*)\"$")
	public void preencho_o_campo_CEP_de_Origem(String cepOrigem) throws Throwable {
	    stepB.preencherCampoCepOrigem(cepOrigem);
	}

	@When("^preencho o campo 'CEP de Destino' \"([^\"]*)\"$")
	public void preencho_o_campo_CEP_de_Destino(String cepDestino) throws Throwable {
	    stepB.preencherCampoCepDestino(cepDestino);
	}

	@When("^seleciono a ddl 'Servico' \"([^\"]*)\"$")
	public void seleciono_a_ddl_Servico(String servico) throws Throwable {
	    stepB.selecionarDdlServico(servico);
	}
}
