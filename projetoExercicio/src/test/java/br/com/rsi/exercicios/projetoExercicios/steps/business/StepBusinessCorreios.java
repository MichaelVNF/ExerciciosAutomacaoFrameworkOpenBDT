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

	//CT1(Buscar CEP - por endereço) e CT2(Buscar Endereco - por CEP)
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
			{   LOG.info("Item"+ (i-3) + ": "+ listaEnderecos.get(i).getText() + " | " + listaEnderecos.get(i+1).getText() + " | " + listaEnderecos.get(i+2).getText() + " | ");
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
				page.waitFor(300).milliseconds();
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
	
	//CT3(Calcular Preços e prazos) e CT5(Calcular Preços e prazos)
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
	
	public void clicarCkbCompararServicos(boolean clica) {
		if(clica) {
			viewElement.waitForElementIsPresent(10, page.getCkbCompararServico());
			viewElement.click(page.getCkbCompararServico());
		}
	}

	public void clicarFormatoObjeto(String formato) {
		
		if(formato.equals("Caixa"))
			viewElement.click(page.getImgCaixa());
		else
			if(formato.equals("Envelope"))
				viewElement.click(page.getImgEnvelope());
		else
			if(formato.equals("Rolo"))
				viewElement.click(page.getImgRolo());
		
	}

	public void selecionarDdlEmbalagem(String embalagem) {

		viewElement.selectByVisibleText(page.getDdlEmbalagem(), embalagem);
		
	}

	public void clicarBotaoParaselecionarTipoEmbalagem(int tipo) {
		page.waitFor(500).milliseconds();//carregar os tipos(imagens)
		List<WebElement> btnsTipoEmbalagem =  viewElement.findElements(page.getXpathBtnsSelecionarEmbalagem());

		tipo--;
		for(int i = 0; i < tipo; i++)
		{
			viewElement.click(page.getLinkNext());
			page.waitFor(500).milliseconds();
		}
		viewElement.waitForElementIsPresent(10, btnsTipoEmbalagem.get(tipo));
		viewElement.click(btnsTipoEmbalagem.get(tipo));
	}

	public void selecionarDdlPesoEstimado(String peso) {
		viewElement.selectByVisibleText(page.getDdlPeso(), peso);
		
	}

	public void clicarCkbMaoPropria(boolean clica) {
		if(clica)
			viewElement.click(page.getCkbMaoPropria());
		
	}

	public void clicarCkbAvisoRecebimento(boolean clica) {
		if(clica)
			viewElement.click(page.getCkbAvisoRecebimento());
	
	}

	public void clicarCkbDeclaracaoValor(boolean clica, String valor) {
		if(clica) {
			viewElement.click(page.getCkbValorDeclarado());
			
			viewElement.waitForElementIsPresent(10, page.getTxtValorDeclarado());
			viewElement.sendText(page.getTxtValorDeclarado(), valor);
		}
	
	}

	public void clicarBtnEnviar() {
		viewElement.click(page.getBtnEnviar());
	}
	
	public void verificarExistenciaResultados() {
		Assert.assertTrue(page.getThValorTotal().getText().contains("Valor total"));
	}

	//CT4(Buscar Agencia)
	public void clicarLinkRedeDeAtendimento() {
		viewElement.click(page.getLinkAgencias());
		
	}

	public void selecionarRdbTipoBusca(String tipoBusca) {

		if(tipoBusca.equals("Proximidade"))
			viewElement.click(page.getRdbTipoBusca().get(0));
		else
			if(tipoBusca.equals("Localidade"))
				viewElement.click(page.getRdbTipoBusca().get(1));
		else
			if(tipoBusca.equals("Serviço"))
				viewElement.click(page.getRdbTipoBusca().get(2));
		
	}

	public void selecionarDdlEstado(String estado) {
		viewElement.waitForElementIsPresent(10, page.getDdlEstadoAgencia());
		viewElement.selectByVisibleText(page.getDdlEstadoAgencia(), estado);
	}

	public void selecionarDdlMunicipio(String municipio) {
		//page.waitForTextToDisappear("Loading");
		page.waitFor(2000).milliseconds();
		viewElement.selectByVisibleText(page.getDdlMunicipioAgencia(), municipio);
	}

	public void selecionarDdlBairro(String bairro) {
		//page.waitForTextToDisappear("Loading");
		page.waitFor(2000).milliseconds();
		viewElement.selectByVisibleText(page.getDdlBairroAgencia(), bairro);
	}
	
	public void verificarListagemEnderecoAgencia(String rua)
	{
		viewElement.waitForElementIsPresent(10, page.getTblAgencias().get(0));//aguarda a presenca d ao menos o 1 elemento
		
		boolean achou = false;
		List<WebElement> listaAgencias = page.getTblAgencias();
		
		for(int i = 0; i < listaAgencias.size(); i++)
		{
			listaAgencias.get(i).click();
			page.waitForTextToAppear("Endereço");
		
			String nomeRua = viewElement.findElement(By.xpath("//*[@id=\"detalheAgencia"+ (i+1) +"\"]/tbody/tr[2]/td")).getText();
			if(nomeRua.contains(rua)) {
				achou = true;
				break;	
			} 
			page.waitFor(500).milliseconds();
		}
		
		Assert.assertTrue(achou);
	}
	
	
	
}
