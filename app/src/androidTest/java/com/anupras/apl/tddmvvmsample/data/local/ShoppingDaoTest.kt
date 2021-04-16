package com.anupras.apl.tddmvvmsample.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.anupras.apl.tddmvvmsample.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Anamika Painuly on 17/03/21.
 */

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ShoppingItemDatabase
    private lateinit var dao: ShoppingDao

    @Before
    fun setUp()
    {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShoppingItemDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.shoppingDao()
    }


    @After
    fun teardown()
    {
        database.close()
    }


    @Test
    fun insertShoppingItem() = runBlockingTest {
         val shoppingItem = ShoppingItem("name",1,1f,"url",1)
         dao.insertShoppingItem(shoppingItem)

        //Live data run asynchronous, test case run on single thread, helper class by google
        val allShoppingItem = dao.observeAllShoppingItem().getOrAwaitValue()

        assertThat(allShoppingItem).contains(shoppingItem)

    }

    @Test
    fun deleteShoppingItem() = runBlockingTest {
        val shoppingItem = ShoppingItem("name",1,1f,"url",1)
        dao.deleteShoppingItem(shoppingItem)

        //Live data run asynchronous, test case run on single thread, helper class by google
        val allShoppingItem = dao.observeAllShoppingItem().getOrAwaitValue()
        assertThat(allShoppingItem).doesNotContain(shoppingItem)

    }

    @Test
    fun observeTotalPriceSum() = runBlockingTest {
        val shoppingItem = ShoppingItem("name",2,10f,"url",1)
        val shoppingItem2 = ShoppingItem("name",4,5.5f,"url",2)
        val shoppingItem3 = ShoppingItem("name",0,100f,"url",3)
        dao.insertShoppingItem(shoppingItem)
        dao.insertShoppingItem(shoppingItem2)
        dao.insertShoppingItem(shoppingItem3)

        val totalPriceSum = dao.observeTotalPrice().getOrAwaitValue()

        assertThat(totalPriceSum).isEqualTo(2 * 10f + 4 * 5.5f)

    }
}