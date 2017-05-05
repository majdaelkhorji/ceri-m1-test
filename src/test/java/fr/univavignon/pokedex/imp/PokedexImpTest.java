package fr.univavignon.pokedex.imp;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import fr.univavignon.pokedex.api.IPokedexTest;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.Imp.*;


public class PokedexImpTest extends IPokedexTest{

	@Before 
	public void setUp() throws Exception { 
	
		this.pokedex = PokedexFactoryImp.getInstance().createPokedex(PokemonMetadataProviderImp.getInstance(), PokemonFactoryImp.getInstance());
		PokemonFactoryImp pokemonFactory =  PokemonFactoryImp.getInstance();
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		this.pokemonsGetIdTeste = new HashMap<Integer,Pokemon>();
		this.size = 2;
		for(int i = 0 ; i < this.size ; i++)
		{
			Pokemon pokemon = pokemonFactory.createPokemon(i,1459 ,77, 2500, 1);
			pokemons.add(pokemon);
			this.pokedex.addPokemon(pokemon);
			this.pokemonsGetIdTeste.put(i, pokemon);
		}
		
		this.PokemonsList = pokemons;
		
		this.pokemonsGetAll = pokemons;
		this.getIdPok = 0;
		this.getVal = PokemonMetadataProviderImp.getInstance().getPokemonMetadata(this.getIdPok);
		this.Pok = this.pokedex.getPokemon(0);
	}
	@Test
	public void saveAndCharge() throws Exception
	{
		String path = "pokedex.test";
		PokedexImp.save((PokedexImp) this.pokedex, path);
		PokedexImp newpok = PokedexImp.charge(path);
		assertEquals(this.pokedex,newpok);
		
	}
	 @Test(expected=Exception.class)   
	 public void testChargeErreur() throws Exception {     
		  PokedexImp.charge("dkdk");
		 }
	 
	 @Test(expected=Exception.class)   
	 public void testSaveErreur() throws Exception {     
		  PokedexImp.save((PokedexImp)this.pokedex,null);
		 }
}