package Practices; 

public class Dog extends Animal{
    private String breed;//Special variable for dog

    public Dog(String name, int age, String breed){
        super(name,age);//Animal class
        this.breed=breed;//Then provide variable of dog class
    }
    
    @Override
    public void makeSound(){
        System.out.println("Wark Wark!");
    }

    public void fetch() {
        System.out.println(name + " catch the ball and bring it!");
    }
}