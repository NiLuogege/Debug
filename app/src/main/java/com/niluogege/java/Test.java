package com.niluogege.java;

import java.text.DecimalFormat;

public class Test {

    static int mavlIndex = 0;

    //码率 / Mbps
    static float[] malv = {1, 1.5f, 1.9f};

    //时间 / h
    static double[] times = {0.5, 1, 2, 3, 4, 5, 6, 7, 8, 10, 12};

    //总观看人数 / 人
    static int[] totlePeoples = {20, 50, 80, 100, 150, 200, 300, 500, 800, 1000, 1500, 2000, 2500, 3000, 4000, 5000, 6000, 7000};


    //同时管看人数（峰值人数） / 人
    static int[] maxPeoples = {5, 10, 15, 20, 25, 30, 50, 80, 100, 150, 200, 300, 500, 800, 1000, 1500, 2000};

    public static void main(String[] args) {
        liuliangjifei();
    }


    /**
     * 流量计费
     * <p>
     * （费用= 直播码率 / 8 × 时间 × 观看人数 × 单价）
     */
    private static void liuliangjifei() {
        DecimalFormat df = new DecimalFormat(".00");

        double gb = malv[mavlIndex] / 8 * (times[2] * 60 * 60) * totlePeoples[3] / 1000;
        double price = gb * getLiuLiangJieti(gb);


//        System.out.println("码率= " + malv[mavlIndex] + "/Mbps "+ "直播时间= "+);
//        System.out.println("码率= "+malv[mavlIndex]+"  price= " + df.format(price));
    }


    private static float getLiuLiangJieti(double gb) {

//        switch (gb){
//            case gb<500:
//                return 0.26f;
//                break;
//        }

        return 0.26f;
    }
}
