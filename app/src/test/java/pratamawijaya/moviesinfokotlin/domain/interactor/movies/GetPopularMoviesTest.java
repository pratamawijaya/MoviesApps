package pratamawijaya.moviesinfokotlin.domain.interactor.movies;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pratamawijaya.moviesinfokotlin.domain.executor.PostExecutionThread;
import pratamawijaya.moviesinfokotlin.domain.executor.ThreadExecutor;
import pratamawijaya.moviesinfokotlin.domain.repository.MoviesRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */
public class GetPopularMoviesTest {

  private GetPopularMovies getPopularMovies;

  @Mock private ThreadExecutor threadExecutor;
  @Mock private PostExecutionThread postExecutionThread;
  @Mock private MoviesRepository moviesRepository;

  @Before public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    getPopularMovies = new GetPopularMovies(threadExecutor, postExecutionThread, moviesRepository);
  }

  @Test public void testGetPopularMoviesUseCase() throws Exception {
    getPopularMovies.buildObservableUseCase();

    verify(moviesRepository).getPopularMovies(false);
    verifyNoMoreInteractions(moviesRepository);
    verifyZeroInteractions(threadExecutor);
    verifyZeroInteractions(postExecutionThread);
  }
}