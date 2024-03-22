package team.uptech.playground.teststate

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val TEST_STATE_ROUTE = "test_state"

fun NavGraphBuilder.testStateScreen() {
  composable(TEST_STATE_ROUTE) {
    TestStateRoute()
  }
}