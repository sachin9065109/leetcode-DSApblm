class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);

        List<List<String>> ans = new ArrayList<>();

        String prefix = "";

        for (char ch : searchWord.toCharArray()) {

            prefix += ch;

            int idx = lowerBound(products, prefix);

            List<String> curr = new ArrayList<>();

            for (int i = idx; i < Math.min(idx + 3, products.length); i++) {

                if (products[i].startsWith(prefix))
                    curr.add(products[i]);
                else
                    break;
            }

            ans.add(curr);
        }

        return ans;
    }

    private int lowerBound(String[] products, String target) {

        int low = 0;
        int high = products.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (products[mid].compareTo(target) < 0)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}