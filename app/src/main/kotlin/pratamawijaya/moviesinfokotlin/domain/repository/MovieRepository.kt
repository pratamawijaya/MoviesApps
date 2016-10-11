package pratamawijaya.moviesinfokotlin.domain.repository

import pratamawijaya.moviesinfokotlin.domain.entity.Movie
import rx.Observable

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */
interface MovieRepository {
  fun getNowPlaying(isUpdate: Boolean): Observable<List<Movie>>
  fun getPopular(isUpdate: Boolean): Observable<List<Movie>>
  fun getDetail(isUpdate: Boolean, movieId: Int): Observable<Movie>
}