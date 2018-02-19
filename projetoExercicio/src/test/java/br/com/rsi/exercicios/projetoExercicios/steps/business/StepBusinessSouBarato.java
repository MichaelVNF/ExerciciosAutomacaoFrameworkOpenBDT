package br.com.rsi.exercicios.projetoExercicios.steps.business;

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
import br.com.rsi.exercicios.projetoExercicios.pages.PageObjectClassSouBarato;
import jxl.common.Logger;
import net.serenity_bdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

@ContextConfiguration("/appcontext.xml")
public class StepBusinessSouBarato {

	PageObjectClassSouBarato page;
	private static Logger LOG = Logger.getLogger(StepBusinessSouBarato.class);
	
	@Autowired
	private WebBrowserScreenElement viewElement; // OBJETO QUE CONT�M M�TODOS PR�PRIOS DO FRAMEWORK

	@Step
	public void abrirPagina(String url) {
		viewElement.open(url);
		viewElement.getDriver().manage().window().maximize();
		
		boolean existe = true; 
		try {
			WebDriverWait wait = new WebDriverWait(viewElement.getDriver(), 3);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lightpop\"]/div/div[2]/a")));//Espera pelo elemento, caso não aparerecer retorna exception	
		}
		catch(Exception e) {
			existe = false;
		}
		
		if(existe)
			viewElement.findElement(By.xpath("//*[@id=\"lightpop\"]/div/div[2]/a")).click();
	}

	//CT01(Adicionar ao carrinho um item da seção Produtos Reembalados)
	public void clicarMenuSuperior(String opcao) {
		page.getMenuSuperior().findElement(By.partialLinkText(opcao)).click();
	}

	public List<WebElement> retornarListaNova() {
		return page.getNomeProdutos().findElements(By.className("p-name"));
	}
	
	public void clicarLinkProdutoEspecifico(String nomeProduto) {
		
		viewElement.waitForElementIsPresent(10, page.getNomeProdutos().findElements(By.className("p-name")).get(0));
		selecionarProduto(nomeProduto,  retornarListaNova(), page.getBtnMaisProdutos());
		
		page.waitFor(5).seconds();
	}
	
	public void selecionarProduto(String nomeProduto, List<WebElement> listaProdutos, org.openqa.selenium.By proximo) {
		boolean achou = false;
		boolean linkProxAtivado = true;
		boolean continua = true;
		int limite = 0;
		int primeiroProduto = 0;
		
		while(continua && limite != 3) 
		{
			
			for(int i = primeiroProduto; i < listaProdutos.size(); i++){
				LOG.info("Item "+ (i+1) + ": " + listaProdutos.get(i).getText());
				viewElement.mouseOver(listaProdutos.get(i));
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
				primeiroProduto = listaProdutos.size();//conta a partir da ultima lida
				viewElement.findElement(proximo).click();
				page.waitFor(5).seconds();//espera carregar a nova lista
				listaProdutos =  retornarListaNova();//nova lista
				
			}
			else{
				continua = false;
			}
			limite++;
		}
		Assert.assertTrue(achou);
	}
	
	public void clicarBtnComprar() {
		boolean clicarContinua = false;
		
		if(viewElement.findElement(By.className("p-buybox")).getText().contains("Reembalado"))
			clicarContinua = true;
		
		viewElement.waitForElementIsPresent(10, page.getBtnComprar());
		viewElement.click(page.getBtnComprar());
		
		if(clicarContinua) {
			viewElement.waitForElementIsPresent(10, page.getLinkContinuarCompra());
			viewElement.click(page.getLinkContinuarCompra());
		}
		
	}
	
	public void clicarRdbsGarantia(String anosGarantia) {
		
		boolean temGarantia = true;
		try {
			WebDriverWait wait = new WebDriverWait(viewElement.getDriver(), 2);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='wr-info']")));//Espera pelo elemento, caso não aparerecer retorna exception
		}
		catch(Exception e) {
			temGarantia = false;
		}
		
		if(temGarantia){
			for(int i = 0; i < page.getRdbsGarantia().size(); i++) {
				if(page.getRdbsGarantia().get(i).getText().contains(anosGarantia)) {
					viewElement.click(page.getRdbsGarantia().get(i));
					break;
				}
			}
			viewElement.click(page.getBtnContinuar());
		}
	}
		
	public void verificarProdutosSacola(String qtdComprados) {
		Assert.assertTrue(viewElement.findElement(By.xpath("//td[@class='text-capitalize col-xs-8']")).getText().contains(qtdComprados));
	}

	//CT02(Adicionar geladeira Brastemp ao carrinho (via Menu)
	public void clicarMenuMenu() {
		viewElement.click(page.getMenuMenu());
	}
	
	public void sobreporMenuCatergoria(String categoria) {
		viewElement.mouseOver(page.getNavMenu().findElement(By.partialLinkText(categoria)));
	}
	
	public void clicarSubmenuCatergoria(String subCategoria) {
		viewElement.click(page.getNavMenu().findElement(By.partialLinkText(subCategoria)));
	}
	
	//CT03(Adicionar Iphone ao carrinho (via campo busca)
	public void preencherCampoBusca(String busca) {
		viewElement.sendText(page.getTxtBusca(), busca);
	}
	
	public void clicarBtnBusca() {
		viewElement.click(page.getBtnBuscar());
	}
	
	
	//CT04(Acessar aba das vantagens do cartão Sou Barato)
	public void clicarMenuSouBarato(String categoria) {
		viewElement.waitForElementIsPresent(10, page.getMenuCartaoSouBarato());
		viewElement.click(page.getMenuCartaoSouBarato().findElement(By.partialLinkText(categoria)));
	}
	
	public void verificarAberturaPagina(String comparativo)
	{
		Assert.assertTrue(page.containsAllText(comparativo));
	}
	
	//CT05(Adicionar item e Calcular frete)
	public void preencherCampoCep(String cep) {
		viewElement.waitForElementIsPresent(10, page.getTxtCep());
		viewElement.sendText(page.getTxtCep(), cep);
	}
	
	public void clicarBtnCalcFrete() {
		viewElement.click(page.getBtnCalcFrete());
		page.waitFor(1).seconds();
	}
	
	public void verificarCalculoFrete() {
		Assert.assertTrue(page.containsAllText("Confira abaixo o prazo de entrega e o valor do frete para o"));
	}
	
	
}
