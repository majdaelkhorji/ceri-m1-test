package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonFactoryTest {
	public static List<Pokemon> genererPokemons(int nbr)
	{
		List<Pokemon> Pokemons = new ArrayList<Pokemon>();
		for(int i = 0; i < nbr ; i++)
			Pokemons.add(new Pokemon(i,"pokemon"+i,1,8,1,2,1,1,1,1));
		return Pokemons;
	}
}