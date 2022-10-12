package com.mungaicodes.stoinksapp.presentation.company_info

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mungaicodes.stoinksapp.domain.repository.StockRepository
import com.mungaicodes.stoinksapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyInfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: StockRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CompanyInfoState())
    var state: StateFlow<CompanyInfoState> = _state

    init {
        viewModelScope.launch {
            val symbol = savedStateHandle.get<String>("symbol") ?: return@launch
            _state.update { it.copy(isLoading = true) }
            val companyInfoResult = async { repository.getCompanyInfo(symbol) }
            val intraDayInfoResult = async { repository.getIntraDayInfo(symbol) }
            when (val result = companyInfoResult.await()) {
                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            company = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                }
                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message,
                            company = null
                        )
                    }
                }
                else -> Unit
            }
            when (val result = intraDayInfoResult.await()) {
                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            stockInfo = result.data ?: emptyList(),
                            isLoading = false,
                            error = null
                        )
                    }
                }
                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message,
                            company = null
                        )
                    }
                }
                else -> Unit
            }
        }
    }
}