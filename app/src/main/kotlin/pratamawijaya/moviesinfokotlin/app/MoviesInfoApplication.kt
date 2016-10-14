package pratamawijaya.moviesinfokotlin.app

import android.app.Application

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */
class MoviesInfoApplication : Application() {

  protected var appComponent: AppComponent? = null

  override fun onCreate() {
    super.onCreate()
    initializeDaggerComponent()
  }

  private fun initializeDaggerComponent() {
    throw UnsupportedOperationException(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}