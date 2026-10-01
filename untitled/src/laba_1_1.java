import java.util.Stack;

public boolean proverka(String stroka)
{
    boolean result = true;
    if (stroka.length() < 1 || stroka.length() > 10000)
        result = false;
    else
    {
        Stack<Character>stack = new Stack<>();
        for(int i = 0; i < stroka.length(); i++)
        {
            char symbol = stroka.charAt(i);
            if (symbol == '{' || symbol == '[' || symbol == '(' || symbol == ')' || symbol == ']' || symbol == '}')
            {
                if (symbol == '{' || symbol == '[' || symbol == '(')
                    stack.push(symbol);
                else
                {
                    if (stack.isEmpty() == false && symbol == ')' && stack.peek() == '(')
                        stack.pop();
                    else if (stack.isEmpty() == false && symbol == '}' && stack.peek() == '{')
                        stack.pop();
                    else if (stack.isEmpty() == false && symbol == ']' && stack.peek() == '[')
                        stack.pop();
                    else result = false;
                }
            }
        }
        if (stack.isEmpty() == false) result = false;
    }
    return result;
}

void main()
{
    String stroka = "([{}])";
    System.out.print(proverka(stroka));
}