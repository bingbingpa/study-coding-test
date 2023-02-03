package me.bingbingpa.book.doit.ch04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Question017 {

    @MethodSource("getParameters")
    @ParameterizedTest
    fun `내림차순으로 자릿수 정렬하기`(input: String, expected: String) {
        assertThat(solution(input)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("2143", "4321")
        )
    }
}

private fun solution(input: String): String {
    val size = input.length
    val str = Array(size) { 0 }
    for (i in 0 until size) {
        str[i] = input.substring(i until i + 1).toInt()
    }
    for (i in 0 until size) {
        var max = i
        for (j in i + 1 until size) {
            if (str[j] > str[max]) {
                max = j
            }
        }
        if (str[i] < str[max]) {
            val temp = str[i]
            str[i] = str[max]
            str[max] = temp
        }
    }
    return str.joinToString("")
}