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
			if(page.getLinksVerHotel().get(i).getText().contains(nome))
			{
				viewElement.waitForElementIsPresent(10, page.getLinksVerHotel().get(i));
				viewElement.open(page.getLinksVerHotel().get(i).getAttribute("href"));
				break;
			}
		}
	}
	
	public void verificarHotelClicado(int qtdEstrelas) {
		viewElement.waitForElementIsPresent(10, page.getIEstrelas().get(0));
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
		page.waitFor(2000).milliseconds();
		viewElement.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[3]/div/div/div/input")).sendKeys(Keys.ENTER);
	}
	
	public void preencherCampoDestino(String destino) {
		viewElement.waitForElementIsPresent(10, page.getTxtDestino());
		viewElement.click(page.getTxtDestino());
		viewElement.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[4]/div/div/div/input")).sendKeys(destino);
		page.waitFor(2000).milliseconds();
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
		viewElement.waitForElementIsPresent(30, viewElement.findElement(By.xpath("//*[@id=\"main-container\"]/div/div/div[3]/div/div[2]/section[1]/div[1]/div[2]/div/div[2]/div/div/div/span")));
		Assert.assertTrue(page.containsAllText("Selecionar"));
	}
	
	
	//CT03(Comprar Ingresso) e 	CT05(Reservar Hotel)
	public void clicarMenuIngressos() {
		viewElement.click(page.getMenuIngressos());
	}
	
	public void clicarSugestaoPesq(int pos) {
		viewElement.findElement(By.xpath("//*[@id=\"hu-hotels-autocomplete-field\"]/div/ul/li["+(pos+3)+"]")).click();
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
	
	
	public void selecionarData(String data) throws InterruptedException{
		
		String dt[] = data.split("/");
		int dia = Integer.parseInt(dt[0]);
		int mes = Integer.parseInt(dt[1]);
		int ano = Integer.parseInt(dt[2]);
		
		int anoPopup = Integer.parseInt(page.getLblAno().getText());

		//converte mes em numero
		String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
		int mesPopup = 0;
		
		for(int i = 0; i < meses.length; i++)
		{
			if(page.getLblMes().getText().contains(meses[i])) {
				mesPopup = i + 1;
			}
		}
		
		//DEFINE ANO
		if(ano > anoPopup)
		{
			int difAno = (ano - anoPopup) - 1;//diferenca entre os anos, desconta 1 ano ja q ele pod não ser 1 'ano' de fato(ou seja, não conter os 12 meses)
			
			int limite = 12 * difAno;//qtd de vezes q os meses serao pulados
			limite = limite + (12-mesPopup);//para o ultimo pular a qtd d vezes subtraindo os meses(convertidos em nums) q encontravam-se no calendario
			limite = limite + mes;//limite incrementa o mes de entrada 
			
			for(int i = 1; i <= limite; i++ )
			{
				viewElement.click(page.getSpanNext());
				page.waitFor(500).milliseconds();
			}
		}
		else
			if(ano < anoPopup)
			{
				int difAno = (anoPopup - ano) - 1;//diferenca entre os anos
				
				int limite = 12 * difAno;//qtd de vezes q os meses serao pulados
				limite = limite + (12-mes);//para o ultimo pular a qtd d vezes subtraindo os meses(convertidos em nums) q foram fornecidos na entrada
				limite = limite + (mesPopup);
				
				for(int i = 1; i <= limite; i++ )
				{	
					viewElement.click(page.getSpanPrevious());
					page.waitFor(500).milliseconds();
				}
			}
		else //DEFINE MES(PARA O MSM ANO QUE SE ENCONTRA CALENDARIO E ENTRADA: ano == anoPopup)
		{
			if(mes > mesPopup)
			{
				for(int i = 1; i <= (mes-mesPopup); i++ )
				{
					viewElement.click(page.getSpanNext());
					page.waitFor(500).milliseconds();
				}
			}
			else
				if(mes < mesPopup)
				{	
					for(int i = 1; i <= (mesPopup-mes); i++ )
					{
						viewElement.click(page.getSpanPrevious());
						page.waitFor(500).milliseconds(); 
					}
				}		
		}
		
		//DEFINE DIA
		page.waitFor(500).milliseconds();//espere carregar os td's dos dias
		
		List<WebElement> listaDias = page.getListaDias();
		for(int i = 0; i < listaDias.size(); i++)
		{
			if(listaDias.get(i).getText().equals(""+dia))
			{
				listaDias.get(i).click();
				i = listaDias.size();
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
		List<WebElement> listaTrajetos = viewElement.findElements(By.xpath("//*[@id=\"reactRoot\"]/div/div[3]/div[2]/div/div/div/div[2]/div/a/div[2]/div[1]/strong"));
		
		for(int i = 0; i < listaTrajetos.size(); i++)
		{	
			if(listaTrajetos.get(i).getText().contains(trajeto)) {
				achou = true;
				break;
			}
		}
		Assert.assertTrue(achou);
	}
	
}
