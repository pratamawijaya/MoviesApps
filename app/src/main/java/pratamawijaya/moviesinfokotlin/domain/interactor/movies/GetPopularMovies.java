package pratamawijaya.moviesinfokotlin.domain.interactor.movies;

import javax.inject.Inject;
import pratamawijaya.moviesinfokotlin.domain.executor.PostExecutionThread;
import pratamawijaya.moviesinfokotlin.domain.executor.ThreadExecutor;
import pratamawijaya.moviesinfokotlin.domain.interactor.UseCase;
import pratamawijaya.moviesinfokotlin.domain.repository.MoviesRepository;
import rx.Observable;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public class GetPopularMovies extends UseCase {
  private boolean isUpdate = false;
  private MoviesRepository moviesRepository;

  @Inject
  public GetPopularMovies(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
      MoviesRepository moviesRepository) {
    super(threadExecutor, postExecutionThread);
    this.moviesRepository = moviesRepository;
  }

  public void setUpdate(boolean update) {
    isUpdate = update;
  }

  @Override protected Observable buildObservableUseCase() {
    return moviesRepository.getPopularMovies(isUpdate);
  }
}
