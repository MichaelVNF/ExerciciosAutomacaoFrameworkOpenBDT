package br.com.rsi.exercicios.projetoExercicios.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageObjectClassHotelUrbano extends PageObject{

	//CT01(Selecionar hotel) 
	@FindBy(css = "a[title=\"Reserva de Hotéis\"]")
	private WebElement menuHoteis;

	@FindBy(id = "huSearchComponentAutocomplete")
	private WebElement txtBarraPesquisa;
	
	@FindBy(xpath = "//*[@id=\"get-intent-midia\"]/div/form/div[2]/div[2]/button")
	private WebElement btnBuscar;
	
	private By ckbsCategoria = By.xpath("//*[@id='filters']/aside/div[2]/div[2]/div[2]/label");
	
	public By getCkbsCategoria() {
		return ckbsCategoria;
	}
	
	@FindBy(xpath = "//*[@id=\"result-card\"]/div/div/div[2]/div/div/div/h3/a")
	private List<WebElement> linksVerHotel;
	
	@FindBy(className = "page-title-text")
	private WebElement lblTituloLocal;
	
	//CT02(Selecionar Passagem aerea)
	@FindBy(css = "a[title=\"Passagens Aéreas\"]")
	private WebElement menuAereos;
	
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[3]/div/div/a")
	private WebElement txtOrigem;
	
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[4]/div/div/a")
	private WebElement txtDestino;

	@FindBy(xpath = "//*[@id=\"search\"]/a")
	private WebElement linkBuscar;
	
	@FindBy(xpath = "//*[@id=\"service-class\"]/div/button/div")
	private WebElement ddlClasse;
	
	//CT03(ComprarIngresso)
	@FindBy(css = "a[title=\"Ingressos\"]")
	private WebElement menuIngressos;
	
	@FindBy(xpath = "//*[@id=\"reactRoot\"]/div/div[3]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/a/div[2]")
	private List<WebElement> divIngressos;
	
	@FindBy(xpath = "//*[@id=\"offer-options\"]/div[1]/div[1]/div/select")
	private WebElement ddlQtdPessoas;
	
	@FindBy(xpath = "//*[@id=\"offer-options\"]/div[2]/div/div[2]/div/div[4]/div[2]/div[4]/a")
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
	@FindBy(css = "a[title=\"Promoções de Viagens\"]")
	private WebElement menuPromocoes;
	
	
	
	//CT05(Reservar Hotel)
	//CALENDARIO POPUP
	@FindBy(xpath = "//*[@id=\"formCalendarTop\"]/div[1]/div[1]/div/input")
	private WebElement txtEntrada;
	
	@FindBy(xpath = "//*[@id=\"formCalendarTop\"]/div[1]/div[2]/div/input")
	private WebElement txtSaida;
		
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")
	private WebElement lblMes;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")
	private WebElement lblAno;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td")
	private List<WebElement> listaDias;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")
	private WebElement spanNext;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")
	private WebElement spanPrevious;
	///FIM - CALENDARIO POPUP
	
	@FindBy(xpath = "//*[@id=\"formCalendarTop\"]/div[2]/div[1]/div/select")
	private WebElement ddlQuartos;
	
	@FindBy(xpath = "//*[@id=\"formCalendarTop\"]/div[2]/div[2]/div/select")
	private WebElement ddlAdultos;
	
	@FindBy(xpath = "//*[@id=\"formCalendarTop\"]/div[2]/div[3]/div/select")
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

	public WebElement getTxtOrigem() {
		return txtOrigem;
	}

	public WebElement getTxtDestino() {
		return txtDestino;
	}

	public WebElement getDdlClasse() {
		return ddlClasse;
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

	public List<WebElement> getDivIngressos() {
		return divIngressos;
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
