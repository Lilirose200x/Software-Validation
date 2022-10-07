This exploratory testing project gives us an initial insight into the testing process, especially black box testing. Our main task is to test as many potentially dangerous user scenarios as possible, and we detect the defects in the program by observing whether they live up to expectations.

Based on the test results, we observed that most cases were correct, but we also found 11 bugs that frequently occurred. The most common feedback is unsatisfactory input type. For example, this API cannot handle non-UTF-8 characters. Otherwise, our detailed findings by categories are as follows.

- Todos
  - Title of Todos cannot be empty.
  - When updating without doneStatus parameter, the doneStatus will remain the same.
  - When creating without doneStatus, the doneStatus will be false as default.
- Project
  - Can not create projects with id. Can not get, update, delete a project with non-exsiting id.
  - The default state of active and completed is false.
- Category
  - Title of a category cannot be empty.
  - PUT /categories/:id and POST /categories/:id act differently.
- Interoperability
  - It is only possible to create a relation between todo-new category, todo-new project, project-new category, etc. We cannot create a relation between existing items.
  - When sending get requests to get any non-existing relationship, the first existing relationship gets returned instead of returning an error.

Finally, we conclude that detailed scenario analysis is essential in exploratory testing as it allow us to avoid repetitive errors during program development. 
