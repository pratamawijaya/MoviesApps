package pratamawijaya.moviesinfokotlin.data.feature.movie;

import io.rx_cache.EvictProvider;
import io.rx_cache.LifeCache;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pratamawijaya.moviesinfokotlin.data.model.MovieModel;
import rx.Observable;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public interface MovieCacheProviders {
  @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS)
  Observable<List<MovieModel>> getNowPlayingMovies(Observable<List<MovieModel>> listObservable,
      EvictProvider evictProvider);
}
