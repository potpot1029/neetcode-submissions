class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] inDeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0], to = prerequisites[i][1];
            graph[from].add(to);
            inDeg[to]++;
        }


        Deque<Integer> stack = new ArrayDeque();
        int added = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) stack.push(i);
        }

        while (!stack.isEmpty()) {
            int node = stack.pop();
            added++;
            for (int to : graph[node]) {
                inDeg[to]--;
                if (inDeg[to] == 0) stack.push(to);
            }
        }

        return numCourses == added;
    }
}
