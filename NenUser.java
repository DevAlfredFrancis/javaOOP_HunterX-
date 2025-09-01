import java.util.ArrayList;
import java.util.Random;

public class NenUser {
    private String userName;
    private NenType nenType; //has-a relationship

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
    public NenUser(String userName) {
        this.userName = userName;

        //tie-breaking mechanism when two attribute have the same value
        ArrayList<Integer> attributes = new ArrayList<>();
        while(attributes.size() < 6) {
            int randNum = random.nextInt(10);
            if(!attributes.contains(randNum)) {
                attributes.add(randNum);
            }
        }

        // assign values from attributes arraylist
        this.determination = attributes.get(0);
        this.creativity    = attributes.get(1);
        this.intelligence  = attributes.get(2);
        this.impulsiveness = attributes.get(3);
        this.manipulation  = attributes.get(4);
        this.uniqueness    = attributes.get(5);

        showStats();
    }

    //method to display user stats
    public void showStats() {
        System.out.println("Determination (Enhancer):  " + determination);
        System.out.println("Impulsiveness (Emitter):  " + impulsiveness);
        System.out.println("Creativity (Transmuter): " + creativity);
        System.out.println("Intelligence (Intelligence): " + intelligence);
        System.out.println("Manipulation (Manipulator): " + manipulation);
        System.out.println("Uniqueness (Specialist): " + uniqueness);

        waterDivination();
        assignSubTypes();

    }

    //todo: add methods to set and get the NenType
    public void waterDivination() {
        System.out.println("=====================================================");
        System.out.println(userName + " performs water divination test...");
        System.out.println("=====================================================");

        //create nenType objects for each category
        NenType enhancer = new NenType("Enhancer","The water volume changes");
        NenType emitter = new NenType("Emitter","The water taste changes");
        NenType transmuter = new NenType("Transmuter","The water taste changes");
        //todo: create Nentype objects for conjurer, manipulator, and specialist

        //determine the user's nen type based on their highest attribute
        if(determination >= creativity && determination >= impulsiveness) {
            this.nenType = enhancer;
            System.out.println("The water's volume changed!" + userName + " is an enhancer!");
        } else if (impulsiveness >= determination && impulsiveness >= creativity) {
            this.nenType = emitter;
            System.out.println("The water's color changed! " + userName + " is an Emitter!");
        }else {
            this.nenType = transmuter;
            System.out.println("The water's color changed! " + userName + " is an Transmuter!");
        }
        //todo: complete the conditional logic for other Nen types

        System.out.println("Water effect: " + nenType.getWaterEffect());
    }

    //sub-NenType
    public void assignSubTypes() {
        
        if(nenType == null) {
            System.out.println("Cannot assign sub-types before determining main Nen Type.");
            return;
        }

        System.out.println("\nDetermining sub-types for " + userName + "...");
        String mainType = nenType.getName();
        // int chance = random.nextInt(101); // 0-100
        int chance = 11; // 0-100

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
        }

        //print sub-nenTypes from arraylist
        System.out.print("Sub-types: ");
        for(String subNenType : subNenTypes) {
            System.out.print(subNenType + " ");
        }

        System.out.println(); //add new line
    }
}
