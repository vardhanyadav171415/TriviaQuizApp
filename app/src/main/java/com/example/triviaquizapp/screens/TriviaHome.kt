package com.example.triviaquizapp.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviaquizapp.component.Questions

@Composable
fun TriviaHome(viewModel: QuestionsViewModel= hiltViewModel()){
    Questions(viewModel = viewModel)
}
