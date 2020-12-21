package dev.ronnie.pokeapiandroidtask.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import dev.ronnie.pokeapiandroidtask.data.repositories.PokemonRepository
import dev.ronnie.pokeapiandroidtask.domain.PokemonResult
import kotlinx.coroutines.flow.Flow


/**
 *created by Ronnie Otieno on 20-Dec-20.
 **/
class PokemonListViewModel @ViewModelInject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {

    private var currentResult: Flow<PagingData<PokemonResult>>? = null
    fun getAdverts(searchString: String?): Flow<PagingData<PokemonResult>> {
        val newResult: Flow<PagingData<PokemonResult>> =
            pokemonRepository.getPokemon(searchString)
        currentResult = newResult
        return newResult
    }
}