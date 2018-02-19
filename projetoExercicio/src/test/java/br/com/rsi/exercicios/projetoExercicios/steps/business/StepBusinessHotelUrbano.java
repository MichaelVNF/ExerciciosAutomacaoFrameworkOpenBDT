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
	
	public void clicarLinkVerHotel(String nome) {
		viewElement.waitForElementIsPresent(10, page.getLinksVerHotel().get(0));
		
		for(int i = 0; i < page.getLinksVerHotel().size(); i++) {
			LOG.info("Item " + (i+1)+ ": " + page.getLinksVerHotel().get(i).getText());
			viewElement.mouseOver(page.getLinksVerHotel().get(i));
			
			if(page.getLinksVerHotel().get(i).getText().contains(nome))
			{
				viewElement.waitForElementIsPresent(10, page.getLinksVerHotel().get(i));
				viewElement.open(page.getLinksVerHotel().get(i).getAttribute("href"));
				break;
			}
		}
	}
	
	public void verificarHotelClicado(String nomeHotel) {
		viewElement.waitForElementIsPresent(10, page.getLblTituloLocal());
		LOG.info("Hotel selecionado: "+page.getLblTituloLocal().getText());
	    Assert.assertTrue(page.getLblTituloLocal().getText().equals(nomeHotel));	
	}
	
	//CT02(Selecionar Passagem aerea)
	public void clicarMenuAereos() {
		viewElement.click(page.getMenuAereos());
	}
	
	public void preencherCampoOrigem(String origem) {
		viewElement.waitForElementIsPresent(10, page.getTxtOrigem());
		viewElement.click(page.getTxtOrigem());
		viewElement.findElement(By.xpath("//input[@placeholder='Cidade ou aeroporto de origem']")).sendKeys(origem);
		page.waitFor(2000).milliseconds();
		viewElement.findElement(By.xpath("//input[@placeholder='Cidade ou aeroporto de origem']")).sendKeys(Keys.ENTER);
	}
	
	public void preencherCampoDestino(String destino) {
		viewElement.waitForElementIsPresent(10, page.getTxtDestino());
		viewElement.click(page.getTxtDestino());
		viewElement.findElement(By.xpath("//input[@placeholder='Cidade ou aeroporto de destino']")).sendKeys(destino);
		page.waitFor(2000).milliseconds();
		viewElement.findElement(By.xpath("//input[@placeholder='Cidade ou aeroporto de destino']")).sendKeys(Keys.ENTER);
	
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
		viewElement.waitForElementIsPresent(30, viewElement.findElement(By.xpath("//button[@class='price-button js-raise-booking']")));
		Assert.assertTrue(viewElement.findElement(By.xpath("//button[@class='price-button js-raise-booking']")).getText().contains("Selecionar"));
	}
	
	
	//CT03(Comprar Ingresso) e 	CT05(Reservar Hotel)
	public void clicarMenuIngressos() {
		viewElement.click(page.getMenuIngressos());
	}
	
	public void clicarSugestaoPesq(int pos) {
		viewElement.findElement(By.xpath("//ul[@class='autocomplete-results']/li["+(pos+3)+"]")).click();
	}
	
	
	public void selecionarDdlQtdPessoas(String qtd) {
		viewElement.waitForElementIsPresent(10, page.getDdlQtdPessoas());
		viewElement.selectByVisibleText(page.getDdlQtdPessoas(), qtd);
	}
	
	public void clicarLinkComprarIngresso(int pos) {
		viewElement.waitForElementIsPresent(10, page.getLinksComprarIngresso().get(pos-1));
		viewElement.click(page.getLinksComprarIngresso().get(pos-1));
	}
	
	public void preencherCampoEmail(String email) {
		viewElement.waitForElementIsPresent(10, page.getTxtEmail());
		viewElement.sendText(page.getTxtEmail(), email);
	}

	public void preencherCampoCpf(String cpf) {
		viewElement.sendText(page.getTxtCpf(), cpf);
	}
	
	public void preencherCampoDtNasc(String dtNasc) {
		viewElement.sendText(page.getTxtDtNasc(), dtNasc);
	}
	
	public void preencherCampoTelefone(String tel) {
		viewElement.sendText(page.getTxtTel(), tel);
	}
	
	public void preencherCampoNumCartao(String numCartao) {
		viewElement.sendText(page.getTxtNumCartao(), numCartao);
	}
	
	public void preencherCampoTitular(String titular) {
		viewElement.click(page.getTxtTitular());
		page.waitFor(1500).milliseconds();
		viewElement.sendText(page.getTxtTitular(), titular);
	}
	
	public void preencherCampoValidade(String validade) {
		viewElement.sendText(page.getTxtValidade(), validade);
	}
	
	public void preencherCampoCodSeguranca(String codSeguranca) {
		viewElement.sendText(page.getTxtCodSeguranca(), codSeguranca);
	}
	
	public void selecionarDdlParcelas(String qtdParcelas) {
		viewElement.selectByValue(page.getDllParcelas(), qtdParcelas);
	}

	public void clicarCkbArmazenarDados(boolean clica) {
		if(clica)
			viewElement.click(page.getCkbArmazenarDados());	
	}
	
	public void preencherCampoEntrada(String data) throws InterruptedException {
		
		viewElement.click(page.getTxtEntrada());
		selecionarData(data);
	}
	
	public void preencherCampoSaida(String data) throws InterruptedException {
		
		viewElement.click(page.getTxtSaida());
		selecionarData(data);

	}
	
	public int converteMesTextoEmMesNumerico(String meses[], String mes) {
		for(int i = 0; i < meses.length; i++)
		{
			if(mes.equals(meses[i])) {
				return i + 1;
			}
		}
		return 0;
	}

	public void selecionarData(String data) throws InterruptedException{
			
		String dt[] = data.split("/");
		int dia = Integer.parseInt(dt[0]);
		int mes = Integer.parseInt(dt[1]);
		int ano = Integer.parseInt(dt[2]);
		
		//nomes dos meses p/ converter mes em numero
		String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
	 
		//DEFINE MES E ANO
		while(ano != Integer.parseInt(page.getLblAno().getText()) || mes != converteMesTextoEmMesNumerico(meses, page.getLblMes().getText())) {
			viewElement.click(page.getSpanNext());	
			page.waitFor(500).milliseconds();
		}
		
		//DEFINE DIA
		int posPrimeiroDia = 0;
		for(int i = 0; i < page.getListaDias().size(); i++)
		{
			if(page.getListaDias().get(i).getText().equals("1")) {
				posPrimeiroDia = i;//o calendario exibe no mes atual dias do mes anterior e/ou sucessor, p/ correção devemos partir do 1 dia do mes atual
				break;
			}
		}
		
		for(int i = posPrimeiroDia; i < page.getListaDias().size(); i++)
		{
			if(page.getListaDias().get(i).getText().equals(""+dia)) {
				page.getListaDias().get(i).click();
				break;
			}
		}
		
	}
	
	public void selecionarDdlQtdQuartos(String qtd) {
		viewElement.selectByVisibleText(page.getDdlQuartos(), qtd);
	}
	
	public void selecionarDdlQtdAdultos(String qtd) {
		viewElement.selectByVisibleText(page.getDdlAdultos(), qtd);
	}
	
	public void selecionarDdlQtdCriancas(String qtd) {
		viewElement.selectByVisibleText(page.getDdlCriancas(), qtd);
	}

	public void clicarBtnVarificarDisp() {
		viewElement.click(page.getBtnVerificarDisp());
	}
	
	public void selecionarDdlsNumQuartos(int pos, String qtd) {
		viewElement.waitForElementIsPresent(10, page.getDdlsNumQuartos().get(pos-1));
		viewElement.selectByValue(page.getDdlsNumQuartos().get(pos-1), qtd);
	}
	
	public void clicarBtnReservar() {
		viewElement.waitForElementIsPresent(10, page.getBtnReservar());
		viewElement.click(page.getBtnReservar());
		
		page.waitFor(5000).milliseconds();//aux
	}
	
	public void preencherNomesResponsaveisQuartos(int qtdQuartos, String responsavel) {
		
		for(int i = 1; i <= qtdQuartos; i++)
		{
			viewElement.findElement(By.name("extraFieldroomIdentificationName["+i+"]")).sendKeys(responsavel+" - "+i);;
		}
			
	}
	
	//CT04(Consultar Promocao)
	public void clicarMenuPromocoes() {
		viewElement.click(page.getMenuPromocoes());
		
	}
	
	public void verificarExistenciaPromocao(String trajeto) {
			
		trajeto = trajeto.toUpperCase();
		boolean achou = false;
		viewElement.waitForElementIsPresent(10, page.getListaTrajetos().get(0));
		
		for(int i = 0; i < page.getListaTrajetos().size(); i++)
		{	
			viewElement.mouseOver(page.getListaTrajetos().get(i));
			LOG.info("\nTrajeto "+ (i+1) +" : " + page.getListaTrajetos().get(i).getText());
			if(page.getListaTrajetos().get(i).getText().contains(trajeto)) {
				achou = true;
				LOG.info("\nAchou o Trajeto!");
				break;
			}
		}
		Assert.assertTrue(achou);
	}
	
}
