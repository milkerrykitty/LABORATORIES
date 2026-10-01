public int removeElementInplace(int[] arr, int val)
{
    if(arr.length < 100 && val > 0 && val < 100)
    {

    }
    int numbers = 0;
    for (int i = 0; i < arr.length; i++)
    {
        if (arr[i] < 50 && arr[i] >= 0)
        {
            if (arr[i] != val)
            {
                arr [numbers] = arr[i];
                numbers++;
            }
        }
    }
    return numbers;
}

void main()
{
    int[] arr = {1, 6, 7, 1, 0, 1};
    int val = 7;
    int numbers = removeElementInplace(arr,val);
    System.out.print(numbers + ", arr = [");
    for (int i = 0; i < arr.length; i++)
    {
        if(i < numbers)
        {
            System.out.print(arr[i]);
        }
        else
        {
            System.out.print("_" );
        }
        if(i < arr.length - 1) System.out.print(", ") ;
    }
    System.out.print("]");
}

