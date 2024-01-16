class RandomizedSet {

    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false; // Element already exists in the set
        }

        // Add the element to the end of the ArrayList
        list.add(val);

        // Put the element and its index in the HashMap
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // Element doesn't exist in the set
        }

        // Get the index of the element to be removed
        int indexToRemove = map.get(val);

        // Swap the element to be removed with the last element in the ArrayList
        int lastElement = list.get(list.size() - 1);
        list.set(indexToRemove, lastElement);
        map.put(lastElement, indexToRemove);

        // Remove the last element from the ArrayList
        list.remove(list.size() - 1);

        // Remove the element from the HashMap
        map.remove(val);

        return true;
    }

    public int getRandom() {
        // Generate a random index within the size of the ArrayList
        int randomIndex = random.nextInt(list.size());

        // Return the element at the randomly generated index
        return list.get(randomIndex);
    }
}