package lapa6;

public class lapa6_1
{
    public static int findClosest(int[] arr, int target) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        for (; left <= right; )
        {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
            {
                return arr[mid];
            }
            else if (arr[mid] < target)
            {
                left = mid + 1;
            } else
            {
                right = mid - 1;
            }
        }

        if (right < 0)
        {
            return arr[0];
        }
        if (left >= n)
        {
            return arr[n - 1];
        }

        int leftDiff = Math.abs(arr[right] - target);
        int rightDiff = Math.abs(arr[left] - target);

        if (leftDiff <= rightDiff) {
            return arr[right];
        } else {
            return arr[left];
        }
    }
}
