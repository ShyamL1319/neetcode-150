class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] arrayKey = str.toCharArray();
            Arrays.sort(arrayKey);
            String key = new String(arrayKey);
            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
