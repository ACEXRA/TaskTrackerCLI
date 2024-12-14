package src;

import java.util.Scanner;

public class TaskTracker {
    public static void main(String[] args) {

        System.out.println("TASK TRACKER CLI");
        System.out.println("Enter task:operation-description");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        TaskTrackerService taskTrackerService = new TaskTrackerService();
        while(flag){
            String input = scanner.nextLine();
            String[] payload = input.split("-");
            switch (payload[0]){
                case "add":
                    if(payload.length>1)taskTrackerService.addTask(payload[1]);
                    break;
                case "delete":
                    if(payload.length>1)taskTrackerService.deleteTask(Long.parseLong(payload[1]));
                    break;
                case "update":
                    if(payload.length>2){
                        taskTrackerService.updateTask(Long.parseLong(payload[1]),payload[2]);
                    }else{
                        System.out.println("Enter a valid input");
                    }
                    break;
                case "mark":
                    if(payload.length>2){
                        taskTrackerService.updateStatus(Long.parseLong(payload[1]),payload[2]);
                    }else{
                        System.out.println("Enter a valid input");
                    }
                    break;
                case "list":
                    if(payload.length>1){
                        taskTrackerService.listByStatus(payload[1]);
                    }else{
                        taskTrackerService.listAll();
                    }
                    break;
                case "end":
                    taskTrackerService.fileWrite();
                    flag = false;
                    break;
                default:
                    System.out.println("Enter a valid input");
            }
        }
        System.out.println("Application ended");
    }
}
