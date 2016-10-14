package pratamawijaya.moviesinfokotlin.data.network;

import android.support.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import pratamawijaya.moviesinfokotlin.BuildConfig;
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
}
