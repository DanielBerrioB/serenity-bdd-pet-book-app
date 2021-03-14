package co.com.devco.stepdefinitions;

import static co.com.devco.exceptions.ComportamientoInesperado.FILTRO_INESPERADO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.devco.exceptions.ComportamientoInesperado;
import co.com.devco.questions.ResultadoFiltroPetBook;
import co.com.devco.tasks.FiltrarPetBook;
import cucumber.api.java.es.Entonces;

public class PetBookStepDefinitions {
	@Entonces("^el (.*) filtra por la categoria (.*)$")
	public void debeFiltrarLasImagenesPorEstaCategoria(String nombreActor, String categoria) {
		theActorCalled(nombreActor).attemptsTo(FiltrarPetBook.laCategoria(categoria));
	}
	
	@Entonces("^debe ver las imagenes por la categoria (.*)$")
	public void debeFiltrarLasImagenesPorEstaCategoria(String categoria) {
		theActorInTheSpotlight().should(seeThat(ResultadoFiltroPetBook.es(categoria))
				.orComplainWith(ComportamientoInesperado.class, FILTRO_INESPERADO));
	}
}
