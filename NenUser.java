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


    //random number generator
    private static Random random = new Random();

    //constructor
    public NenUser(String userName) {
        this.userName = userName;
        this.determination = random.nextInt(10);
        this.creativity = random.nextInt(10);
        this.intelligence = random.nextInt(10);
        this.impulsiveness = random.nextInt(10);
        this.manipulation = random.nextInt(10);
        this.uniqueness = random.nextInt(10);

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

        if(nenType != null) {
            System.out.println("Nen Type: " + nenType.getName());
        }else {
            System.out.println("Nen Type not determined yet.");
        }
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

        System.out.println("Water effect: " +nenType.getWaterEffect());
    }

    //sub-NenType
    public void assignSubTypes() {

        System.out.println("this is users" + nenType);
        
        if(nenType == null) {
            System.out.println("Cannot assign sub-types before determining main Nen Type.");
            return;
        }

        System.out.println("\nDetermining sub-types for " + userName + "...");
        String mainType = nenType.getName();
        int chance = random.nextInt(101); // 0-100

        System.out.println(userName + "'s main type: " + mainType);
        System.out.print("Sub-types: ");

        //Example for Enhancer sub-types
        if(mainType.equals("enhancer")) {
            if(chance < 80) System.out.println("Transmuter");
            if(chance < 80) System.out.println("Emitter");
            if (chance < 40) System.out.print("Conjurer ");
            if (chance < 40) System.out.print("Manipulator ");
            if (chance < 10) System.out.print("Specialist");
        }

        // TODO: Add similar logic for other main Nen types
    }
}
