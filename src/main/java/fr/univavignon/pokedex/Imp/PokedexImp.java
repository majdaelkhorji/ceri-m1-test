package fr.univavignon.pokedex.Imp;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class PokedexImp implements IPokedex,Serializable {
	private static final long serialVersionUID = 1L;

	private List<Pokemon> pokemons;
	private IPokemonMetadataProvider pokemonMetadataProvider;
	private IPokemonFactory pokemonFactory;
	
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		// TODO Auto-generated method stub
		return this.pokemonMetadataProvider.getPokemonMetadata(index);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws Exception {
		// TODO Auto-generated method stub
		return this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
	}
	
	public PokedexImp(IPokemonMetadataProvider pokemonMetadataProvider,IPokemonFactory pokemonFactory ) 
	{
	
		this.pokemonMetadataProvider = pokemonMetadataProvider;
		this.pokemonFactory = pokemonFactory; 
		pokemons = new ArrayList<Pokemon>();
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.pokemons.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		this.pokemons.add(pokemon);
		return this.pokemons.size()  ;
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		// TODO Auto-generated method stub
		return this.pokemons.get(id);
	}

	@Override
	public List<Pokemon> getPokemons() {
		// TODO Auto-generated method stub
		return this.pokemons;
	}


public static PokedexImp charge(String path) throws Exception
{
	ObjectInputStream ois = null;
	final FileInputStream fichier = new FileInputStream(path);
    ois = new ObjectInputStream(fichier);
    final PokedexImp pokedex = (PokedexImp) ois.readObject();
    ois.close();
    return pokedex;
}
@Override
public boolean equals(Object poke)
{
	PokedexImp pokedex  = (PokedexImp)poke;
	if(poke != null && this.size()  == pokedex.size() )
	{
		for(int i = 0 ; i < this.size() ; i++)
			try {
				if(!this.getPokemon(i).equals(pokedex.getPokemon(i)))
					return false;
			} catch (PokedexException e) {
				// TODO Auto-generated catch block
				return false;
			}
	}
	else {
		return false;
	}
			return true;
}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		// TODO Auto-generated method stub
		ArrayList<Pokemon> PokemonsList = new ArrayList<Pokemon>(this.pokemons.size());
		for(int i = 0 ; i < this.pokemons.size() ; i++)
		{
			int p = 0;
			for(int j = 0 ; j < this.pokemons.size() ; j++)
			{
				if(i != j)
				{int val = order.compare(this.pokemons.get(i), this.pokemons.get(j));
					if(val > 0)
					{p++;
					}else if(val == 0 && i > j){p++;}
				}
			}
			PokemonsList.add(p, this.pokemons.get(i));
		}
				
		return PokemonsList;
	}
	public static void save(PokedexImp pokedex,String path) throws Exception
	{
		
		ObjectOutputStream objoutputStream = null;
		final FileOutputStream file = new FileOutputStream(path);
		objoutputStream = new ObjectOutputStream(file);
		objoutputStream.writeObject(pokedex);
		objoutputStream.flush();
		objoutputStream.close();

}
	}