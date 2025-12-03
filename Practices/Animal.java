package Practices;

public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age){
        this.name=name;
        this.age=age;
    }

    public void makeSound(){
        System.out.println("Unknown animal  sound..");
    }
    public void printInfo(){
        System.out.println("Name: "+name+"Age: "+age);
    }
    
}

