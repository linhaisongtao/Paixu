package com.example.daisongsong.paixu;

import junit.framework.TestCase;

/**
 * Created by daisongsong on 2015/8/28.
 */
public class GuibingThreadTest extends TestCase {

    public void testDiff() throws Exception {
        int[] data = new int[]{43, 3, 32, 43, 455};

        new GuibingThread(data, null).diff(data, 0, data.length - 1);

    }
}