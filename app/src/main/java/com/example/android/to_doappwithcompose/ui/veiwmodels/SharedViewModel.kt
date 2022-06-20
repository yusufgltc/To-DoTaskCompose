package com.example.android.to_doappwithcompose.ui.veiwmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.to_doappwithcompose.data.models.ToDoTask
import com.example.android.to_doappwithcompose.data.repository.ToDoRepository
import com.example.android.to_doappwithcompose.util.RequestState
import com.example.android.to_doappwithcompose.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks =
        MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val allTask: StateFlow<RequestState<List<ToDoTask>>> = _allTasks

    fun getAllTasks() {
        _allTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.gelAllTask.collect {
                    _allTasks.value = RequestState.Success(it)
                }
            }
        }catch (e: Exception){
            _allTasks.value = RequestState.Error(e)
        }
    }
}