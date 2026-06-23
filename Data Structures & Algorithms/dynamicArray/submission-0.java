class DynamicArray {

    private int[] arr;
    private int size;
    private int capacity;

    // Constructor
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }

    // Get element at index i
    public int get(int i) {
        return arr[i];
    }

    // Set element at index i
    public void set(int i, int n) {
        arr[i] = n;
    }

    // Add element at end
    public void pushback(int n) {
        // If full, resize first
        if (size == capacity) {
            resize();
        }

        arr[size] = n;
        size++;
    }

    // Remove and return last element
    public int popback() {
        int value = arr[size - 1];
        size--;
        return value;
    }

    // Double the capacity
    public void resize() {
        capacity = capacity * 2;
        int[] newArr = new int[capacity];

        // Copy old elements
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    // Return current size
    public int getSize() {
        return size;
    }

    // Return current capacity
    public int getCapacity() {
        return capacity;
    }
}
