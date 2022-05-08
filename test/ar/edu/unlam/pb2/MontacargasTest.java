package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class MontacargasTest {

	@Test
	public void queSePuedaAgregarPesoAlMontacargasSiNoHaAlcanzadoSuPesoMaximo() {
		//given
		Montacargas montacargas;
		final Double PESO_ESPERADO_EN_EL_MONTACARGAS = 10.0, PESO_MAXIMO_PERMITIDO = 50.0;
		Double pesoAAgregarEnElMontacargas = 10.0;

		//when
		montacargas = new Montacargas(PESO_MAXIMO_PERMITIDO);
		montacargas.agregarPeso(pesoAAgregarEnElMontacargas);

		//then
		assertEquals(PESO_ESPERADO_EN_EL_MONTACARGAS, montacargas.getPesoTotal());
	}

	@Test
	public void queSePuedaSaberSiElMontacargasLlegoASuCapacidadMaxima() {
		//given
		Montacargas montacargas;
		final Double PESO_MAXIMO_PERMITIDO = 10.0;
		Double pesoAAgregarEnElMontacargas = 10.0;

		//when
		montacargas = new Montacargas(PESO_MAXIMO_PERMITIDO);
		montacargas.agregarPeso(pesoAAgregarEnElMontacargas);

		//then
		assertTrue(montacargas.getSeAlcanzoCapacidadMáxima());
	}

	@Test
	public void queNoSePermitaAgregarPesoSiSeLlegoAlPesoMaximo() {
		//given
		Montacargas montacargas;
		final Double PESO_ESPERADO_EN_EL_MONTACARGAS = 50.0, PESO_MAXIMO_PERMITIDO = 50.0;
		Double primerPesoAAgregarEnElMontacargas = 50.0, segundoPesoAAgregarEnElMontacargas = 30.0;

		//when
		montacargas = new Montacargas(PESO_MAXIMO_PERMITIDO);
		montacargas.agregarPeso(primerPesoAAgregarEnElMontacargas);
		montacargas.agregarPeso(segundoPesoAAgregarEnElMontacargas);

		//then
		assertEquals(PESO_ESPERADO_EN_EL_MONTACARGAS, montacargas.getPesoTotal());
		assertTrue(montacargas.getSeAlcanzoCapacidadMáxima());

	}

	@Test
	public void queNoSePermitaAgregarPesoSiSumandoLaNuevaCargaSeSuperaElPesoMaximo() {
		//given
		Montacargas montacargas;
		final Double PESO_ESPERADO_EN_EL_MONTACARGAS = 30.0, PESO_MAXIMO_PERMITIDO = 50.0, 
				PRIMER_PESO_A_AGREGAR_EN_EL_MONTACARGAS = 30.0, SEGUNDO_PESO_A_AGREGAR_EN_EL_MONTACARGAS = 30.0;

		//when
		montacargas = new Montacargas(PESO_MAXIMO_PERMITIDO);
		montacargas.agregarPeso(PRIMER_PESO_A_AGREGAR_EN_EL_MONTACARGAS);
		montacargas.agregarPeso(SEGUNDO_PESO_A_AGREGAR_EN_EL_MONTACARGAS);

		//then
		assertEquals(PESO_ESPERADO_EN_EL_MONTACARGAS, montacargas.getPesoTotal());
		assertFalse(montacargas.getSeAlcanzoCapacidadMáxima());
	}

	@Test
	public void queSeLePuedaQuitarPesoAlMontacargas() {
		//given
		Montacargas montacargas;
		final Double PESO_ESPERADO_EN_EL_MONTACARGAS = 30.0, PESO_MAXIMO_PERMITIDO = 100.0, 
				PESO_A_AGREGAR_EN_EL_MONTACARGAS = 40.0, SEGUNDO_PESO_A_AGREGAR_EN_EL_MONTACARGAS = 30.0, 
				PESO_A_RESTAR_AL_MONTACARGAS = 40.0;

		//when
		montacargas = new Montacargas(PESO_MAXIMO_PERMITIDO);
		montacargas.agregarPeso(PESO_A_AGREGAR_EN_EL_MONTACARGAS);
		montacargas.agregarPeso(SEGUNDO_PESO_A_AGREGAR_EN_EL_MONTACARGAS);
		montacargas.restarPeso(PESO_A_RESTAR_AL_MONTACARGAS);

		//then
		assertEquals(PESO_ESPERADO_EN_EL_MONTACARGAS, montacargas.getPesoTotal());
		assertFalse(montacargas.getSeAlcanzoCapacidadMáxima());

	}


}
