package pratamawijaya.moviesinfokotlin.app;

import android.app.Application;
import android.support.annotation.NonNull;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import pratamawijaya.moviesinfokotlin.data.executor.JobExecutor;
import pratamawijaya.moviesinfokotlin.domain.executor.PostExecutionThread;
import pratamawijaya.moviesinfokotlin.domain.executor.ThreadExecutor;
import pratamawijaya.moviesinfokotlin.domain.executor.UIThread;

/**
 * Created by pratama on 9/30/16.
 */

@Module @Singleton public class AppModule {
  Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides @NonNull @Singleton public Application providesApplication() {
    return application;
  }

  @Provides @Singleton @NonNull
  public ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton @NonNull
  public PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }
}
