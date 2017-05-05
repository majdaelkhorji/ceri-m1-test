package fr.univavignon.pokedex.Imp;


import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
/**
 * Factory interface for class that aims to create IPokedex instance.
 * 
 */
public class PokedexFactoryImp implements IPokedexFactory {
	private static PokedexFactoryImp instance; 
	private PokedexFactoryImp()
	{
		
	}
	public static PokedexFactoryImp getInstance()
	{
		if(instance == null)
			instance = new PokedexFactoryImp();
		return instance;
	}
		/**
	 * Creates a new pokedex instance using the given 
	 * <tt>metadataProvider</tt> and <tt>pokemonFactory</tt>. 
	 * 
	 * @param metadataProvider Metadata provider the created pokedex will use.
	 * @param pokemonFactory Pokemon factory the created pokedex will use.
	 * @return Created pokedex instance.
	 * 	 */
	
	
	@Override
	public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		// TODO Auto-generated method stub
		return new PokedexImp(metadataProvider,pokemonFactory);
	}
}
