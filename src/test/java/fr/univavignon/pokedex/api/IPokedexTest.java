package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;




public  class IPokedexTest {
	@Mock 
	protected IPokedex pokedex;
	
	protected List<Pokemon> PokemonsList;
	
	protected Map<Integer,Pokemon> pokemonsGetIdTeste;
	
	protected int size;
	
	protected List<Pokemon> pokemonsGetAll;
	
	protected int getIdPok;
	
	protected PokemonMetadata getVal;
	
	protected Pokemon Pok;
	
	@Before 
	public void setUp() throws PokedexException, IOException, Exception { 
		MockitoAnnotations.initMocks(this);
		size = 7;
		List<Pokemon> pokemons = PokemonFactoryTest.genererPokemons(size);
		this.PokemonsList = pokemons;
		this.pokemonsGetAll = pokemons;
		this.pokemonsGetIdTeste = new HashMap<Integer,Pokemon>();
		this.getIdPok = 2;
		
		for(int i = 0 ; i < size ; i++)
		{
			Pokemon pokemon = pokemons.get(i);
			this.pokemonsGetIdTeste.put(i, pokemon);
			Mockito.when(pokedex.addPokemon(this.PokemonsList.get(i))).thenReturn(size + i +1);
			Mockito.when(pokedex.getPokemon(i)).thenReturn(pokemon);
			
		}
		this.Pok = pokemons.get(0);
		this.getVal = pokemons.get(this.getIdPok);
		Mockito.when(pokedex.getPokemons()).thenReturn(pokemons);
		Mockito.when(pokedex.createPokemon(this.Pok.getIndex(), this.Pok.getCp(), this.Pok.getHp(), this.Pok.getDust(), this.Pok.getCandy())).thenReturn(this.Pok);
		Mockito.when(pokedex.getPokemonMetadata(this.getIdPok)).thenReturn(this.getVal);
	
	} 
	
	
	@Test
	public void testAddPokemon() throws PokedexException
	{
		int size = pokedex.getPokemons().size();
		for(int i = 0; i < this.PokemonsList.size() ; i++)
			assertEquals(this.pokedex.addPokemon(this.PokemonsList.get(i)),size + i +1);
	}
	@Test
	public void testGetPokemonMetadata() throws PokedexException
	{
		assertEquals(this.pokedex.getPokemonMetadata(this.getIdPok),this.getVal);
	}
	@Test
	public void testSize()
	{
		
		assertEquals(pokedex.getPokemons().size() , this.size);
	}
	@Test
	public void testGetPokemonId() throws PokedexException
	{
		for(Map.Entry<Integer, Pokemon> pokemon : this.pokemonsGetIdTeste.entrySet())
			assertEquals(this.pokedex.getPokemon(pokemon.getKey()),pokemon.getValue());
	}
	@Test
	public void testGetPokemons()
	{
		List<Pokemon> pokemons = this.pokedex.getPokemons();
		for(int i = 0 ; i < this.pokemonsGetAll.size() ; i++)
			assertEquals(this.pokemonsGetAll.get(i),pokemons.get(i));
	}
	@Test
	public void testCreatePokemon() throws Exception
	{
		assertEquals(this.pokedex.createPokemon(this.Pok.getIndex(), this.Pok.getCp(), this.Pok.getHp(), this.Pok.getDust(), this.Pok.getCandy()),this.Pok);
	}
	
	
	
	
	
	
	
}