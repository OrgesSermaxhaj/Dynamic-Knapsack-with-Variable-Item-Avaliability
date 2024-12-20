# Dynamic Knapsack with Variable Item Availability

## Purpose of the Code

This program solves a variant of the **Knapsack Problem**, where items are available only during specific time intervals. The objective is to maximize the total value of items selected while considering:

1. **Knapsack Capacity**: Maximum weight the knapsack can carry.
2. **Item Availability Over Time**: Items appear and disappear based on their availability intervals.

---

## Key Features

### Dynamic Programming (DP)
- A 2D DP table (`dp`) is used to calculate the maximum achievable value for each time step and weight.
- The algorithm respects both weight and time constraints to ensure an optimal solution.

### Traceback for Solution Reconstruction
- A `traceback` table stores the indices of items selected at each time step.
- This allows reconstruction of the selected items contributing to the optimal value.

### User Input
- The user provides:
  - The number of items and their details: **value**, **weight**, **start time**, and **end time**.
  - The **maximum weight capacity** of the knapsack.
  - The **total time range** of the problem.

---

## Code Breakdown
### Dynamic Programming Table (dp)
The dp[t][w] table stores the maximum achievable value at time step t with a knapsack capacity of w.

- Initialization: The table is initialized to 0 since no value is achieved without items.
- Logic:
          - Iterate through each time step.
          - For each item available during the time step:
              - Check if including the item increases the value (dp[t][w - item.weight] + item.value).
              - Update dp[t][w] if including the item improves the value.

### Traceback Table
The traceback table keeps track of the selected items for the optimal solution.
- If including an item improves the value:
              - Add the item’s index to the list in traceback[t][w].


### Continuity Between Time Steps
To ensure that values from previous time steps are carried forward:
- The dp table propagates values from t-1 to t.


### Solution Extraction
After filling the dp table:
- Find the maximum value across all time steps and weights
- Reconstruct the selected items using the traceback table

---

## How to Use the Program
### Input
- Number of items (n).
- For each item: value, weight, start time, and end time.
- Maximum weight of the knapsack (maxWeight).
- Total time range (maxTime).
### Output
- Maximum achievable value.
- Time step when this value is achieved.
- Details of the selected items (value, weight, availability time).

---

## Example Input/Output
![image alt](https://github.com/OrgesSermaxhaj/Dynamic-Knapsack-with-Variable-Item-Avaliability/blob/14346ee0012912cc859251e0e1bada6fcb1a0fc1/screenshot2.PNG)

---

## Algorithm Summary
1. Dynamic Programming: Solve subproblems (max value at each time/weight).

2. Backtracking: Reconstruct the optimal solution from the traceback table.

3. Time Complexity: O(n x maxTime x maxWeight), where n is the number of items.
   
4. Space Complexity: O(maxTime x maxWeight) for the dp and traceback tables

---

## Conclusion
This program offers a robust solution for solving the dynamic knapsack problem with time-dependent item availability using dynamic programming. It ensures both optimality and clarity in reconstructing the selected items.



















              


