package fr.univavignon.pokedex.Imp;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.json.*;
import org.apache.commons.io.IOUtils;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
public class PokemonMetadataProviderImp implements IPokemonMetadataProvider,Serializable {

	
	private static final long serialVersionUID = 1L;
	private static PokemonMetadataProviderImp instance ;
	private List<PokemonMetadata> pokemonMetadata;
	
	private PokemonMetadataProviderImp() throws IOException
	{
		URL orc = new URL(URL);
		URLConnection url = orc.openConnection();  
		String genreJson = IOUtils.toString(url.getInputStream(),"UTF-8");
		this.pokemonMetadata = new ArrayList<PokemonMetadata>();  
		JSONArray MetadataList = new JSONArray(genreJson);
		for(int i = 0 ; i < MetadataList.length(); i++)
		{
		    	JSONObject jsonMetadata = new JSONObject(MetadataList.get(i).toString());
		    	pokemonMetadata.add(new PokemonMetadata(Integer.parseInt((String) jsonMetadata.get("PkMn")) -1, 
		    	(String) jsonMetadata.get("Identifier"), 
		    	Integer.parseInt((String)jsonMetadata.get("BaseAttack")),
		    	Integer.parseInt((String) jsonMetadata.get("BaseDefense")),
		    	Integer.parseInt((String)jsonMetadata.get("BaseStamina"))    
				));
		}
	}
	private static final String URL ="https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json";
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		// TODO Auto-generated method stub
		if(index < 0 || index >= this.pokemonMetadata.size())
			throw new PokedexException(" Error");
		return this.pokemonMetadata.get(index);
	}
	
	public static PokemonMetadataProviderImp getInstance() throws IOException {
		
		if(instance == null)
			instance = new PokemonMetadataProviderImp();
		return instance;
	}
	
	
}