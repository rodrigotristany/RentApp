package com.rodrigotristany.rentapp.ui.viewmodels

import androidx.lifecycle.*
import com.rodrigotristany.domain.contracts.RealStatesRepository
import com.rodrigotristany.domain.models.GetRealStatesRequest
import com.rodrigotristany.domain.models.RealState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RealStateViewModel(
    private val realStatesRepository: RealStatesRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) : ViewModel() {

    private var _realStateItems = MutableStateFlow<MutableList<RealState>>(mutableListOf())
    private val _getRealStatesRequest = GetRealStatesRequest(0, 10, "updated")

    val realStateItems: StateFlow<MutableList<RealState>> = _realStateItems

    fun getRealStateItems() {
        viewModelScope.launch(ioDispatcher) {
            val result = realStatesRepository.getRealStates(_getRealStatesRequest)
            _realStateItems.value.addAll(result)
            _getRealStatesRequest.page = +1
        }
    }

    init {
        getRealStateItems()
    }
}