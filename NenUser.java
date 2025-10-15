import java.util.ArrayList;
import java.util.Random;

public class NenUser {
    private String userName;
    private NenType nenType; //has-a relationship

    //Getters
    public NenType getNenType() {return nenType;}

    //character attributes
    private int determination;
    private int creativity;
    private int impulsiveness;
    private int intelligence;
    private int manipulation;
    private int uniqueness;

    //add sub-nenType to arraylist
    ArrayList<String> subNenTypes = new ArrayList<>();

    //random number generator
    private static Random random = new Random();

    //constructor
    public NenUser(String userName, int determination, int creativity, int intelligence, int impulsiveness, int manipulation, int uniqueness) {
        this.userName = userName; //hunter 

        this.determination = determination; //enhancer
        this.creativity    = creativity; //transmuter
        this.intelligence  = intelligence; //conjurer
        this.impulsiveness = impulsiveness; //emitter
        this.manipulation  = manipulation; //manipulator
        this.uniqueness    = uniqueness; //specialist

        showStats();
        waterDivination();
        assignSubTypes();
    }

    public NenUser(String userName) {
        this.userName = userName; //hunter 
        
        getNenAttribute();
        showStats();
        waterDivination();
        assignSubTypes();
    }

    public void getNenAttribute() {
        //tie-breaking mechanism when two attributes have the same value
        ArrayList<Integer> attributes = new ArrayList<>();
        while(attributes.size() < 6) {
            int randNum = random.nextInt(10);
            if(!attributes.contains(randNum)) {
                attributes.add(randNum);
            }
        }

        // assign values from generated random attributes stored in the arraylist
        this.determination = attributes.get(0); //enhancer
        this.creativity    = attributes.get(1); //transmuter
        this.intelligence  = attributes.get(2); //conjurer
        this.impulsiveness = attributes.get(3); //emitter
        this.manipulation  = attributes.get(4); //manipulator
        this.uniqueness    = attributes.get(5); //specialist
    }

    //method to display user stats
    public void showStats() {
        System.out.println("Determination (Enhancer):  " + determination);
        System.out.println("Impulsiveness (Emitter):  " + impulsiveness);
        System.out.println("Creativity (Transmuter): " + creativity);
        System.out.println("Intelligence (Conjurer): " + intelligence);
        System.out.println("Manipulation (Manipulator): " + manipulation);
        System.out.println("Uniqueness (Specialist): " + uniqueness);
    }

    //add methods to set and get the NenType
    public NenType waterDivination() {
        System.out.println("=====================================================");
        System.out.println(userName + " performs water divination test...");
        System.out.println("=====================================================");

        //create nenType objects for each category
        NenType enhancer = new NenType("Enhancer","The water volume changes");
        NenType emitter = new NenType("Emitter","The water color changes");
        NenType transmuter = new NenType("Transmuter","The water taste changes");
        NenType conjurer = new NenType("Conjurer","Impurities appear in water.");
        NenType manipulator = new NenType("Manipulator","Leaf moves on the water.");
        NenType specialist = new NenType("Specialist","Different change appears.");

        //determine the user's nen type based on their highest attribute
        if(determination > creativity && determination > impulsiveness && determination > intelligence && determination > manipulation && determination > uniqueness) {
            this.nenType = enhancer;
            System.out.println("The water's volume changed! " + userName + " is an enhancer!");
        }else if (impulsiveness > determination && impulsiveness > creativity && impulsiveness > intelligence && impulsiveness > manipulation && impulsiveness > uniqueness) {
            this.nenType = emitter;
            System.out.println("The water's color changed! " + userName + " is an Emitter!");
        }else if (creativity >= determination && creativity >= intelligence) {
            this.nenType = transmuter;
            System.out.println("The water taste changes " + userName + " is a Transmuter!");
        }else if (intelligence >= creativity && intelligence >= manipulation) {
            this.nenType = conjurer;
            System.out.println("Impurities appear in water. " + userName + " is a Conjurer!");
        }else if (manipulation >= impulsiveness && manipulation >= intelligence) {
            this.nenType = manipulator;
            System.out.println("Leaf moves on the water. " + userName + " is a Manipulator!");
        }else if(uniqueness >= manipulation && uniqueness >= intelligence){ 
            this.nenType = specialist;
            System.out.println("Different change appears. " + userName + " is a specialist!");
        }

        System.out.println("Water effect: " + nenType.getWaterEffect());
        return nenType;

    }

    //create method for assigning sub-NenType
    public void assignSubTypes() {
        
        if(nenType == null) {
            System.out.println("Cannot assign sub-types before determining main Nen Type.");
            return;
        }

        System.out.println("\nDetermining sub-types for " + userName + "...");
        String mainType = nenType.getName();
        int chance = random.nextInt(101); // 0-100

        System.out.println("Chance is: " + chance);
        System.out.println(userName + "'s main type: " + mainType);
        
        //Determine sub-nenTypes based on chance
        if(mainType.equals("Enhancer")) {
            if(chance >= 80) subNenTypes.add("Emitter");
            if(chance >= 80) subNenTypes.add("Transmuter");
            if(chance <= 79 && chance >= 11) subNenTypes.add("Conjurer");
            if(chance <= 79 && chance >= 11) subNenTypes.add("Manipulator");
            if(chance <= 10) subNenTypes.add("Specialist");
        }else if(mainType.equals("Emitter")) {
            if(chance >= 80) subNenTypes.add("Enhancer");
            if(chance >= 80) subNenTypes.add("Manipulator");
            if(chance <= 79 && chance >= 11) subNenTypes.add("Transmuter");
            if(chance <= 79 && chance >= 11) subNenTypes.add("Conjurer");
            if(chance <= 10) subNenTypes.add("Specialist");
        }else if(mainType.equals("Transmuter")) {
            if(chance >= 80) subNenTypes.add("Enhancer");
            if(chance >= 80) subNenTypes.add("Conjurer");
            if(chance <= 79 && chance >= 11) subNenTypes.add("Emitter");
            if(chance <= 79 && chance >= 11) subNenTypes.add("Manipulator");
            if(chance <= 10) subNenTypes.add("Specialist");
        }else if(mainType.equals("Conjurer")) {
            if(chance >= 80) subNenTypes.add("Transmuter");
            if(chance >= 80) subNenTypes.add("Manipulator");
            if(chance <= 79 && chance >= 11) subNenTypes.add("Emitter");
            if(chance <= 79 && chance >= 11) subNenTypes.add("Enhancer");
            if(chance <= 10) subNenTypes.add("Specialist");
        }else if(mainType.equals("Manipulator")) {
            if(chance >= 80) subNenTypes.add("Emitter");
            if(chance >= 80) subNenTypes.add("Conjurer");
            if(chance <= 79 && chance >= 11) subNenTypes.add("Enhancer");
            if(chance <= 79 && chance >= 11) subNenTypes.add("Transmuter");
            if(chance <= 10) subNenTypes.add("Specialist");
        }else{
            subNenTypes.add("Specialist");
        }

        System.out.print("Sub-types: ");
        for(String subNenType : subNenTypes) {
            System.out.print(subNenType + " ");
        }

        System.out.println(); //add new line
    }
}
