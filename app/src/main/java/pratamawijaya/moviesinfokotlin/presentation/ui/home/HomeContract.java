package pratamawijaya.moviesinfokotlin.presentation.ui.home;

import java.util.List;
import pratamawijaya.moviesinfokotlin.domain.entity.Movie;
import pratamawijaya.moviesinfokotlin.presentation.base.BaseMvpView;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public interface HomeContract {
  interface View extends BaseMvpView {
    void showLoading();

    void hideLoading();

    void showMessage(String msg);

    void setNowPlayingMovieData(List<Movie> movies);

    void setPopularMovieData(List<Movie> movies);
  }
}
