package team.uptech.playground.teststate

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import team.uptech.playground.teststate.model.ImmutableList
import team.uptech.playground.teststate.model.toImmutableList
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class TestStateViewModel @Inject constructor() : ViewModel() {

  private val _state = MutableStateFlow(State())
  val state: StateFlow<State> = _state.asStateFlow()

  private val _transactions = MutableStateFlow(emptyList<String>().toImmutableList())
  val transactions: StateFlow<ImmutableList<String>> = _transactions.asStateFlow()

  fun updateField1(field1: String) {
    _state.update {
      it.copy(field1 = field1)
    }
  }

  fun updateField2(field2: String) {
    _state.update {
      it.copy(field2 = field2)
    }
  }

  fun updateField3(field3: String) {
    _state.update {
      it.copy(field3 = field3)
    }
  }

  fun addTransaction() {
    val transaction = UUID.randomUUID().toString()
    _transactions.update {
      (it + transaction).toImmutableList()
    }
  }

  data class State(
    val field1: String = "",
    val field2: String = "",
    val field3: String = "",
  )
}