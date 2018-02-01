package br.com.rsi.exercicios.projetoExercicios.steps.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import io.openbdt.element.WebBrowserScreenElement;
import br.com.rsi.exercicios.projetoExercicios.pages.PageObjectClassNetshoes;
import jxl.common.Logger;
import net.serenity_bdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

@ContextConfiguration("/appcontext.xml")
public class StepBusinessNetshoes {

	PageObjectClassNetshoes page;
	private static Logger LOG = Logger.getLogger(StepBusinessNetshoes.class);
	
	@Autowired
	private WebBrowserScreenElement viewElement; // OBJETO QUE CONT�M M�TODOS PR�PRIOS DO FRAMEWORK

	@Step
	public void abrirPagina(String url) {
		viewElement.open(url);
		viewElement.getDriver().manage().window().maximize();
	}

	//CT01 e CT02 - (Adicionar item ao carrinho) 
	public void preencherCampoBusca(String busca) {
		viewElement.sendText(page.getCampoBusca(), busca);
		
	}

	public void clicarIconeBusca() {
		viewElement.click(page.getBtnBuscar());
		
	}

	public void clicarLinkProduto(String nomeProduto) {
		viewElement.waitForElementIsPresent(10, page.getDivProdutos().get(0));
		selecionarProduto(nomeProduto, page.getDivProdutos(), page.getBtnProximo());

	}
	
	public void selecionarProduto(String nomeProduto, List<WebElement> listaProdutos, org.openqa.selenium.By proximo) {
		boolean achou = false;
		boolean linkProxAtivado = true;
		boolean continua = true;
		
		while(continua) 
		{
			for(int i = 0; i < listaProdutos.size(); i++){
				LOG.info("Item "+ (i+1) + ": " + listaProdutos.get(i).getText());
				if(listaProdutos.get(i).getText().contains(nomeProduto)) {
					LOG.info("ACHOU O PRODUTO!");
					achou = true;
					listaProdutos.get(i).click();
					break;
				}
			}
			
			if(achou == false){
				try {
					WebDriverWait wait = new WebDriverWait(viewElement.getDriver(), 3);
					wait.until(ExpectedConditions.presenceOfElementLocated(proximo));//Espera pelo elemento, caso não aparerecer retorna exception
				}
				catch(Exception e) {
					linkProxAtivado = false;
				}
			}
			
			if(achou == false && linkProxAtivado){
				
				viewElement.findElement(proximo).click();
				page.waitFor(5).seconds();//espera carregar a nova lista
				listaProdutos = page.getDivProdutos();//atribui a nova lista
			}
			else{
				continua = false;
			}
		}
		Assert.assertTrue(achou);
	}
		
	public void clicarRdbCores(int pos) {	
		viewElement.waitForElementIsPresent(10, page.getLinksCores().get(pos-1));
		viewElement.click(page.getLinksCores().get(pos-1));
		page.waitFor(1).seconds();
	}

	public void clicarRdbTamanho(String numTam) {
		viewElement.findElement(By.cssSelector("span[title=\""+ numTam +"\"]")).click();
		page.waitFor(1).seconds();
	}
	
	public void clicarBotaoComprar() {
		viewElement.click(page.getBtnComprar());
	}
	
	public void verificarProdutoNoCarrinho(int qtd) {
		viewElement.waitForElementIsPresent(10, page.getListaCarrinho().get(0));//espera aparecer ao meno o 1º elemento
		
		int total = 0;
		for(int i = 0; i < page.getListaCarrinho().size(); i++)
			total += Integer.parseInt(page.getListaCarrinho().get(i).getAttribute("value"));
		
		Assert.assertTrue(total == qtd);
	}
	
	//CT03(Escolher um calçado na secao outlet com valor abaixo de 150 reais)
	public void clicarLinkTenisOutlet() {
		viewElement.waitForElementIsPresent(10, page.getLinkTenisOutlet());
		viewElement.click(page.getLinkTenisOutlet());
	}
	
	public void clicarCkbsPrecos(double valor) {
		
		double precos[] = {50, 100, 200, 300, 500, 1000};
		
		for(int i = 0; i < precos.length; i++) {
			if(valor >= precos[i]){
				viewElement.waitForElementIsPresent(10, page.getCkbsPrecos().get(i));
				viewElement.click(page.getCkbsPrecos().get(i));
			}
		}	
	}
	
	
	//CT04(Adicionar item ao carrinho e calcular frete)
	public void preencherCamposCpf(String cpf) {
		String cpfPartes[] = cpf.split("-");
		viewElement.sendText(page.getCpfPrefixo(), cpfPartes[0]);
		viewElement.sendText(page.getCpfSufixo(), cpfPartes[1]);
	}
	
	public void clicarBtnCalcularFrete() {
		viewElement.click(page.getBtnCalcFrete());
		page.waitFor(1).seconds();
	}

	public void verificarCalculoFrete() {
		
		Assert.assertTrue(viewElement.findElement(By.xpath("/html/body/div[3]/div[2]/table/tfoot/tr[1]/td[2]/strong")).getText().contains("FRETE"));
	}

	//CT05(Adicionar item no carrinho, Limpar Carrinho e voltar para loja)
	public void clicarBtnLimparCarrinho() {
		viewElement.click(page.getBtnLimparCarrinho());
		
	}

	public void clicarLinkVoltarLoja() {
		viewElement.waitForElementIsPresent(10, page.getLinkVoltarLoja());
		viewElement.click(page.getLinkVoltarLoja());

	}
	
	
	
	
	

}
