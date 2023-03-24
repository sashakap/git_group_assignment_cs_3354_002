/** Node object containing a product's info for ProductList
 * @author Sasha Kaplan
 * @author CS 3345.003
 * @since 02-22-2023
 * @version 1.0
*/

public class Product implements IDedObject{
	private int productID;
	private String productName;
	private String supplierName;
	
	/**
	 * Default Constructor of Product Class
	 */
	public Product() {;}
	
	/**
	 * Overloaded Constructor of Product Class
	 * @param productID - productID of new node
	 * @param productName - productName of new node
	 * @param supplierName - supplierName of new node
	 */
	public Product (int productID, String productName, String supplierName) {
		this.productID = productID;
		this.productName = productName;
		this.supplierName = supplierName;
	}
	
	/**
	 * Prints the ID of the object
	 */
	public void printID() {
		System.out.println(this.productID);
	}       
	
	/**
	 * Returns the ID of the object
	 * @return productID of given Product 
	 */
	public int getID() {
		return productID;
	}     
	
	/**
	 * Replaces the productID of the Product object
	 * @param productID The new productID of the Product object
	 */
	public void setID(int productID) {
		this.productID = productID;
	}
	
	/**
	 * Returns the Product name of the object
	 * @return productName of given Product 
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Replaces the productName of the Product object
	 * @param productName The new productID of the Product object
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Returns the Supplier Name of the object
	 * @return supplierName of given Product 
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * Replaces the supplierName of the Product object
	 * @param supplierName The new productID of the Product object
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	@Override
	/**
	 * Returns the Product object in a string representation
	 * @return product as a string
	 */
	public String toString() {
		String s = this.productID + "\n" + this.productName + "\n" + this.supplierName;;
		return s; 
	}
}
