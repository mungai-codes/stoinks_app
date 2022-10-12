package com.mungaicodes.stoinksapp.di

import com.mungaicodes.stoinksapp.data.csv.CompanyListingParser
import com.mungaicodes.stoinksapp.data.csv.CsvParser
import com.mungaicodes.stoinksapp.data.csv.IntraDayInfoParser
import com.mungaicodes.stoinksapp.data.repoitory.StockRepositoryImpl
import com.mungaicodes.stoinksapp.domain.model.CompanyListing
import com.mungaicodes.stoinksapp.domain.model.IntraDayInfo
import com.mungaicodes.stoinksapp.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//module for interfaces

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingParser: CompanyListingParser
    ): CsvParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntraDayInfoParserParser(
        intraDayInfoParser: IntraDayInfoParser
    ): CsvParser<IntraDayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}