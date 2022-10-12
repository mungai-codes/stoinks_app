package com.mungaicodes.stoinksapp.domain.repository

import com.mungaicodes.stoinksapp.domain.model.CompanyInfo
import com.mungaicodes.stoinksapp.domain.model.CompanyListing
import com.mungaicodes.stoinksapp.domain.model.IntraDayInfo
import com.mungaicodes.stoinksapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    //domain layer shouldn't access the data layer

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntraDayInfo(
        symbol: String
    ): Resource<List<IntraDayInfo>>

    suspend fun getCompanyInfo(
        symbol: String
    ): Resource<CompanyInfo>
}