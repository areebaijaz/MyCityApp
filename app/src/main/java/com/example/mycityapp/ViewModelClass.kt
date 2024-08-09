package com.example.mycityapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mycityapp.ui.theme.Data
import com.example.mycityapp.ui.theme.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModelClass : ViewModel() {
   private  val _uiState = MutableStateFlow(OrderUiState())
    val uiState :StateFlow<OrderUiState> = _uiState.asStateFlow()

fun ShowDes(isclick : Int) {
        _uiState.update { currentUiState ->
            currentUiState.copy(
                currentDescription = isclick
            )


    }
}







}
