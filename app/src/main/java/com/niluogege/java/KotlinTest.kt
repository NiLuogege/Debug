package com.niluogege.java

import java.text.DecimalFormat

var mavlIndex = 0

//码率 / Mbps
var malv = floatArrayOf(1f, 1.5f, 1.9f)

//时间 / h
var times = doubleArrayOf(0.5, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 10.0, 12.0)

//总观看人数 / 人
var totlePeoples = intArrayOf(20, 50, 80, 100, 150, 200, 300, 500, 800, 1000, 1500, 2000, 2500, 3000, 4000, 5000, 6000, 7000)


//同时管看人数（峰值人数） / 人
var maxPeoples = intArrayOf(5, 10, 15, 20, 25, 30, 50, 80, 100, 150, 200, 300, 500, 800, 1000, 1500, 2000)


fun main() {
    liuliangjifei()
}

/**
 * 流量计费
 *
 *
 * （费用= 直播码率 / 8 × 时间 × 观看人数 × 单价）
 */
fun liuliangjifei() {
    val df = DecimalFormat(".00")


    for (time in times) {
        for (totlePeople in totlePeoples) {

            val gb = malv[mavlIndex] / 8 * (time * 60 * 60) * totlePeople / 1000
//            println("使用了 $gb gb流量 转之前")
            val price = gb * getTXLiuLiangJieti(gb.toInt())


            println("码率= ${malv[mavlIndex]}/Mbps ; 直播时间= $time 小时 ; 总观看人数= $totlePeople 人 ; 消耗 $gb gb流量; 花费 ${df.format(price)} 元" );
        }
    }



}

/**
 * 腾讯流量阶梯
 */
fun getTXLiuLiangJieti(gb: Int): Float {

//    println("使用了 $gb gb流量  转之后")


    when (gb) {
        in 0..500 -> return 0.26f
        in 500..2000 -> return 0.25f
        in 2000..10000 -> return 0.23f
        in 10000..50000 -> return 0.23f
        in 50000..100000 -> return 0.19f
        in 100000..1000000 -> return 0.16f
        else -> return 0.16f
    }

    println("error  没找到对应 $gb gb流量")
}