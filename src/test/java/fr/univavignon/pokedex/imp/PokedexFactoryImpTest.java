package fr.univavignon.pokedex.imp;

import java.io.IOException;
import org.junit.Before;
import fr.univavignon.pokedex.api.IPokedexFactoryTest;
import fr.univavignon.pokedex.Imp.PokedexImp;
import fr.univavignon.pokedex.Imp.*;


public class PokedexFactoryImpTest extends IPokedexFactoryTest {
	@Before 
	public void setUp() throws IOException  {
		
		this.pokedexfactory = PokedexFactoryImp.getInstance();
		this.metadataProvider = PokemonMetadataProviderImp.getInstance();
		this.pokemonFactory = PokemonFactoryImp.getInstance();
		this.Pokedex = new PokedexImp(this.metadataProvider,this.pokemonFactory);
	
	} 
}