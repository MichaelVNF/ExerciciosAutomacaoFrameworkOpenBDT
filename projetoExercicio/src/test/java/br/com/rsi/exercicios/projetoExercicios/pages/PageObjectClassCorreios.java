package br.com.rsi.exercicios.projetoExercicios.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageObjectClassCorreios extends PageObject{

	@FindBy(id = "acesso-busca")
	private WebElement txtCepOuEndereco;
	
	@FindBy(xpath = "//*[@id=\"busca-acesso-rapido\"]/form/input[2]")
	private WebElement btnPesq;

	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr/td")
	private List<WebElement> tblEnderecos;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[5]/a")
	private WebElement linkProxima;
	
	@FindBy(xpath = "//*[@id=\"content-principais-servicos\"]/ul/li[3]/a")
	private WebElement linkPrecosPrazos;
	
	@FindBy(id = "data")
	private WebElement txtData;
	
	@FindBy(name = "cepOrigem")
	private WebElement txtCepOrigem;
	
	@FindBy(name = "cepDestino")
	private WebElement txtCepDestino;
	
	@FindBy(name = "servico")
	private WebElement ddlServico;
	
	@FindBy(name = "compararServico")
	private WebElement ckbCompararServico;
	
	public WebElement getTxtCepOuEndereco() {
		return txtCepOuEndereco;
	}

	public WebElement getBtnPesq() {
		return btnPesq;
	}

	public List<WebElement> getTblEnderecos() {
		return tblEnderecos;
	}

	public WebElement getLinkProxima() {
		return linkProxima;
	}

	public WebElement getLinkPrecosPrazos() {
		return linkPrecosPrazos;
	}

	public WebElement getTxtData() {
		return txtData;
	}

	public WebElement getTxtCepOrigem() {
		return txtCepOrigem;
	}

	public WebElement getTxtCepDestino() {
		return txtCepDestino;
	}

	public WebElement getDdlServico() {
		return ddlServico;
	}

	public WebElement getCkbCompararServico() {
		return ckbCompararServico;
	}
	
	
	
	
}
