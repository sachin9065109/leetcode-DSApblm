class Solution {

    public List<List<String>> displayTable(List<List<String>> orders) {

        TreeSet<String> foods = new TreeSet<>();

        TreeMap<Integer, Map<String, Integer>> tables = new TreeMap<>();

        for (List<String> order : orders) {

            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);

            foods.add(food);

            tables.putIfAbsent(table, new HashMap<>());

            Map<String, Integer> map = tables.get(table);

            map.put(food, map.getOrDefault(food, 0) + 1);
        }

        List<List<String>> ans = new ArrayList<>();

        List<String> header = new ArrayList<>();
        header.add("Table");

        for (String food : foods)
            header.add(food);

        ans.add(header);

        for (int table : tables.keySet()) {

            List<String> row = new ArrayList<>();

            row.add(String.valueOf(table));

            Map<String, Integer> map = tables.get(table);

            for (String food : foods) {
                row.add(String.valueOf(map.getOrDefault(food, 0)));
            }

            ans.add(row);
        }

        return ans;
    }
}