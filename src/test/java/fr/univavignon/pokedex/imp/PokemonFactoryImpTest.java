package fr.univavignon.pokedex.imp;

import org.junit.Before;
import fr.univavignon.pokedex.api.*;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.Imp.*;



	/**
	 * Test of creation the Pokemon instance
	 * 
	 */

public class PokemonFactoryImpTest extends IPokemonFactoryTest  {
	/**
	 * Configuration the mock for IPokemonMetadataProvider.
	 * 
	 * @param mock
	 * @throws Exception
	 */	
	/*
	 * Defining the behavior of mocked objects 
	 */
	@Before 
	public void setUp() { 
		this.pokemonfactory = PokemonFactoryImp.getInstance();
		this.pokemon = new Pokemon(0,"Bulbasaur",126,126,90,1459, 77, 2500,1,84.4000015258789);
		this.index = 0;
		this.cp = 1459;
		this.hp = 77;
		this.dust = 2500;
		this.candy = 1;
		
	
	
	}

	
}






