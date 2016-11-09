package pratamawijaya.moviesinfokotlin.presentation.ui.home.presenter;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pratamawijaya.moviesinfokotlin.domain.interactor.movies.GetNowPlayingMovies;
import pratamawijaya.moviesinfokotlin.domain.interactor.movies.GetPopularMovies;
import pratamawijaya.moviesinfokotlin.presentation.exception.ErrorMessageFactory;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */
public class HomePresenterImplTest {
  @Mock GetPopularMovies getPopularMoviesMock;
  @Mock GetNowPlayingMovies getNowPlayingMoviesMock;
  @Mock ErrorMessageFactory errorMessageFactory;

  HomePresenterImpl presenter;

  @Before public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    presenter =
        new HomePresenterImpl(getNowPlayingMoviesMock, getPopularMoviesMock, errorMessageFactory);
  }
}