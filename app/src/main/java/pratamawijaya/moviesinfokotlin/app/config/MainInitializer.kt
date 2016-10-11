package pratamawijaya.moviesinfokotlin.app.config

import android.app.Application
import timber.log.Timber

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */
class MainInitializer(logTree: Timber.Tree, application: Application) : ReleaseInitializer(
    logTree) {

  override fun initialize() {
    super.initialize()
    initializeActivityLifeCycle()
  }

  private fun initializeActivityLifeCycle() {
    throw UnsupportedOperationException(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}