class RecentCounter {
    /*
    이게뭐야~
    큐 자료구조도 확인해보고,
    */
    private int[] queue;
    private int start, end, size;

    public RecentCounter() {
        queue = new int[10000]; 
        start = 0;
        end = 0;
        size = 0;
    }

    public int ping(int t) {
        while (size > 0 && queue[start] < t - 3000) {
            start = (start + 1) % queue.length;
            size--;
        }
        queue[end] = t;
        end = (end + 1) % queue.length;
        size++;
        return size;
    }
}


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */