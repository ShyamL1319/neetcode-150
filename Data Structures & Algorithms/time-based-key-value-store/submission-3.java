class TimeMap {
    // Inner class to store value and timestamp together
    private static class Data {
        String value;
        int timestamp;

        Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Data> list = map.get(key);
        return binarySearch(list, timestamp);
    }

    private String binarySearch(List<Data> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value; // Potential candidate
                left = mid + 1;               // Try to find a more recent one
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}