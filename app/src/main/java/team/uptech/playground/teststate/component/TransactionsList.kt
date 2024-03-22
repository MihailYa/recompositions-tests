package team.uptech.playground.teststate.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import team.uptech.playground.teststate.model.ImmutableList

@Composable
fun TransactionsList(
  transactions: () -> ImmutableList<String>
) {
  LazyColumn {
    items(transactions()) { transaction ->
      TransactionItem(transaction)
    }
  }
}

@Composable
fun TransactionItem(transaction: String) {
  Text(text = transaction)
}
