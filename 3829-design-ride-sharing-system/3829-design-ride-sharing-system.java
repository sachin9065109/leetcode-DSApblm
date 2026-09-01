class RideSharingSystem {

    private Queue<Integer> riders;
    private Queue<Integer> drivers;
    private HashSet<Integer> activeRiders;

    public RideSharingSystem() {
        riders = new LinkedList<>();
        drivers = new LinkedList<>();
        activeRiders = new HashSet<>();
    }

    public void addRider(int riderId) {
        riders.offer(riderId);
        activeRiders.add(riderId);
    }

    public void addDriver(int driverId) {
        drivers.offer(driverId);
    }

    public int[] matchDriverWithRider() {

        while (!riders.isEmpty() && !activeRiders.contains(riders.peek())) {
            riders.poll();
        }

        if (riders.isEmpty() || drivers.isEmpty()) {
            return new int[]{-1, -1};
        }

        int riderId = riders.poll();
        int driverId = drivers.poll();

        activeRiders.remove(riderId);

        return new int[]{driverId, riderId};
    }

    public void cancelRider(int riderId) {
        if (activeRiders.contains(riderId)) {
            activeRiders.remove(riderId);
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */