package laba4_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        MinStack<Integer> stack = new MinStackImpl();
        String line;


        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            tokenizer = new StringTokenizer(line);
            if (!tokenizer.hasMoreTokens()) continue;

            String command = tokenizer.nextToken();

            switch (command) {
                case "push":
                    int value = Integer.parseInt(tokenizer.nextToken());
                    stack.push(value);
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
                case "min":
                    System.out.println(stack.min());
                    break;
            }
        }
    }
}


