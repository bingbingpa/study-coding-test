package me.bingbingpa.leetcode.easy

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Question1 {

    @MethodSource("getParameters")
    @ParameterizedTest
    fun `Two Sum`(nums: IntArray, target: Int, expected: IntArray) {
        Assertions.assertThat(twoSum(nums, target)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1)),
            Arguments.of(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2)),
            Arguments.of(intArrayOf(3, 3), 6, intArrayOf(0, 1)),
        )
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val hashMap = mutableMapOf<Int, Int>()

    for ((i, v) in nums.withIndex()) {
        val diff = target - v
        val indexForDiffValue = hashMap[diff]

        indexForDiffValue?.let {
            return@twoSum intArrayOf(indexForDiffValue, i)
        }

        hashMap[v] = i
    }
    throw IllegalStateException()
}