package br.com.rsi.exercicios.projetoExercicios.acceptance;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.openbdt.cucumber.CucumberWithOpenBdt;

@RunWith(CucumberWithOpenBdt.class)
@CucumberOptions(features = {"src/test/resources/bdd/features/hotelUrbano/CT03_ComprarIngresso.feature"}, glue = {"br.com.rsi.exercicios.projetoExercicios.steps.definition"})
public class DefaultAcceptanceTestRunner {}
