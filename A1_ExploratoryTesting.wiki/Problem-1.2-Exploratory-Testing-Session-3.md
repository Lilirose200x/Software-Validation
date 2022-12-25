## Session Notes
### Charter:
Analyze the rest API todo list manager's functionality and report on the potential bugs and risks
### Build:
1.5.2  
Run command `java -jar runTodoManagerRestAPI-1.5.2.jar`
### Area:
Todos
### Environment:
Windows11
### Start Time:
20:00 09/28/2022
### Duration:
60 minutes
### Test Notes:
We tested the following routes in the Todo area.
- http://localhost:4567/todos
  - GET all todo instances
  - POST with id.
  - POST with all parameters except id.
  - POST with all parameters including id.
  - POST without doneStatus.
  - POST without description.
  - POST without title.
  - POST without non-UTF-8 characters in description. 
  - POST without non-UTF-8 characters in title. 
- http://localhost:4567/todos/:id
  - GET with existing id.
  - GET with non-existing id.
  - POST with all parameters.
  - POST without doneStatus when saved status is false.
  - POST without doneStatus when saved status is true.
  - POST without description.
  - POST without title.
  - POST without id.
  - POST without non-UTF-8 characters in description. 
  - POST without non-UTF-8 characters in title. 
  - PUT with all parameters.
  - PUT without doneStatus when saved status is false.
  - PUT without doneStatus when saved status is true.
  - PUT without description.
  - PUT without title.
  - PUT without id.
  - PUT without non-UTF-8 characters in description. 
  - PUT without non-UTF-8 characters in title. 
  - DELETE with existing id.
  - DELETE with non-existing id.
  - DELETE without id.

## Session Summary
We could successfully create, update, delete the todo instances in this API
Todos have 4 parameters: doneStatus, description, id and title.
Title can not be empty. 
When updating without doneStatus parameter, the doneStatus will remain the same.
When creating without doneStatus, the doneStatus will be false as default.
## Bugs Logged:
- [Bug Summary: Cannot display non-UTF-8 characters](#bug1)
## Issues/Concerns and Testing Ideas
### Issues/Concerns:
- Unable to display non-UTF-8 characters.
### Testing Ideas:
- Test for very long title.
- Test for very long descriptions.
- Test for the missing title, id, doneStatus or description when updating todo.
- Test for the missing title, doneStatus or description when creating todo.
- Test for getting, updating and deleting non-existing todo
- Test for update id.
- Test for weird input parameters with non-UTF-8 characters or other kinds of characters.

## <a name="bug1"></a> Bug Summary: Cannot display non-UTF-8 characters
### Pre-conditions:
Have a category with id 49
### Steps to reproduce:
- Send a PUT request or a POST request to `http://localhost:4567/todos/:id` with `id = 49` and body: `{
   "doneStatus":true,"description": "some desc","title": "啊啊啊"
}`
### Frequency:
Always
### Productivity impact:
Program unable to display the character "啊啊啊". Users can not use other languages with the non-UTF-8 characters.
### Notes:
The issue also occurs if the description contains non-UTF-8 characters.



