package br.com.rsi.exercicios.projetoExercicios.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageObjectClassCorreios extends PageObject{

	//CT1(Buscar CEP - por endereço) e CT2(Buscar Endereco - por CEP)
	@FindBy(id = "acesso-busca")
	private WebElement txtCepOuEndereco;
	
	@FindBy(xpath = "//*[@id=\"busca-acesso-rapido\"]/form/input[2]")
	private WebElement btnPesq;

	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr/td")
	private List<WebElement> tblEnderecos;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[5]/a")
	private WebElement linkProxima;
	
	//CT3(Calcular Preços e prazos)
	@FindBy(xpath = "//*[@id=\"content-principais-servicos\"]/ul/li[3]/a")
	private WebElement linkPrecosPrazos;
	
	@FindBy(id = "data")
	private WebElement txtData;
	
	@FindBy(name = "cepOrigem")
	private WebElement txtCepOrigem;
	
	@FindBy(name = "cepDestino")
	private WebElement txtCepDestino;
	
	@FindBy(name = "servico")
	private WebElement ddlServico;
	
	@FindBy(name = "compararServico")
	private WebElement ckbCompararServico;
	
	@FindBy(className = "caixa")
	private WebElement imgCaixa;
	
	@FindBy(className = "envelope")
	private WebElement imgEnvelope;
	
	@FindBy(className = "rolo")
	private WebElement imgRolo;
	
	@FindBy(name = "embalagem1")
	private WebElement ddlEmbalagem;
	
	//para embalagem dos correios
	private By xpathBtnsSelecionarEmbalagem = By.xpath("//*[@id='spanTipoEmbalagem']/div/div[2]/div/div/div/p/button");
	
	public By getXpathBtnsSelecionarEmbalagem() {
		return xpathBtnsSelecionarEmbalagem;
	}

	@FindBy(xpath = "//*[@id=\"spanTipoEmbalagem\"]/div/div[1]/a[2]")
	private WebElement linkNext;
	//-----------------------------
	
	@FindBy(name = "peso")
	private WebElement ddlPeso;
	
	@FindBy(name = "avisoRecebimento")
	private WebElement ckbAvisoRecebimento;
	
	@FindBy(name = "MaoPropria")
	private WebElement ckbMaoPropria;
	
	@FindBy(name = "ckValorDeclarado")
	private WebElement ckbValorDeclarado;
	
	@FindBy(name = "valorDeclarado")
	private WebElement txtValorDeclarado;
	
	@FindBy(name = "Calcular")
	private WebElement btnEnviar;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/table/tfoot/tr/th")
	private WebElement thValorTotal;
	
	//CT4(Buscar Agencia)
	@FindBy(xpath = "//*[@id=\"content-principais-servicos\"]/ul/li[4]/a")
	private WebElement linkAgencias;
	
	@FindBy(id = "tipoBusca")
	private List<WebElement> rdbTipoBusca;
	
	@FindBy(name = "estadoAgencia")
	private WebElement ddlEstadoAgencia;
	
	@FindBy(name = "municipioAgencia")
	private WebElement ddlMunicipioAgencia;
	
	@FindBy(name = "bairroAgencia")
	private WebElement ddlBairroAgencia;
	
	@FindBy(xpath = "//*[@id=\"tableNomeAgencia\"]/tbody/tr/td/a")
	private List<WebElement> tblAgencias;
	
	
	
	public WebElement getTxtCepOuEndereco() {
		return txtCepOuEndereco;
	}

	public WebElement getBtnPesq() {
		return btnPesq;
	}

	public List<WebElement> getTblEnderecos() {
		return tblEnderecos;
	}

	public WebElement getLinkProxima() {
		return linkProxima;
	}

	public WebElement getLinkPrecosPrazos() {
		return linkPrecosPrazos;
	}

	public WebElement getTxtData() {
		return txtData;
	}

	public WebElement getTxtCepOrigem() {
		return txtCepOrigem;
	}

	public WebElement getTxtCepDestino() {
		return txtCepDestino;
	}

	public WebElement getDdlServico() {
		return ddlServico;
	}

	public WebElement getCkbCompararServico() {
		return ckbCompararServico;
	}

	public WebElement getImgCaixa() {
		return imgCaixa;
	}

	public WebElement getImgEnvelope() {
		return imgEnvelope;
	}

	public WebElement getImgRolo() {
		return imgRolo;
	}

	public WebElement getDdlEmbalagem() {
		return ddlEmbalagem;
	}

	public WebElement getLinkNext() {
		return linkNext;
	}

	public WebElement getDdlPeso() {
		return ddlPeso;
	}

	public WebElement getCkbAvisoRecebimento() {
		return ckbAvisoRecebimento;
	}

	public WebElement getCkbMaoPropria() {
		return ckbMaoPropria;
	}

	public WebElement getCkbValorDeclarado() {
		return ckbValorDeclarado;
	}

	public WebElement getTxtValorDeclarado() {
		return txtValorDeclarado;
	}

	public WebElement getBtnEnviar() {
		return btnEnviar;
	}

	public WebElement getThValorTotal() {
		return thValorTotal;
	}

	public WebElement getLinkAgencias() {
		return linkAgencias;
	}

	public List<WebElement> getRdbTipoBusca() {
		return rdbTipoBusca;
	}

	public WebElement getDdlEstadoAgencia() {
		return ddlEstadoAgencia;
	}

	public WebElement getDdlMunicipioAgencia() {
		return ddlMunicipioAgencia;
	}

	public WebElement getDdlBairroAgencia() {
		return ddlBairroAgencia;
	}

	public List<WebElement> getTblAgencias() {
		return tblAgencias;
	}
	
	
	
	
	
}
