package pratamawijaya.moviesinfokotlin.app.config

import android.support.annotation.NonNull
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import pratamawijaya.moviesinfokotlin.data.network.OkHttpInterceptors
import pratamawijaya.moviesinfokotlin.data.network.OkHttpNetworkInterceptors
import timber.log.Timber
import java.util.*
import javax.inject.Singleton

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */

@Module
class SupportModule {

  @Provides
  @OkHttpInterceptors
  @Singleton
  @NonNull
  fun provideOkHttpInterceptors(): List<Interceptor> {
    val interceptorList = ArrayList<Interceptor>()
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    interceptorList.add(httpLoggingInterceptor)
    return interceptorList
  }

  @Provides
  @OkHttpNetworkInterceptors
  @Singleton
  @NonNull
  fun provideOkHttpNetworkInterceptors(): List<Interceptor> {
    return emptyList()
  }

  @Provides @Singleton @NonNull fun provideTimber(): Timber.Tree {
    return Timber.DebugTree()
  }

  @Provides @Singleton @NonNull fun provideInitializer(initializer: MainInitializer): Initializer {
    return initializer
  }
}