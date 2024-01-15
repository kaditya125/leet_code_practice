class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap<>();
        Map<Integer, Boolean> hasPlayed = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);
            hasPlayed.put(winner, true);
            hasPlayed.put(loser, true);
        }

        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int player : hasPlayed.keySet()) {
            int losses = lossCount.getOrDefault(player, 0);

            if (losses == 0) {
                noLoss.add(player);
            } else if (losses == 1) {
                oneLoss.add(player);
            }
        }

        // Sort the lists in increasing order
        noLoss.sort(null);
        oneLoss.sort(null);

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(noLoss);
        answer.add(oneLoss);

        return answer;
    }
}