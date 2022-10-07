## Session Notes
### Charter:
Analyze the rest API todo list manager's functionality and report on the potential bugs and risks
### Build:
1.5.2  
Run command `java -jar runTodoManagerRestAPI-1.5.2.jar`
### Area:
Categories
### Environment:
Windows10
### Start Time:
1:57 PM 09/25/2022
### Testers:
| name       | email                  | id        |
| ---------- | ---------------------- | --------- |
| Zimu Su | zimu.su@mail.mcgill.ca | 260848487 |
| Viet Tran | viet.tran3@mail.mcgill.ca | 260924954 |
### Duration:
60 minutes
### Test Notes:
We tested the following routes in the categories area.
- http://localhost:4567/categories
  - POST with id.
  - POST without id.
  - POST with title.
  - POST without title.
  - POST with description.
  - POST without description.
- http://localhost:4567/categories/:id
  - GET with existing id.
  - GET with empty id.
  - GET with non-existing id.
  - GET with negative id.
  - GET with String id.
  - POST with description.
  - POST without description.
  - POST with non-UTF-8 characters in description.
  - POST with title.
  - POST without title.
  - POST with non-UTF-8 characters in title.
  - POST with id.
  - POST with empty body.
  - PUT with description.
  - PUT without description.
  - PUT with non-UTF-8 characters in description.
  - PUT with title.
  - PUT without title.
  - PUT with non-UTF-8 characters in title.
  - PUT with id.
  - PUT with empty body.
  - DELETE with existing id.
  - DELETE with non-exisisting id.
  - DELETE without id.
## Session Summary
- It is possible to create, update and delete categories in this API.
- Categories have id, description and title. 
  - Title cannot be empty.
## Bugs Logged:
- [Bug Summary 1: Cannot display non-UTF-8 characters](#bug1)
- [Bug Summary 2: PUT /categories/:id and POST /categories/:id act differently](#bug2)
## Issues/Concerns and Testing Ideas
### Issues/Concerns:
- Unable to display non-UTF-8 characters.
- PUT and POST /categories/:id act differently which might lead to potential hard-to-find bugs.
### Testing Ideas:
- Test for a large number of categories.
- Test for very long descriptions.
- Test for SQL injections.
- Test for the missing title, and description.
- Test for update id.
- Test for very large id.

## <a name="bug1"></a> Bug Summary 1: Cannot display non-UTF-8 characters
### Pre-conditions:
Have a category with id 1
### Steps to reproduce:
- Send a PUT request or a POST request to `http://localhost:4567/categories/:id` with `id = 1` and body: `{
    "title":"some title",
    "description":"阿达"
}`
### Frequency:
Always
### Productivity impact:
Strongly impact the program's usability if the user wants to write the description in a different language
### Notes:
The issue also occurs if the title contains problematic characters.

## <a name="bug2"></a> Bug Summary 2: PUT /categories/:id and POST /categories/:id act differently
### Pre-conditions:
Have a category `{
    "description": "some desc",
    "id": "1",
    "title": "some title"
}`
### Steps to reproduce:
- Send a POST request to `http://localhost:4567/categories/:id` with `id = 1` and body: `{
    "title":"new title",
}`
- Observe that the category becomes `{
    "description": "some desc",
    "id": "1",
    "title": "new title"
}`
- Send a PUT request with the same body.
- Observe that the description disappears: `{
    "description": "",
    "id": "1",
    "title": "new title"
}`
### Frequency:
Always
### Productivity impact:
Makes PUT and POST act differently and could cause bugs when used not carefully.