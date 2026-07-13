class UndergroundSystem {

    class CheckInInfo {
        String station;
        int time;

        CheckInInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class RouteInfo {
        int totalTime;
        int trips;

        RouteInfo(int totalTime, int trips) {
            this.totalTime = totalTime;
            this.trips = trips;
        }
    }

    private Map<Integer, CheckInInfo> checkInMap;
    private Map<String, RouteInfo> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {

        checkInMap.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckInInfo info = checkInMap.get(id);

        String route = info.station + "-" + stationName;

        int travelTime = t - info.time;

        RouteInfo routeInfo = routeMap.getOrDefault(route,
                new RouteInfo(0, 0));

        routeInfo.totalTime += travelTime;

        routeInfo.trips++;

        routeMap.put(route, routeInfo);

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "-" + endStation;

        RouteInfo info = routeMap.get(route);

        return (double) info.totalTime / info.trips;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */