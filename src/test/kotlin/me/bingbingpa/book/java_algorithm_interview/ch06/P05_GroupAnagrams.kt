package me.bingbingpa.book.java_algorithm_interview.ch06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class P05_GroupAnagrams {

    /**
     * 문자열 배열을 받아 애너그램 단위로 그룹핑하라.
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * @see <a href="https://leetcode.com/problems/group-anagrams/"> https://leetcode.com/problems/group-anagrams/
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `그룹 애너그램`(strs: Array<String>, expected: List<List<String>>) {
        //given & when
        val result = solution(strs)

        //then
        assertThat(result.map { it.sorted() })
            .containsExactlyInAnyOrderElementsOf(expected.map { it.sorted() })
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                arrayOf("eat", "tea", "tan", "ate", "nat", "bat"),
                listOf(
                    listOf("bat"),
                    listOf("nat", "tan"),
                    listOf("ate", "eat", "tea"),
                )
            ),
            Arguments.of(
                arrayOf(""),
                listOf(
                    listOf("")
                )
            ),
            Arguments.of(
                arrayOf("a"),
                listOf(
                    listOf("a")
                )
            )
        )
    }
}

private fun solution(strs: Array<String>): List<List<String>> {
    val resultMap = mutableMapOf<String, MutableList<String>>()
    for (str in strs) {
        val key = str.toCharArray().sorted().joinToString("")
        resultMap.getOrPut(key) { mutableListOf() }
        resultMap[key]?.add(str)
    }
    return resultMap.values.toList()
}