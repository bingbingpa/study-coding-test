package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._01_string;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        System.out.println("result ============ " + Arrays.toString(solution2(new int[]{1, 2, 3,}, 3, new int[]{}, 0)));
        System.out.println("result ============ " + Arrays.toString(solution2(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{4, 5, 6}, 3)));
        System.out.println("result ============ " + Arrays.toString(solution2(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3)));
    }

    /**
     * TODO 주어진 정렬된 두 배열(nums1, nums2)을 정렬을 유지하면서 병합하라.
     * nums1 과 nums2 의 각각의 크기는 m 과 n 개의 요소로 초기화 되어 있다.
     * nums1 은 nums1 과 nums2 를 병합하기에 충분한 크기로 할당되어 있다(m+n)개
     * 예) nums1: [1,2,3], m:3, nums2: [], n:0 // output: [1,2,3]
     * nums1: [1,2,3,0,0,0], m:3, nums2: [4,5,6], n:3 // output: [1,2,3,4,5,6]
     * nums1: [4,5,6,0,0,0], m:3, nums2: [1,2,3], n:3 // output: [1,2,3,4,5,6]
     */
    public static int[] solution1(int[] nums1, int m, int[] nums2, int n) {
        // 시간 복잡도: O(NlogN)
        // 공간 복잡도: O(N)
        int length = nums1.length;
        for (int i = m; i < length; i++) {
            nums1[i] = nums2[i - n];
        }

        Arrays.sort(nums1);

        return nums1;
    }


    public static int[] solution2(int[] nums1, int m, int[] nums2, int n) {
        // 시간 복잡도: O(N+M)
        // 공간 복잡도: O(1)
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
        return nums1;
    }
}
