## Session Notes
### Charter:
Analyze the rest API todo list manager's functionality and report on the potential bugs and risks
### Build:
1.5.2  
Run command `java -jar runTodoManagerRestAPI-1.5.2.jar`
### Area:
Interoperability
### Environment:
Windows10
### Start Time:
11:00 AM 09/26/2022
### Duration:
60 minutes
### Test Notes:
We tested the following routes in the interoperability area.
- http://localhost:4567/todos/:id/categories
  - GET with existing id.
  - GET with non-existing id.
  - POST with existing id.
  - POST with non-existing id.
- http://localhost:4567/todos/:id/categories/:id
  - DELETE with existing id.
  - DELETE with non-existing id.
  - DELETE with empty id.
- http://localhost:4567/todos/:id/task-of
  - GET with existing id.
  - GET with non-existing id.
  - POST with existing id.
  - POST with non-existing id.
- http://localhost:4567/todos/:id/task-of/:id
  - DELETE with existing id.
  - DELETE with non-existing id.
  - DELETE with empty id.
- http://localhost:4567/projects/:id/categories
  - GET with existing id.
  - GET with non-existing id.
  - POST with existing id.
  - POST with non-existing id.
- http://localhost:4567/projects/:id/categories/:id
  - DELETE with existing id.
  - DELETE with non-existing id.
  - DELETE with empty id.
## Session Summary
- It is possible to get the relation between todo-categories, todo-projects, project-categories, etc.
- It is only possible to create a relation between todo-new category, todo-new project, project-new category, etc. We cannot create a relation between existing items.
## Bugs Logged:
- [Bug Summary 1: Wrong category when getting categories of specific todo](#bug1)
- [Bug Summary 2: Unable to create relationship between todo and existing category](#bug2)
- [Bug Summary 3: Wrong project when getting project of specific todo](#bug3)
- [Bug Summary 4: Unable to create relationship between todo and existing project](#bug4)
- [Bug Summary 5: Wrong category when getting categories of specific project](#bug5)
- [Bug Summary 6: Unable to create relationship between project and existing category](#bug6)
## Issues/Concerns and Testing Ideas
### Issues/Concerns:
- GET requests return all relationships if an incorrect id is given.
- POST requests cannot create relationships between existing items.
### Testing Ideas:
- Test for a large number of categories, todos, and projects.
- Test for non-existing data.
- Test for creating relationships between existing items.
- Test relationship between categories and todos
- Test relationship between categories and projects

## <a name="bug1"></a> Bug Summary 1: Wrong category when getting categories of specific todo
### Pre-conditions:
Have a todo in the database.
### Steps to reproduce:
- Send a GET request to `http://localhost:4567/todos/:id/categories` with and non-existing id.
- Observe that all the categories that are associated with a todo are returned.
### Notes:
- This issue also happens if we don't enter any id.
### Frequency:
Always
### Productivity impact:
Consistently returns false data for non-existing id. This could cause security issues and makes future development difficult when this feature is used.

## <a name="bug2"></a> Bug Summary 2: Unable to create relationship between todo and existing category
### Pre-conditions:
- Have a category `{
    "description": "some desc",
    "id": "1",
    "title": "some title"
}`
- Have a todo `{
            "doneStatus": "false",
            "description": "",
            "id": "1",
            "title": "scan paperwork",
            "categories": []
        }`
### Steps to reproduce:
- Send a POST request to `http://localhost:4567/todos/:id/categories` with `id = 1` and body: `{
            "description": "",
            "id": "1"
            "title": "Office"
        }`
- Observe that the relation cannot be created even though the category and the todo both exist.
### Frequency:
Always
### Productivity impact:
Strongly impact the usability of the POST request since we can never associate a todo with an existing category.

## <a name="bug3"></a> Bug Summary 3: Wrong project when getting project of specific todo
### Pre-conditions:
Have a todo in the database.
### Steps to reproduce:
- Send a GET request to `http://localhost:4567/todos/:id/task-of` with and non-existing id.
- Observe that all the projects that are associated with a todo are returned.
### Notes:
- This issue also happens if we don't enter any id.
### Frequency:
Always
### Productivity impact:
Consistently returns false data for non-existing id. This could cause security issues and makes future development difficult when this feature is used.

## <a name="bug4"></a> Bug Summary 4: Unable to create relationship between todo and existing project
### Pre-conditions:
- Have a project `{
    "description": "",
    "active": "false",
    "id": "1",
    "completed": "false",
    "title": "Office Work",
    "tasks": []
}`
- Have a todo `{
            "doneStatus": "false",
            "description": "",
            "id": "1",
            "title": "scan paperwork",
            "categories": []}`
### Steps to reproduce:
- Send a POST request to `http://localhost:4567/todos/:id/task-of` with `id = 1` and body: `{
    "description": "",
    "active": "false",
    "id": "1",
    "completed": "false",
    "title": "Office Work",
    "tasks": [
        {
            "id": "1"
        }
    ]
}`
- Observe that the relation cannot be created even though the project and the todo both exist.
### Frequency:
Always
### Productivity impact:
Strongly impact the usability of the POST request since we can never associate a todo with an existing project.

## <a name="bug5"></a> Bug Summary 5: Wrong category when getting categories of specific project
### Pre-conditions:
Have a project in the database.
### Steps to reproduce:
- Send a GET request to `http://localhost:4567/projects/:id/categories` with and non-existing id.
- Observe that all the categories that are associated with a project are returned.
### Notes:
- This issue also happens if we don't enter any id.
### Frequency:
Always
### Productivity impact:
Consistently returns false data for non-existing id. This could cause security issues and makes future development difficult when this feature is used.

## <a name="bug6"></a> Bug Summary 6: Unable to create relationship between project and existing category
### Pre-conditions:
- Have a project `{
    "description": "",
    "active": "false",
    "id": "1",
    "completed": "false",
    "title": "Office Work",
    "tasks": [],
    "categories":[]
}`
- Have a category`{
            "description": "",
            "id": "1",
            "title": "Office"
        }`
### Steps to reproduce:
- Send a POST request to `http://localhost:4567/projects/:id/categories` with `id = 1` and body: `{
            "description": "",
            "id": "1",
            "title": "Office"
        }`
- Observe that the relation cannot be created even though the project and the category both exist.
### Frequency:
Always
### Productivity impact:
Strongly impact the usability of the POST request since we can never associate a project with an existing category.
