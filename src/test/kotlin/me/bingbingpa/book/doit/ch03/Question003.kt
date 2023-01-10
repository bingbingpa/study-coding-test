package me.bingbingpa.book.doit.ch03

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Question003 {

    @MethodSource("getParameters")
    @ParameterizedTest
    fun `구간 합 구하기`(numbers: IntArray, expected: Int) {
        val target = intArrayOf(5, 4, 3, 2, 1)
        Assertions.assertThat(solution(target, numbers)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(intArrayOf(1, 3), 12),
            Arguments.of(intArrayOf(2, 4), 9),
            Arguments.of(intArrayOf(5, 5), 1)
        )
    }
}

private fun solution(target: IntArray, numbers: IntArray): Int {
    val calculatedArray = IntArray(target.size)
    calculatedArray[0] = target[0]
    for (i in 1 until target.size) {
        calculatedArray[i] = calculatedArray[i - 1] + target[i]
    }
    val end = calculatedArray[numbers[1] - 1]
    val start = if (numbers[0] == 1) 0 else calculatedArray[numbers[0] - 2]
    return end - start
}