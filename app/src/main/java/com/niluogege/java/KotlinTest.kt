package com.niluogege.java

import java.text.DecimalFormat

var mavlIndex = 0

//码率 / Mbps
var malv = floatArrayOf(0.5f, 0.8f, 1f, 1.5f, 1.9f)

//时间 / h
var times = doubleArrayOf(0.5, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 10.0, 12.0)

//总观看人数 / 人
var totlePeoples = intArrayOf(20, 50, 80, 100, 150, 200, 300, 500, 800, 1000, 1500, 2000, 2500, 3000, 4000, 5000, 6000, 7000)


//同时管看人数（峰值人数） / 人
var maxPeoples = intArrayOf(5, 10, 15, 20, 25, 30, 50, 80, 100, 150, 200, 300, 500, 800, 1000, 1500, 2000)

//流量包 /gb
var liuLiangBaos = intArrayOf(100, 500, 1000, 5000, 10000, 50000, 200000, 1000000)


fun main() {
//    流量计费
//    liuliangjifei()
//    峰值计费
//    fengZhiJiFei()
//    流量包
//    liuLiangBao()

    println("草草草 aaaa")

}

fun liuLiangBao() {
    val df = DecimalFormat(".00")
    for (gb in liuLiangBaos) {
//        var price=getTXLiuLiangBaoJieti(liuLiangBao)

        //腾讯
//        val price = gb * getTXLiuLiangJieti(gb)
        //七牛
//            val price = gb * getQNLiuLiangJieti(gb)
        //金山
        val price = gb * getJSLiuLiangJieti(gb)

        println("${df.format(price)}");
    }

}


/**
 * 峰值计费
 */
fun fengZhiJiFei() {
    val df = DecimalFormat(".00")
    for (ml in malv) {
        for (maxPeople in maxPeoples) {
            val maxMbps = ml * maxPeople;
            //腾讯
//            val price = maxMbps * getTXKuanDaiJieti(maxMbps.toInt());
            //七牛
//            val price = maxMbps * getQNKuanDaiJieti(maxMbps.toInt());
            //金山
            val price = maxMbps * getJSKuanDaiJieti(maxMbps.toInt());

//            println("$ml ; $maxPeople ; ${df.format(maxMbps)} ;${df.format(price)}");
            println("${df.format(price)}");
        }
    }

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
            //腾讯
//            val price = gb * getTXLiuLiangJieti(gb.toInt())
            //七牛
//            val price = gb * getQNLiuLiangJieti(gb.toInt())
            //金山
            val price = gb * getJSLiuLiangJieti(gb.toInt())


//            println("码率= ${malv[mavlIndex]}/Mbps ; 直播时间= $time 小时 ; 总观看人数= $totlePeople 人 ; 消耗 $gb gb流量; 花费 ${df.format(price)} 元");
//            println("${malv[mavlIndex]} ; $time ; $totlePeople ; ${df.format(gb)} ;${df.format(price)}");
            println("${df.format(price)}");
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

/**
 * 七牛流量阶梯
 */
fun getQNLiuLiangJieti(gb: Int): Float {

//    println("使用了 $gb gb流量  转之后")


    when (gb) {
        in 0..500 -> return 0.26f
        in 500..2000 -> return 0.26f
        in 2000..10000 -> return 0.26f
        in 10000..50000 -> return 0.25f
        in 50000..100000 -> return 0.23f
        in 100000..1000000 -> return 0.19f
        else -> return 0.16f
    }

    println("error  没找到对应 $gb gb流量")
}

/**
 * 金山流量阶梯
 */
fun getJSLiuLiangJieti(gb: Int): Float {

//    println("使用了 $gb gb流量  转之后")


    when (gb) {
        in 0..500 -> return 0.22f
        in 500..2000 -> return 0.22f
        in 2000..10000 -> return 0.22f
        in 10000..50000 -> return 0.2f
        in 50000..100000 -> return 0.18f
        in 100000..1000000 -> return 0.15f
        else -> return 0.13f
    }

    println("error  没找到对应 $gb gb流量")
}


/**
 * 腾讯宽带阶梯
 */
fun getTXKuanDaiJieti(mb: Int): Float {
    when (mb) {
        in 0..500 -> return 0.64f
        in 500..5000 -> return 0.62f
        in 5000..20000 -> return 0.59f
        else -> return 0.58f
    }
}

/**
 * 七牛宽带阶梯
 */
fun getQNKuanDaiJieti(mb: Int): Float {
    when (mb) {
        in 0..500 -> return 0.65f
        in 500..5000 -> return 0.63f
        in 5000..20000 -> return 0.6f
        else -> return 0.597f
    }
}

/**
 * 金山宽带阶梯
 */
fun getJSKuanDaiJieti(mb: Int): Float {
    when (mb) {
        in 0..500 -> return 0.6f
        in 500..5000 -> return 0.56f
        in 5000..20000 -> return 0.52f
        else -> return 0.52f
    }
}


/**
 * 腾讯流量包计费
 */
fun getTXLiuLiangBaoJieti(gb: Int): Int {
    return when (gb) {
        100 -> 25
        500 -> 118
        1000 -> 236
        5000 -> 1086
        10000 -> 2172
        50000 -> 8972
        200000 -> 30198
        1000000 -> 149589
        else -> 0
    }
}