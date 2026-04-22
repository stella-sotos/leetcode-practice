class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> toVisit = new LinkedList<>();
        toVisit.add(0);
        while (toVisit.size() != 0) {
            int visiting = toVisit.remove();
            visited[visiting] = true;
            List<Integer> keys = rooms.get(visiting);

            for (int k : keys) {
                if (visited[k] == false) {
                    toVisit.add(k);
                }
            }

        }
        for (boolean b : visited) {
            if (b == false) {
                return false;
            }
        }
        return true;

    }
}