# Introduction
We need to create a UPPAAL model for Dekker’s algorithm, a concurrent programming algorithm for mutual exclusion, according to the specifications. And we are also required to verify the correctness of the algorithm by formalizing three properties in temporal logic.

# UPPAAL model
**URL to our model:** [https://github.com/McGill-ECSE429-Fall2022/assignment-3-asgn-10/blob/main/UPPAAL_V1.xml](https://github.com/McGill-ECSE429-Fall2022/assignment-3-asgn-10/blob/main/UPPAAL_V1.xml)

## Screenshot
![Model](https://github.com/McGill-ECSE429-Fall2022/assignment-3-asgn-10/blob/main/Image/Model.png)

## Explanation 
> See the URL above for implementation details.

We are asked to implement the Dekker's mutual exclusion algorithm for N process. The model starts with an idle state. The model checks if the current process can enter the critical session. The process will enter critical state if the current process is true, and no other process is running. If current process is false and other process is running, the current process is going to wait status. While current process is in wait status, if there is no other process running. The current process will enter critical status. We have implemented a method ```is_other_running``` to check if there is other process running


# Properties in Temporal Logic
### 1. The system is deadlock free.
we just use ```A[] not deadlock``` to ensure there is no deadlock in our model at all, and obtain meaningful results.
### 2. Mutual exclusion is enforced.
we use ```A[] not(Process3.critical and Process2.critical)```, ```A[] not(Process1.critical and Process3.critical)```, ```A[] not(Process1.critical and Process2.critical)``` to check the mutual exclusion is satisfied, which means there cannot be more than one process reaching the critical section at one time, and obtain meaningful results.
### 3. The critical section is reachable for some processes.
we use ```E<> Process3.critical```, ```E<> Process2.critical```, ```E<> Process1.critical``` to check if all processes can reach the critical section and obtain meaningful results.<br>

![Property logic](https://github.com/McGill-ECSE429-Fall2022/assignment-3-asgn-10/blob/main/Image/property%20logic.png)

# Verification Results
We conformed both constraints and checked the "deadlock free", "mutual exclusion" and "critical section reachable" cases. All these properties have been satisfied as below. In short, our model is implemented correctly.<br>

![Verification result](https://github.com/McGill-ECSE429-Fall2022/assignment-3-asgn-10/blob/main/Image/verification%20success.png)

# Conclusions
In this assignment, we learn how the processor deal with the interaction between multiple processes through Dekker’s mutual exclusion algorithm. By using UPPAAL Model Checker, we simulated three processes and created our model following two listed constraints. Then we verified the correctness of the algorithm with three basic properties in temporal logic and finally we got all positive feedbacks. In summary, Dekker’s algorithm is a great solution that handles the mutual exclusion problem in concurrent programming where processes communicate only through shared memory, and we realized a correct model.
