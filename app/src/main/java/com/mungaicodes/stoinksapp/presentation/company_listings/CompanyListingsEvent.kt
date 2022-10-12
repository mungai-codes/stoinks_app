package com.mungaicodes.stoinksapp.presentation.company_listings

//represents any ui events that may occur

sealed class CompanyListingsEvent {
    object Refresh : CompanyListingsEvent()
    data class OnSearchQueryChange(val query: String) : CompanyListingsEvent()
}
