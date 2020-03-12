import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Your hierarchy must also operate properly with this (sad, little) "order system"
 * class.  Run and pass all the JUnit tests first.  And the JUnit program will create
 * the Database.dat file read in by this class.
 * 
 * A few things in this class are worth taking a look at:
 * - The use of an ArrayList<Fastener> object as the collection type.
 * - The use of polymorphism when invoking toString and using the isInstance method.
 * - The use of Class objects.
 * - A wildcard used with the generic Class object: Class<? extends Fastener>
 */
public class FastenerOrderSystem {

	private static ArrayList<Fastener> db;
    private static Scanner screenInput = new Scanner(System.in);
	
	// Reads the contents of Database.dat into the ArrayList<Fastener> collection.
    @SuppressWarnings("unchecked")
	private static void readDB() {
    	String inputFile = "Database.dat";
        try (ObjectInputStream binFileIn = new ObjectInputStream(new FileInputStream(inputFile))) {
            // Here is the unchecked cast:
        	db = (ArrayList<Fastener>)binFileIn.readObject();
        } catch (ClassNotFoundException | IOException err) {
            System.out.println(err.getMessage());
        } 		
	} // end readDB
	
    // From IOHelper.  Gets a String from the user.
    private static String getString(String prompt) {
    	String userText;
        System.out.print(prompt);
        userText = screenInput.next();
        return userText;
    } // end one parameter getString method

    // From IOHelper.  Gets an int from the user.
    private static int getInt(int low, String prompt, int high) {
        int numFromUser = 0;
        String dummy;
        boolean numericEntryOK;
        do {
            System.out.print(prompt);
            numericEntryOK = false;
            try {
                numFromUser = screenInput.nextInt();
                numericEntryOK = true;
            } catch (InputMismatchException e) {
                dummy = screenInput.nextLine();
                System.out.println(dummy + " is not an integer!");
                numFromUser = low;
            } // end try-catch
            // Indicate to the user why he is being prompted again.
            if (numFromUser < low || numFromUser > high) {
                System.out.println("The number is outside the legal limits.");
            }
        } while (!numericEntryOK || numFromUser < low || numFromUser > high);
        return numFromUser;
    } // end full parameter getInt method

    // A menu prompting the user to choose one of four class types.
    // It returns a generic Class type object obtained using the .class attribute.
    private static Class<? extends Fastener> getClassChoice () {
		char displayChoice = getString("Display N(a)ils, (N)uts, (B)olts or (S)crews?: ").toLowerCase().charAt(0);
		switch (displayChoice) {
			case 'a' :
				return Nail.class;
			case 'n' :
				return InnerThreaded.class;
			case 'b' :
				return Bolt.class;
			case 's' :
				return Screw.class;
		}
    	return null;
    } // end getClassChoice
    
    // Displays only those fasteners that match the classChoice argument, and then
    // returns the number of the one the user chooses from this displayed list.
    private static int getFastenerChoice(Class<? extends Fastener> classChoice) {
    	System.out.println("\nFasteners of type " + classChoice.getName().toString() + ":");
    	System.out.println("Part#\tDescription");
    	for (int i = 0; i < db.size(); i++)
    		if (classChoice.isInstance(db.get(i)))
    			System.out.println(i + "\t" + db.get(i));
    	return getInt(0, "Choose part#: ", 11);
    } // end getFastenerChoice
    
    // The order system just allows the user to choose a faster from a sub-list of those
    // available, then asks for how many of these fasteners the user would like to order.
    // The program then displays the total cost of that order.
    public static void main(String[] args) {
		int orderSize;
		int partNum;
		String cost;
    	Class<? extends Fastener> classChoice;
		readDB();
		if (db == null || db.size() == 0)
			System.out.println("Read failed!");
		else {
			classChoice = getClassChoice();
			if (classChoice == null) {
				System.out.println("Illegal Choice!");
				System.exit(0);
			}
			partNum = getFastenerChoice(classChoice);
			if (!(classChoice.isInstance(db.get(partNum)))) {
				System.out.println("Illegal Choice!");
				System.exit(0);
			}				
			System.out.println(db.get(partNum));
			orderSize = getInt(1, "\nHow many?: ", 1000);
			cost = String.format("Cost will be $%1$.2f", db.get(partNum).getOrderCost(orderSize));
			System.out.println(cost);
		} // end else
	} // end main

} // end FastenerOrderSystem class