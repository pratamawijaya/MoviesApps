package pratamawijaya.moviesinfokotlin.data.network;

import android.app.Application;
import android.support.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import io.rx_cache.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import pratamawijaya.moviesinfokotlin.BuildConfig;
import pratamawijaya.moviesinfokotlin.data.feature.movie.MovieCacheProviders;
import pratamawijaya.moviesinfokotlin.data.feature.movie.MovieServices;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pratama on 9/30/16.
 */
@Module @Singleton public final class ApiModule {

  @Provides @Singleton @NonNull public Retrofit provideRetrofit(@NonNull OkHttpClient okHttpClient,
      @NonNull Converter.Factory factory) {
    return new Retrofit.Builder().baseUrl(BuildConfig.SERVER_URL)
        .client(okHttpClient)
        .addConverterFactory(factory)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .validateEagerly(BuildConfig.DEBUG)
        .build();
  }

  @Provides @Singleton @NonNull Gson providesGson() {
    Gson gson = new GsonBuilder().create();
    return gson;
  }

  @Provides @Singleton @NonNull Converter.Factory provideConverter(@NonNull Gson gson) {
    return GsonConverterFactory.create(gson);
  }

  @Provides @NonNull MovieServices provideMovieServices(Retrofit retrofit) {
    return retrofit.create(MovieServices.class);
  }

  @Provides @NonNull MovieCacheProviders provideMovieCache(Application application) {
    return new RxCache.Builder().persistence(application.getCacheDir(), new GsonSpeaker())
        .using(MovieCacheProviders.class);
  }
}
