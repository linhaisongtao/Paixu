package com.example.daisongsong.paixu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private boolean isRunning = false;
    private ChartView mChartView;
    private int[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChartView = (ChartView) findViewById(R.id.mChartView);

        findViewById(R.id.mTextViewTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                data = new int[50 + random.nextInt(30)];

                for (int i = 0; i < data.length; ++i) {
                    data[i] = Math.abs(random.nextInt(1000));
                }
                Log.d(getClass().getSimpleName(), "data=" + data);
                mChartView.postDraw(data);
            }
        });

        findViewById(R.id.mButtonMaopao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    return;
                }
                MaoPaoThread thread = new MaoPaoThread();
                thread.start();
            }
        });
    }

    private int[] copy(int[] src) {
        int[] dest = new int[src.length];
        for (int i = 0; i < src.length; ++i) {
            dest[i] = src[i];
        }
        return dest;
    }

    private class MaoPaoThread extends Thread {

        public MaoPaoThread() {
            if (data == null) {
                Random random = new Random();
                data = new int[50 + random.nextInt(30)];

                for (int i = 0; i < data.length; ++i) {
                    data[i] = Math.abs(random.nextInt(1000));
                }
                Log.d(getClass().getSimpleName(), "data=" + data);
                mChartView.postDraw(data);
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < data.length; ++i) {

                for (int j = i + 1; j < data.length; ++j) {
                    if (data[i] < data[j]) {
                        //exchange
                        int temp = data[i];
                        data[i] = data[j];
                        data[j] = temp;
                    }

                }
                refreshView();
            }
            isRunning = false;
            super.run();
        }

        private void refreshView() {
            mChartView.postDraw(copy(data));
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
