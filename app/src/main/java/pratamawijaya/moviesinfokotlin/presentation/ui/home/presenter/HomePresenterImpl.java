package pratamawijaya.moviesinfokotlin.presentation.ui.home.presenter;

import java.util.List;
import javax.inject.Inject;
import pratamawijaya.moviesinfokotlin.domain.entity.Movie;
import pratamawijaya.moviesinfokotlin.domain.interactor.DefaultSubscriber;
import pratamawijaya.moviesinfokotlin.domain.interactor.movies.GetNowPlayingMovies;
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

  @Inject public HomePresenterImpl(GetNowPlayingMovies getNowPlayingMovies) {
    this.getNowPlayingMovies = getNowPlayingMovies;
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
}
