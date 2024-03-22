package team.uptech.playground.teststate.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theapache64.rebugger.Rebugger

@Composable
fun SecondSection(
  field2: String,
  updateField2: (String) -> Unit
) {

  Rebugger(
    trackMap = mapOf(
      "field2" to field2,
      "updateField2" to updateField2,
    )
  )

  Surface(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp)
  ) {
    Column {
      Text("Large composable")
      Row {
        Icon(
          imageVector = Icons.Default.Favorite,
          contentDescription = "Favorite"
        )
        Text("This is a large composable")
      }

      TextField(value = field2, onValueChange = updateField2)
    }
  }
}