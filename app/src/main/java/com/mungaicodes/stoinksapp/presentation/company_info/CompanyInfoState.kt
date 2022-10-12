package com.mungaicodes.stoinksapp.presentation.company_info

import com.mungaicodes.stoinksapp.domain.model.CompanyInfo
import com.mungaicodes.stoinksapp.domain.model.IntraDayInfo

data class CompanyInfoState(
    val stockInfo: List<IntraDayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
