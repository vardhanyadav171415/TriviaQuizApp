package com.example.triviaquizapp.network

import com.example.triviaquizapp.model.Question
import retrofit2.http.GET
import retrofit2.http.Url
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions():Question
}