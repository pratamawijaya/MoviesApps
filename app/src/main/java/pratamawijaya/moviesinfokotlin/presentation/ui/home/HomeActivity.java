package pratamawijaya.moviesinfokotlin.presentation.ui.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import easymvp.annotation.ActivityView;
import easymvp.annotation.Presenter;
import java.util.List;
import pratamawijaya.moviesinfokotlin.R;
import pratamawijaya.moviesinfokotlin.app.AppComponent;
import pratamawijaya.moviesinfokotlin.domain.entity.Movie;
import pratamawijaya.moviesinfokotlin.presentation.base.BaseActivity;
import pratamawijaya.moviesinfokotlin.presentation.ui.home.di.DaggerHomeActivityComponent;
import pratamawijaya.moviesinfokotlin.presentation.ui.home.di.HomeActivityModule;
import pratamawijaya.moviesinfokotlin.presentation.ui.home.presenter.HomePresenterImpl;
import timber.log.Timber;

@ActivityView(layout = R.layout.activity_main, presenter = HomePresenterImpl.class)
public class HomeActivity extends BaseActivity
    implements HomeView, SwipeRefreshLayout.OnRefreshListener {

  @BindView(R.id.refreshLayout) SwipeRefreshLayout swipeRefreshLayout;
  @BindView(R.id.recyclerView) RecyclerView recyclerView;
  @BindView(R.id.loadingView) ProgressBar loadingView;

  @Presenter HomePresenterImpl presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ButterKnife.bind(this);
    setupRecylerView();

    presenter.loadItemHome(true);
  }

  @Override protected void onStart() {
    super.onStart();
    // Now presenter is injected.
  }

  @Override protected void onStop() {
    super.onStop();
  }

  private void setupRecylerView() {
    // TODO: 10/15/16 setup data to recyclerview
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    swipeRefreshLayout.setOnRefreshListener(this);
  }

  @Override protected void buildComponent(AppComponent appComponent) {
    DaggerHomeActivityComponent.builder()
        .homeActivityModule(new HomeActivityModule(this))
        .appComponent(appComponent)
        .build()
        .inject(this);
  }

  @Override public void showLoading() {
    recyclerView.setVisibility(View.GONE);
    loadingView.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoading() {
    loadingView.setVisibility(View.GONE);
    recyclerView.setVisibility(View.VISIBLE);
  }

  @Override public void showMessage(String msg) {
    Toast.makeText(HomeActivity.this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override public void setNowPlayingMovieData(List<Movie> movies) {
    for (Movie data : movies) {
      Timber.d("setNowPlayingMovieData() :  %s", data.getTitle());
    }
  }

  @Override public void setPopularMovieData(List<Movie> movies) {
    for (Movie data : movies) {
      Timber.d("setPopularMovieData() :  %s", data.getTitle());
    }
  }

  @Override public void onRefresh() {
    // TODO: 10/15/16 handle onRefresh
  }
}
