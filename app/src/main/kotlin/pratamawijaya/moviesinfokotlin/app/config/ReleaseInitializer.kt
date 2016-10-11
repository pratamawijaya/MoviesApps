package pratamawijaya.moviesinfokotlin.app.config

import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */
open class ReleaseInitializer @Inject constructor(private val logTree: Timber.Tree) : Initializer {

  override fun initialize() {
    initializeLog()
  }

  private fun initializeLog() {
    Timber.plant(logTree)
  }
}