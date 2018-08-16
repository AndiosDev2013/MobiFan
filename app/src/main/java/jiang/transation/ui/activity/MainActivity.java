package jiang.transation.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.View;

import jiang.transation.R;

public class MainActivity extends BaseActionBarActivity implements
        View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActionBar();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        setTitle("Page List");

        findViewById(R.id.btn_first).setOnClickListener(this);
        findViewById(R.id.btn_second).setOnClickListener(this);
        findViewById(R.id.btn_third).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_first: {
                Intent intent = new Intent(this, FirstActivity.class);
                startActivity(intent);
            }
            break;

            case R.id.btn_second: {
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
            }
            break;

            case R.id.btn_third: {
                Intent intent = new Intent(this, ThirdActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}
