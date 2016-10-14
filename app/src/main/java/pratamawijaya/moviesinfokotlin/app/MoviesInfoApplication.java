package pratamawijaya.moviesinfokotlin.app;

import android.app.Application;
import android.content.Context;
import javax.inject.Inject;
import pratamawijaya.moviesinfokotlin.app.config.Initializer;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/14/16
 * Project Name : MoviesInfoKotlin
 */

public class MoviesInfoApplication extends Application {

  @Inject Initializer initializer;

  protected AppComponent appComponent;

  public AppComponent getAppComponent() {
    return appComponent;
  }

  public static MoviesInfoApplication get(Context context) {
    return (MoviesInfoApplication) context.getApplicationContext();
  }

  @Override public void onCreate() {
    super.onCreate();
    initializeDaggerComponent();
    initializer.initialize();
  }

  private void initializeDaggerComponent() {
    appComponent = buildComponent();
    appComponent.inject(this);
  }

  private AppComponent buildComponent() {
    if (appComponent == null) {
      appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
    return appComponent;
  }
}
