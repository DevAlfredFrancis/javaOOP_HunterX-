import java.util.ArrayList;
import java.util.Scanner;

public class NenSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<NenUser> hunters = new ArrayList<>();
        
        do {
            System.out.println("=====================================================");
            System.out.print("Nen User Name: ");
            String name = sc.nextLine();
            System.out.println("=====================================================");
            System.out.println("Water Divination test ongoing!");
            System.out.println("=====================================================");
            System.out.println("====== " + name + " Stats" + " ======");

            NenUser hunter;

            switch (name.toLowerCase()) {
                case "gon":
                    hunter = new NenUser(name,8,4,6,5,2,1);
                    break;
                case "killua":
                    hunter = new NenUser(name,3,4,6,7,5,2);
                    break;
                case "kurapika" :
                    hunter = new NenUser(name,7,6,8,3,4,9);
                    break;
                case "leorio" :   
                    hunter = new NenUser(name,6,5,7,9,4,3);
                    break;
                default:
                    hunter = new NenUser(name);
            }

            System.out.println("=====================================================");    
            System.out.print("Press 'Y' to continue or Press any key to exit: ");
            String retry = sc.next();
            if(retry.equalsIgnoreCase("y")) {
                sc.nextLine();
            }else {
                System.out.println("Summary Result:");
                break;
            }

            hunters.add(hunter);

        }while(true);

        //show summary after loop
        int enhancers = 0, emitters = 0, transmuters = 0, conjurers = 0, manipulators = 0, specialists = 0;

        // show result
        for(NenUser hunter : hunters) {
            String nenType = hunter.getNenType().getName();

            switch (nenType) {
                case "Enhancer" : 
                    enhancers++;
                    break;
                case "Emitter" :
                    emitters++;
                    break;
                case "Transmuter" :
                    transmuters++;
                    break;
                case "Conjurer" :
                    conjurers++;
                    break;
                case "Manipulator" :
                    manipulators++;
                    break;
                case "Specialist" :
                    specialists++;
            }
        }

        //display summary
        System.out.println("=======================================");
        System.out.println("Nen Type Summary:");
        System.out.println("Enhancers: " + enhancers);
        System.out.println("Emitters: " + emitters);
        System.out.println("Transmuters: " + transmuters);
        System.out.println("Conjurers: " + conjurers);
        System.out.println("Manipulators: " + manipulators);
        System.out.println("Specialists: " + specialists);
        System.out.println("=======================================");

    }
}

        

