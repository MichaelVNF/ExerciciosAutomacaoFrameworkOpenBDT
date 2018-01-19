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
import br.com.rsi.exercicios.projetoExercicios.pages.PageObjectClassCorreios;
import jxl.common.Logger;
import net.serenity_bdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

@ContextConfiguration("/appcontext.xml")
public class StepBusinessCorreios {

	PageObjectClassCorreios page;
	private static Logger LOG = Logger.getLogger(StepBusinessCorreios.class);
	
	@Autowired
	private WebBrowserScreenElement viewElement; // OBJETO QUE CONT�M M�TODOS PR�PRIOS DO FRAMEWORK

	@Step
	public void abrirPagina(String url) {
		viewElement.open(url);
		viewElement.getDriver().manage().window().maximize();
	}

	public void preencherCampoCepOUEndereco(String cepOuEndereco) {
		viewElement.sendText(page.getTxtCepOuEndereco(), cepOuEndereco);
	}
	
	public void clicarBtnPesquisar() {
		viewElement.click(page.getBtnPesq());
	}
	
	public void verificarAberturaGuia() {
		
		String janelaAnterior = viewElement.getDriver().getWindowHandle(); //armazena a handle atual, sera reutilizada caso queira retornar a pag anterior
		String novaJanela = "";
		
		for(String janela : viewElement.getDriver().getWindowHandles()){
			viewElement.getDriver().switchTo().window(janela);//coleta a ultima janela aberta e altera para ela 
			novaJanela = janela;
		}
		LOG.info("\n Handle - Janela Anaterior:"+janelaAnterior+"\n");
		LOG.info("\n Handle - Nova Janela.....:"+novaJanela+"\n");
		
		Assert.assertTrue(!novaJanela.equals(janelaAnterior));//retorna verdadeiro quando a janela atual(nova) for diferente da anterior
		
	}
	
	public void verificarSeHouveDadosEncontrados() {
		Assert.assertFalse(page.containsAllText("DADOS NAO ENCONTRADOS"));
	}
	
	public void pesquisarEnderecoVerificarTabelaCep(String logradouro, String bairro, String localidade, String cepEsperado) {
		
		boolean continua = true;
		boolean achou = false;
		boolean linkProxAtivado = true;
		String cep = "";
	
		List<WebElement> listaEnderecos = page.getTblEnderecos();//atribui a 1º lista

		while(continua)
		{	
			for(int i = 0; i < listaEnderecos.size(); i+=4)
			{
				if(listaEnderecos.get(i).getText().contains(logradouro) && listaEnderecos.get(i+1).getText().contains(bairro) && listaEnderecos.get(i+2).getText().contains(localidade))
				{
					LOG.info("\n\nACHOU - CEP: " + listaEnderecos.get(i+3).getText() + "\n\n");
					cep = listaEnderecos.get(i+3).getText();
					achou = true;
					break;
				}
			}
			
			if(achou == false)
			{
				try {
					WebDriverWait wait = new WebDriverWait(viewElement.getDriver(), 1);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[5]/a")));//Espera pelo elemento, caso não aparerecer retorna exception
				}
				catch(Exception e) {
					linkProxAtivado = false;
				}
			}
		
			if(achou == false && linkProxAtivado)
			{
				LOG.info("\n\n\nPROXIMA\n\n\n");
				viewElement.click(page.getLinkProxima());
				page.waitFor(500).milliseconds();
				listaEnderecos = page.getTblEnderecos();//atribui a nova lista gerada dps de clicar em 'Proxima'
			}
			else
			{
				continua = false;
				LOG.info("\n\n\nCANCELA\n\n\n");
			}
		}
		Assert.assertTrue(cep.contains(cepEsperado));
	}
	
	public void pesquisarCepVerificarTabelaEndereco(String logradouroEsperado, String bairroEsperado, String localidadeEsperada) {
		
		boolean achou = false;
		List<WebElement> listaEnderecos = page.getTblEnderecos();
		
		if(listaEnderecos.get(0).getText().contains(logradouroEsperado) && listaEnderecos.get(1).getText().contains(bairroEsperado) && listaEnderecos.get(2).getText().contains(localidadeEsperada))
			achou = true;
		
		Assert.assertTrue(achou);
	}
	
	public void clicarLinkPrecosPrazos() {
		viewElement.click(page.getLinkPrecosPrazos());
	}
	
	
	public void preencherCampoDataPostagem(String data) {
		viewElement.clear(page.getTxtData());
		viewElement.sendText(page.getTxtData(), data);
	}
	
	public void preencherCampoCepOrigem(String cepOrigem) {
		viewElement.sendText(page.getTxtCepOrigem(), cepOrigem);
	}
	
	public void preencherCampoCepDestino(String cepDestino) {
		viewElement.sendText(page.getTxtCepDestino(), cepDestino);
	}

	public void selecionarDdlServico(String servico) {
		viewElement.selectByVisibleText(page.getDdlServico(), servico);
	
	}

	public void selecionarCkbCompararServico() {
		viewElement.click(page.getCkbCompararServico());
		page.waitFor(2).seconds();
	}
}
