package com.example.triviaquizapp.repositary

import android.util.Log
import com.example.triviaquizapp.data.DataOrException
import com.example.triviaquizapp.model.QuestionItem
import com.example.triviaquizapp.network.QuestionApi
import com.example.triviaquizapp.util.api
import javax.inject.Inject

class QuestionRepositary @Inject constructor(private val questionApi: QuestionApi) {
    private val dataOrException= DataOrException<ArrayList<QuestionItem>,Boolean,Exception>()
    suspend fun getAllQuestions():DataOrException<ArrayList<QuestionItem>,Boolean,java.lang.Exception>{
        try {
            dataOrException.loading=true
            dataOrException.data=questionApi.getAllQuestions()
            if(dataOrException.data.toString().isNotEmpty()) dataOrException.loading=false

        }catch (exception:Exception){
              dataOrException.e=exception
            Log.d("Exc","getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }

}