package fr.univavignon.pokedex.Imp;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import fr.univavignon.pokedex.Imp.outil.IvCalculate;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;
import io.github.bonigarcia.wdm.ChromeDriverManager;


/**
 * Factory interface for class that aims to create Pokemon instance.
 * 
 */
public class PokemonFactoryImp implements IPokemonFactory {
	private static final long serialVersionUID = 1L;
	private static PokemonFactoryImp instance;
	private PokemonFactoryImp()
	{
		
	}

	/**
	 * Creates a pokemon instance computing it IVs.
	 * 
	 * @param index Pokemon index.
	 * @param cp Pokemon CP.
	 * @param hp Pokemon HP.
	 * @param dust Required dust for upgrading pokemon.
	 * @param candy Required candy for upgrading pokemon.
	 * @return Created pokemon instance.
	 * @throws IOException 
	 * @throws PokedexException 
	 */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException, IOException {
    	
    	// TODO Auto-generated method stub
    			ChromeDriverManager.getInstance().setup();
    			IvCalculate ivcalcul = new IvCalculate(new ChromeDriver());
    			PokemonMetadata pokemonmetadata = PokemonMetadataProviderImp.getInstance().getPokemonMetadata(index);
    			return new Pokemon(index,pokemonmetadata.getName(),pokemonmetadata.getAttack(),pokemonmetadata.getDefense(),pokemonmetadata.getStamina(),cp,hp,dust,candy,ivcalcul.getIv(pokemonmetadata.getName(), cp, hp, dust));
    			
    		}
    		
    		public static PokemonFactoryImp getInstance()
    		{
    			if(instance == null)
    				instance = new PokemonFactoryImp();
    			return instance;
    		}
    		
    	}  
