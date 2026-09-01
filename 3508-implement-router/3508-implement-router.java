class Router {

    private static class Packet {
        int source;
        int destination;
        int timestamp;

        Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Packet)) {
                return false;
            }

            Packet other = (Packet) obj;

            return source == other.source
                    && destination == other.destination
                    && timestamp == other.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

    private static class DestinationData {
        ArrayList<Integer> timestamps = new ArrayList<>();
        int head = 0;
    }

    private int memoryLimit;

    private Queue<Packet> queue;
    private HashSet<Packet> set;

    private HashMap<Integer, DestinationData> map;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;

        queue = new ArrayDeque<>();
        set = new HashSet<>();
        map = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {

        Packet packet = new Packet(source, destination, timestamp);

        if (set.contains(packet)) {
            return false;
        }

        queue.offer(packet);
        set.add(packet);

        DestinationData data = map.get(destination);

        if (data == null) {
            data = new DestinationData();
            map.put(destination, data);
        }

        data.timestamps.add(timestamp);

        if (queue.size() > memoryLimit) {
            removeOldest();
        }

        return true;
    }

    public int[] forwardPacket() {

        if (queue.isEmpty()) {
            return new int[0];
        }

        Packet packet = removeOldest();

        return new int[]{
            packet.source,
            packet.destination,
            packet.timestamp
        };
    }

    public int getCount(int destination, int startTime, int endTime) {

        DestinationData data = map.get(destination);

        if (data == null) {
            return 0;
        }

        ArrayList<Integer> list = data.timestamps;
        int left = data.head;

        if (left >= list.size()) {
            return 0;
        }

        int first = lowerBound(list, left, startTime);
        int last = upperBound(list, left, endTime);

        return last - first;
    }

    private Packet removeOldest() {

        Packet packet = queue.poll();

        set.remove(packet);

        DestinationData data = map.get(packet.destination);

        data.head++;

        return packet;
    }

    private int lowerBound(ArrayList<Integer> list, int left, int target) {

        int low = left;
        int high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int upperBound(ArrayList<Integer> list, int left, int target) {

        int low = left;
        int high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */