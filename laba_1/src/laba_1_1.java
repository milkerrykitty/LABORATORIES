import java.util.Stack;

public class laba_1_1
{
    public boolean proverka(String str)
    {
        boolean result = true;
        Stack <Character> stack = new Stack<>();
        if(str.length() < 1 && str.length() > 10000)
            return false;

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) != '{' && str.charAt(i) != '(' && str.charAt(i) != '[' &&
                    str.charAt(i) != '}'&& str.charAt(i) != ')' && str.charAt(i) != ']')
                return false;
            if(str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[')
            {
                stack.push(str.charAt(i));
            }
            else if(stack.isEmpty() == false && str.charAt(i) == ')' && stack.peek() == '(')
            {
                stack.pop();
            }
            else if (stack.isEmpty() == false && str.charAt(i) == '}' && stack.peek() == '{')
            {
                stack.pop();
            }
            else if(stack.isEmpty() == false && str.charAt(i) == ']' && stack.peek() == '[')
            {
                stack.pop();
            }
            else
            {
                result = false;
            }
        }
        if(stack.isEmpty() == false)
        {
            result = false;
        }
        return result;
    }


    void main()
    {
        String str = "()";
        System.out.println(proverka(str) + " 😍");
    }
}