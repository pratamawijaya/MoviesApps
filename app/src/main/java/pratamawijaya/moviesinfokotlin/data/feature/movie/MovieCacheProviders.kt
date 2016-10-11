package pratamawijaya.moviesinfokotlin.data.feature.movie

import io.rx_cache.EvictProvider
import pratamawijaya.moviesinfokotlin.data.model.MovieModel
import rx.Observable

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */
interface MovieCacheProviders {
  fun getNowPlaying(movies: Observable<List<MovieModel>>,
      evictProvider: EvictProvider): Observable<List<MovieModel>>
}