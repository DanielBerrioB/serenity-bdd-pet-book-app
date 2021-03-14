package co.com.devco.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class PetBookMainPage {
	public static final String PET_BOOK_HOME_PAGE = "http://localhost:4200/";
	public static final Target CAT_BUTTON = Target.the("Boton de filtro para gato").located(By.xpath("//button[text()=\"Gato\"]"));
	public static final Target DOG_BUTTON = Target.the("Boton de filtro para perro").located(By.xpath("//button[text()=\"Perro\"]"));
	public static final Target ALL_BUTTON = Target.the("Boton de filtro para all").located(By.xpath("//button[text()=\"All\"]"));
	public static final Target ALL_IMAGES = Target.the("Todas las imagenes").located(By.xpath("//img"));
}
