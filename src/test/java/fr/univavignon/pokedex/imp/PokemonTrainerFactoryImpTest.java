package fr.univavignon.pokedex.imp;

import java.io.IOException;

import org.junit.Before;

import fr.univavignon.pokedex.Imp.PokedexFactoryImp;
import fr.univavignon.pokedex.Imp.PokemonFactoryImp;
import fr.univavignon.pokedex.Imp.PokemonMetadataProviderImp;
import fr.univavignon.pokedex.Imp.PokemonTrainerFactoryImp;
import fr.univavignon.pokedex.api.*;
import fr.univavignon.pokedex.imp.*;


public class PokemonTrainerFactoryImpTest extends IPokemonTrainerFactoryTest {
	

	@Before 
	public void setUp() throws IOException 
	{ 
		this.pokemonTrainerFactory = PokemonTrainerFactoryImp.getInstance(); 
		this.name = "majda";
		this.team = Team.INSTINCT;
		this.pokedexFactory = PokedexFactoryImp.getInstance();
		this.pokemonTrainer = new PokemonTrainer(name,team,this.pokedexFactory.createPokedex(PokemonMetadataProviderImp.getInstance(), PokemonFactoryImp.getInstance()));
	}
}