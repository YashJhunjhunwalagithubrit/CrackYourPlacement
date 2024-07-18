class InsertDeleteGetRandomO(1)-Duplicatesallowed{
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> valToIndices;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        valToIndices = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = valToIndices.containsKey(val);
        if (!contains) {
            valToIndices.put(val, new LinkedHashSet<>());
        }
        valToIndices.get(val).add(nums.size());
        nums.add(val);
        return !contains;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!valToIndices.containsKey(val) || valToIndices.get(val).isEmpty()) {
            return false;
        }

        // Get an index of the element to remove
        int indexToRemove = valToIndices.get(val).iterator().next();
        valToIndices.get(val).remove(indexToRemove);

        // If it's not the last element, swap it with the last one
        if (indexToRemove != nums.size() - 1) {
            int lastVal = nums.get(nums.size() - 1);
            nums.set(indexToRemove, lastVal);
            valToIndices.get(lastVal).remove(nums.size() - 1);
            valToIndices.get(lastVal).add(indexToRemove);
        }

        nums.remove(nums.size() - 1);
        if (valToIndices.get(val).isEmpty()) {
            valToIndices.remove(val);
        }

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
