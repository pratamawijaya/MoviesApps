package pratamawijaya.moviesinfokotlin.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import pratamawijaya.moviesinfokotlin.data.model.DatesModel;
import pratamawijaya.moviesinfokotlin.data.model.MovieModel;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public class NowPlayingMoviesResponse {
  @SerializedName("page") @Expose private Integer page;
  @SerializedName("results") @Expose private List<MovieModel> results = new ArrayList<>();
  @SerializedName("dates") @Expose private DatesModel dates;
  @SerializedName("total_pages") @Expose private Integer totalPages;
  @SerializedName("total_results") @Expose private Integer totalResults;

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public List<MovieModel> getResults() {
    return results;
  }

  public void setResults(List<MovieModel> results) {
    this.results = results;
  }

  public DatesModel getDates() {
    return dates;
  }

  public void setDates(DatesModel dates) {
    this.dates = dates;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public Integer getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(Integer totalResults) {
    this.totalResults = totalResults;
  }
}
