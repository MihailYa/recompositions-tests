package team.uptech.playground.teststate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TestStateRoute(
  testStateViewModel: TestStateViewModel = hiltViewModel()
) {
  val state by testStateViewModel.state.collectAsState()
  val transactions by testStateViewModel.transactions.collectAsState()
  TestStateScreen(
    state = state,
    transactions = { transactions },
    updateField1 = testStateViewModel::updateField1,
    updateField2 = testStateViewModel::updateField2,
    updateField3 = testStateViewModel::updateField3,
    onClickAddTransaction = testStateViewModel::addTransaction,
  )
}