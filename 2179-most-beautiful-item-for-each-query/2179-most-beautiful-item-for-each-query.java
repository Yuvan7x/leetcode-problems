class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int[] results = new int[queries.length];
        Integer[] queryIndices = new Integer[queries.length];
        
        for (int i = 0; i < queries.length; i++) queryIndices[i] = i;
        Arrays.sort(queryIndices, (i, j) -> queries[i] - queries[j]);
        
        int maxBeauty = 0, itemIndex = 0;
        for (int q : queryIndices) {
            while (itemIndex < items.length && items[itemIndex][0] <= queries[q]) 
                maxBeauty = Math.max(maxBeauty, items[itemIndex++][1]);
            results[q] = maxBeauty;
        }
        return results;
    }
}
