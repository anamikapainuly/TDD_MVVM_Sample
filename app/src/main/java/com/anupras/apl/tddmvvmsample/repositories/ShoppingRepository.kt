package com.anupras.apl.tddmvvmsample.repositories

import androidx.lifecycle.LiveData
import com.anupras.apl.tddmvvmsample.data.local.ShoppingItem
import com.anupras.apl.tddmvvmsample.data.remote.response.ImageResponse
import com.bumptech.glide.load.engine.Resource

/**
 * Created by Anamika Painuly on 18/04/21.
 */
interface ShoppingRepository {
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): com.anupras.apl.tddmvvmsample.others.Resource<ImageResponse>
}