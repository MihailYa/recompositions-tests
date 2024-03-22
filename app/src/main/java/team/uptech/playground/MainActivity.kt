package team.uptech.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import team.uptech.playground.teststate.TEST_STATE_ROUTE
import team.uptech.playground.teststate.testStateScreen
import team.uptech.playground.ui.theme.PlayGroundTheme
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    Timber.d("Create main activity")
    setContent {
      PlayGroundTheme {
        // Sample nav host
        val navController = rememberNavController()
        NavHost(navController, startDestination = TEST_STATE_ROUTE) {
          testStateScreen()
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  PlayGroundTheme {
    Greeting("Android")
  }
}