package sorting;

public class Heap {
    int[] heapArr;

    public Heap(final int[] array) {
        this.heapArr = array;
    }

    public int value(final int index) {
        return heapArr[index];
    }

    public int parentIndex(final int index) {
        return (int) Math.floor(index / 2);
    }

    public int leftChildIndex(final int index) {
        return 2 * index;
    }

    public int rightChildIndex(final int index) {
        return 2 * index + 1;
    }

    public void maxHeapify(final int index) {
        int left = leftChildIndex(index);
        int right = rightChildIndex(index);
        int largest = heapArr[index];
        if (heapArr[left] > heapArr[largest]) {
            largest = left;
        } else if (heapArr[right] > heapArr[largest]) {
            largest = right;
        }
        if (index != largest) {
            int temp = heapArr[index];
            heapArr[index] = heapArr[largest];
            heapArr[largest] = temp;
            maxHeapify(largest);
        }
    }

    public void minHeapify(final int index) {
        int left = leftChildIndex(index);
        int right = rightChildIndex(index);
        int smallest = heapArr[index];
        if (heapArr[left] < heapArr[smallest]) {
            smallest = left;
        } else if (heapArr[right] < heapArr[smallest]) {
            smallest = right;
        }
        if (index != smallest) {
            int temp = heapArr[index];
            heapArr[index] = heapArr[smallest];
            heapArr[smallest] = temp;
            maxHeapify(smallest);
        }
    }
}
