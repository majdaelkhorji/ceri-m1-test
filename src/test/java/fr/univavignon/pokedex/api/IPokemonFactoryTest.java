package fr.univavignon.pokedex.api;
	
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.univavignon.pokedex.imp.PokemonFactoryImpTest;
import fr.univavignon.pokedex.Imp.*;


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

	@Mock
	protected IPokemonFactory pokemonfactory;
	protected Pokemon pokemon;
	protected int index;
	protected int cp;
	protected int hp;
	protected int dust;
	protected int candy;

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
	@Before 
	public void setUp() throws Exception { 
		MockitoAnnotations.initMocks(this);
		this.pokemon = PokemonFactoryTest.genererPokemons(1).get(0);
		this.index = 0;
		this.cp = 1;
		this.hp = 1;
		this.dust = 1;
		this.candy = 1;
		
		Mockito.when(pokemonfactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(pokemon);
		Mockito.when(pokemonfactory.createPokemon(-1, cp, hp, dust, candy)).thenThrow(new Exception());
	
	} 
	@Test
	public void testCreate() throws Exception
	{
		assertEquals(this.pokemonfactory.createPokemon(index, cp, hp, dust, candy),this.pokemon);
	}
	@Test(expected=Exception.class)
	public void testErreur() throws Exception
	{
		this.pokemonfactory.createPokemon(-1, cp, hp, dust, candy);
	}

	}




