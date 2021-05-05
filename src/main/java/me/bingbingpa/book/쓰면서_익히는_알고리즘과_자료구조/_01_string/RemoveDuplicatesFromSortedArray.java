package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._01_string;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 1, 2, 2, 2};
        System.out.println("result =============== " + solution(nums));
    }

    /**
     * TODO 정렬된 배열의 요소들을 중복 없이 단 1번씩만 가질 수 있도록 주어진 배열을 그대로(inPlace) 수정하고, 수정된 배열의 새로운 길이를 반환하라.
     * 예) input: [0,0,0,1,2,2,], output: 3
     */
    public static int solution(int[] nums) {
        // 시간 복잡도: O(n)
        // 공간 복잡도: O(1)
        if (nums.length <= 0) {
            return 0;
        }
        int curr = nums[0];
        int cnt = 1;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (curr != nums[i]) {
                curr = nums[i];
                nums[cnt] = curr;
                cnt++;
            }
        }

        return cnt;
    }
}
