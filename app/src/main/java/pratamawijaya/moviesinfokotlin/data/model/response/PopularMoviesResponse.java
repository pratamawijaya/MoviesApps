package pratamawijaya.moviesinfokotlin.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import pratamawijaya.moviesinfokotlin.data.model.MovieModel;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public class PopularMoviesResponse {
  @SerializedName("page") @Expose private int page;
  @SerializedName("results") @Expose private List<MovieModel> results = new ArrayList<>();
  @SerializedName("total_results") @Expose private int totalResults;
  @SerializedName("total_pages") @Expose private int totalPages;

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public List<MovieModel> getResults() {
    return results;
  }

  public void setResults(List<MovieModel> results) {
    this.results = results;
  }

  public int getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(int totalResults) {
    this.totalResults = totalResults;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }
}
