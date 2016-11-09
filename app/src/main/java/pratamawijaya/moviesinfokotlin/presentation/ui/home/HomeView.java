package pratamawijaya.moviesinfokotlin.presentation.ui.home;

import java.util.List;
import pratamawijaya.moviesinfokotlin.domain.entity.Movie;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/27/16
 * Project Name : MoviesInfoKotlin
 */

public interface HomeView {
  void showLoading();

  void hideLoading();

  void showMessage(String msg);

  void setNowPlayingMovieData(List<Movie> movies);

  void setPopularMovieData(List<Movie> movies);
}
