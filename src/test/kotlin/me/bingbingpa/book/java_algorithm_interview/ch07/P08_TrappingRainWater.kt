package me.bingbingpa.book.java_algorithm_interview.ch07

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class P08_TrappingRainWater {

    /**
     * 높이를 입력받아 비 온 후 얼마나 많은 물이 쌓일 수 있는지 계산하라.
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * @see <a href="https://leetcode.com/problems/trapping-rain-water/"> https://leetcode.com/problems/trapping-rain-water/
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `빗물 트래핑`(height: IntArray, expected: Int) {
        //given & when
        val result = solution(height)

        //then
        assertThat(result).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1),
                6,
            ),
            Arguments.of(
                intArrayOf(4, 2, 0, 3, 2, 5),
                9,
            ),
        )
    }
}

private fun solution(height: IntArray): Int {
    var volume = 0
    var left = 0
    var right = height.size - 1
    var leftMax = 0
    var rightMax = 0

    while (left < right) {
        leftMax = height[left].coerceAtLeast(leftMax)
        rightMax = height[right].coerceAtLeast(rightMax)

        if (leftMax <= rightMax) {
            volume += leftMax - height[left]
            left++
        } else {
            volume += rightMax - height[right]
            right--
        }
    }
    return volume
}
