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
	
	@FindBy(xpath = "//input[@class='acesso-busca-submit' and position()=2]")
	private WebElement btnPesq;
	
	@FindBy(xpath = "//table[@class='tmptabela']/tbody/tr/td")
	private List<WebElement> tblEnderecos;
	
	@FindBy(xpath = "//a[text()='[ Próxima ]']")
	private WebElement linkProxima;
	
	//CT3(Calcular Preços e prazos) e CT5(Calcular Preços e prazos)
	@FindBy(xpath = "//a[@title='Preços e prazos']")
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
	private By xpathBtnsSelecionarEmbalagem = By.xpath("//button[text()='Selecionar esta']");
	
	public By getXpathBtnsSelecionarEmbalagem() {
		return xpathBtnsSelecionarEmbalagem;
	}
	
	@FindBy(className = "next")
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
	
	@FindBy(xpath = "//tr[@class='destaque' and position()=1]/th")
	private WebElement thValorTotal;
	
	//CT4(Buscar Agencia)
	@FindBy(id = "tipoBusca")
	private List<WebElement> rdbTipoBusca;
	
	@FindBy(name = "estadoAgencia")
	private WebElement ddlEstadoAgencia;
	
	@FindBy(name = "municipioAgencia")
	private WebElement ddlMunicipioAgencia;
	
	@FindBy(name = "bairroAgencia")
	private WebElement ddlBairroAgencia;
	
	@FindBy(xpath = "//a[@title='Rede de Atendimento']")
	private WebElement linkAgencias;

	
	@FindBy(xpath = "//*[@id='tableNomeAgencia']")
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
