package com.anupras.apl.tddmvvmsample.di

import android.content.Context
import androidx.room.Room
import com.anupras.apl.tddmvvmsample.data.local.ShoppingDao
import com.anupras.apl.tddmvvmsample.others.Constants.BASE_URL
import com.anupras.apl.tddmvvmsample.others.Constants.DATABASE_NAME
import com.anupras.apl.tddmvvmsample.data.remote.PixabayAPI
import com.anupras.apl.tddmvvmsample.data.local.ShoppingItemDatabase
import com.anupras.apl.tddmvvmsample.repositories.DefaultShoppingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Anamika Painuly on 17/04/21.
 */
@Module
@InstallIn (ApplicationComponent::class)
object  AppModule {

    @Singleton
    @Provides
    fun provideShoppingItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ShoppingItemDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDefaultShoppingRepo(
        dao: ShoppingDao,
        api: PixabayAPI
    ) = DefaultShoppingRepository(dao, api)

    @Singleton
    @Provides
    fun provideShoppingDao(
        database: ShoppingItemDatabase
    ) = database.shoppingDao()

    @Singleton
    @Provides
    fun providePixabayApi(): PixabayAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixabayAPI::class.java)
    }

}