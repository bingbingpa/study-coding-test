package me.bingbingpa.book.java_algorithm_interview.ch07

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class P10_ArrayPartition {

    /**
     * n 개의 페어를 이용한 min(a,b)의 합으로 만들 수 있는 가장 큰 수를 출력하라.
     * Input: [1,3,4,2]
     * Output: 4
     * @see <a href="https://leetcode.com/problems/array-partition/"> https://leetcode.com/problems/array-partition/
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `배열 파티션1`(nums: IntArray, expected: Int) {
        //given & when
        val result = solution(nums)

        //then
        Assertions.assertThat(result).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 4, 2),
                4,
            ),
            Arguments.of(
                intArrayOf(6, 2, 6, 5, 1, 2),
                9,
            ),
        )
    }
}

private fun solution(nums: IntArray): Int {
    var sum = 0
    nums.sort()

    for ((i, n) in nums.withIndex()) {
        if (i % 2 == 0) {
            sum += n
        }
    }
    return sum
}