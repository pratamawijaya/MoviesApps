package pratamawijaya.moviesinfokotlin.domain.repository;

import java.util.List;
import pratamawijaya.moviesinfokotlin.domain.entity.Movie;
import rx.Observable;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public interface MoviesRepository {
  Observable<List<Movie>> getNowPlayingMovies(final boolean isUpdate);
}
