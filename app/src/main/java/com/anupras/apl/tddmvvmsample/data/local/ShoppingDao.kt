package com.anupras.apl.tddmvvmsample.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * We will have four functions
 * Insert
 * Delete
 * Observe Live Data
 * Get Total
 */

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    //We don't make it suspend because this function return live data object and live data is asynchronous by default
    //Live data + Room
    @Query("SELECT * FROM `shopping_items `")
    fun observeAllShoppingItem():LiveData<List<ShoppingItem>>

    @Query("SELECT SUM(price * amount) FROM `shopping_items `")
    fun observeTotalPrice(): LiveData<Float>

}