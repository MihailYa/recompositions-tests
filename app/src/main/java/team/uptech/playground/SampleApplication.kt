package team.uptech.playground

import android.app.Application
import android.util.Log
import com.datadog.android.Datadog
import com.datadog.android.DatadogSite
import com.datadog.android.core.configuration.Configuration
import com.datadog.android.log.Logs
import com.datadog.android.log.LogsConfiguration
import com.datadog.android.privacy.TrackingConsent
import com.datadog.android.rum.Rum
import com.datadog.android.rum.RumConfiguration
import com.datadog.android.rum.tracking.FragmentViewTrackingStrategy
import dagger.hilt.android.HiltAndroidApp
import team.uptech.playground.util.datadog.TimberToDlogTree
import timber.log.Timber
import kotlin.time.Duration.Companion.seconds

@HiltAndroidApp
class SampleApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    Timber.plant(Timber.DebugTree())
    configureDatadog()
  }

  private fun configureDatadog() {
    val clientToken = ""
    val environmentName = "dev"
    val appVariantName = "alpha"

    val configuration = Configuration.Builder(
      clientToken = clientToken,
      env = environmentName,
      variant = appVariantName
    )
      .useSite(DatadogSite.EU1)
      .build()
    Datadog.initialize(this, configuration, TrackingConsent.GRANTED)

    val applicationId = ""
    val rumConfiguration = RumConfiguration.Builder(applicationId)
      .trackUserInteractions()
      .trackLongTasks(2.seconds.inWholeMilliseconds)
      .useViewTrackingStrategy(FragmentViewTrackingStrategy(trackArguments = true))
      .build()
    Rum.enable(rumConfiguration)

    val logsConfig = LogsConfiguration.Builder().build()
    Logs.enable(logsConfig)
    Timber.plant(TimberToDlogTree())

    Datadog.setVerbosity(Log.VERBOSE)
  }
}