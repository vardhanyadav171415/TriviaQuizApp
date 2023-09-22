package com.example.triviaquizapp.di

import com.example.triviaquizapp.network.QuestionApi
import com.example.triviaquizapp.repositary.QuestionRepositary
import com.example.triviaquizapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesQuestionRepositary(api:QuestionApi)=QuestionRepositary(api)


   @Provides
   @Singleton
   fun provideQuestionApi():QuestionApi{
       return Retrofit.Builder()
           .baseUrl(Constants.BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(QuestionApi::class.java)
   }
}