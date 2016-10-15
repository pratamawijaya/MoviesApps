package pratamawijaya.moviesinfokotlin.data.feature.movie;

import io.rx_cache.EvictProvider;
import java.util.List;
import javax.inject.Inject;
import pratamawijaya.moviesinfokotlin.BuildConfig;
import pratamawijaya.moviesinfokotlin.data.model.MovieModel;
import pratamawijaya.moviesinfokotlin.data.model.mapper.MovieModelMapper;
import pratamawijaya.moviesinfokotlin.data.model.response.NowPlayingMoviesResponse;
import pratamawijaya.moviesinfokotlin.domain.entity.Movie;
import pratamawijaya.moviesinfokotlin.domain.repository.MoviesRepository;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public class MovieRepositoryImpl implements MoviesRepository {

  private final MovieServices movieServices;
  private final MovieCacheProviders movieCacheProviders;
  private final MovieModelMapper movieModelMapper;

  @Inject
  public MovieRepositoryImpl(MovieServices movieServices, MovieCacheProviders movieCacheProviders,
      MovieModelMapper movieModelMapper) {
    this.movieServices = movieServices;
    this.movieCacheProviders = movieCacheProviders;
    this.movieModelMapper = movieModelMapper;
  }

  @Override public Observable<List<Movie>> getNowPlayingMovies(boolean isUpdate) {
    return movieCacheProviders.getNowPlayingMovies(
        movieServices.getNowPlayingMovies(BuildConfig.THEMOVIEDBKEY)
            .flatMap(new Func1<NowPlayingMoviesResponse, Observable<List<MovieModel>>>() {
              @Override public Observable<List<MovieModel>> call(
                  NowPlayingMoviesResponse nowPlayingMoviesResponse) {
                return Observable.just(nowPlayingMoviesResponse.getResults());
              }
            }), new EvictProvider(isUpdate)).map(this.movieModelMapper::transform);
  }

  @Override public Observable<List<Movie>> getPopularMovies(boolean isUpdate) {
    return movieServices.getPopularMovies(BuildConfig.THEMOVIEDBKEY)
        .flatMap(popularMoviesResponse -> Observable.just(popularMoviesResponse.getResults()))
        .map(this.movieModelMapper::transform);
  }
}
