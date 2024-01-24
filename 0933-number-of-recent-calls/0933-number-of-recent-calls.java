class RecentCounter {
    /*
    이게뭐야~
    큐 자료구조도 확인해보고,
    */
    private int[] queue;
    private int start, end, size, capacity;

    public RecentCounter() {
        capacity = 3000; 
        queue = new int[capacity];
        start = 0;
        end = 0;
        size = 0;
    }

    private void resizeIfNeeded() {
        if (size < capacity) {
            return;
        }
        int[] newQueue = new int[capacity * 2];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(start + i) % capacity];
        }
        queue = newQueue;
        start = 0;
        end = size;
        capacity *= 2;
    }

    public int ping(int t) {

        resizeIfNeeded();

        queue[end] = t;
        end = (end + 1) % capacity;
        size++;


        while (queue[start] < t - 3000) {
            start = (start + 1) % capacity;
            size--;
        }

        return size;
    }

}


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */