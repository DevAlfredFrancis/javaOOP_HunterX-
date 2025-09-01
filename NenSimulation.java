import java.util.Scanner;

public class NenSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("=====================================================");
            System.out.print("Nen User Name: ");
            String name = sc.nextLine();
            System.out.println("=====================================================");
            System.out.println("Water Divination test ongoing!");
            System.out.println("=====================================================");
            System.out.println("====== " + name + " Stats" + " ======");

            //create object from nenUser class
            NenUser user1 = new NenUser(name);

            System.out.println("=====================================================");
            System.out.print("Try Again? ");
            String retry = sc.next();
            if(retry.equalsIgnoreCase("y")) {
                sc.nextLine();
            }else {
                System.out.println("Exiting....");
                break;
            }
        }while(true);
    }
}