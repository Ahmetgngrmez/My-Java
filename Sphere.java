public class Sphere extends Object3D {
private double radius;
// Constructor
public Sphere(String material, String color, double radius) {
super(material, color); // Calls the superclass constructor to set material and color
this.radius = radius; // Sets the radius of the sphere
}
public double getRadius() {
return this.radius;
}
// Implementing abstract method to calculate the volume of the sphere
@Override

public double calculateVolume() {
return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3); // Volume formula for a sphere
}
// Implementing abstract method to calculate the surface area of the sphere
@Override
public double calculateSurfaceArea() {
return 4 * Math.PI * radius * radius; // Surface area formula for a sphere
}
}