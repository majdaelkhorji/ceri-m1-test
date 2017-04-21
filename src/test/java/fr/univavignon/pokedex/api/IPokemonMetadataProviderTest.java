package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.mockito.Mockito;



public class IPokemonMetadataProviderTest {
	


	/**
	 * Configuration the mock for IPokemonMetadataProvider.
	 * 
	 * @param mock
	 * @throws PokedexException 
	 * @throws Exception
	 */	

	@Mock private IPokemonMetadataProvider IPokemonMetaProvider;
	

	private PokemonMetadata Metadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
	
	
	/**
	 * Retrieves and returns the metadata for the pokemon
	 * denoted by the given <tt>index</tt>.
	 * 
	 * @param index Index of the pokemon to retrieve metadata for.
	 * @return Metadata of the pokemon.
	 * @throws PokedexException If the given <tt>index</tt> is not valid.
	 */
	
	@Test
	public void getPokemonMetadataTest() throws PokedexException{
		assertEquals(133, Metadata.getIndex());
		assertEquals("Aquali", Metadata.getName());
		assertEquals(186, Metadata.getAttack());
		assertEquals(168, Metadata.getDefense());
		assertEquals(260, Metadata.getStamina());
	
	}
	
	
	@Test(expected = PokedexException.class)
	public void exceptionTest() throws PokedexException{
		IPokemonMetaProvider.getPokemonMetadata(25);
		
	}
	
	/*
	 * Defining the behavior of mocked objects 
	 */
	@Before
	public void setUp() throws PokedexException {
	MockitoAnnotations.initMocks(this);//Integration of Mockito in JUnit
	Mockito.when(IPokemonMetaProvider.getPokemonMetadata(133)).thenReturn(Metadata);
	Mockito.when(IPokemonMetaProvider.getPokemonMetadata(25)).thenThrow(new PokedexException("Index non trouvé"));

	}
	

}


