package kr.ac.kumoh.ce.s20240000.s24w04carddealer

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class CardViewModel : ViewModel() {
    // 5개 Int를 만들고 모두 0으로 초기화
    // 동일: private val _numbers = intArrayOf(0, 0, 0, 0, 0, )
    // 배열의 내용은 변하지만 배열 자체는 변하지 않으므로 val 사용
    private val _cards = IntArray(5) { 0 }

    val cards
        get() = _cards

    fun shuffle() {
        for (i in _cards.indices)
            // TODO: 중복 및 정렬 처리
            _cards[i] = Random.nextInt(52)
    }
}