class Solution {

    static class Edge {
        String to;
        double rate;

        Edge(String t, double r) {
            to = t;
            rate = r;
        }
    }

    public double maxAmount(String initialCurrency,
                            List<List<String>> pairs1,
                            double[] rates1,
                            List<List<String>> pairs2,
                            double[] rates2) {

        Map<String, List<Edge>> g1 = buildGraph(pairs1, rates1);
        Map<String, List<Edge>> g2 = buildGraph(pairs2, rates2);

        Map<String, Double> day1 = new HashMap<>();
        dfs(initialCurrency, 1.0, g1, day1);

        Map<String, Double> day2 = new HashMap<>();
        dfs(initialCurrency, 1.0, g2, day2);

        double ans = 1.0;

        for (String cur : day1.keySet()) {
            if (day2.containsKey(cur)) {
                ans = Math.max(ans,
                        day1.get(cur) / day2.get(cur));
            }
        }

        return ans;
    }

    private Map<String, List<Edge>> buildGraph(List<List<String>> pairs,
                                               double[] rates) {

        Map<String, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < pairs.size(); i++) {

            String u = pairs.get(i).get(0);
            String v = pairs.get(i).get(1);

            double r = rates[i];

            graph.computeIfAbsent(u, k -> new ArrayList<>())
                    .add(new Edge(v, r));

            graph.computeIfAbsent(v, k -> new ArrayList<>())
                    .add(new Edge(u, 1.0 / r));
        }

        return graph;
    }

    private void dfs(String cur,
                     double amount,
                     Map<String, List<Edge>> graph,
                     Map<String, Double> value) {

        value.put(cur, amount);

        if (!graph.containsKey(cur))
            return;

        for (Edge next : graph.get(cur)) {

            if (value.containsKey(next.to))
                continue;

            dfs(next.to,
                    amount * next.rate,
                    graph,
                    value);
        }
    }
}