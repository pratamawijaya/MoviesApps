package pratamawijaya.moviesinfokotlin.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import pratamawijaya.moviesinfokotlin.app.AppComponent;
import pratamawijaya.moviesinfokotlin.app.MoviesInfoApplication;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/14/16
 * Project Name : MoviesInfoKotlin
 */

public abstract class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupActivityComponent();
  }

  protected void setupActivityComponent() {
    buildComponent(MoviesInfoApplication.get(this).getAppComponent());
  }

  abstract protected void buildComponent(AppComponent appComponent);
}
