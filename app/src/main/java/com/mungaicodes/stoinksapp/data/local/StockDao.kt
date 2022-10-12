package com.mungaicodes.stoinksapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompanyListings(
        companyListingEntity: List<CompanyListingEntity>
    )

    @Query("Delete From CompanyListingEntity")
    suspend fun clearCompanyListings()

    @Query(
        """
            Select *
            from CompanyListingEntity
             where Lower(name) like '%' || Lower(:query) || '%' OR
             upper(:query) == symbol
        """
    )
    suspend fun searchCompanyListing(query: String): List<CompanyListingEntity>
}