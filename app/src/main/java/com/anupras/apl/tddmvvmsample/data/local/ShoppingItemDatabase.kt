package com.anupras.apl.tddmvvmsample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
/**
 * Created by Anamika Painuly on 16/03/21.
 */
@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingItemDatabase : RoomDatabase() {

    abstract fun shoppingDao(): ShoppingDao
}