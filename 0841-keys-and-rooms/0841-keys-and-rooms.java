class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();

        boolean[] vis = new boolean[n];

        dfs(0, rooms, vis);

        for (boolean x : vis) {
            if (!x)
                return false;
        }

        return true;
    }

    private void dfs(int room,
                     List<List<Integer>> rooms,
                     boolean[] vis) {

        vis[room] = true;

        for (int key : rooms.get(room)) {

            if (!vis[key])
                dfs(key, rooms, vis);
        }
    }
}