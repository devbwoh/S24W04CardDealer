package kr.ac.kumoh.ce.s20240000.s24w04carddealer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class CardViewModel : ViewModel() {
    private var _cards = MutableLiveData<IntArray>(IntArray(5) { 0 })
    val cards: LiveData<IntArray>
        get() = _cards

//    fun shuffle() {
//        var num = 0
//        val newCards = IntArray(5) { 0 }
//
//        for (i in newCards.indices) {
//            // 중복 검사
//            do {
//                num = Random.nextInt(52)
//            } while (newCards.contains(num))
//            newCards[i] = num
//        }
//
//        // 정렬
//        newCards.sort()
//
//        _cards.value = newCards
//    }

    fun shuffle() {
        // var로 변경, size를 0으로 변경
        var newCards = IntArray(0)

        while (newCards.size < 5) {
            val num = Random.nextInt(52)
            if (!newCards.contains(num))
                newCards = newCards.plus(num)
        }

        newCards.sort()

        _cards.value = newCards
    }
}