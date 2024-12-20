import java.util.*;

public class DynamicKnapsackWithAvailability {
    static class Item {
        int value;
        int weight;
        int startTime;
        int endTime;

        Item(int value, int weight, int startTime, int endTime) {
            this.value = value;
            this.weight = weight;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static int maximizeValueWithTime(int maxWeight, List<Item> items, int maxTime) {

        int[][] dp = new int[maxTime + 1][maxWeight + 1];


        List<Integer>[][] traceback = new ArrayList[maxTime + 1][maxWeight + 1];
        for (int t = 0; t <= maxTime; t++) {
            for (int w = 0; w <= maxWeight; w++) {
                traceback[t][w] = new ArrayList<>();
            }
        }


        for (int t = 0; t <= maxTime; t++) {
            for (Item item : items) {

                if (item.startTime <= t && item.endTime >= t) {

                    for (int w = maxWeight; w >= item.weight; w--) {
                        if (dp[t][w - item.weight] + item.value > dp[t][w]) {
                            dp[t][w] = dp[t][w - item.weight] + item.value;
                            traceback[t][w] = new ArrayList<>(traceback[t][w - item.weight]);
                            traceback[t][w].add(items.indexOf(item));
                        }
                    }
                }
            }

            if (t > 0) {
                for (int w = 0; w <= maxWeight; w++) {
                    if (dp[t - 1][w] > dp[t][w]) {
                        dp[t][w] = dp[t - 1][w];
                        traceback[t][w] = new ArrayList<>(traceback[t - 1][w]);
                    }
                }
            }
        }


        int maxValue = 0;
        int bestTime = 0;
        int bestWeight = 0;
        for (int t = 0; t <= maxTime; t++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (dp[t][w] > maxValue) {
                    maxValue = dp[t][w];
                    bestTime = t;
                    bestWeight = w;
                }
            }
        }


        System.out.println("Maximum achievable value: " + maxValue);
        System.out.println("Achieved at time step: " + bestTime);
        System.out.println("Selected items: ");
        for (int itemIndex : traceback[bestTime][bestWeight]) {
            Item item = items.get(itemIndex);
            System.out.println("Item with value " + item.value + ", weight " + item.weight + ", available from " + item.startTime + " to " + item.endTime);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of items:");
        int n = scanner.nextInt();

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter value, weight, start time, and end time for item " + (i + 1) + ":");
            int value = scanner.nextInt();
            int weight = scanner.nextInt();
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            items.add(new Item(value, weight, startTime, endTime));
        }

        System.out.println("Enter the maximum weight of the knapsack:");
        int maxWeight = scanner.nextInt();

        System.out.println("Enter the total time range:");
        int maxTime = scanner.nextInt();

        maximizeValueWithTime(maxWeight, items, maxTime);

        scanner.close();
    }
}