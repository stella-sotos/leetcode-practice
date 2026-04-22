class Solution {
    public int findCircleNum(int[][] isConnected) {
        int prov = 1;
        boolean[] visited = new boolean[isConnected.length];
        Queue<Integer> toCheck = new LinkedList<>();
        toCheck.add(0);

        while (toCheck.size() != 0) {
            int index = toCheck.remove();
            if (!visited[index]) {
                visited[index] = true;
                int[] neighbors = isConnected[index];
                for (int n = 0; n < neighbors.length; n++) {
                    if (index == n || neighbors[n] == 0)
                        continue;

                    if (!visited[n]) {
                        toCheck.add(n);
                    }
                }
            }
            // done going through connected islands,
            // now go to an index that has not yet been visited and increment counter
            if (toCheck.size() == 0) {
                for (int i = 1; i < isConnected.length; i++) {
                    if (!visited[i]) {
                        toCheck.add(i);
                        prov++;
                        i = isConnected.length;
                    }
                }

            }
        }
        return prov;

    }
}