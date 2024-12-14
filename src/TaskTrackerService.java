package src;

import com.google.gson.Gson;
import src.entity.Task;
import src.utils.Helper;
import src.utils.STATUS;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TaskTrackerService {

    static List<Task> taskList = new ArrayList<>();

    Helper helper = new Helper();

    public void addTask(String description) {
        Task task = helper.taskCreator(description);
        taskList.add(task);
        System.out.println("Task created Successfully" + new Gson().toJson(task));
    }

    public void deleteTask(long id) {
        boolean isRemoved = taskList.removeIf(task -> task.getId() == id);

        System.out.println(isRemoved ? "Task removed successfully" : "No Task Exist");

        if (taskList.isEmpty()) {
            System.out.println("Task list is empty");
        }
    }

    public void updateTask(long id, String description) {
        for(Task task : taskList){
            if(task.getId()==id){
                task.setDescription(description);
                task.setUpdatedAt(new Date());
                System.out.println("Task created Successfully" + new Gson().toJson(task));
                System.out.println("Updated successfully");
                return;
            }
        }
        System.out.println("No Task exist");
    }

    public void updateStatus(long id, String status){
        try {
            STATUS updatedStatus = STATUS.valueOf(status.toUpperCase());
            for(Task task : taskList){
                if(task.getId()==id){
                    task.setStatus(updatedStatus);
                    task.setUpdatedAt(new Date());
                    System.out.println("Task created Successfully" + new Gson().toJson(task));
                    System.out.println("Updated successfully");
                    return;
                }
            }
            System.out.println("No Task exist");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status: " + status);
        }
    }

    public void listAll(){
        taskList.forEach(task -> System.out.println(task.toString()));
    }

    public void listByStatus(String status){
        taskList.stream()
                .filter(task -> task.getStatus().equals(STATUS.valueOf(status.toUpperCase())))
                .forEach(task -> System.out.println(task.toString()));
    }

    public void fileWrite() {
        Gson gson = new Gson();
        String json = gson.toJson(taskList);
        System.out.println(json);
        try (FileWriter writer = new FileWriter("people.json")) {
            writer.write(json);
            System.out.println("Data saved to people.json");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
