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
import java.util.List;
import javax.inject.Inject;
import pratamawijaya.moviesinfokotlin.R;
import pratamawijaya.moviesinfokotlin.app.AppComponent;
import pratamawijaya.moviesinfokotlin.domain.entity.Movie;
import pratamawijaya.moviesinfokotlin.presentation.base.BaseActivity;
import pratamawijaya.moviesinfokotlin.presentation.ui.home.di.DaggerHomeActivityComponent;
import pratamawijaya.moviesinfokotlin.presentation.ui.home.di.HomeActivityModule;
import pratamawijaya.moviesinfokotlin.presentation.ui.home.presenter.HomePresenterImpl;
import timber.log.Timber;

public class HomeActivity extends BaseActivity
    implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener {

  @BindView(R.id.refreshLayout) SwipeRefreshLayout swipeRefreshLayout;
  @BindView(R.id.recyclerView) RecyclerView recyclerView;
  @BindView(R.id.loadingView) ProgressBar loadingView;

  @Inject HomePresenterImpl presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    presenter.attachView(this);
    presenter.loadItemHome(false);

    setupRecylerView();
  }

  private void setupRecylerView() {
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

  @Override public void onRefresh() {
    // TODO: 10/15/16 handle onRefresh
  }
}
