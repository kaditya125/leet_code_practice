class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
         boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        // Mark direct prerequisites
        for (int[] prereq : prerequisites) {
            isPrerequisite[prereq[0]][prereq[1]] = true;
        }

        // Apply Floyd-Warshall algorithm for transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isPrerequisite[i][k] && isPrerequisite[k][j]) {
                        isPrerequisite[i][j] = true;
                    }
                }
            }
        }

        // Answer each query based on the transitive closure matrix
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPrerequisite[query[0]][query[1]]);
        }

        return result;
    }
}