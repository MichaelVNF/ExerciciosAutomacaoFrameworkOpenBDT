package br.com.rsi.exercicios.projetoExercicios.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageObjectClassHotelUrbano extends PageObject{

	//CT01(Selecionar hotel) 
	@FindBy(css = "a[title='Reserva de Hotéis']")
	private WebElement menuHoteis;

	@FindBy(id = "huSearchComponentAutocomplete")
	private WebElement txtBarraPesquisa;
	
	@FindBy(xpath = "//button[@data-event-action='Click_buscar']")
	private WebElement btnBuscar;
	
	private By ckbsCategoria = By.xpath("//label[@data-event-action='Click_filtro_categoria']");
	
	public By getCkbsCategoria() {
		return ckbsCategoria;
	}
	
	@FindBy(xpath = "//h3[@class='component-card_title_h']/a")
	private List<WebElement> linksVerHotel;
	
	@FindBy(className = "page-title-text")
	private WebElement lblTituloLocal;
	
	//CT02(Selecionar Passagem aerea)
	@FindBy(css = "a[title='Passagens Aéreas']")
	private WebElement menuAereos;
	
	@FindBy(xpath = "//a[@tabindex='1']")
	private WebElement divOrigem;
	
	@FindBy(xpath = "//input[@placeholder='Cidade ou aeroporto de origem']")
	private WebElement txtOrigem;
	
	@FindBy(xpath = "//a[@class='place-selector__cover text-ellipsis js-autocomplete-place-cover']")
	private WebElement divDestino;
	
	@FindBy(xpath = "//input[@placeholder='Cidade ou aeroporto de destino']")
	private WebElement txtDestino;

	@FindBy(xpath = "//*[@id='search']/a")
	private WebElement linkBuscar;
	
	@FindBy(xpath = "//button[@aria-label='Classe de cabine']/div")
	private WebElement ddlClasse;
	
	@FindBy(xpath = "//button[@class='price-button js-raise-booking']")
	private WebElement btnSelecionarPassagem;
	
	//CT03(ComprarIngresso)
	@FindBy(css = "a[title='Ingressos']")
	private WebElement menuIngressos;
	
	@FindBy(css = "select[class='hu-dropdown--field mapx-produto-pacotes-click-oferta_input_pessoa select2-hidden-accessible']")
	private WebElement ddlQtdPessoas;
	
	@FindBy(xpath = "//a[contains(text(),'COMPRAR')]")
	private List<WebElement> linksComprarIngresso;
	
	@FindBy(name = "guestEmail")
	private WebElement txtEmail;
	
	@FindBy(name = "cpf[]")
	private WebElement txtCpf;
	
	@FindBy(name = "date-of-birthday[]")
	private WebElement txtDtNasc;
	
	@FindBy(name = "phoneNumber[]")
	private WebElement txtTel;
	
	@FindBy(name = "cardNumber[]")
	private WebElement txtNumCartao;
	
	@FindBy(name = "cardHolder[]")
	private WebElement txtTitular;
	
	@FindBy(name = "expiration[]")
	private WebElement txtValidade;
	
	@FindBy(name = "cvv[]")
	private WebElement txtCodSeguranca;
	
	@FindBy(name = "installments[]")
	private WebElement dllParcelas;
	
	@FindBy(name = "storeCardInfo[]")
	private WebElement ckbArmazenarDados;

	//CT04(Consultar Promocao)
	@FindBy(css = "a[title='Promoções de Viagens']")
	private WebElement menuPromocoes;
	
	@FindBy(css = "strong[class='product-card__support-text']")
	private List<WebElement> listaTrajetos;
	
	//CT05(Reservar Hotel)
	//CALENDARIO POPUP
	@FindBy(xpath = "//input[@data-event-label='DisponibilidadeA' and @name='checkin']")
	private WebElement txtEntrada;
	
	@FindBy(xpath = "//input[@data-event-label='DisponibilidadeA' and @name='checkout']")
	private WebElement txtSaida;
		
	@FindBy(css = "span[class='ui-datepicker-month']")
	private WebElement lblMes;
	
	@FindBy(css = "span[class='ui-datepicker-year']")
	private WebElement lblAno;
	
	@FindBy(css = "td[data-handler='selectDay']")
	private List<WebElement> listaDias;
	
	@FindBy(xpath = "//a[@title='Próximo']/span")
	private WebElement spanNext;
	
	@FindBy(xpath = "//a[@title='Anterior']/span")
	private WebElement spanPrevious;
	///FIM - CALENDARIO POPUP
	
	@FindBy(css = "select[name='rooms']")
	private WebElement ddlQuartos;
	
	@FindBy(css = "select[name='adults']")
	private WebElement ddlAdultos;
	
	@FindBy(css = "select[name='children']")
	private WebElement ddlCriancas;
	
	@FindBy(css = "input[value='Verificar disponibilidade']")
	private WebElement btnVerificarDisp;
	
	@FindBy(name = "sku_quantity[]")
	private List<WebElement> ddlsNumQuartos;
	
	@FindBy(css = "input[value='Reservar']")
	private WebElement btnReservar;
	
	
	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtCpf() {
		return txtCpf;
	}

	public WebElement getTxtDtNasc() {
		return txtDtNasc;
	}

	public WebElement getTxtTel() {
		return txtTel;
	}

	public WebElement getTxtNumCartao() {
		return txtNumCartao;
	}

	public WebElement getTxtTitular() {
		return txtTitular;
	}

	public WebElement getTxtValidade() {
		return txtValidade;
	}

	public WebElement getTxtCodSeguranca() {
		return txtCodSeguranca;
	}

	public WebElement getDllParcelas() {
		return dllParcelas;
	}
	
	public WebElement getMenuHoteis() {
		return menuHoteis;
	}

	public WebElement getTxtBarraPesquisa() {
		return txtBarraPesquisa;
	}

	public WebElement getBtnBuscar() {
		return btnBuscar;
	}

	public List<WebElement> getLinksVerHotel() {
		return linksVerHotel;
	}

	public WebElement getLblTituloLocal() {
		return lblTituloLocal;
	}

	public WebElement getMenuAereos() {
		return menuAereos;
	}

	public WebElement getDivOrigem() {
		return divOrigem;
	}
	
	public WebElement getTxtOrigem() {
		return txtOrigem;
	}

	public WebElement getTxtDestino() {
		return txtDestino;
	}

	public WebElement getDivDestino() {
		return divDestino;
	}

	public WebElement getDdlClasse() {
		return ddlClasse;
	}

	public WebElement getBtnSelecionarPassagem() {
		return btnSelecionarPassagem;
	}

	public WebElement getLinkBuscar() {
		return linkBuscar;
	}

	public WebElement getMenuIngressos() {
		return menuIngressos;
	}

	public WebElement getMenuPromocoes() {
		return menuPromocoes;
	}
	
	public List<WebElement> getListaTrajetos() {
		return listaTrajetos;
	}

	public WebElement getDdlQtdPessoas() {
		return ddlQtdPessoas;
	}

	public List<WebElement> getLinksComprarIngresso() {
		return linksComprarIngresso;
	}

	public WebElement getCkbArmazenarDados() {
		return ckbArmazenarDados;
	}

	public WebElement getTxtEntrada() {
		return txtEntrada;
	}

	public WebElement getTxtSaida() {
		return txtSaida;
	}

	
	public WebElement getDdlQuartos() {
		return ddlQuartos;
	}

	public WebElement getDdlAdultos() {
		return ddlAdultos;
	}

	public WebElement getDdlCriancas() {
		return ddlCriancas;
	}

	public WebElement getBtnVerificarDisp() {
		return btnVerificarDisp;
	}

	public WebElement getLblMes() {
		return lblMes;
	}

	public WebElement getLblAno() {
		return lblAno;
	}

	public List<WebElement> getListaDias() {
		return listaDias;
	}

	public WebElement getSpanNext() {
		return spanNext;
	}

	public WebElement getSpanPrevious() {
		return spanPrevious;
	}
	
	public List<WebElement> getDdlsNumQuartos() {
		return ddlsNumQuartos;
	}

	public WebElement getBtnReservar() {
		return btnReservar;
	}

	

	
	
	
	
}
