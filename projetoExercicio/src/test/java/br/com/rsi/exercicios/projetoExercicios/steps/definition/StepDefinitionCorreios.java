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
	
	//CT1(Buscar CEP - por endereço) e CT2(Buscar Endereco - por CEP)
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

	//CT3(Calcular Preços e prazos)
	@When("^clico no link 'Precos e Prazos'$")
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
	
	@When("^clico no ckb 'Comparar Servicos'$")
	public void clico_no_ckb_Comparar_Servicos() throws Throwable {
	    stepB.clicarCkbCompararServicos();
	}

	@When("^clico sobre o 'Formato' do objeto \"([^\"]*)\"$")
	public void clico_sobre_o_Formato_do_objeto(String formato) throws Throwable {
	    stepB.clicarFormatoObjeto(formato);
	}

	@When("^seleciono na ddl o tipo de 'Embalagem' \"([^\"]*)\"$")
	public void seleciono_o_tipo_de_Embalagem(String embalagem) throws Throwable {
	    stepB.selecionarDdlEmbalagem(embalagem);
	}
	
	@When("^clico no botao 'Selecionar esta' para escolher um tipo \"([^\"]*)\"$")
	public void clico_no_botao_Selecionar_esta_para_escolher_um_tipo(int tipo) throws Throwable {
	    stepB.clicarBotaoParaselecionarTipoEmbalagem(tipo);
	}
	
	@When("^seleciono a ddl 'Peso estimado' \"([^\"]*)\"$")
	public void seleciono_a_ddl_Peso_estimado(String peso) throws Throwable {
	    stepB.selecionarDdlPesoEstimado(peso);
	}

	@When("^clico no ckb 'Mao Propria'$")
	public void clico_no_ckb_Mao_Propria() throws Throwable {
	    stepB.clicarCkbMaoPropria();
	}

	@When("^clico no ckb 'Aviso de Recebimento - AR'$")
	public void clico_no_ckb_Aviso_de_Recebimento_AR() throws Throwable {
		stepB.clicarCkbAvisoRecebimento();
	}

	@When("^clico no ckb 'Declaracao de Valor'$")
	public void clico_no_ckb_Declaracao_de_Valor() throws Throwable {
		stepB.clicarCkbDeclaracaoValor();
	}

	@When("^preencho o campo 'Declaracao de Valor' \"([^\"]*)\"$")
	public void preencho_o_campo_Declaracao_de_Valor(String valor) throws Throwable {
		stepB.preencherCampoDeclaracaoValor(valor);
	}

	@When("^clico no botao 'Enviar'$")
	public void clico_no_botao_Enviar() throws Throwable {
	    stepB.clicarBtnEnviar();
	}

	@Then("^verifco se houve resultado dos calculos$")
	public void verifco_se_houve_resultado_dos_calculos() throws Throwable {
	    stepB.verificarExistenciaResultados();
	}
	
	//CT4(Buscar Agencia)
	@When("^clico no link 'Rede de atendimento'$")
	public void clico_no_link_Rede_de_atendimento() throws Throwable {
	    stepB.clicarLinkRedeDeAtendimento();
	}

	@When("^seleciono o tipo da busca \"([^\"]*)\"$")
	public void seleciono_o_tipo_da_busca(String tipoBusca) throws Throwable {
	    stepB.selecionarRdbTipoBusca(tipoBusca);
	}

	@When("^seleciono a ddl 'Estado' \"([^\"]*)\"$")
	public void seleciono_a_ddl_Estado(String estado) throws Throwable {
	    stepB.selecionarDdlEstado(estado);
	}

	@When("^seleciono a ddl 'Municipio' \"([^\"]*)\"$")
	public void seleciono_a_ddl_Municipio(String municipio) throws Throwable {
	    stepB.selecionarDdlMunicipio(municipio);
	}

	@When("^seleciono a ddl 'Bairro' \"([^\"]*)\"$")
	public void seleciono_a_ddl_Bairro(String bairro) throws Throwable {
	    stepB.selecionarDdlBairro(bairro);
	}

	@Then("^verifico a presenca da agencia na lista \"([^\"]*)\"$")
	public void verifico_a_presenca_da_agencia_na_lista(String rua  ) throws Throwable {
	    stepB.verificarListagemEnderecoAgencia(rua);

	}
	
	
	
}
