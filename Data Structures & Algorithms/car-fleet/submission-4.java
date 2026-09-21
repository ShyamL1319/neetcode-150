class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Pair each car's position and speed
        int n = position.length; // Number of cars
        double[][] cars = new double[n][2]; // Array to hold position and time for each car
        for (int i = 0; i < n; i++) { // Loop through all cars
            cars[i][0] = position[i]; // Store position
            cars[i][1] = (double)(target - position[i]) / speed[i]; // Calculate time to reach target
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0])); // Sort cars by position descending

        int fleets = 0; // Initialize fleet count
        double lastTime = 0; // Track time of last fleet
        for (int i = 0; i < n; i++) { // Loop through sorted cars
            if (cars[i][1] > lastTime) { // If current car takes longer than last fleet
                fleets++; // New fleet is formed
                lastTime = cars[i][1]; // Update lastTime to current car's time
            }
        }
        return fleets; // Return total fleets
    }
}
