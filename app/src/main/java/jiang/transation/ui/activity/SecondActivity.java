package jiang.transation.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;

import jiang.transation.R;

public class SecondActivity extends BaseActionBarActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initActionBar();

        final AppBarLayout appBarLayout = findViewById(R.id.appBarLayout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
                if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0) {
                    collapsingToolbar.setTitle("Jane Doe");
                } else {
                    collapsingToolbar.setTitle(" ");
                }
            }
        });
    }
}
