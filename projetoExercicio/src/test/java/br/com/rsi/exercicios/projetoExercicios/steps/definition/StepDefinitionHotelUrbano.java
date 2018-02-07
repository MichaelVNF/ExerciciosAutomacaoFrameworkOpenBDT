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
	
	//CT01(Selecionar hotel) 
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
	
	@When("^clico no link 'Ver' \"([^\"]*)\"$")
	public void clico_no_link_Ver_Hotel(String nome) throws Throwable {
	    stepB.clicarLinkVerHotel(nome);
	}

	@Then("^verifico o link do hotel clicado \"([^\"]*)\"$")
	public void verifico_o_link_do_hotel_clicado(String nomeHotel) throws Throwable {
	    stepB.verificarHotelClicado(nomeHotel);
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

	@When("^clico na sugestao \"([^\"]*)\"$")
	public void clico_na_sugestao(int pos) throws Throwable {
	    stepB.clicarSugestaoPesq(pos);
	}
	
	@When("^clico no link 'Comprar' ingresso \"([^\"]*)\"$")
	public void clico_no_link_Comprar_ingresso(int pos) throws Throwable {
	    stepB.clicarLinkComprarIngresso(pos);
	}
	
	@When("^seleciono a qtd de 'Pessoas' \"([^\"]*)\"$")
	public void seleciono_a_qtd_de_Pessoas(String qtd) throws Throwable {
	    stepB.selecionarDdlQtdPessoas(qtd);
	}

	@When("^seleciono a ddl 'Pessoas' \"([^\"]*)\"$")
	public void seleciono_a_ddl_Pessoas(String qtd) throws Throwable {
	    stepB.selecionarDdlQtdPessoas(qtd);
	}

	@When("^preencho o campo 'Email' \"([^\"]*)\"$")
	public void preencho_o_campo_Email(String email) throws Throwable {
	    stepB.preencherCampoEmail(email);
	}

	@When("^preencho o campo 'Cpf' \"([^\"]*)\"$")
	public void preencho_o_campo_Cpf(String cpf) throws Throwable {
	    stepB.preencherCampoCpf(cpf);
	}

	@When("^preencho o campo 'Data de Nascimento' \"([^\"]*)\"$")
	public void preencho_o_campo_Data_de_Nascimento(String dtNasc) throws Throwable {
	    stepB.preencherCampoDtNasc(dtNasc);
	}
	
	@When("^preencho o campo 'Telefone' \"([^\"]*)\"$")
	public void preencho_o_campo_Telefone(String tel) throws Throwable {
	    stepB.preencherCampoTelefone(tel);
	}

	@When("^preencho o campo 'Numero do Cartao' \"([^\"]*)\"$")
	public void preencho_o_campo_Numero_do_Cartao(String numCartao) throws Throwable {
	    stepB.preencherCampoNumCartao(numCartao);
	}

	@When("^preencho o campo 'Titular' \"([^\"]*)\"$")
	public void preencho_o_campo_Titular(String titular) throws Throwable {
	    stepB.preencherCampoTitular(titular);
	}

	@When("^preencho o campo 'Validade' \"([^\"]*)\"$")
	public void preencho_o_campo_Validade(String validade) throws Throwable {
	    stepB.preencherCampoValidade(validade);
	}

	@When("^preencho o campo 'Codigo de Seguranca' \"([^\"]*)\"$")
	public void preencho_o_campo_Codigo_de_Seguranca(String codSeguranca) throws Throwable {
	    stepB.preencherCampoCodSeguranca(codSeguranca);
	}

	@When("^seleciono o numero de 'Parcelas' \"([^\"]*)\"$")
	public void seleciono_o_numero_de_Parcelas(String qtdParcelas) throws Throwable {
	    stepB.selecionarDdlParcelas(qtdParcelas);
	}
	
	@Then("^clico na ckb 'Armazenar dados' \"([^\"]*)\"$")
	public void clico_na_ckb_Armazenar_dados(boolean clica) throws Throwable {
	    stepB.clicarCkbArmazenarDados(clica);
	}

	//CT04(Consultar Promocao)
	@When("^clico no menu 'Promocoes' na barra superior$")
	public void clico_no_menu_Promocoes_na_barra_superior() throws Throwable {
	    stepB.clicarMenuPromocoes();
	}
	
	@Then("^verifico se existe promocoa para o trajeto \"([^\"]*)\"$")
	public void verifico_se_existe_promocoa_para_o_trajeto(String trajeto) throws Throwable {
	    stepB.verificarExistenciaPromocao(trajeto);
	}
	
	//CT05(Reservar Hotel)
	@When("^preencho o campo 'Entrada' \"([^\"]*)\"$")
	public void preencho_o_campo_Entrada(String data) throws Throwable {
		stepB.preencherCampoEntrada(data);
	} 
	
	@When("^preencho o campo 'Saida' \"([^\"]*)\"$")
	public void preencho_o_campo_Saida(String data) throws Throwable {
		stepB.preencherCampoSaida(data);
	} 
	
	@When("^seleciono a ddl 'Quartos' \"([^\"]*)\"$")
	public void seleciono_a_ddl_Quartos(String qtd) throws Throwable {
	    stepB.selecionarDdlQtdQuartos(qtd);
	}

	@When("^seleciono a ddl 'Adultos' \"([^\"]*)\"$")
	public void seleciono_a_ddl_Adultos(String qtd) throws Throwable {
	    stepB.selecionarDdlQtdAdultos(qtd);
	}

	@When("^seleciono a ddl 'Criancas' \"([^\"]*)\"$")
	public void seleciono_a_ddl_Criancas(String qtd) throws Throwable {
	    stepB.selecionarDdlQtdCriancas(qtd);
	}
	
	@When("^clicar botao 'Verificar Disponibilidade'$")
	public void clicar_botao_Verificar_Disponibilidade() throws Throwable {
	    stepB.clicarBtnVarificarDisp();
	}

	@When("^seleciono a ddl 'Numero de Quartos' \"([^\"]*)\" \"([^\"]*)\"$")
	public void seleciono_a_ddl_Numero_de_Quartos(int pos, String qtd) throws Throwable {
	    stepB.selecionarDdlsNumQuartos(pos, qtd);
	}

	@When("^clico no botao 'Reservar'$")
	public void clico_no_botao_Reservar() throws Throwable {
	    stepB.clicarBtnReservar();
	    
	}
	
	@When("^preencher campos 'Responsavel do Quarto' \"([^\"]*)\" \"([^\"]*)\"$")
	public void preencher_campos_Responsavel_do_Quarto(int qtdQuartos, String responsavel) throws Throwable {
	    stepB.preencherNomesResponsaveisQuartos(qtdQuartos, responsavel);
	}
}
