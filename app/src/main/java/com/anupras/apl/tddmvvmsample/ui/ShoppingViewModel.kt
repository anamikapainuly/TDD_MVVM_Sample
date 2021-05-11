package com.anupras.apl.tddmvvmsample.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anupras.apl.tddmvvmsample.data.local.ShoppingItem
import com.anupras.apl.tddmvvmsample.data.remote.response.ImageResponse
import com.anupras.apl.tddmvvmsample.others.Event
import com.anupras.apl.tddmvvmsample.others.Resource
import com.anupras.apl.tddmvvmsample.repositories.DafaultShoppingRepository_Factory
import com.anupras.apl.tddmvvmsample.repositories.ShoppingRepository
import kotlinx.coroutines.launch


/**
 * Created by Anamika Painuly on 11/05/21.
 */
class ShoppingViewModel @ViewModelInject constructor(
private val repository: ShoppingRepository
) : ViewModel() {


    val shoppingItem = repository.observeAllShoppingItems()
    val totalPrice = repository.observeTotalPrice()

    private val _images = MutableLiveData<Event<Resource<ImageResponse>>>()
    val images: LiveData<Event<Resource<ImageResponse>>> = _images

    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String> = _imageUrl

    private val _insertShoppingItemStatus = MutableLiveData<Event<Resource<ShoppingItem>>>()
    val insertShoppingItemStatus: LiveData<Event<Resource<ShoppingItem>>> = _insertShoppingItemStatus

    fun setCurrentImageUrl (url: String){
        _imageUrl.postValue(url)

    }

    fun deleteShoppingItem(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.deleteShoppingItem(shoppingItem)
    }

    fun insertSHoppingItemIntoDatabase(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.insertShoppingItem(shoppingItem)
    }

    fun insertSHoppingItem(name: String, amountString: String, priceString: String){

    }

    fun searchForImage(image: String){

    }
}