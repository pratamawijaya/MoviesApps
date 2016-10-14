package pratamawijaya.moviesinfokotlin.app

import dagger.Component
import pratamawijaya.moviesinfokotlin.app.config.MainInitializer
import pratamawijaya.moviesinfokotlin.app.config.SupportModule
import pratamawijaya.moviesinfokotlin.data.network.ApiModule
import pratamawijaya.moviesinfokotlin.data.network.NetworkModule
import javax.inject.Singleton

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */

@Singleton @Component(
    modules = arrayOf(AppModule::class, SupportModule::class, NetworkModule::class,
        ApiModule::class)) interface AppComponent : AppDependencies {
  fun inject(initializer: MainInitializer)

  fun inject(app: MoviesInfoApplication)
}