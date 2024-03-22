package team.uptech.playground.teststate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.theapache64.rebugger.Rebugger
import team.uptech.playground.teststate.component.SecondSection
import team.uptech.playground.teststate.component.TransactionAddingSection
import team.uptech.playground.teststate.component.TransactionsList
import team.uptech.playground.teststate.model.ImmutableList

@Composable
fun TestStateScreen(
  state: TestStateViewModel.State,
  transactions: () -> ImmutableList<String>,
  updateField1: (String) -> Unit,
  updateField2: (String) -> Unit,
  updateField3: (String) -> Unit,
  onClickAddTransaction: () -> Unit,
) {
  Rebugger(
    trackMap = mapOf(
      "field1" to state.field1,
      "field2" to state.field2,
      "field3" to state.field3,
      "transactions" to transactions(),
      "updateField1" to updateField1,
      "updateField2" to updateField2,
      "updateField3" to updateField3,
      "onClickAddTransaction" to onClickAddTransaction,
    )
  )
  // Write Column with text fields
  Scaffold(
    modifier = Modifier
      .safeContentPadding()
  ) { paddingValues ->
    Column(
      modifier = Modifier
        .padding(paddingValues)
    ) {


      TransactionAddingSection(field1 = state.field1, updateField1 = updateField1, onClickAddTransaction = onClickAddTransaction)

      SecondSection(
        field2 = state.field2,
        updateField2 =  updateField2
      )

      TextField(value = state.field3, onValueChange = updateField3)

      TransactionsList(transactions = transactions)
    }
  }
}