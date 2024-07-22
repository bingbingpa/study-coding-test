package me.bingbingpa.book.java_algorithm_interview.ch06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.util.*

class P01_ValidPalindrome {

    /**
     * 주어진 문자열이 팰린드롬인지 확인하라. 대소문자를 구분하지 않으며, 영숫자(영문자와 숫자)만을 대상으로 한다.
     * @see <a href="https://leetcode.com/problems/valid-palindrome/"> https://leetcode.com/problems/valid-palindrome/
     */
    @CsvSource(
        value = ["A man, a plan, a canal: Panama:true", "race a car:false", "' ':true", "Do geese see God?:true", "ab_a:true"],
        delimiter = ':'
    )
    @ParameterizedTest
    fun `유효한 팰린드롬`(input: String, expected: Boolean) {
        //given
        //when
        val result = solution(input)

        //then
        assertThat(result).isEqualTo(expected)
    }
}

private fun solution(s: String): Boolean {
    val replaceNumbers = s.filter { it.isLetterOrDigit() }.lowercase(Locale.getDefault())
    return replaceNumbers == replaceNumbers.reversed()
}

private fun bookSolution(s: String): Boolean {
    var start = 0
    var end = s.length - 1
    // 서로 중앙으로 이동해 나가다 겹치는 지점에 도달하면 종료
    while (start < end) {
        when {
            // 영숫자인지 판별하고 유효하지 않으면 뒤로 한 칸 이동
            !Character.isLetterOrDigit(s[start]) -> start++
            // 영숫자인지 판별하고 유효하지 않으면 앞으로 한 칸 이동
            !Character.isLetterOrDigit(s[end]) -> end--
            else -> {
                // 이 외에는 유효한 문자이므로 앞뒤 글자를 모두 소문자로 변경하여 비교
                if (Character.toLowerCase(s[start]) != Character.toLowerCase(s[end])) {
                    // 하나라도 일치하지 않는다면 팰린드롬이 아니므로 false 리턴
                    return false
                }
                // 앞쪽 문자는 한 칸 뒤로, 뒤쪽 문자는 한 칸 앞으로 이동
                start++
                end--
            }
        }
    }
    // 무사히 종료될 경우 팰린드롬이므로 true 리턴
    return true
}