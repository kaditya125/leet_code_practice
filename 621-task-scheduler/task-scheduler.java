import java.util.HashMap;
import java.util.Map;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];

        // Count occurrences of each task
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }

        // Sort tasks based on occurrences in descending order
        Arrays.sort(taskCount);

        // Calculate the number of units of time needed for each task
        int maxCount = taskCount[25] - 1;
        int idleSlots = maxCount * n;

        // Fill idle slots with other tasks
        for (int i = 24; i >= 0 && taskCount[i] > 0; i--) {
            idleSlots -= Math.min(taskCount[i], maxCount);
        }

        // Total time needed
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
