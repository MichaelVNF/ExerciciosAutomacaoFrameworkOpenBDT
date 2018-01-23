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
			
	@FindBy(xpath = "//*[@id=\"result-card\"]/div/div/a")
	private List<WebElement> linksVerHotel;
	
	@FindBy(xpath = "//*[@id=\"wrap-page-head\"]/div[1]/span/i")
	private List<WebElement> iEstrelas;
	
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
	
	
	//CT03 - ComprarIngresso
	@FindBy(css = "a[title=\"Ingressos\"]")
	private WebElement menuIngressos;
	
	@FindBy(xpath = "//*[@id=\"reactRoot\"]/div/div[3]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/a/div[2]")
	private List<WebElement> divIngressos;
	
	@FindBy(id = "select2-o13i-container")
	private WebElement ddlQtdPessoas;
	
	@FindBy(xpath = "//*[@id=\"offer-options\"]/div[2]/div/div[2]/div/div[4]/div[2]/div[4]/a")
	private List<WebElement> linksComprarIngresso;
	
	
	
	
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

	public List<WebElement> getIEstrelas() {
		return iEstrelas;
	}

	public List<WebElement> getiEstrelas() {
		return iEstrelas;
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

	public List<WebElement> getDivIngressos() {
		return divIngressos;
	}

	public WebElement getDdlQtdPessoas() {
		return ddlQtdPessoas;
	}

	public List<WebElement> getLinksComprarIngresso() {
		return linksComprarIngresso;
	}

	
	
	
	
}
