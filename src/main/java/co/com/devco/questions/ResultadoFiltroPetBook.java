package co.com.devco.questions;

import static co.com.devco.userinterfaces.PetBookMainPage.ALL_IMAGES;

import java.util.List;
import java.util.stream.Collectors;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResultadoFiltroPetBook implements Question<Boolean> {
	private String resultado;

	public ResultadoFiltroPetBook(String resultado) {
		this.resultado = resultado;
	}

	public static ResultadoFiltroPetBook es(String resultado) {
		return new ResultadoFiltroPetBook(resultado);
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		if (!resultado.contains("all")) {
			List<WebElementFacade> elements = ALL_IMAGES.resolveAllFor(actor);
			List<WebElementFacade> result = elements.stream().filter(e -> !e.getAttribute("src").contains(resultado))
					.collect(Collectors.toList());

			return result.size() == 0 ? true : false;
		}

		return ALL_IMAGES.resolveAllFor(actor).size() == 5;
	}
}