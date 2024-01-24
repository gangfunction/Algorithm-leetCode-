class RecentCounter {
    /*
    이게뭐야~
    큐 자료구조도 확인해보고,
    */
    private Queue<Integer> requests;
    public RecentCounter() {
       requests = new LinkedList<>();
    }
    
    public int ping(int t) {
        requests.add(t);
        while (!requests.isEmpty()&&requests.peek() < t - 3000) {
            requests.poll();
        }
        return requests.size();
    }
}


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */