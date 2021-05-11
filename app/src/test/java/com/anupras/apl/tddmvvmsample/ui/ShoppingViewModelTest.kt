package com.anupras.apl.tddmvvmsample.ui


import com.anupras.apl.tddmvvmsample.getOrAwaitValueTest
import com.anupras.apl.tddmvvmsample.others.Status
import com.anupras.apl.tddmvvmsample.repositories.DefaultShoppingRepository
import com.anupras.apl.tddmvvmsample.repositories.SShoppingRepository
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Created by Anamika Painuly on 11/05/21.
 */
class ShoppingViewModelTest{

    private lateinit var viewModel: ShoppingViewModel

    @Before
    fun setup(){
        viewModel = ShoppingViewModel(SShoppingRepository())

    }

    @Test
    //fun `insert shopping item with empty field returns error`
    fun insetShoppingItemWithEmptyFieldReturnsError(){
        viewModel.insertSHoppingItem("testName","","2.0")
        val value = viewModel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }


}