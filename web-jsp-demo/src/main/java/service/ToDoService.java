package service;

public class ToDoService {

    private static ToDoService INSTANCE;

    private ToDoService() {

    }

    public static ToDoService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ToDoService();
        }
        return INSTANCE;
    }

}
