package co.com.devco.stepdefinitions;

import static co.com.devco.exceptions.ComportamientoInesperado.ID_NO_ENCONTRADO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.gargoylesoftware.htmlunit.javascript.host.html.Image;

import co.com.devco.exceptions.ComportamientoInesperado;
import co.com.devco.questions.ResultadoFiltroPetBook;
import co.com.devco.questions.ResultadoSeleccionPetBook;
import co.com.devco.tasks.FiltrarPetBook;
import co.com.devco.tasks.SeleccionarPetBook;
import cucumber.api.PendingException;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;

public class PetBookImagesStepDefinition {
	@Cuando("^el (.*) da click en la imagen (\\d+)$")
	public void elUsuarioDaClickEnUnaImagen(String nombreActor, int id) {
		theActorCalled(nombreActor).attemptsTo(SeleccionarPetBook.laImagen(id));
	}

	
	@Entonces("^debe ver la imagen (\\d+) en pantalla completa$")
	public void debeVerLaImagenEnPantallaCompleta(int id) {
		
		theActorInTheSpotlight().should(seeThat(ResultadoSeleccionPetBook.resultado())
				.orComplainWith(ComportamientoInesperado.class, ID_NO_ENCONTRADO ));
	}
}
