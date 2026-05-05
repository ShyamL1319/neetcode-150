class Solution {

    public String encode(List<String> strs) {
        return strs
        .stream()
        .map(s -> s.length() + "#" + s)
        .collect(Collectors.joining());
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            int separator = s.indexOf('#', i);
            int length = Integer.parseInt(s.substring(i, separator));
            i = separator + 1;
            
            result.add(s.substring(i, i + length));
            i += length;
        }
        return result;
    }
}
