package pratamawijaya.moviesinfokotlin.presentation.ui.home.presenter;

import easymvp.AbstractPresenter;
import java.util.List;
import javax.inject.Inject;
import pratamawijaya.moviesinfokotlin.domain.entity.Movie;
import pratamawijaya.moviesinfokotlin.domain.exception.DefaultErrorBundle;
import pratamawijaya.moviesinfokotlin.domain.exception.ErrorBundle;
import pratamawijaya.moviesinfokotlin.domain.interactor.DefaultSubscriber;
import pratamawijaya.moviesinfokotlin.domain.interactor.movies.GetNowPlayingMovies;
import pratamawijaya.moviesinfokotlin.domain.interactor.movies.GetPopularMovies;
import pratamawijaya.moviesinfokotlin.presentation.exception.ErrorMessageFactory;
import pratamawijaya.moviesinfokotlin.presentation.ui.home.HomeView;
import timber.log.Timber;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public class HomePresenterImpl extends AbstractPresenter<HomeView> implements HomePresenter {

  private final GetNowPlayingMovies getNowPlayingMovies;
  private final GetPopularMovies getPopularMovies;
  private final ErrorMessageFactory errorMessageFactory;

  @Inject public HomePresenterImpl(GetNowPlayingMovies getNowPlayingMovies,
      GetPopularMovies getPopularMovies, ErrorMessageFactory errorMessageFactory) {
    this.getNowPlayingMovies = getNowPlayingMovies;
    this.getPopularMovies = getPopularMovies;
    this.errorMessageFactory = errorMessageFactory;
  }

  @Override public void loadItemHome(boolean isUpdate) {
    getView().showLoading();

    getNowPlayingMovies.setUpdate(isUpdate);
    getNowPlayingMovies.execute(new NowPlayingMoviesSubscriber());

    getPopularMovies.setUpdate(isUpdate);
    getPopularMovies.execute(new PopularMovieSubscriber());
  }

  @Override public void showError(Throwable throwable) {
    showErrorMessage(new DefaultErrorBundle(throwable));
  }

  @Override public void showErrorMessage(ErrorBundle errorBundle) {
    String errorMessage = errorMessageFactory.create(errorBundle.getException());
  }

  private final class NowPlayingMoviesSubscriber extends DefaultSubscriber<List<Movie>> {
    @Override public void onError(Throwable e) {
      super.onError(e);
      getView().hideLoading();
      Timber.e("onError() :  %s", e.getLocalizedMessage());
      showError(e);
    }

    @Override public void onCompleted() {
      super.onCompleted();
      getView().hideLoading();
    }

    @Override public void onNext(List<Movie> movies) {
      super.onNext(movies);
    }
  }

  private final class PopularMovieSubscriber extends DefaultSubscriber<List<Movie>> {
    @Override public void onNext(List<Movie> movies) {
      super.onNext(movies);
    }

    @Override public void onCompleted() {
      super.onCompleted();
    }

    @Override public void onError(Throwable e) {
      super.onError(e);
      showError(e);
      Timber.e("onError() :  %s", e.getLocalizedMessage());
    }
  }
}
