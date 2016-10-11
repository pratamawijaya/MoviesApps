package pratamawijaya.moviesinfokotlin.data.network

import android.support.annotation.NonNull
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import pratamawijaya.moviesinfokotlin.BuildConfig
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/10/16
 * Project Name : MoviesInfoKotlin
 */

@Module
@Singleton
class ApiModule {

  @Provides
  @Singleton
  @NonNull
  fun provideRetrofit(@NonNull okHttpClient: OkHttpClient,
      @NonNull factory: Converter.Factory): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.SERVER_URL)
        .client(okHttpClient)
        .addConverterFactory(factory)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()
  }

  @Provides
  @Singleton
  @NonNull
  fun providesGson(): Gson {
    return Gson()
  }

  @Provides
  @Singleton
  @NonNull
  fun provideConverter(@NonNull gson: Gson): Converter.Factory {
    return GsonConverterFactory.create(gson)
  }

}