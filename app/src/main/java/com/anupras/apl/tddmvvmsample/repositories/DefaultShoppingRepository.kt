package com.anupras.apl.tddmvvmsample.repositories

import androidx.lifecycle.LiveData
import com.anupras.apl.tddmvvmsample.data.local.ShoppingDao
import com.anupras.apl.tddmvvmsample.data.local.ShoppingItem
import com.anupras.apl.tddmvvmsample.data.remote.PixabayAPI
import com.anupras.apl.tddmvvmsample.data.remote.response.ImageResponse
import com.anupras.apl.tddmvvmsample.others.Resource
import retrofit2.Response
import javax.inject.Inject


/**
 * Created by Anamika Painuly on 18/04/21.
 */
class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayAPI: PixabayAPI
) : ShoppingRepository {

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observeAllShoppingItem()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixabayAPI.searchForImage(imageQuery)
            if(response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An unknown error occured", null)
            } else {
                Resource.error("An unknown error occured", null)
            }
        } catch(e: Exception) {
            Resource.error("Couldn't reach the server. Check your internet connection", null)
        }
    }
}





