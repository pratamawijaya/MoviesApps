package pratamawijaya.moviesinfokotlin.data.network

import android.app.Application
import android.support.annotation.NonNull
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.io.File
import javax.inject.Singleton

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/10/16
 * Project Name : MoviesInfoKotlin
 */

@Module
class NetworkModule {

  companion object {
    val CACHE_DIR = "okhttp_kt_dir"
    val CACHE_SIZE = 50 * 1024 * 1024

    fun createOkHttpClientBuilder(application: Application): OkHttpClient.Builder {
      val cacheBuilder = OkHttpClient.Builder().cache(createHttpCache(application))
      return cacheBuilder
    }

    fun createHttpCache(application: Application): Cache {
      val cacheDir = File(application.cacheDir, CACHE_DIR)
      return Cache(cacheDir, 50 * 1024 * 1024)
    }

    fun createOkHttpClient(builder: OkHttpClient.Builder, interceptors: List<Interceptor>,
        networkInterceptors: List<Interceptor>): OkHttpClient {

      for (interceptor in interceptors) {
        builder.addInterceptor(interceptor)
      }

      for (networkInterceptor in networkInterceptors) {
        builder.addNetworkInterceptor(networkInterceptor)
      }

      return builder.build()
    }
  }

  @Provides
  @Singleton
  @NonNull
  fun provideOkHttpClient(application: Application,
      @OkHttpInterceptors @NonNull interceptors: List<Interceptor>,
      @OkHttpNetworkInterceptors @NonNull networkInterceptors: List<Interceptor>): OkHttpClient {
    return createOkHttpClient(createOkHttpClientBuilder(application), interceptors,
        networkInterceptors)
  }
}