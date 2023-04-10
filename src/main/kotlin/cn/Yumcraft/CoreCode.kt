package cn.Yumcraft

import taboolib.common.platform.command.command
import java.util.*

object CoreCode {

    fun destiny(arr: IntArray): Boolean {
        val sorted = Arrays.copyOf(arr, arr.size)
        Arrays.sort(sorted)
        for (i in arr.indices) {
            val random = Random()
            val randomNum = random.nextInt(arr.size)
            val temp = arr[i]
            arr[i] = arr[randomNum]
            arr[randomNum] = temp
        }
        return Arrays.equals(sorted, arr)
    }

}
