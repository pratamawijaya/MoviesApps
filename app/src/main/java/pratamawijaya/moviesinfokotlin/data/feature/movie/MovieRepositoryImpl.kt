package pratamawijaya.moviesinfokotlin.data.feature.movie

import pratamawijaya.moviesinfokotlin.data.model.mapper.MovieModelMapper
import pratamawijaya.moviesinfokotlin.domain.entity.Movie
import pratamawijaya.moviesinfokotlin.domain.repository.MovieRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */
class MovieRepositoryImpl @Inject constructor(private val services: MovieServices,
    private val cacheProviders: MovieCacheProviders,
    private val movieModelMapper: MovieModelMapper) : MovieRepository {

  override fun getNowPlaying(isUpdate: Boolean): Observable<List<Movie>> {
    throw UnsupportedOperationException(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
    //return cacheProviders.getNowPlaying(services.getNowPlaying().flatMap(Func1 { Observable.just(it.results) }),
    //  EvictProvider(isUpdate)).
  }

  override fun getPopular(isUpdate: Boolean): Observable<List<Movie>> {
    throw UnsupportedOperationException(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getDetail(isUpdate: Boolean, movieId: Int): Observable<Movie> {
    throw UnsupportedOperationException(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}