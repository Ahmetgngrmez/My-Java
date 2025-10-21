class GameObject {
    private String name;
    private double[] position;
    
    public GameObject(String name, double[] position) {
        this.name = name;
        this.position = position;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double[] getPosition() {
        return position;
    }
    
    public void setPosition(double[] position) {
        this.position = position;
    }
    
    public void draw() {
        System.out.println(name + " is drawn on screen at position (" + position[0] + ", " + position[1] + ").");
    }
    
    public void erase() {
        System.out.println(name + " disappears from the screen.");
    }
}

class PlayerCharacter extends GameObject {
    private int health;
    
    public PlayerCharacter(String name, double[] position, int health) {
        super(name, position);
        this.health = health;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public void attack(PlayerCharacter playerToAttack) {
        playerToAttack.health -= 5;
        System.out.println(this.getName() + " attacks " + playerToAttack.getName() + "!");
        if (playerToAttack.health <= 0) {
            playerToAttack.erase();
        }
    }
}

public class GameSimulation {
    public static void main(String[] args) {
        PlayerCharacter wizard = new PlayerCharacter("Wizard", new double[]{4.0, -5.5}, 10);
        PlayerCharacter orc = new PlayerCharacter("Orc", new double[]{-4.0, 5.5}, 5);
        
        wizard.draw();
        orc.draw();
        
        wizard.attack(orc);
    }
}
