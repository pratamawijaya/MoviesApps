package pratamawijaya.moviesinfokotlin.presentation.ui.home.di;

import dagger.Component;
import pratamawijaya.moviesinfokotlin.app.AppComponent;
import pratamawijaya.moviesinfokotlin.presentation.di.scope.ActivityScope;
import pratamawijaya.moviesinfokotlin.presentation.ui.home.HomeActivity;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

@Component(dependencies = AppComponent.class, modules = HomeActivityModule.class) @ActivityScope
public interface HomeActivityComponent {
  void inject(HomeActivity activity);
}
