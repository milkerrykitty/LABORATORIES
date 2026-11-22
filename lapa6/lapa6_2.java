package lapa6;

public class lapa6_2
{
    public long diplom (long n , long w , long h)
    {
        long left = 1;
        long right = Math.max(w, h) * n;

        while (left < right)
        {
            long mid = left + (right - left) / 2;

            long colonkis = mid / w;
            long stroki = mid / h;
            if (colonkis * stroki >= n)
                right = mid;
            else
                left = mid + 1;

        }
        return left;
    }
}
