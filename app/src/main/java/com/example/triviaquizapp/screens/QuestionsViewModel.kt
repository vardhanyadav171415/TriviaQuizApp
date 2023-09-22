package com.example.triviaquizapp.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaquizapp.data.DataOrException
import com.example.triviaquizapp.model.QuestionItem
import com.example.triviaquizapp.repositary.QuestionRepositary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repositary: QuestionRepositary) : ViewModel(){
    val data:MutableState<DataOrException<ArrayList<QuestionItem>,Boolean,java.lang.Exception>> =
        mutableStateOf(DataOrException(null,true,Exception("")))

    init {
        getAllQuestions()
    }
    private fun getAllQuestions(){
        viewModelScope.launch {
            data.value.loading=true
            data.value=repositary.getAllQuestions()

            if(data.value.data.toString().isNotEmpty()){
                data.value.loading=false
            }
        }
    }
    fun getTotalQuestionCount():Int{
        return data.value.data?.toMutableList()!!.size
    }
}