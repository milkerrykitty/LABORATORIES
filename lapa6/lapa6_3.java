package lapa6;

public class lapa6_3
{
    public static double findingX(double a)
    {
        double left = 1;
        double right = 1000000;

        while (right - left > 0.000000001)
        {
            double mid = left + (right - left) / 2;
            double result = mid * mid - mid + Math.sqrt(mid);
            if (result < a)
                left = mid;
            else
                right = mid;
        }
        return left;
    }
}
