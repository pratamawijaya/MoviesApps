package pratamawijaya.moviesinfokotlin.presentation.ui.home.di;

import android.app.Activity;
import dagger.Module;
import dagger.Provides;
import pratamawijaya.moviesinfokotlin.data.feature.movie.MovieRepositoryImpl;
import pratamawijaya.moviesinfokotlin.domain.interactor.UseCase;
import pratamawijaya.moviesinfokotlin.domain.interactor.movies.GetNowPlayingMovies;
import pratamawijaya.moviesinfokotlin.domain.repository.MoviesRepository;
import pratamawijaya.moviesinfokotlin.presentation.base.ActivityModule;
import pratamawijaya.moviesinfokotlin.presentation.di.scope.ActivityScope;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

@Module public class HomeActivityModule extends ActivityModule {
  public HomeActivityModule(Activity activity) {
    super(activity);
  }

  @Provides @ActivityScope Activity activity() {
    return this.activity;
  }

  @Provides MoviesRepository provideMovieRepo(MovieRepositoryImpl movieRepository) {
    return movieRepository;
  }

  @Provides UseCase provideNowPlayingUseCase(GetNowPlayingMovies getNowPlayingMovies) {
    return getNowPlayingMovies;
  }
}
