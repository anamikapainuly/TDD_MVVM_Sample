package com.anupras.apl.tddmvvmsample.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.anupras.apl.tddmvvmsample.repositories.DafaultShoppingRepository_Factory
import com.anupras.apl.tddmvvmsample.repositories.ShoppingRepository

/**
 * Created by Anamika Painuly on 11/05/21.
 */
class ShoppingViewModel @ViewModelInject constructor(
private val repository: ShoppingRepository
) : ViewModel() {

}