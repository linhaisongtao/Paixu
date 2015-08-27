package com.example.daisongsong.paixu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ChartView mChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChartView = (ChartView) findViewById(R.id.mChartView);

        findViewById(R.id.mTextViewTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int[] data = new int[50 + random.nextInt(30)];

                for (int i = 0; i < data.length; ++i) {
                    data[i] = Math.abs(random.nextInt(1000));
                }
                Log.d(getClass().getSimpleName(), "data=" + data);
                mChartView.postDraw(data);
            }
        });
    }

}
