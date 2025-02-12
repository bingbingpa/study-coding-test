package me.bingbingpa.book.java_algorithm_interview.ch07

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class P07_TwoSum {

    /**
     * 덧셈하여 타깃을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라.
     * Input: nums = [2, 6, 11, 15], target = 8
     * Output: [0, 1]
     * @see <a href="https://leetcode.com/problems/two-sum/"> https://leetcode.com/problems/two-sum/
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun twoSum(nums: IntArray, target: Int, expected: IntArray) {
        //given & when
        val result = bookSolution(nums, target)

        //then
        assertThat(result).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                intArrayOf(2, 7, 11, 15),
                9,
                intArrayOf(0, 1)
            ),
            Arguments.of(
                intArrayOf(3, 2, 4),
                6,
                intArrayOf(1, 2)
            ),
            Arguments.of(
                intArrayOf(3, 3),
                6,
                intArrayOf(0, 1)
            )
        )
    }
}

private fun solution(nums: IntArray, target: Int): IntArray {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf(0, 0)
}

private fun bookSolution(nums: IntArray, target: Int): IntArray {
    val numsMap = HashMap<Int, Int>()
    for ((i, num) in nums.withIndex()) {
        if (numsMap.containsKey(target - num)) {
            return intArrayOf(numsMap[target - num] ?: 0, i)
        }
        numsMap[num] = i
    }
    return intArrayOf(0, 0)
}

