package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 시간 초과 ㅠㅠ
 */
public class MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {
        new MinimumOperationsToReduceXToZero();
    }

    public int minOperations(int[] nums, int x) {
        int lastindex = nums.length - 1;
        int index = 0;

        Queue<Info> infoQueue = new LinkedList<>();
        infoQueue.add(new Info(1, x - nums[0], 1, lastindex));
        infoQueue.add(new Info(1, x - nums[lastindex], 0, lastindex - 1));
        while (!infoQueue.isEmpty()) {
            Info info = infoQueue.poll();
            index++;

            if (info.remainder == 0) {
                return info.count;
            }

            if (info.remainder < 0) {
                continue;
            }

            if (info.leftIndex >= nums.length || info.rightIndex <= 0) {
                continue;
            }

            infoQueue.add(new Info(
                    info.count + 1,
                    info.remainder - nums[info.leftIndex],
                    info.leftIndex + 1,
                    info.rightIndex
            ));

            infoQueue.add(new Info(
                    info.count + 1,
                    info.remainder - nums[info.rightIndex],
                    info.leftIndex,
                    info.rightIndex - 1
            ));
        }

        return -1;
    }

    class Info {
        int count;
        int remainder;
        int leftIndex;
        int rightIndex;

        Info(int count, int remainder, int leftIndex, int rightIndex) {
            this.count = count;
            this.remainder = remainder;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }
}
