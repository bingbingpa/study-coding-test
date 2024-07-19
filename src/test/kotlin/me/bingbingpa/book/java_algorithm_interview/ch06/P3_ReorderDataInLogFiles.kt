package me.bingbingpa.book.java_algorithm_interview.ch06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class P3_ReorderDataInLogFiles {

    /**
     * 로그를 재정렬하라. 기준은 다음과 같다.
     * 1. 로그의 가장 앞부분은 식별자로서, 순서에 영향을 끼치지 않는다.
     * 2. 문자로 구성된 로그가 숫자 로그보다 앞에 오며, 문자 로그는 사전순으로 한다.
     * 3. 문자가 동일할 경우에는 식별자순으로 한다.
     * 4. 숫자 로그는 입력 순서대로 한다.
     * 입력: ["id1 8 1 8 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero"]
     * 출력: ["id2 art can", "id5 art zero", "id4 own kit dig", "id1 8 1 8 1", "id3 3 6"]
     * @see <a href = "https://leetcode.com/problems/reorder-data-in-log-files/"> https://leetcode.com/problems/reorder-data-in-log-files/
     */
    @Test
    fun `로그 파일 재정렬`() {
        //given
        val input = arrayOf("id1 8 1 8 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero")

        //when
        val result = solution(input)

        //then
        assertThat(result).isEqualTo(arrayOf("id2 art can", "id5 art zero", "id4 own kit dig", "id1 8 1 8 1", "id3 3 6"))
    }
}

private fun solution(logs: Array<String>): Array<String> {
    val letterList = mutableListOf<String>()
    val digitList = mutableListOf<String>()
    for (log in logs) {
        val first = log.substring(4).toCharArray().first()
        if (first.isDigit()) {
            digitList.add(log)
        } else {
            letterList.add(log)
        }
    }

    letterList.sortWith { o1, o2 ->
        val s1 = o1.split(" ", limit = 2)
        val s2 = o2.split(" ", limit = 2)
        val compared = s1.last().compareTo(s2.last())
        if (compared == 0) {
            s1.first().compareTo(s2.first())
        } else {
            compared
        }
    }
    letterList.addAll(digitList)

    return letterList.toTypedArray()
}

private fun bookSolution(logs: Array<String>): Array<String> {
    val letterList = mutableListOf<String>()
    val digitList = mutableListOf<String>()
    for (log in logs) {
        if (Character.isDigit(log.split(" ")[1][0])) {
            digitList.add(log)
        } else {
            letterList.add(log)
        }
    }

    letterList.sortWith { s1, s2 ->
        val s1x = s1.split(" ", limit = 2)
        val s2x = s2.split(" ", limit = 2)
        val compared = s1x[1].compareTo(s2x[1])
        if (compared == 0) {
            s1x[0].compareTo(s2x[0])
        } else {
            compared
        }
    }
    letterList.addAll(digitList)

    return letterList.toTypedArray()
}