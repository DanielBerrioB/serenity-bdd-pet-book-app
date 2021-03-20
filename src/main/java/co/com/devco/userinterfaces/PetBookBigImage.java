package co.com.devco.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class PetBookBigImage {
	public static final Target BIG_IMAGE = Target.the("Imagen en grande").located(By.xpath("//div[@style]"));
}
