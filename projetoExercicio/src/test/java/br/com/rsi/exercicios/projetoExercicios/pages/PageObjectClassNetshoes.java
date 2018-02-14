package br.com.rsi.exercicios.projetoExercicios.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageObjectClassNetshoes extends PageObject{


	//CT01 e CT02 - (Adicionar item ao carrinho) 
	@FindBy(id = "search-input")
	private WebElement campoBusca;
	
	@FindBy(css = "button[title='Buscar']")
	private WebElement btnBuscar;
	
	@FindBy(css = "span[itemprop='name']")
	private List<WebElement> divProdutos;
	
	private By btnProximo = By.partialLinkText("Próxim");
	
	@FindBy(xpath = "//*[@id=\"buy-box\"]/section/div/ul/li/a")
	private List<WebElement> linksCores;

	@FindBy(name = "quantity")
	private List<WebElement> listaCarrinho;
	
	@FindBy(id = "buy-button-now")
	private WebElement btnComprar;
	
	//CT03(Escolher um calçado na secao outlet com valor abaixo de 150 reais)
	@FindBy(xpath = "//*[@id=\"aggregate-salePrice\"]/div/a")
	private List<WebElement> ckbsPrecos;
	
	//CT04(Adicionar item ao carrinho e calcular frete)
	@FindBy(name = "shipping[zipCode]")
	private WebElement txtCep;
	
	@FindBy(className = "calculate-shipping__button")
	private WebElement btnCalcFrete;
	
	//CT05(Adicionar item no carrinho, Limpar Carrinho e voltar para loja)
	@FindBy(linkText = "Limpar Carrinho")
	private WebElement linkLimparCarrinho;
	
	@FindBy(id = "back-to-store")
	private WebElement linkVoltarLoja;
	
	public WebElement getCampoBusca() {
		return campoBusca;
	}

	public WebElement getBtnBuscar() {
		return btnBuscar;
	}

	public WebElement getBtnComprar() {
		return btnComprar;
	}

	public List<WebElement> getLinksCores() {
		return linksCores;
	}

	public List<WebElement> getListaCarrinho() {
		return listaCarrinho;
	}

	public WebElement getTxtCep() {
		return txtCep;
	}

	public WebElement getBtnCalcFrete() {
		return btnCalcFrete;
	}

	public List<WebElement> getDivProdutos() {
		return divProdutos;
	}

	public WebElement getLinkLimparCarrinho() {
		return linkLimparCarrinho;
	}

	public WebElement getLinkVoltarLoja() {
		return linkVoltarLoja;
	}

	public List<WebElement> getCkbsPrecos() {
		return ckbsPrecos;
	}

	public By getBtnProximo() {
		return btnProximo;
	}

	
	
	
	
}
