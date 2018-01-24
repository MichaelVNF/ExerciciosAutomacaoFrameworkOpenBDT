package br.com.rsi.exercicios.projetoExercicios.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageObjectClassNetshoes extends PageObject{


	@FindBy(id = "search")
	private WebElement campoBusca;
	
	@FindBy(xpath = "//*[@id=\"input-search-bt\"]/span")
	private WebElement btnBuscar;
	
	@FindBy(xpath = "//*[@id=\"search-linx\"]/div[6]/div[2]/ul[2]/li/a")
	private List<WebElement> linksProdutos;

//	cores - lista
//	/html/body/div[3]/div[2]/div[1]/div[3]/div/form/div[3]/ul/li
//	
//	tamanho - lista
//	/html/body/div[3]/div[2]/div[1]/div[3]/div/form/div[4]/ul/li/label/span
	
	@FindBy(id = "buy-now-button")
	private WebElement btnComprar;
	
}
