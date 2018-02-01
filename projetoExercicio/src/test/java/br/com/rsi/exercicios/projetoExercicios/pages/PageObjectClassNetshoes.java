package br.com.rsi.exercicios.projetoExercicios.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageObjectClassNetshoes extends PageObject{


	//CT01 e CT02 - (Adicionar item ao carrinho) 
	@FindBy(id = "search")
	private WebElement campoBusca;
	
	@FindBy(xpath = "//*[@id=\"input-search-bt\"]/span")
	private WebElement btnBuscar;
	
	@FindBy(css = "div[itemprop='name']")
	private List<WebElement> divProdutos;
	
	private By btnProximo = By.partialLinkText("Próxim");
	
	@FindBy(id = "border-bottom-color-text")
	private List<WebElement> linksCores;

	@FindBy(name = "quantity")
	private List<WebElement> listaCarrinho;
	
	@FindBy(id = "buy-now-button")
	private WebElement btnComprar;
	
	//CT03(Escolher um calçado na secao outlet com valor abaixo de 150 reais)
	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div[3]/aside/div/div[2]/ul/li[12]/a")
	private WebElement linkTenisOutlet;
	
	@FindBy(name = "price.pricelistLow")
	private List<WebElement> ckbsPrecos;
	
	//CT04(Adicionar item ao carrinho e calcular frete)
	@FindBy(name = "cep-first-input")
	private WebElement cpfPrefixo;
	
	@FindBy(name = "cep-second-input")
	private WebElement cpfSufixo;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/table/tfoot/tr[1]/td[1]/div/form/div/div/div[4]/button")
	private WebElement btnCalcFrete;
	
	//CT05(Adicionar item no carrinho, Limpar Carrinho e voltar para loja)
	@FindBy(xpath = "/html/body/div[3]/div[2]/table/tfoot/tr[5]/td[1]/form/button")
	private WebElement btnLimparCarrinho;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/div[3]/div[1]/div/a")
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

	public WebElement getCpfPrefixo() {
		return cpfPrefixo;
	}

	public WebElement getCpfSufixo() {
		return cpfSufixo;
	}

	public WebElement getBtnCalcFrete() {
		return btnCalcFrete;
	}

	public List<WebElement> getDivProdutos() {
		return divProdutos;
	}

	public WebElement getBtnLimparCarrinho() {
		return btnLimparCarrinho;
	}

	public WebElement getLinkVoltarLoja() {
		return linkVoltarLoja;
	}

	public WebElement getLinkTenisOutlet() {
		return linkTenisOutlet;
	}

	public List<WebElement> getCkbsPrecos() {
		return ckbsPrecos;
	}

	public By getBtnProximo() {
		return btnProximo;
	}

	
	
	
	
}
