package br.com.rsi.exercicios.projetoExercicios.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageObjectClassSouBarato extends PageObject{

	//CT01(Adicionar ao carrinho um item da seção Produtos Reembalados)
	
	@FindBy(xpath = "//*[@id=\"containerpage\"]/div[1]/div/div/ul")
	private WebElement menuSuperior;
	
	@FindBy(linkText = "Produtos Reembalados")
	private WebElement menuProdutosReembalados;
	
	@FindBy(className = "p-name")
	private List<WebElement> nomeProdutos;
	
	private By btnMaisProdutos = By.xpath("//*[@id=\"containerpage\"]/div[2]/div/div/div/section/div[2]/a");
	
	@FindBy(id = "product-buy-button")
	private WebElement btnComprar;
	
	@FindBy(id = "product-selected-buy-continue")
	private WebElement linkContinuarCompra;
	
	@FindBy(xpath = "//*[@id=\"containerpage\"]/form/div[2]/div[1]/div/div[2]/ul/li/label/span[2]/span")
	private List<WebElement> rdbsGarantia;
	
	@FindBy(xpath = "//*[@id=\"containerpage\"]/form/div[2]/div[2]/div/div[2]/button")
	private WebElement btnContinuar;

	//CT02(Adicionar geladeira Brastemp ao carrinho (via Menu)
	@FindBy(xpath = "//*[@id=\"main-header-menu-toggle\"]/span")
	private WebElement menuMenu;
	
	@FindBy(id = "header-menu")
	private WebElement navMenu;
	
	//CT03(Adicionar Iphone ao carrinho (via campo busca)
	@FindBy(id = "header-search-input")
	private WebElement txtBusca;
	
	@FindBy(xpath = "//*[@id=\"main-header\"]/div[3]/div/div[4]/form/button")
	private WebElement btnBuscar;
	
	
	//CT04(Acessar aba das vantagens do cartão Sou Barato)
	@FindBy(xpath = "//*[@id=\"containerpage\"]/div[3]/div/div/div[1]/ul")
	private WebElement menuCartaoSouBarato;
	
	//CT05
	@FindBy(id = "cep")
	private WebElement txtCep;
	
	@FindBy(id = "calculate-freight-button")
	private WebElement btnCalcFrete;	
	
	
	
	public By getBtnMaisProdutos() {
		return btnMaisProdutos;
	}

	public WebElement getTxtBusca() {
		return txtBusca;
	}

	public WebElement getMenuProdutosReembalados() {
		return menuProdutosReembalados;
	}

	public List<WebElement> getNomeProdutos() {
		return nomeProdutos;
	}

	public WebElement getBtnComprar() {
		return btnComprar;
	}

	public WebElement getLinkContinuarCompra() {
		return linkContinuarCompra;
	}

	public List<WebElement> getRdbsGarantia() {
		return rdbsGarantia;
	}

	public WebElement getBtnContinuar() {
		return btnContinuar;
	}

	public WebElement getMenuMenu() {
		return menuMenu;
	}

	public WebElement getNavMenu() {
		return navMenu;
	}

	public WebElement getBtnBuscar() {
		return btnBuscar;
	}

	public WebElement getMenuSuperior() {
		return menuSuperior;
	}

	public WebElement getMenuCartaoSouBarato() {
		return menuCartaoSouBarato;
	}

	public WebElement getTxtCep() {
		return txtCep;
	}

	public WebElement getBtnCalcFrete() {
		return btnCalcFrete;
	}
	
	
	
	
	
	
}
