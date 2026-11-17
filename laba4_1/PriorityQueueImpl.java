package laba4_2;
import java.util.ArrayList;
import java.util.List;

public class PriorityQueueImpl implements PriorityQueue<Integer> {

    private static class HeapItem 
    {
        long operation;
        Integer value;

        HeapItem(long operation, Integer value) 
      {
            this.operation = operation;
            this.value = value;
        }
    }

    private final List<HeapItem> heap = new ArrayList<>();
    private final List<Integer> pos = new ArrayList<>();
    private long operationCounter = 0;

    public PriorityQueueImpl() {
        pos.add(-1); 
    }

    @Override
    public void enqueue(Integer value) {
        operationCounter++;
        HeapItem newItem = new HeapItem(operationCounter, value);

        int currentIndex = heap.size();
        heap.add(newItem);
        pos.add(currentIndex); 

        siftUp(currentIndex);
    }

    @Override
    public Integer dequeueMax() {
        if (heap.isEmpty()) {
            System.out.println("*");
            return null;
        }

        HeapItem maxItem = heap.get(0);
        System.out.println(maxItem.operation + " " + maxItem.value);

        int lastIndex = heap.size() - 1;
        if (lastIndex > 0) {
            swap(0, lastIndex); 
        }

        heap.remove(lastIndex); 
        pos.set((int) maxItem.operation, -1); 

        if (!heap.isEmpty()) {
            siftDown(0); 
        }

        return maxItem.value;
    }

    @Override
    public void increment(long operation, Integer addition) {
        if (operation <= 0 || operation >= pos.size()) {
            return;
        }

        int indexInHeap = pos.get((int) operation);
        if (indexInHeap == -1) {
            return; 
        }

        HeapItem item = heap.get(indexInHeap);
        item.value += addition;
        siftUp(indexInHeap);
        siftDown(pos.get((int) operation));
    }

    private void siftUp(int index) 
  {
        while (index > 0) 
        {
            int parent = (index - 1) / 2;
            if (heap.get(index).value > heap.get(parent).value) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void siftDown(int index) {
        int size = heap.size();
        while (2 * index + 1 < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = left;

            if (right < size && heap.get(right).value > heap.get(left).value) {
                largest = right;
            }

            if (heap.get(index).value >= heap.get(largest).value) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) 
  {
        HeapItem itemI = heap.get(i);
        HeapItem itemJ = heap.get(j);

        heap.set(i, itemJ);
        heap.set(j, itemI);
        pos.set((int) itemJ.operation, i);
        pos.set((int) itemI.operation, j);
    }
}
