package pratamawijaya.moviesinfokotlin.data.network;

/**
 * Created by pratama on 9/30/16.
 */

import pratamawijaya.moviesinfokotlin.data.feature.movie.MovieCacheProviders;
import pratamawijaya.moviesinfokotlin.data.feature.movie.MovieServices;

/**
 * list of all services for feature
 */
public interface ServiceDependencies {
  MovieServices movieServices();

  MovieCacheProviders movieCacheProviders();
}
