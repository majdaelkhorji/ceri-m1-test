package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokedexFactoryTest {


/**
 * Factory interface for class that aims to create IPokedex instance.
 */
	

	@Mock private IPokedexFactory IPokedexFactory;

	  private IPokemonMetadataProvider PokMetadataProvider;

	  private IPokemonFactory PokemonFactory;

	  private IPokedex Pokedex;

/*
protected IPokedexFactory getIPokedexFactory() {
	
	Mockito.when(IPokedexFactory.createPokedex(PokMetadataProvider,PokemonFactory)).thenReturn(Pokedex);
	
	return IPokedexFactory;
	
}
*/
	  
@Before
public void setUp()
{
 	MockitoAnnotations.initMocks(this);

	//Mock Pokedex factory
	Mockito.when(IPokedexFactory.createPokedex(PokMetadataProvider, PokemonFactory)).thenReturn(Pokedex);
}


/**
 * /*
	 * test de la methode IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory);
	 */


@Test
public void testCreatePokedex() {
	
	assertEquals(Pokedex,IPokedexFactory.createPokedex(PokMetadataProvider,PokemonFactory));
	
}

}


