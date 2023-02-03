package me.bingbingpa.book.doit.ch04

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Question015 {

    @MethodSource("getParameters")
    @ParameterizedTest
    fun `수 정렬하기 1`(numbers: IntArray, expected: IntArray) {
        assertThat(solution(numbers)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(intArrayOf(5, 2, 3, 4, 1), intArrayOf(1, 2, 3, 4, 5))
        )
    }
}

private fun solution(numbers: IntArray): IntArray {
    val size = numbers.size
    for (i: Int in 0 until size) {
        for (j: Int in 0..size - 2) {
            if (numbers[j] > numbers[j + 1]) {
                val temp = numbers[j]
                numbers[j] = numbers[j + 1]
                numbers[j + 1] = temp
            }
        }
    }
    return numbers
}