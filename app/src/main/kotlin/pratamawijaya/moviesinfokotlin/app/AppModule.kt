package pratamawijaya.moviesinfokotlin.app

import android.app.Application
import android.support.annotation.NonNull
import dagger.Module
import dagger.Provides
import pratamawijaya.moviesinfokotlin.data.executor.JobExecutor
import pratamawijaya.moviesinfokotlin.domain.executor.ThreadExecutor
import javax.inject.Singleton

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */
@Module
@Singleton
class AppModule constructor(private val application: Application) {

  @Provides @NonNull @Singleton fun providesApplication(): Application {
    return application
  }

  @Provides
  @Singleton
  @NonNull
  fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
    return jobExecutor
  }

}