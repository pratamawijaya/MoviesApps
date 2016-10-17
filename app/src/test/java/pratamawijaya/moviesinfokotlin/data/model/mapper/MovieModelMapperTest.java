package pratamawijaya.moviesinfokotlin.data.model.mapper;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import pratamawijaya.moviesinfokotlin.data.model.MovieModel;
import pratamawijaya.moviesinfokotlin.domain.entity.Movie;

import static org.junit.Assert.assertThat;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */
public class MovieModelMapperTest {

  private static final Boolean ADULT = true;
  private static final String TITLE = "Pirate";
  private MovieModelMapper movieModelMapper;

  @Before public void setUp() throws Exception {
    movieModelMapper = new MovieModelMapper();
  }

  @Test public void testMovieTransform() throws Exception {
    MovieModel movieModel = createMovie();
    Movie movie = movieModelMapper.transform(movieModel);
    assertThat(movie.getTitle(), Matchers.is(TITLE));
    assertThat(movie.getAdult(), Matchers.is(ADULT));
  }

  @Test public void testMoviesListTransform() throws Exception {
    MovieModel movieModel1 = createMovie();
    MovieModel movieModel2 = createMovie();
    List<MovieModel> movieModels = new ArrayList<>();
    movieModels.add(movieModel1);
    movieModels.add(movieModel2);

    List<Movie> movies = movieModelMapper.transform(movieModels);

    MatcherAssert.assertThat(movies.get(0), Matchers.is(CoreMatchers.instanceOf(Movie.class)));
    MatcherAssert.assertThat(movies.get(1), Matchers.is(CoreMatchers.instanceOf(Movie.class)));
  }

  private MovieModel createMovie() {
    MovieModel movie = new MovieModel();
    movie.setTitle(TITLE);
    movie.setAdult(ADULT);
    return movie;
  }
}