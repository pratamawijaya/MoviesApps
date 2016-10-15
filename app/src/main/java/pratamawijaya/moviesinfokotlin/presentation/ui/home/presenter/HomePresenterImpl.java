package pratamawijaya.moviesinfokotlin.presentation.ui.home.presenter;

import java.util.List;
import javax.inject.Inject;
import pratamawijaya.moviesinfokotlin.domain.entity.Movie;
import pratamawijaya.moviesinfokotlin.domain.interactor.DefaultSubscriber;
import pratamawijaya.moviesinfokotlin.domain.interactor.movies.GetNowPlayingMovies;
import pratamawijaya.moviesinfokotlin.domain.interactor.movies.GetPopularMovies;
import pratamawijaya.moviesinfokotlin.presentation.base.BasePresenter;
import pratamawijaya.moviesinfokotlin.presentation.ui.home.HomeContract;
import timber.log.Timber;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public class HomePresenterImpl extends BasePresenter<HomeContract.View> implements HomePresenter {
  private final GetNowPlayingMovies getNowPlayingMovies;
  private final GetPopularMovies getPopularMovies;

  @Inject public HomePresenterImpl(GetNowPlayingMovies getNowPlayingMovies,
      GetPopularMovies getPopularMovies) {
    this.getNowPlayingMovies = getNowPlayingMovies;
    this.getPopularMovies = getPopularMovies;
  }

  @Override public void attachView(HomeContract.View mvpView) {
    super.attachView(mvpView);
  }

  @Override public void detachView() {
    super.detachView();
    getNowPlayingMovies.unsubscribe();
  }

  @Override public void loadItemHome(boolean isUpdate) {
    checkViewAttached();
    getMvpView().showLoading();

    getNowPlayingMovies.setUpdate(isUpdate);
    getNowPlayingMovies.execute(new NowPlayingMoviesSubscriber());

    getPopularMovies.setUpdate(isUpdate);
    getPopularMovies.execute(new PopularMovieSubscriber());
  }

  private final class NowPlayingMoviesSubscriber extends DefaultSubscriber<List<Movie>> {
    @Override public void onError(Throwable e) {
      super.onError(e);
      getMvpView().hideLoading();
      Timber.e("onError() :  %s", e.getLocalizedMessage());
    }

    @Override public void onCompleted() {
      super.onCompleted();
      getMvpView().hideLoading();
    }

    @Override public void onNext(List<Movie> movies) {
      super.onNext(movies);
      getMvpView().setNowPlayingMovieData(movies);
    }
  }

  private final class PopularMovieSubscriber extends DefaultSubscriber<List<Movie>> {
    @Override public void onNext(List<Movie> movies) {
      super.onNext(movies);
      getMvpView().setPopularMovieData(movies);
    }

    @Override public void onCompleted() {
      super.onCompleted();
    }

    @Override public void onError(Throwable e) {
      super.onError(e);
      Timber.e("onError() :  %s", e.getLocalizedMessage());
    }
  }
}
