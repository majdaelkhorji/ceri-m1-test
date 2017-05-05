package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.*;
import org.mockito.*;


public class IPokedexFactoryTest {
	@Mock 
	protected IPokedexFactory pokedexfactory;
	@Mock 
	protected IPokemonMetadataProvider metadataProvider;
	@Mock 
	protected IPokemonFactory pokemonFactory;
	@Mock
	protected IPokedex Pokedex;
	
	
	
	
	@Before 
	public void setUp() throws IOException {
		MockitoAnnotations.initMocks(this);
		List<Pokemon> pokemons = PokemonFactoryTest.genererPokemons(4);
		Mockito.when(pokedexfactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(Pokedex);
		Mockito.when(Pokedex.size()).thenReturn(pokemons.size());
		Mockito.when(Pokedex.getPokemons()).thenReturn(pokemons);
	} 
	
	@Test()
	public void testEqualPokemon() throws IOException
	{
		IPokedex pokedexByFactory = this.getPokodexFactory();
		for(int i = 0 ; i < Pokedex.getPokemons().size() ; i++)
		{
			assertEquals(Pokedex.getPokemons().get(i) , pokedexByFactory.getPokemons().get(i));
		}
	}
	
	
	
	public IPokedex getPokodexFactory() throws IOException
	{
		return pokedexfactory.createPokedex(metadataProvider, pokemonFactory);
	}
	
	
	@Test()
	public void testSize() throws IOException
	{
		IPokedex pokedexByFactory = this.getPokodexFactory();
		assertEquals(Pokedex.size(),pokedexByFactory.size());
	}
	
	
	
	
	
}

