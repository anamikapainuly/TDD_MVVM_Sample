package com.anupras.apl.tddmvvmsample.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Anamika Painuly on 16/03/21.
 */

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    var name: String,
    var amount: Int,
    var price: Float,
    var imageUrl: String,
    @PrimaryKey(autoGenerate =  true)
    val id: Int? = null
) {

}