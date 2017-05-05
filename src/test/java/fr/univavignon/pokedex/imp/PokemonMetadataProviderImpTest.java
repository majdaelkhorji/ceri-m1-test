package fr.univavignon.pokedex.imp;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
import fr.univavignon.pokedex.Imp.*;


public class PokemonMetadataProviderImpTest extends IPokemonMetadataProviderTest {

	
	@Before 
	public void setUp() throws PokedexException 
	{ 
		try {
			this.pokemonMetaDataProvider = PokemonMetadataProviderImp.getInstance();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ErrorList = new ArrayList<Integer>();
		this.ErrorList.add(-1);
		this.ErrorList.add(2333);
		pokemonMetadata = new ArrayList<PokemonMetadata>();
		pokemonMetadata.add(new PokemonMetadata(0,"Bulbasaur",126,126,90));
		pokemonMetadata.add(new PokemonMetadata(13,"Kakuna",62,82,90));
		
	} 
}