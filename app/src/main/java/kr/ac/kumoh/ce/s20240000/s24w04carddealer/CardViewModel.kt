package kr.ac.kumoh.ce.s20240000.s24w04carddealer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class CardViewModel : ViewModel() {
    private var _cards = MutableLiveData<IntArray>(IntArray(5) { 0 })
    val cards: LiveData<IntArray>
        get() = _cards

    fun shuffle() {
        val newCards = IntArray(5) { 0 }

        for (i in newCards.indices)
            // TODO: 중복 및 정렬 처리
            newCards[i] = Random.nextInt(52)

        _cards.value = newCards
    }
}