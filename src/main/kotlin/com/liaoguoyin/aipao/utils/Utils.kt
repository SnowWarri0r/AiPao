package com.liaoguoyin.aipao.utils


object Utils {

    fun encrypt(i: Int): String {
        val originString = "czplgyznba"
        val list: List<Char> = i.toString().toList()
        val result = StringBuilder()
        for (i in list) result.append(originString[i - '0'])
        return result.toString()
    }

    fun random(min: Double, max: Double): Double {
        return (min + Math.random() * (max - min))
    }

    fun random(min: Int, max: Int): Int {
        return (min + Math.random() * (max - min)).toInt()
    }

}
