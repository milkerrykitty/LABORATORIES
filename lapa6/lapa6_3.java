package lapa6;

public class lapa6_3
{
    public static double findX (double a)
    {
        double left = 1;
        double right = 1000000;

        while (right - left > 1e-9)
        {
            double mid = left + (right - left) / 2;
            double primer = mid * mid - mid + Math.sqrt(mid);
            if (primer < a)
                left = mid;
            else if (primer >= a)
                right = mid;

        }
        return left;
    }
}
