package me.bingbingpa.book.doit.ch03

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Question002 {

    @MethodSource("getParameters")
    @ParameterizedTest
    fun `평균 구하기`(n: Int, scores: IntArray, expected: Double) {
        assertThat(solution(scores)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(3, intArrayOf(40, 80, 60), 75.0),
            Arguments.of(4, intArrayOf(1, 100, 100, 100), 75.25),
            Arguments.of(5, intArrayOf(1, 2, 4, 8, 16), 38.75),
            Arguments.of(2, intArrayOf(3, 10), 65.0),
        )
    }
}

private fun solution(scores: IntArray): Double {
    val max = scores.max().toDouble()
    return (scores.sumOf { it.toDouble() / max * 100 } / scores.size)
}
