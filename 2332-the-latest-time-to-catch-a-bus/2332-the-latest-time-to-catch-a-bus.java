class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int passengerIndex = 0;
        int lastBoarded = -1;

        for (int busIndex = 0; busIndex < buses.length; busIndex++) {
            int count = 0;

            while (passengerIndex < passengers.length &&
                   passengers[passengerIndex] <= buses[busIndex] &&
                   count < capacity) {
                lastBoarded = passengers[passengerIndex];
                passengerIndex++;
                count++;
            }

            if (busIndex == buses.length - 1) {
                if (count < capacity) {
                    int time = buses[busIndex];

                    while (contains(passengers, time)) {
                        time--;
                    }

                    return time;
                } else {
                    int time = lastBoarded - 1;

                    while (contains(passengers, time)) {
                        time--;
                    }

                    return time;
                }
            }
        }

        return -1;
    }

    private boolean contains(int[] passengers, int time) {
        return Arrays.binarySearch(passengers, time) >= 0;
    }
}