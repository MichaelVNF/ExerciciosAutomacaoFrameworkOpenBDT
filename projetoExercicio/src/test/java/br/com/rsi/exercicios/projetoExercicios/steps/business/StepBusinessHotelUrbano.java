package br.com.rsi.exercicios.projetoExercicios.steps.business;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import io.openbdt.element.WebBrowserScreenElement;
import br.com.rsi.exercicios.projetoExercicios.pages.PageObjectClassHotelUrbano;
import jxl.common.Logger;
import net.serenity_bdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

@ContextConfiguration("/appcontext.xml")
public class StepBusinessHotelUrbano {

	PageObjectClassHotelUrbano page;
	private static Logger LOG = Logger.getLogger(StepBusinessHotelUrbano.class);
	
	@Autowired
	private WebBrowserScreenElement viewElement; // OBJETO QUE CONT�M M�TODOS PR�PRIOS DO FRAMEWORK

	@Step
	public void abrirPagina(String url) {
		viewElement.open(url);
		viewElement.getDriver().manage().window().maximize();
	}

	//CT01(Selecionar Hotel)
	public void clicarMenuHoteis() {
		viewElement.click(page.getMenuHoteis());
	}

	
	public void preencherCampoPesquisa(String pesquisa) {
		viewElement.waitForElementIsPresent(10, page.getTxtBarraPesquisa());
		viewElement.sendText(page.getTxtBarraPesquisa(), pesquisa);
	}
	
	public void clicarBotaoBuscar() {
		viewElement.click(page.getBtnBuscar());
	}
	
	public void selecionarCkbCategoria(int qtdEstrelas) {
		viewElement.waitForElementIsPresent(10, viewElement.findElements(page.getCkbsCategoria()).get(5-qtdEstrelas));
		viewElement.findElements(page.getCkbsCategoria()).get(5-qtdEstrelas).click();//subtrai 5, pois a categoria esta em ordem decrescente
		page.waitForTextToDisappear("Buscando as melhores ofertas...");
	}
	
	public void clicarLinkVerHotel(int pos) {
		viewElement.waitForElementIsPresent(10, page.getLinksVerHotel().get(pos-1));
		viewElement.click(page.getLinksVerHotel().get(pos-1));	
		
		page.waitFor(5).seconds();
	}
	
	public void verificarHotelClicado(int qtdEstrelas) {
		Assert.assertTrue(qtdEstrelas == page.getIEstrelas().size());	
	}
	
	//CT02(Selecionar Passagem aerea)
	public void clicarMenuAereos() {
		viewElement.click(page.getMenuAereos());
	}
	
	public void preencherCampoOrigem(String origem) {
		viewElement.waitForElementIsPresent(10, page.getTxtOrigem());
		viewElement.click(page.getTxtOrigem());
		viewElement.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[3]/div/div/div/input")).sendKeys(origem);
		page.waitFor(1000).milliseconds();
		viewElement.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
	}
	
	public void preencherCampoDestino(String destino) {
		viewElement.waitForElementIsPresent(10, page.getTxtDestino());
		viewElement.click(page.getTxtDestino());
		viewElement.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[4]/div/div/div/input")).sendKeys(destino);
		page.waitFor(1000).milliseconds();
		viewElement.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[4]/div/div/div/input")).sendKeys(Keys.ENTER);
	
	}
	
	public void selecionarDdlClasse(String classe) {
		viewElement.click(page.getDdlClasse());
		page.waitFor(1000).milliseconds();
		viewElement.findElement(By.partialLinkText(classe)).click();
	}
	
	public void clicarLinkBuscar() {
		viewElement.click(page.getLinkBuscar());
	}
	
	public void verificarResultadosBuscaVoo() {
		page.waitForTextToDisappear("Estamos procurando os voos mais baratos.");
		page.waitFor(500).milliseconds();
		Assert.assertTrue(page.containsAllText("Selecionar"));
	}
	
	
	//CT02(Comprar Ingresso)
	public void clicarMenuIngressos() {
		viewElement.click(page.getMenuIngressos());
	}
	
	public void clicarDivIngresso(int pos) {
		viewElement.click(page.getDivIngressos().get(pos-1));
	}
	
	public void selecionarDdlQtdPessoas(String qtd) {
		viewElement.waitForElementIsPresent(10, page.getDdlQtdPessoas());
		viewElement.selectByVisibleText(page.getDdlQtdPessoas(), qtd);
	}
	
	public void clicarLinkComprarIngresso(int pos) {
		viewElement.click(page.getLinksComprarIngresso().get(pos-1));
	}
}
