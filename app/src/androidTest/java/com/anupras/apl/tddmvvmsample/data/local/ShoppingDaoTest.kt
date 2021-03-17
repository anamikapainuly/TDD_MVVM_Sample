package com.anupras.apl.tddmvvmsample.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Anamika Painuly on 17/03/21.
 */

@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingDaoTest {

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
        val allShoppingItem = dao.observeAllShoppingItem()
    }
}