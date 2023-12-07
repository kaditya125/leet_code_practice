class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                } else if (words[i].contains(words[j])) {
                    result.add(words[j]);
                }
            }
        }

        return new ArrayList<>(result);
    }
}