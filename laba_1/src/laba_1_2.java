public int  removeElementInplace(int[] arr, int val)
{
    int number = 0;
    if(0 > arr.length || arr.length> 100)
    {
        return 0;
    }

    for(int i = 0; i < arr.length; i++)
    {
        if(arr[i] > 50 || arr[i] < 0)
        {
            return 0;
        }

        if(arr[i] != val)
        {
            arr[number] = arr[i];
            number++;
        }
    }
    return number;
}

void main()
{
    int [] arr = {1, 6, 5, 1, 0};
    int val = 1;
    int number = removeElementInplace(arr, val);
    System.out.print(number + ", arr = [");
    for(int i = 0; i < arr.length; i++)
    {
        if(i <= number-1)
        {
            System.out.print(arr[i]);
        }
        else
        {
            System.out.print("_");
        }
        if (i< arr.length-1){
            System.out.print(",");
        }
    }
    System.out.print("]");
}