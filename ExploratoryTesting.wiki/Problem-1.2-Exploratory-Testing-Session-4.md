## Session Notes
### Charter:
Analyze the rest API todo list manager's functionality and report on the potential bugs and risks
### Build:
1.5.2  
Run command `java -jar runTodoManagerRestAPI-1.5.2.jar`
### Area:
Projects
### Environment:
macOS
### Start Time:
11:00 PM 09/28/2022

### Duration:
60 minutes
### Test Notes:
We tested the following routes in the projects area.
- http://localhost:4567/projects
  - Get all project instances.
  - POST with id.
  - POST without id.
  - POST with title.
  - POST without title.
  - POST without description.
- http://localhost:4567/projects/:id
  - GET with existing id.
  - GET with existing id when completed is true.
  - GET with non-existing id.
  - POST without description.
  - POST with id.
  - POST without id.
  - PUT with existing id.
  - PUT with non-existing id.
  - PUT without description when completed is true.
  - DELETE with existing id.
  - DELETE with non-existing id.
  - DELETE with existing id when active is true.
- http://localhost:4567/projects/:id/tasks
  - GET with existing id.
  - GET with non-existing id.
  - POST with exsiting id.
  - POST with non-existing id.
- http://localhost:4567/projects/:id/tasks/:id
  - DELETE with existing id.
  - DELETE with non-existing id.
## Session Summary
- Projects have description, id, title, active and completed states. It is possible to get, create, update and delete projects in this API.
- Can not create projects with id. Can not get, update, delete a project with non-exsiting id.
- The default state of active and completed is false.
## Bugs Logged:
- [Bug Summary 1: Put automatically changes the state of active/completed to false](#bug1)
- [Bug Summary 2: Get tasks with non-existing id also returns all the todo items related to project](#bug2)
## Issues/Concerns and Testing Ideas
### Issues/Concerns:
- Unable to correctly display non-UTF-8 characters in strings.
- Hard to tell the id of todos and projects.
- It is advisable to have a prompt when an item is successfully deleted to avoid repeat checkings.
- Users should be able to set up id by theirselves.
- Users should be able to delete some tasks rather than all tasks under a specific id.
### Testing Ideas:
- Test for different kinds of input, like decimal, arrays, null.
- Test for the true state of active and completed, since the default state is false.
- Test for the missing of title, and description.
- Test for the non-exsiting id.
- Test for special characters.

## <a name="bug1"></a> Bug Summary 1: Put automatically changes the state of active/completed to false
### Pre-conditions:
Set the state of active or completed to true.
- Send a PUT request to `http://localhost:4567/projects/:id` with `id = 8` and body: `{
    "active":true,
    "completed":true
}`
### Steps to reproduce:
- Send a PUT request to `http://localhost:4567/projects/:id` with `id = 8` and body: `{
    "description":"hahahahaha"
}`
### Frequency:
Always
### Productivity impact:
When users update any other inputs rather than the state of active/completed, these two values automatically revert to their default settings: false. This would introduce lots of error messages, seriously reducing the reliability of the program.
### Notes:
The issue may happen to all boolean input values.

## <a name="bug2"></a> Bug Summary 2: Get tasks with non-existing id also returns all the todo items related to project
### Pre-conditions:
There exist tasks related to this project.
### Steps to reproduce:
- Send a GET request to `http://localhost:4567/projects/:id/tasks` with `id = 100`
- Observe that the todos becomes: `[{
  "doneStatus": "false",
  "description": "",
  "id": "2",
  "title": "file paperwork"
}
{
  "doneStatus": "false",
  "description": "",
  "id": "1",
  "title": "scan paperwork",
  "categories": [
    {
      "id": "1"
    }
  ]
}]`

### Frequency:
Always
### Productivity impact:
Non-existent id should not return this information,which can mislead users to believe this id is valid.
