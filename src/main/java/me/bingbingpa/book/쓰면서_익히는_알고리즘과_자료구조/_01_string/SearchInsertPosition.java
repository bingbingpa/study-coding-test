package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._01_string;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println("result ============ " + solution2(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println("result ============ " + solution2(new int[]{1,4,5,6,}, 3));
    }

    /**
     * TODO 정렬된 배열과 목푯값(target)이 주어질 때 목푯값을 찾는다면 배열의 해당 인덱스를 반환하고, 찾지 못한다면 정렬된 배열이 되도록 목표값이 배열에 들어가야하는 인텍스를 구하라.
     * 예) input: [1,2,3,4,5] , target: 3, output: 2
     * input [1,4,5,6], target: 3, output: 1
     */
    public static int solution1(int[] nums, int target) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(1)
        int index = 0;
        int length = nums.length;
        while (index < length) {
            if (target <= nums[index]) {
                break;
            }
            index++;
        }
        return index;
    }

    public static int solution2(int[] nums, int target) {
        // 시간 복잡도: O(logN)
        // 공간 복잡도: O(1)
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == mid) {
                return mid;
            }

            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
