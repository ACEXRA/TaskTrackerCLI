## [Roadmap Task Tracker CLI](https://roadmap.sh/projects/task-tracker)

A Task tracker java application, run in a IDE.

### Required
- IDE
- JDK installed

**STEPS**
- Clone the repo or fork it.
- Open in IDE as maven project, let maven dependency loads.
- run the program.

**Functionality**
- Add tasks
- Update tasks
- Delete tasks
- Update status
- List task based on status
- Store all in json file

**Commands**

Structure of command is operation-value-value..

**Inputs**
```bash
add-checking it
#add the task and with "checking it" as description
update-1-lol
#update the task id:1 description as given
delete-1
#delete the task with id:1


mark-1-todo
#mark status as todo for id:1
mark-1-progress
#mark status as progress for id:1
mark-1-done
#mark status as done for id:1

list
#list all task
list-done
#list task with done status
#same with progress and todo
