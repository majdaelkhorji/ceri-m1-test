package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonTrainerFactoryTest 
{
	
	
	@Mock
	protected IPokedexFactory pokedexFactory;
	
	@Mock
	protected IPokemonTrainerFactory pokemonTrainerFactory;
	protected PokemonTrainer pokemonTrainer;
	protected String name; 
	protected Team team;
	
	@Before 
	public void setUp() throws Exception { 
		MockitoAnnotations.initMocks(this);
		this.name = "majda";
		this.team = Team.INSTINCT;
	Mockito.when(this.pokemonTrainerFactory.createTrainer(name, team, pokedexFactory)).thenReturn(pokemonTrainer);
	}
	
	@Test()
	public void testCreate() throws Exception{
	assertEquals(this.pokemonTrainerFactory.createTrainer(name, team, pokedexFactory),this.pokemonTrainer);
}
		
	}
