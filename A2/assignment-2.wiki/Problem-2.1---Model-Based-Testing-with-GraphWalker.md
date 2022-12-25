# Introduction
In this assignment, we need to find potential issues in the cruise control system. According to the specifications, we apply our defined statemachine model into Graphwalker, a model-based testing tool, and then we analyse its states and transitions by running tests to detect problems.

# Maven Instructions
run ```mvn clean``` to clean our maven project.\
run ```mvn install``` after adding the JSON file to the project.\
run ```mvn graphwalker:generate-sources``` to generate the source code from the JSON file.\
run ```mvn graphwalker:test``` after finishing the test methods to run the test runs.
# Screenshot of Statemachine Models

## Initial Model  
[Initial Model JSON File: V0](https://github.com/McGill-ECSE429-Fall2022/assignment-2-asgn-10/blob/main/gw_graphs/v0.json)
- In the initial design of the state machine model, we tried to match everything mentioned in the SUT description document. We didn't consider any sneak path so that we can confirm if the model works following the description.
![image](https://user-images.githubusercontent.com/32471983/201532716-31201728-5da0-4e5b-ac2d-c8eab35c4ea3.png)

## Fault Model
[Fault Model JSON File: V1](https://github.com/McGill-ECSE429-Fall2022/assignment-2-asgn-10/blob/main/gw_graphs/v1.json)
> This model captures all possible transitions.
- Then, we modified the initial model to include all sneak paths. This is to see if there are any unexpected state transitions happening when some event takes place. This model actually was able to reveal an issue, it is more detailly explained in the later section.
![image](https://user-images.githubusercontent.com/32471983/201532738-65dce417-a085-4be9-8813-0af89044dbe2.png)

## Final Model 
[Final Model JSON File: V2](https://github.com/McGill-ECSE429-Fall2022/assignment-2-asgn-10/blob/main/gw_graphs/v2.json)
> This model builds and checks all steps except issues found by the fault model.

- Finally, we removed the sneak path that found an issue and continued with the remaining model. This is to check if there are any more issues that were hidden by the previous issue.
![final](https://user-images.githubusercontent.com/34031806/202236656-1c839779-e105-4153-a0fa-c8b0d2bfb24f.png)

# Screenshot of the Testrun Output
## Test run output with Fault Model 
We can observe that there are 2 vertices that were not visited: v_cc_deactivated and v_cc_off.  
![image](https://user-images.githubusercontent.com/32471983/201532910-8c8a48ec-a78e-4d30-a775-00c6d30a18a0.png)

## Test run output with Final Model
![image](https://user-images.githubusercontent.com/32471983/201532924-e56763dc-94ae-4e78-8bc6-cb0d251f8230.png)

# Description of Potential Issues
We used a random execution path for test runs.
* When the res/accel event is taken when the system is at deactivated state. The event will turn the cruise control to activated. This may cause a safety problem. The cruise control will be activated without an initial speed.