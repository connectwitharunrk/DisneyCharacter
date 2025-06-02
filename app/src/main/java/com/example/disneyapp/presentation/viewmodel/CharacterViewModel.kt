package com.example.disneyapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyapp.core.util.Resource
import com.example.disneyapp.domain.model.Character
import com.example.disneyapp.domain.usecase.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
): ViewModel() {

    private val _characters = MutableStateFlow<Resource<List<Character>>>(Resource.Loading)
    val characters: StateFlow<Resource<List<Character>>> = _characters

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            getCharacterUseCase().collect { response ->
                Log.d("Disney", "getCharacters: ${response}")
                _characters.value = response
            }
        }
    }

}