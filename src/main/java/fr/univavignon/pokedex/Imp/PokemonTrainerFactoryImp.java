package fr.univavignon.pokedex.Imp;

import java.io.IOException;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;

/**
 * Factory interface for class that aims to create PokemonTrainer instance.
 * 
 * 
 */
public class PokemonTrainerFactoryImp  implements IPokemonTrainerFactory{

	/**
	 * Creates and returns a PokemonTrainer instance.
	 * 
	 * @param name Name of the created trainer.
	 * @param team Team of the created trainer.
	 * @param pokedexFactory Factory to use for creating associated pokedex instance.
	 * @return Created trainer instance.
	 */
	private static PokemonTrainerFactoryImp instance;
	
	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) throws IOException {
		// TODO Auto-generated method stub
		return new PokemonTrainer(name,team,pokedexFactory.createPokedex(PokemonMetadataProviderImp.getInstance(), PokemonFactoryImp.getInstance()));
	}
	
	public static PokemonTrainerFactoryImp getInstance()
	{
		if(instance == null)
			instance = new PokemonTrainerFactoryImp();
		return instance;
	}
}