package co.com.devco.tasks;

import static co.com.devco.userinterfaces.PetBookMainPage.PET_BOOK_HOME_PAGE;
import static co.com.devco.userinterfaces.PetBookMainPage.CAT_BUTTON;
import static co.com.devco.userinterfaces.PetBookMainPage.DOG_BUTTON;
import static co.com.devco.userinterfaces.PetBookMainPage.ALL_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;

public class FiltrarPetBook implements Task {
	private String categoria;

	public FiltrarPetBook(String categoria) {
		this.categoria = categoria;
	}

	public static Performable laCategoria(String categoria) {
		return instrumented(FiltrarPetBook.class, categoria);
	}

	private Target getSelectorByCategory() {
		if (categoria.contains("gato")) {
			return CAT_BUTTON;
		} else if (categoria.contains("perro")) {
			return DOG_BUTTON;
		} else if (categoria.contains("all")) {
			return ALL_BUTTON;
		}
		return null;
	}

	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Open.url(PET_BOOK_HOME_PAGE), Click.on(getSelectorByCategory()));
	}
}
