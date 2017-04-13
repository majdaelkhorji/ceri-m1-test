package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


	/**
	 * Test of creation the Pokemon instance
	 * 
	 */

public class IPokemonFactoryTest {

			/**
			 * Configuration the mock for IPokemonMetadataProvider.
			 * 
			 * @param mock
			 * @throws Exception
			 */	
		
			@Mock private IPokemonFactory IPokemonFactory;
			
			private Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
			
			/**
			 * Creates a pokemon instance computing it IVs.
			 * 
			 * @param index Pokemon index.
			 * @param cp Pokemon CP.
			 * @param hp Pokemon HP.
			 * @param dust Required dust for upgrading pokemon.
			 * @param candy Required candy for upgrading pokemon.
			 * @return Created pokemon instance.
			 */
			@Test
			public void createPokemonTest(){
				
				int index = 0;
				int cp = 613;
				int hp = 64;
				int dust = 4000;
				int candy = 4;
				
				assertEquals(index, pokemon.getIndex());
				assertEquals(cp, pokemon.getCp());
				assertEquals(hp, pokemon.getHp());
				assertEquals(dust, pokemon.getDust());
				assertEquals(candy, pokemon.getCandy());
			
			}
			
					
			
			/*
			 * Defining the behavior of mocked objects 
			 */
			@Before
			public void setUp() throws PokedexException {
			MockitoAnnotations.initMocks(this);//Integration of Mockito in JUnit
			Mockito.when(IPokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(pokemon);
			
		
			}
			

}





