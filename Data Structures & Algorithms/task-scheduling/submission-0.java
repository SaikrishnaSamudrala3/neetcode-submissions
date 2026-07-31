class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }


        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : map.values()) {
            maxHeap.offer(freq);
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll() - 1);
                }
            }

            for (int freq : temp) {
                if (freq > 0) {
                    maxHeap.offer(freq);
                }
            }

            if (maxHeap.isEmpty()) {
                time += temp.size();
            } else {
                time += (n + 1);
            }
        }

        return time;
    }
}