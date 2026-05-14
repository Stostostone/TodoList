package model;

public class TodoList {
    private String todo;
    private String details;
    private String date;

    public TodoList(){}

    public TodoList(String todo, String details, String date){
        this.todo = todo;
        this.details = details;
        this.date = date;
    }

    public String getTodo(){
        return todo;
    }
    public String getDetails(){
        return details;
    }
    public String getDate(){
        return date;
    }

    public void setTodo(String todo){
        this.todo = todo;
    }
    public void setDetails(String details){
        this.details = details;
    }
    public void setDate(String date){
        this.date = date;
    }

}
