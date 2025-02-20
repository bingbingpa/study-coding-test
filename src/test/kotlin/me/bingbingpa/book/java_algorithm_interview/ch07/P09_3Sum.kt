package me.bingbingpa.book.java_algorithm_interview.ch07

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class P09_3Sum {

    /**
     * 배열을 입력받아 합으로 0을 만들 수 있는 3개의 엘리먼트를 출력하라.
     * Input: [-1,0,1,2,-1,-5]
     * Output: [[-1,0,1],[-1,-1,2]]
     * @see <a href="https://leetcode.com/problems/3sum/"> https://leetcode.com/problems/3sum/
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `세 수의 합`(nums: IntArray, expected: List<List<Int>>) {
        //given & when
        val result = solution(nums)

        //then
        Assertions.assertThat(result).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                intArrayOf(-1, 0, 1, 2, -1, -5),
                listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)),
            ),
            Arguments.of(
                intArrayOf(0, 1, 1),
                emptyList<Int>(),
            ),
            Arguments.of(
                intArrayOf(0, 0, 0),
                listOf(listOf(0, 0, 0)),
            ),
        )
    }
}

private fun solution(nums: IntArray): List<List<Int>> {
    var left: Int
    var right: Int
    var sum: Int
    val results = mutableListOf<List<Int>>()
    nums.sort()
    for (i in 0 until nums.size - 2) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        left = i + 1
        right = nums.size - 1
        while (left < right) {
            sum = nums[i] + nums[left] + nums[right]
            if (sum < 0) {
                left++
            } else if (sum > 0) {
                right--
            } else {
                results.add(listOf(nums[i], nums[left], nums[right]))
                while (left < right && nums[left] == nums[left + 1]) {
                    left++
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--
                }
                left++
                right--
            }
        }
    }
    return results
}
