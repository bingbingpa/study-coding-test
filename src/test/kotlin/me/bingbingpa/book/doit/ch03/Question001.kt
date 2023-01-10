package me.bingbingpa.book.doit.ch03

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Question001 {

    @CsvSource(value = [
        "1:1:1",
        "5:54321:15",
        "25:70000000000000000000000:7",
        "11:10987654321:46"
                       ], delimiter = ':')
    @ParameterizedTest
    fun `숫자의 합 구하기`(n: Int, numbers: String, expected: Int) {
        assertThat(solution(numbers)).isEqualTo(expected)
    }
}

private fun solution(numbers: String): Int {
    return numbers.toCharArray().sumOf { it - '0' }
}