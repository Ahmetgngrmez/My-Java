package Practices;

public class TestPolymorphism {
    public static void main(String[] args) {
        
        // Polymorphism: Referance animal, object dog
        Animal myPet= new Dog ("KArabaş",3,"Kangal");

        myPet.makeSound();//Because of overriding output will be wark wark


        if (myPet instanceof Dog){
            Dog myDog=(Dog) myPet;
            myDog.fetch();
        }

    }
     
}
