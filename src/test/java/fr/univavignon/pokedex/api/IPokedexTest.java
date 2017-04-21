package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokedexTest {

	/**
	 * Returns the number of pokemon this pokedex contains.
	 * 
	 * @return Number of pokemon in this pokedex.
	 */

	
	@Mock private IPokedex IPokedex;
	private int i;
	
	private Pokemon pokemon = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1);
	private Pokemon newPokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	private List<Pokemon> listPokemons = new ArrayList<Pokemon>(151);

	
	
	
	/**
	 * Adds the given <tt>pokemon</tt> to this pokedex and returns
	 * it unique index.
	 * 
	 * @param pokemon Pokemon to add to this pokedex.
	 * @return Index of this pokemon relative to this pokedex.
	 */
	@Test
	public void sizeTest() {
		assertNotNull(IPokedex.size());
	}
/*
 * test de la methode int addPokemon(Pokemon pokemon);
 */
	@Test
	public void addPokemonTest() {
		assertEquals(IPokedex.addPokemon(pokemon),1);
		assertEquals(IPokedex.addPokemon(newPokemon),0);

		

	}

	/*
	 *  test de la methode  getPokemon(int id) throws PokedexException;
	 */

	@Test
	public void getPokemonTest() throws PokedexException {
		assertEquals(IPokedex.getPokemon(133),pokemon );
		assertEquals(IPokedex.getPokemon(0),newPokemon );

	}

	/* test exception  PokedexException
	 */

	@Test(expected = PokedexException.class)
	public void getPokemonPokedexExceptionTest() throws PokedexException {
		IPokedex.getPokemon(24);
	}
	
/*
 *   test de la methode List<Pokemon> getPokemons();

 */
	@Test
	public void getPokemonsTest(){
		List<Pokemon> Poks = IPokedex.getPokemons();
		assertEquals(listPokemons, Poks);
	}
	

			 @Before
			    public void setUp() throws PokedexException {
				 	MockitoAnnotations.initMocks(this);
				 	i=0;
			        Mockito.when(IPokedex.addPokemon(newPokemon)).thenReturn(0);
			       listPokemons.add(newPokemon);i++;
			        
			        Mockito.when(IPokedex.addPokemon(pokemon)).thenReturn(1);
			        listPokemons.add(pokemon);  i++;
			      
			        Mockito.when(IPokedex.size()).thenReturn(i);
			        Mockito.when(IPokedex.getPokemon(133)).thenReturn(pokemon);
			        Mockito.when(IPokedex.getPokemon(0)).thenReturn(newPokemon);

			        Mockito.when(IPokedex.getPokemon(24)).thenThrow(new PokedexException("Index non trouvé"));
			       Mockito.when(IPokedex.getPokemons()).thenReturn(listPokemons);
			    }
			
			
	


}

