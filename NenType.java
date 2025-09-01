public class NenType {
    private String name;
    private String waterEffect;

    //constructor
    public NenType(String name, String waterEffect) {
        this.name = name;
        this.waterEffect = waterEffect;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getWaterEffect() {
        return waterEffect;
    }

    //todo add a toString() method to display Nen Type information
    public String toString() {
        return "NenType [name: " + name + ", waterEffect: " + waterEffect + "]";
    }

}
