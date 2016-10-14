package pratamawijaya.moviesinfokotlin.app

import android.app.Application
import pratamawijaya.moviesinfokotlin.data.network.ServicesDependencies
import pratamawijaya.moviesinfokotlin.domain.executor.PostExecutionThread
import pratamawijaya.moviesinfokotlin.domain.executor.ThreadExecutor

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */
interface AppDependencies : ServicesDependencies {
  fun application(): Application

  fun threadExecutor(): ThreadExecutor

  fun postExecutionThread(): PostExecutionThread

}