import java.util.Scanner;

/** Driver class for ProductList
 * @author Sasha Kaplan
 * @author CS 3345.003
 * @since 02-22-2023
 * @version 1.0
*/
public class Main <AnyType extends IDedObject>{
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		ProductList list = new ProductList<>();
		do {
			System.out.print("Operations on List\r\n"
					+ "1.	Make Empty\r\n"
					+ "2.	Find ID\r\n"
					+ "3.	Insert At Front\r\n"
					+ "4.	Delete From Front\r\n"
					+ "5.	Delete ID\r\n"
					+ "6.	Print All Records\r\n"
					+ "7.	Done\r\n"
					+ "Your Choice: \r"
					+ "");
			String choice = scanner.next();
			
			switch(choice) {
			//Empty the list
			case("1"):
				list.makeEmpty();
				System.out.println("List is emptied");
				break;
			//Finds item
			case("2"):
				boolean valid = false;
				do {
					System.out.print("What ID do you need to find? ");
					try {
						input = scanner.nextInt();
						valid = true;
					}
					catch(Exception e) {
						System.out.println("Invalid input, please put in an integer");
						scanner.next();
					}
				} while(!valid);
					
				if (((list.findID(input) == null)))
					System.out.println("\nItem does not exist");
				else
					System.out.println("\n" + list.findID(input).toString());
				System.out.println();
				break;
			//Inserts new node at Front
			case("3"):
			int productID = 0;
			valid = false;
			do {
				System.out.print("What is the Product ID: \r");
				try {
					productID = scanner.nextInt();
					valid = true;
				}
				catch(Exception e) {
					System.out.println("Invalid input, please put in an integer");
					scanner.next();
				}
			} while(valid == false);
				System.out.print("What is the Product Name: ");
				scanner.nextLine();
				String productName = scanner.nextLine();
				System.out.print("What is the Supplier Name: ");
				String supplierName = scanner.nextLine();
				Product product = new Product(productID, productName, supplierName);
				list.insertAtFront(product);
				System.out.println("\nItem inserted\n");
				break;
			//Deletes node from the front of list
			case("4"):
				if(list.getHead() == null)
					System.out.println("List is empty");
				else {
					System.out.println("Deleting front node");
					System.out.println(list.getHead().getData().toString());
					list.deleteFromFront();
					System.out.println("Item deleted\n");
				}
				break;
			//Deletes item of certain ID
			case("5"):
				valid = false;
				do {
					System.out.print("What ID do you need to find? ");
					try {
						input = scanner.nextInt();
						valid = true;
					}
					catch(Exception e) {
						System.out.println("Invalid input, please put in an integer");
						scanner.next();
					}
				} while(!valid);
				
				if (((list.findID(input) == null)))
					System.out.println("\nItem does not exist\n");
				else {
					System.out.println(list.findID(input).toString());
					list.delete(input);
					System.out.println();
					System.out.println("Item deleted\n");
				}
				break;
			//Prints all items in list
			case("6"):
				System.out.println("Printing all records:\n");
				list.printAllRecords();
				break;
			//Exits out of program
			case("7"):
				System.out.println("Done");
				return;
			default:
				System.out.println("Invalid Output");
				break;
			}
		} while(input != 7);
		
		scanner.close();
	}
}
