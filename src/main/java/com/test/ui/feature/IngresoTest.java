package com.test.ui.feature;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IngresoTest {

	private Utils util;
	private WebDriver driver;

	@Before
	public void inicio() {
		util = Utils.getInstance();
		driver = util.getWebDriver();
	}

	@Given("^ir a la pagina \"([^\"]*)\"$")
	public void ir_a_la_pagina(String url) {

		driver.get(url);
	}

	@When("^ingreso el email \"([^\"]*)\"$")
	public void ingreso_el_email(String email) {

		driver.findElement(By.id("email")).sendKeys(email);
	}

	@When("^ingreso el password \"([^\"]*)\"$")
	public void ingreso_el_password(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("^presiono el boton Autenticar$")
	public void presiono_el_boton_Autenticar() {

		WebElement btnenviar = driver.findElement(By.id("botonEnvio"));
		btnenviar.click();
	}

	@Then("^muestra pagina de bienvenida con el usuario \"([^\"]*)\"$")
	public void muestra_pagina_de_bienvenida_con_el_usuario(String usuario) throws InterruptedException {
		Thread.sleep(1000);
		String mensajeExito = driver.findElement(By.id("usuario")).getText();
		Assert.assertEquals(usuario, mensajeExito);
	}

	@After
	public void cerrarBrowser() {
		driver.close();
	}

}
