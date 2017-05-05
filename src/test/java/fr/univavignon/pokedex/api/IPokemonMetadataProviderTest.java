package fr.univavignon.pokedex.api;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class IPokemonMetadataProviderTest {
	@Mock 
	protected IPokemonMetadataProvider pokemonMetaDataProvider;

	protected List<PokemonMetadata> pokemonMetadata ;
	protected List<Integer> ErrorList;
	
	
	@Before 
	public void setUp() throws PokedexException  { 
		MockitoAnnotations.initMocks(this);
		this.ErrorList = new ArrayList<Integer>();
		this.ErrorList.add(-1);
		this.ErrorList.add(233);
		pokemonMetadata = new ArrayList<PokemonMetadata>();
		pokemonMetadata.add(new PokemonMetadata(0,"Bulbizarre",126,126,90));
		pokemonMetadata.add(new PokemonMetadata(133,"Aquali",186,168,260));
		Mockito.when(pokemonMetaDataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata.get(0));
		Mockito.when(pokemonMetaDataProvider.getPokemonMetadata(133)).thenReturn(pokemonMetadata.get(1));
		Mockito.when(pokemonMetaDataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException(" Exception"));
		Mockito.when(pokemonMetaDataProvider.getPokemonMetadata(233)).thenThrow(new PokedexException("Exception pokedex"));
		
		} 
	 @Test(expected=PokedexException.class)   
	 public void testPokemonNotFoundException() throws PokedexException {     
		for(Integer index : this.ErrorList)
		 	pokemonMetaDataProvider.getPokemonMetadata(index);
	
		 }
	
	 @Test()
	 public void testPokemonFound() throws PokedexException
	 {
		 for(PokemonMetadata pokemondata : pokemonMetadata)
			 assertEquals(this.pokemonMetaDataProvider.getPokemonMetadata(pokemondata.getIndex()),pokemondata);
		 
	 }
}

