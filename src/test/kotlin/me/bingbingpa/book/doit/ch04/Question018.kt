package me.bingbingpa.book.doit.ch04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Question018 {

    @MethodSource("getParameters")
    @ParameterizedTest
    fun `ATM 인출 시간 계산하기`(numbers: IntArray, expected: Int) {
        assertThat(solution(numbers)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(intArrayOf(3, 1, 4, 3, 2), 32)
        )
    }
}

private fun solution(numbers: IntArray): Int {
    val size = numbers.size
    val A = numbers
    val S = Array(size) { 0 }
    for (i in 1 until size) {
        var insertPoint = i
        val insertValue = A[i]
        for (j in i - 1 downTo 0) {
            if (A[j] < A[i]) {
                insertPoint = j + 1
                break
            }
            if (j == 0) {
                insertPoint = 0
            }
        }
        for (j in i downTo insertPoint + 1) {
            A[j] = A[j - 1]
        }
        A[insertPoint] = insertValue
    }
    S[0] = A[0]
    for (i in 1 until size) {
        S[i] = S[i - 1] + A[i]
    }
    var sum = 0
    for (i in 0 until size) {
        sum += S[i]
    }

    return sum
}

fun main() {
    val A = IntArray(3)
    val i = 0
    val insertPoint = 0
    for (j in i..insertPoint + 1) {
        A[j] = A[j - 1]
    }
}