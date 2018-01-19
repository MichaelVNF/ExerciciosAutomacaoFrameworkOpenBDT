package br.com.rsi.exercicios.projetoExercicios.steps.definition;

import java.util.UUID;

import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import br.com.rsi.exercicios.projetoExercicios.steps.business.StepBusinessNetshoes;
import net.thucydides.core.annotations.Steps;

@ContextConfiguration("/appcontext.xml")
public class StepDefinitionNetshoes {

	@Steps
	StepBusinessNetshoes stepB;
	
//	@Given("^estou na pagina inicial do site \"([^\"]*)\"$")
//	public void estou_na_pagina_inicial_do_site(String url) throws Throwable {
//	    stepB.abrirPagina(url);
//	}

	
}
