package co.com.devco.questions;

import static co.com.devco.userinterfaces.PetBookBigImage.BIG_IMAGE;

import java.util.List;
import java.util.stream.Collectors;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResultadoSeleccionPetBook implements Question<Boolean> {
	private int id;

	public ResultadoSeleccionPetBook(int id) {
		this.id = id;
	}

	public static ResultadoSeleccionPetBook resultado(int id) {
		return new ResultadoSeleccionPetBook(id);
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		return BIG_IMAGE.resolveFor(actor).getAttribute("style").contains("assets/images/");
	}
}