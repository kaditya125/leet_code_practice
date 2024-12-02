class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
         ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(sentence.split(" ")));

         for(int i =0;i<wordsList.size();i++)
         {
            if(wordsList.get(i).startsWith(searchWord))
            {
                return i+1;
            }
         }

         return -1;
    }
}