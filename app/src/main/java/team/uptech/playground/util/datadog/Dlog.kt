package team.uptech.playground.util.datadog

import com.datadog.android.log.Logger

val Dlog = Logger.Builder()
  .setNetworkInfoEnabled(true)
  .setLogcatLogsEnabled(false)
  .setRemoteSampleRate(100f)
  .setBundleWithTraceEnabled(true)
  .setName("Dlog")
  .build()