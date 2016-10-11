package pratamawijaya.moviesinfokotlin.app

import android.app.Application
import pratamawijaya.moviesinfokotlin.data.network.ServicesDependencies

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */
interface AppDependencies : ServicesDependencies {
  fun application(): Application

}