package me.bingbingpa.book.java_algorithm_interview.ch06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class P06_LongestPalindromicSubstring {

    /**
     * 가장 긴 팰린드롬 부분 문자열을 출력하라.
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/"> https://leetcode.com/problems/longest-palindromic-substring/
     */
    @CsvSource(value = ["babad:bab", "cbbd:bb", "ac:a", "bb:bb"], delimiter = ':')
    @ParameterizedTest
    fun `가장 긴 팰린드롬 부분 문자열`(input: String, expected: String) {
        //given & when
        val result = solution(input)
        leftIndex = 0
        maxLength = 0

        //then
        assertThat(result).isEqualTo(expected)
    }
}

var leftIndex = 0
var maxLength = 0

private fun extendPalindrome(s: String, start: Int, end: Int) {
    val length = s.length
    var left = start
    var right = end
    while (left >= 0 && right < length && s[left] == s[right]) {
        left--
        right++
    }
    val max = right - left - 1
    if (maxLength < max) {
        leftIndex = left + 1
        maxLength = max
    }
}

private fun solution(s: String): String {
    val length = s.length
    if (length < 2) return s
    if (length == 2 && s[0] != s[1]) return s.substring(0, 1)
    for (i in 0 until length - 1) {
        extendPalindrome(s, i, i + 1)
        extendPalindrome(s, i, i + 2)
    }
    return s.substring(leftIndex, leftIndex + maxLength)
}