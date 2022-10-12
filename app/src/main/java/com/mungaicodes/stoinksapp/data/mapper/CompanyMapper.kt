package com.mungaicodes.stoinksapp.data.mapper

import com.mungaicodes.stoinksapp.data.local.CompanyListingEntity
import com.mungaicodes.stoinksapp.data.remote.dto.CompanyInfoDto
import com.mungaicodes.stoinksapp.domain.model.CompanyInfo
import com.mungaicodes.stoinksapp.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = "name ?: ",
        country = country ?: "",
        industry = industry ?: ""
    )
}