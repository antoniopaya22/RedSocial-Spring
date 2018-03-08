package com.social.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.social.tests.utils.SeleniumUtils;


public class PO_PrivateView extends PO_NavView {
	
	static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) 
	{
		// Esperamos 5 segundo a que cargue el DOM porque en algunos equipos falla
		SeleniumUtils.esperarSegundos(driver, 5);
		
		// Seleccionamos el alumnos userOrder
		new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
		
		// Rellenemos el campo de descripción
		WebElement description = driver.findElement(By.name("description"));
		description.clear();
		description.sendKeys(descriptionp);
		
		// Rellenamos el campo de puntuación
		WebElement score = driver.findElement(By.name("score"));
		score.click();
		score.clear();
		score.sendKeys(scorep);
		
		// Pulsamos el botón
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
	
	
	static public void fillFormAddUser(WebDriver driver, int userOrder, String dnip, String nombrep, String apellidop, String passp) 
	{
		// Esperamos 5 segundo a que cargue el DOM porque en algunos equipos falla
		SeleniumUtils.esperarSegundos(driver, 5);
		
		// Rellenemos el campo de descripción
		WebElement dni = driver.findElement(By.name("dni"));
		dni.clear();
		dni.sendKeys(dnip);
		
		// Rellenamos el campo de puntuación
		WebElement nombre = driver.findElement(By.name("name"));
		nombre.click();
		nombre.clear();
		nombre.sendKeys(nombrep);
		
		// Rellenamos el campo de puntuación
		WebElement apellidos = driver.findElement(By.name("lastName"));
		apellidos.click();
		apellidos.clear();
		apellidos.sendKeys(apellidop);
		
		// Rellenamos el campo de puntuación
		WebElement pass = driver.findElement(By.name("password"));
		pass.click();
		pass.clear();
		pass.sendKeys(passp);
		
		// Pulsamos el botón
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
}