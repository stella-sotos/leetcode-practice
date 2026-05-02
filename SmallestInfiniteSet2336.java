class SmallestInfiniteSet {
    PriorityQueue<Integer> q;
    Integer addedUpTo;

    public SmallestInfiniteSet() {
        q = new PriorityQueue<Integer>();
        addedUpTo = 10;
        addMore(0);
    }

    private void addMore(int start) {
        for (int i = start + 1; i <= addedUpTo; i++) {
            q.add(i);
        }
    }

    public int popSmallest() {
        int ret = q.remove();
        if (q.isEmpty()) {
            int start = addedUpTo;
            addedUpTo *= 2;
            addMore(start);

        }
        return ret;

    }

    public void addBack(int num) {
        if (num > addedUpTo) {
            int start = addedUpTo;
            addedUpTo = num * 2;

            addMore(start);
        } else if (!q.contains(num)) {
            q.add(num);
        }

    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */