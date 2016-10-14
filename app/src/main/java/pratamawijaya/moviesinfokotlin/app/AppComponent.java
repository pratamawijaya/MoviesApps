package pratamawijaya.moviesinfokotlin.app;

import dagger.Component;
import javax.inject.Singleton;
import pratamawijaya.moviesinfokotlin.app.config.MainInitializer;
import pratamawijaya.moviesinfokotlin.app.config.SupportModule;
import pratamawijaya.moviesinfokotlin.data.network.ApiModule;
import pratamawijaya.moviesinfokotlin.data.network.NetworkModule;

/**
 * Created by pratama on 10/3/16.
 */

@Singleton @Component(modules = {
    AppModule.class, SupportModule.class, NetworkModule.class, ApiModule.class
}) public interface AppComponent extends AppDependencies {
  void inject(MoviesInfoApplication app);

  void inject(MainInitializer initializer);
}
