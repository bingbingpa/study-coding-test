package me.bingbingpa.inflearn.practice._01_string_array;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("result =================== " + trappingRainWater.solution1(heights));
    }

    /**
     * TODO 높이를 나타내는 음이 아닌 정수 n 개가 주어졌을때 각 막대의 너비는 1이고, 이후에 채울 수 있는 물의 양을 계산하라.
     * 예) input: [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1], output: 6
     */
    public int solution1(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int result = 0;
        int left = 0;
        int right = heights.length - 1;
        int leftMax = heights[left];
        int rightMax = heights[right];

        while (left < right) {
            if (leftMax <= rightMax) {
                result += leftMax - heights[left];
                left++;
                leftMax = Math.max(heights[left], leftMax);
            } else {
                result += rightMax - heights[right];
                right--;
                rightMax = Math.max(heights[right], rightMax);
            }
        }

        return result;
    }

    public int solution2(int[] heights) {
        int result = 0;
        if (heights == null || heights.length <= 2) {
            return result;
        }
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        int max = heights[0];
        left[0] = heights[0];

        for (int i = 1; i < heights.length; i++) {
            if (max < heights[i]) {
                left[i] = heights[i];
                max = heights[i];
            } else {
                left[i] = max;
            }
        }

        max = heights[heights.length - 1];
        right[heights.length - 1] = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            if (max < heights[i]) {
                right[i] = heights[i];
                max = heights[i];
            } else {
                right[i] = max;
            }
        }

        for (int i = 0; i < heights.length; i++) {
            result += Math.min(left[i], right[i]) - heights[i];
        }

        return result;
    }
}
