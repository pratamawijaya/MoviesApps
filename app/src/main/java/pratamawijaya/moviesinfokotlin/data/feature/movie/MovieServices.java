package pratamawijaya.moviesinfokotlin.data.feature.movie;

import pratamawijaya.moviesinfokotlin.data.model.response.NowPlayingMoviesResponse;
import pratamawijaya.moviesinfokotlin.data.model.response.PopularMoviesResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public interface MovieServices {
  @GET("movie/now_playing") Observable<NowPlayingMoviesResponse> getNowPlayingMovies(
      @Query("api_key") String apiKey);

  @GET("movie/popular") Observable<PopularMoviesResponse> getPopularMovies(
      @Query("api_key") String apiKey);
}
