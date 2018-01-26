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
	
	@FindBy(xpath = "//*[@id=\"search-linx\"]/div[6]/div[2]/ul[2]/li/a/div[2]/div[1]/span")
	private List<WebElement> divProdutos;
		
	@FindBy(id = "border-bottom-color-text")
	private List<WebElement> linksCores;

	@FindBy(name = "quantity")
	private List<WebElement> listaCarrinho;
	
	@FindBy(id = "buy-now-button")
	private WebElement btnComprar;
	
	//CT04(Adicionar item ao carrinho e calcular frete)
	@FindBy(name = "cep-first-input")
	private WebElement cpfPrefixo;
	
	@FindBy(name = "cep-second-input")
	private WebElement cpfSufixo;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/table/tfoot/tr[1]/td[1]/div/form/div/div/div[4]/button")
	private WebElement btnCalcFrete;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/table/tfoot/tr[1]/td[3]/p/span[1]")
	private List<WebElement> valoresFrete;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/table/tbody/tr/td[4]/p")
	private List<WebElement> precosProdutos;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/table/tfoot/tr[3]/td[2]/p/strong")
	private List<WebElement> precoTotal;
	
	
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

	public List<WebElement> getValoresFrete() {
		return valoresFrete;
	}

	public List<WebElement> getDivProdutos() {
		return divProdutos;
	}

	public List<WebElement> getPrecosProdutos() {
		return precosProdutos;
	}

	public List<WebElement> getPrecoTotal() {
		return precoTotal;
	}
	
	
	
	
	
	
}
