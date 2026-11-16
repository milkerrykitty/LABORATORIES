package laba3_3;

import java.util.List;

public class GenericInsertionSort<T extends Comparable<? super T>> implements Sorting<T> {
    @Override
    public void sort(List<T> nums) {

        if (nums == null || nums.size() <= 1) {
            return;
        }

        for (int i = 1; i < nums.size(); i++) {
            T current = nums.get(i);
            int j = i;

            while (j > 0 && nums.get(j - 1).compareTo(current) > 0) {
                nums.set(j, nums.get(j - 1));
                j--;
            }

            nums.set(j, current);
        }
    }
}