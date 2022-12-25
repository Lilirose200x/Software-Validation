## Original Source Code
The original source code for problem 1.1 comes from [jpacman-framework](https://github.com/SERG-Delft/jpacman-framework).

## Static Analysis
- The build script pom.xml is located at [here](https://github.com/McGill-ECSE429-Fall2022/assignment-1-asgn-10/blob/master/pom.xml)
- Screenshot for a successful build in SonarQube:
![image](https://user-images.githubusercontent.com/32471983/192111328-a895ad1a-8463-49bc-91d9-c167c9ddd3cc.png)
![image](https://user-images.githubusercontent.com/32471983/192111355-aaeec3e5-62c3-4d8e-b267-359ec1771a75.png)

- The command line parameters used for SonarQube is:`mvn clean verify sonar:sonar \
  -Dsonar.projectKey=assignment_1 \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=sqp_143da3d5d41d2d7cf830a89db186ac7631c5f21d`

- **Interesting bugs found**:
  1. This bug is classified as a code smell. Although it may seem simple to fix this bug, it is quite difficult catch because it overwrites the final variable declared further up in the file. Leaving this variable as is adds ambiguity to the code given that there is no real way to determine if the code should affect the initial variable or be a completely separated entity. 
  ![image](https://user-images.githubusercontent.com/32471983/192156488-f9cc5357-fb3d-44fa-92ec-9aab6f5ce130.png)
  2. The code in the image below is classified as a bug as it is doing an implicit type conversion when adding the two values. This type of bug is usually hard to catch given that it is not detected by the compiler. It is a good idea to perform a manual conversion to ensure that this block code performs in the manner we expect to.
  ![image](https://user-images.githubusercontent.com/32471983/192156527-141cf614-cc53-4a64-bbd1-6961f14f412f.png)
  3. For this code smell, it is better to replace the null value with an empty list given that the expected return type is a list. By implementing this change we can prevent any future oversights from other developers that will make use of this method.
  ![image](https://user-images.githubusercontent.com/32471983/192156542-77af0664-3f05-486c-beab-77c8d4b8407b.png)
  4. Fixing this final code smell improves the efficiency of the program. Instead of iterating over the keyset of a map and then calling the appropriate value, this changes allows the code to remove the extra call to the map object.
  ![image](https://user-images.githubusercontent.com/32471983/192156557-8ddfe560-dcf4-4902-847a-1655c72cb1c1.png)

- **Other bugs and False alarms**:
  1. Pseudorandom number generator  
  SonarQube detects this as a potential security risk, in a context that requires randomness there has been known vulnerabilities in these kind of random number generators. There have been cases where the random pattern was discovered and allowed attackers to guess the next number. For this method specifically, this is not an issue given that there is no sensitive information that is being dealt with. Therefore, we can consider this warning a false alarm.
     ![image](https://user-images.githubusercontent.com/34031806/193465659-141fa170-f49a-4965-b357-f7f541aaca53.png)
  2.  Asserts in the code  
  SonarQube detected various uses of assertions throughout the code, this is an issue given that it might stop the execution of the code and the JVM allows for assertions to be disabled. In that case, these checks would be completely removed and no longer serve their intended purpose. It would be important to fix this issue to ensure that the code performs appropriately regardless of the JVM settings.
![image](https://user-images.githubusercontent.com/34031806/193465883-0c5c16fe-a151-4920-8cc4-5840df8d1431.png)
  3. Transient or serializable  
 SonarQube detects this as an error since fields in a serializable class must either be Serializable or transient. Without this tag the program may crash when used in certain scenarios. This is a relevant issue given that it may cause unexpected behaviors during testing or usage.
![image](https://user-images.githubusercontent.com/34031806/193466123-5588b01d-5c3e-4915-b9b8-7dd1649e14d2.png)
  4. Map Issue  
SonarQube indicates that there exists better methods to test this kind of scenario. Instead of checking the get method against a null value it would be better to use other methods in the java.util.Map API like computeIfPresent() or computeIfAbsent(). This kind of issue is not a real problem for the code base, but would contribute positively to the overall quality of the code and readability. 
![image](https://user-images.githubusercontent.com/34031806/193466509-899ccf49-7bb5-4dae-a0c9-6514ac5ba79d.png)




## Code Review
The code review process is documented below:

-  The developer proposes changes and notifies the reviewer. 

-  The reviewer inspects the pull request and starts a review.

-  After the commits is approved by the reviewer, the pull request will be merged.


- [DEV] Zimu [REV] Viet 
![image](https://user-images.githubusercontent.com/32471983/192155333-5055f811-6fe3-40f1-b0f4-b87287f74c70.png)
- [DEV] Haipeng [REV] Ruoli
![image](https://user-images.githubusercontent.com/32471983/192155795-ca2b7d86-e2e9-4a77-9b3f-a0df09b108c7.png)
- [DEV] Ruoli [REV] Haipeng
![image](https://user-images.githubusercontent.com/32471983/192155372-81f3b077-3f77-4142-a241-d4a3f1159974.png)
- [DEV] Viet [Rev] Zimu
![image](https://user-images.githubusercontent.com/32471983/192155309-2f897b95-1bc1-4765-8412-fcf24b096cf9.png)