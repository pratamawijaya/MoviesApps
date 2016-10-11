package pratamawijaya.moviesinfokotlin.domain.interactor.movies

import pratamawijaya.moviesinfokotlin.domain.entity.Movie
import pratamawijaya.moviesinfokotlin.domain.executor.PostExecutionThread
import pratamawijaya.moviesinfokotlin.domain.executor.ThreadExecutor
import pratamawijaya.moviesinfokotlin.domain.interactor.UseCase
import pratamawijaya.moviesinfokotlin.domain.repository.MovieRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */

/**
 * UseCase untuk mendapatkan list wovie dari webservice NowPlaying
 */
class GetNowPlayingListUseCase @Inject constructor(threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread, private val movieRepository: MovieRepository) : UseCase<List<Movie>>(
    threadExecutor, postExecutionThread) {

  private var isUpdate: Boolean = false

  fun setIsUpdate(isUpdate: Boolean) {
    this.isUpdate = isUpdate
  }

  override fun buildUseCaseObservable(): Observable<List<Movie>> {
    return this.movieRepository.getNowPlaying(isUpdate)
  }
}