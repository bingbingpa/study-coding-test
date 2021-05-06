package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._01_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println("result ============== " + solution(new int[]{1, 3, 5, 7,}, new int[]{2, 4, 8}));
    }

    /**
     * TODO 정렬된 2개의 배열(nums1, nums2)을 정렬을 유지하면서 nums1 배열부터 채워나가 nums2 까지 확장하라.
     * nums1 의 크리는 m+n 크기만큼 공간이 있지 않다.
     * 추가 배열 할당 없이 문제를 해결해야 한다.
     * nums1 배열에 nums1 과 nums2 의 모든 요소를 작은 수부터 채워나가고 nums2 에는 나머지를 정렬을 유지하며 넣는다.
     * 예) nums1: [1,3,5,7,], nums2: [2,4,8], output: [1,2,3,4],[5,7,8]
     */
    public static List<String> solution(int[] nums1, int[] nums2) {
        // 시간 복잡도: O(mn)
        // 공간 복잡도: O(1)
        List<String> result = new ArrayList<>();
        for (var i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;

                for (var j = 1; j < nums2.length; j++) {
                    if (temp <= nums2[j]) {
                        nums2[j - 1] = temp;
                        break;
                    }
                    nums2[j - 1] = nums2[j];
                }
            }
        }
        result.add(Arrays.toString(nums1));
        result.add(Arrays.toString(nums2));

        return result;
    }
}
