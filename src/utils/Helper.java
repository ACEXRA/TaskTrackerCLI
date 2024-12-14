package src.utils;

import src.entity.Task;

import java.util.Date;

public class Helper {
    private static long count = 0;
    public Task taskCreator(String description){
        long  id  = ++count;
        return new Task(id,description,STATUS.TODO, new Date());
    }
}
