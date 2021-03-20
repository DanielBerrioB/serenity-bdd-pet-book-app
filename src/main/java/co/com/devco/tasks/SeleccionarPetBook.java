package co.com.devco.tasks;

import static co.com.devco.userinterfaces.PetBookMainPage.PET_BOOK_HOME_PAGE;
import static co.com.devco.userinterfaces.PetBookMainPage.IMAGE;
import static co.com.devco.exceptions.ComportamientoInesperado.ID_NO_ENCONTRADO;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;

public class SeleccionarPetBook implements Task {
	private int id;

	public SeleccionarPetBook(int id) {
		this.id = id;
	}

	public static Performable laImagen(int id) {
		return instrumented(SeleccionarPetBook.class, id);
	}
	
	 private String addChar(String str, char ch, int position) {
		    StringBuilder sb = new StringBuilder(str);
		    sb.insert(position, ch);
		    return sb.toString();
	}

	private Target getSelectorByCategory() {
		String selector = addChar(IMAGE, (char) (id+'0'), IMAGE.indexOf(',')+1);
		Target IMAGE_SELECTOR = Target.the("Imagen de filtro para perro 1").located(By.xpath(selector));
		if (id >= 1 && id<=5 ) {
			return IMAGE_SELECTOR;
		}
		return null;
	}

	public <T extends Actor> void performAs(T actor) {
		Target selector = getSelectorByCategory();
		if(selector != null ) {
			actor.attemptsTo(Open.url(PET_BOOK_HOME_PAGE), Click.on(selector));	
		} else {
			System.out.println(ID_NO_ENCONTRADO);
		}
	}
}
