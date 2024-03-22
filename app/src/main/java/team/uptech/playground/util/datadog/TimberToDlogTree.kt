package team.uptech.playground.util.datadog

import timber.log.Timber

class TimberToDlogTree: Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        Dlog.log(priority, (tag ?: "Unknown") + ": $message", t)
    }
}