package me.bingbingpa.inflearn.practice._01_string_array;

import me.bingbingpa.test.CustomTest;
import me.bingbingpa.test.TestUnit;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
    public static void main(String[] args) {
        MissingRange missingRange = new MissingRange();
        int[] nums = {2, 3, 5, 50, 75};
        int lower = 0;
        int upper = 99;
        List<String> result = missingRange.solution(nums, lower, upper);
        System.out.println("result ================== " + result);
        System.out.println("match ================== " + "[0->1, 4, 6->49, 51->74, 76->99]".equals(result.toString()));
    }

    /**
     * TODO 정렬된 정수 배열 nums 가 주어졌을 대 포함 범위(하한, 상한)에 있는 경우 누락된 범위를 반환하라.
     * 예) Input: nums = [2, 3, 5, 50, 75], lower = 0 and upper = 99, Output: ["0->1","4","6->49","51->74","76->99"]
     * TEST
     * - input 값 체크(nums 의 길이는 0 보다 커야 하고 lower 값은 upper 값보다 작아야 한다.)
     * - lower < nums[0] 인 경우는 lower->nums[0]-1 로 표현한다.
     * - nums[nums.length-1] < upper 인 경우는 nums[nums.length-1]->upper 로 표현한다.
     * - 나머지 값들은 nums[i]+1->nums[i+1]-1 로 표현한다.
     */
    public List<String> solution(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        TestUnit.test(this.getClass()); // 테스트코드 실행
        if (!isValid(nums, lower, upper)) {
            return result;
        }

        result.add(makeFirstRange(lower, nums[0]));

        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            if (nums[i] != nums[i+1] && nums[i] +1 < nums[i+1] ) {
                result.add(makeRange(nums[i]+1, nums[i+1]-1));
            }
        }

        result.add(makeEndRange(nums[length - 1], upper));
        return result;
    }

    private boolean isValid(int[] nums, int lower, int upper) {
        return nums.length > 0 && lower < upper;
    }

    private String makeFirstRange(int num1, int num2) {
        return num1 < num2 ? makeRange(num1, num2 - 1) : "";
    }

    private String makeEndRange(int num1, int num2) {
        return num1 < num2 ? makeRange(num1+1, num2) : "";
    }

    private String makeRange(int num1, int num2) {
        return num1 == num2 ? String.valueOf(num1) : num1 + "->" + num2;
    }

    @CustomTest
    private void testIsValid() {
        TestUnit.printMessage(isValid(new int[]{2, 3, 5, 50, 75}, 0, 99));
    }

    @CustomTest
    private void testMakeFirstRange() {
        TestUnit.printMessage("0->1".equals(makeFirstRange(0, 2)));
        TestUnit.printMessage("".equals(makeFirstRange(13, 0)));
    }

    @CustomTest
    private void testMakeEndRange() {
        TestUnit.printMessage("76->99".equals(makeEndRange(75,99)));
        TestUnit.printMessage("".equals(makeEndRange(99,43)));
    }
}
