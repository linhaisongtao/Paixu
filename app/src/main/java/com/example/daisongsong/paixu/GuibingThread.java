package com.example.daisongsong.paixu;

/**
 * Created by daisongsong on 2015/8/28.
 */
public class GuibingThread extends Thread {
    private int[] mData;
    private ChartView mChartView;

    public GuibingThread(int[] data, ChartView chartView) {

    }

    @Override
    public void run() {
        super.run();
        diff(mData, 0, mData.length - 1);
    }


    public void diff(int[] data, int start, int end) {
        if (start >= end) {

        } else {
            int middle = (start + end) / 2;
            diff(data, start, middle);
            diff(data, middle + 1, end);
            merge(data, start, middle, end);
        }


    }

    private void merge(int[] data, int start, int middle, int end) {
        if (end < start) {
            return;
        }
        int[] temp = new int[end - start + 1];
        for (int i = 0; i < temp.length; ++i) {
            if (data[start] > data[middle + 1]) {
                temp[i] = data[start];
                start++;
            } else {
                temp[i] = data[middle + 1];
                middle++;
            }
        }

        System.out.println();
        for(int i = 0; i < temp.length; ++i){
            System.out.print(" " + temp[i]);
        }
        System.out.println();
    }
}
