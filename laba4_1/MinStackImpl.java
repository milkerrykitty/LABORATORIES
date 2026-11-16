package laba4_1;


public class MinStackImpl implements MinStack<Integer> {

    private static class Node {
        int value;
        int min;
        Node next;

        public Node(int value, int min, Node next)
        {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }

    private Node head  = null;

    @Override
    public void push(Integer value)
    {
        int newMin;
        if (head == null)
            newMin = value;
        else
            newMin = Math.min(value,head.min);

        head = new Node(value, newMin, head);
    }

    @Override
    public Integer pop()
    {
        int pop = head.value;
        head = head.next;
        return pop;
    }

    @Override
    public Integer top()
    {
        return head.value;
    }

    @Override
    public Integer min()
    {
        // TODO
        return head.min;
    }
}