package edu.unimagdalena.web.try1.dto;

public class User {
    private int id;
    private String name;
    private int edad;
   
    
    public User(int id, String name, int edad) {
        this.id = id;
        this.name = name;
        this.edad = edad;
    }

    public User() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
