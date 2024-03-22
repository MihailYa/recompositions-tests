package team.uptech.playground.teststate.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionAddingSection(
  field1: String,
  updateField1: (String) -> Unit,
  onClickAddTransaction: () -> Unit,
) {
  Column {
    Text("Section 1")
    TextField(value = field1, onValueChange = updateField1)
    Button(onClick = onClickAddTransaction) {
      Text("Add transaction")
    }
  }
}