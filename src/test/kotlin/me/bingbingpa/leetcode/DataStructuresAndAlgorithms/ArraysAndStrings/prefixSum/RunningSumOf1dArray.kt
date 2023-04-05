package me.bingbingpa.leetcode.DataStructuresAndAlgorithms.ArraysAndStrings.prefixSum

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RunningSumOf1dArray {

    /**
     * Example 1:
     *  Input: nums = [1,2,3,4]
     *  Output: [1,3,6,10]
     *  Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
     * Example 2:
     *  Input: nums = [1,1,1,1,1]
     *  Output: [1,2,3,4,5]
     *  Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
     * Example 3:
     *  Input: nums = [3,1,2,10,1]
     *  Output: [3,4,6,16,17]
     * Constraints:
     *  1 <= nums.length <= 1000
     *  -10^6 <= nums[i] <= 10^6
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `Running Sum of 1d Array`(input: IntArray, expected: IntArray) {
        assertThat(solution(input)).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(intArrayOf(1, 2, 3, 4), intArrayOf(1, 3, 6, 10)),
            Arguments.of(intArrayOf(1, 1, 1, 1, 1), intArrayOf(1, 2, 3, 4, 5)),
            Arguments.of(intArrayOf(3, 1, 2, 10, 1), intArrayOf(3, 4, 6, 16, 17))
        )
    }
}

private fun solution(input: IntArray): IntArray {
    var preSum = 0
    val newArray = IntArray(input.size)

    input.forEachIndexed { index, i ->
        preSum += i
        newArray[index] = preSum
    }

    return newArray
}