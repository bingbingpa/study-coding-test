package me.bingbingpa.book.java_algorithm_interview.ch06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class P04_MostCommonWord {

    /**
     * 금지된 단어를 제외하고 가장 흔하게 등장하는 단어를 출력하라. 대소문자를 구분하지 않으며, 구두점(마침표, 쉼표 등) 또한 무시한다.
     * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
     * Output: "ball"
     * @see <a href ="https://leetcode.com/problems/most-common-word"> https://leetcode.com/problems/most-common-word
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `가장 흔한 단어`(paragraph: String, banned: Array<String>, expected: String) {
        //given & when
        val result = solution(paragraph, banned)

        //then
        assertThat(result).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                "Bob hit a ball, the hit BALL flew far after it was hit.",
                arrayOf("hit"),
                "ball"
            ),
            Arguments.of(
                "a, a, a, a, b,b,b,c, c",
                arrayOf("a"),
                "b"
            )
        )
    }
}

private fun solution(paragraph: String, banned: Array<String>): String {
    val words = paragraph
        .replace("\\W+".toRegex(), " ").lowercase(Locale.getDefault()).trim().split(" ")
    val wordMap = mutableMapOf<String, Int>()
    var maxWord = ""
    var max = 0

    words.forEach { word ->
        if (!banned.contains(word)) {
            wordMap[word] = wordMap.getOrDefault(word, 0) + 1
            val value = wordMap[word]!!
            if (value > max) {
                max = value
                maxWord = word
            }
        }
    }

    return maxWord
}
