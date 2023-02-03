package me.bingbingpa.book.doit.ch04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Question016 {

    @MethodSource("getParameters")
    @ParameterizedTest
    fun `버블 소트 프로그램 1`(numbers: IntArray, expected: Int) {
        assertThat(solution(numbers)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(intArrayOf(10, 1, 5, 2, 3), 3)
        )
    }
}

private fun solution(numbers: IntArray): Int {
    val size = numbers.size
    val A = arrayOfNulls<MData>(size)
    for (i in 0 until size) {
        A[i] = MData(numbers[i], i)
    }
    A.sort()
    var max = 0
    for (i in 0 until size) {
        if (max < A[i]!!.index - i) {
            max = A[i]!!.index - i
        }
    }
    return max + 1
}

class MData(
    private val value: Int,
    val index: Int
): Comparable<MData> {
    override fun compareTo(other: MData): Int {
        return this.value - other.value
    }
}
