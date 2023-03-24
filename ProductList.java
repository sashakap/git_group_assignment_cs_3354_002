/** Linked list that contains Product nodes
 * @author Sasha Kaplan
 * @author CS 3345.003
 * @since 02-22-2023
 * @version 1.0
*/
public class ProductList<AnyType extends IDedObject>{
	
	/**
	 * Node Class for Product List
	 * @param <AnyType> Generic for Node Data
	 */
	class Node<AnyType>{
		//Node Instance Fields
		Node<AnyType> next;
		AnyType data;
		
		/**
		 * Empty Constructor for Nodes
		 */
		public Node() {;}
		
		/**
		 * Overloaded constructor of Nodes
		 * @param data new data of AnyType when constructing new Node
		 */
		public Node(AnyType data) {this.data = data;}
		
		/**
		 * Return's thenode's next node
		 * @return Node's next node
		 */
		public Node<AnyType> getNext() {
			return next;
		}
		
		/**
		 * Sets a node's next to a new node
		 * @param next New node to be set to
		 */
		public void setNext(Node<AnyType> next) {
			this.next = next;
		}
		
		/**
		 * Returns Node's data
		 * @return Node's product data
		 */
		public AnyType getData() {
			return data;
		}
		
		/**
		 * Sets data of new Node
		 * @param data New data of new node
		 */
		public void setData(AnyType data) {
			this.data = data;
		}
	}
	
	//Head node of list
	private Node<AnyType> head;

	/**
	 * Empty constructor of ProductList Class
	 */
	public ProductList() {
		this.head = null;
	}
	
	/**
	 * Returns head node in list
	 * @return Head node in the list
	 */
	public Node<AnyType> getHead() {
		return head;
	}

	/**
	 * Set's the head of list to a new Node
	 * @param head New head node of the list
	 */
	public void setHead(Node<AnyType> head) {
		this.head = head;
	}


	/**
	 * Empties the linked list
	 */
	public void makeEmpty() {
		this.head = null;
	} 
	
	/**
	 * Searches through list for a certain node of productID, ID
	 * @param ID ID of the node to be found
	 * @return Node if found, or null if not found
	 */
	public AnyType findID(int ID) {
		Node<AnyType> temp = this.head;
		while(temp != null) {
			if(temp.getData().getID() == ID)
				return temp.getData();
			else
				temp = temp.next;
		}
		return null;
	}
	
	/**
	 * Inserts a new Node at the front
	 * @param x New node to be inserted
	 * @return false if node already exists, true if it does not exist
	 */
	public boolean insertAtFront(AnyType x) {
		// insert at front of list or return false if that ID already exists 
		if(findID(x.getID()) == null) {
			Node<AnyType> newHead = new Node<AnyType>(x);
			newHead.next = this.head;
			this.head = newHead;
			return true;
		}
		return false;
	}
	
	/**
	 * Deletes node from the front of the list
	 * @return Node that is deleted
	 */
	public AnyType deleteFromFront() {
		// delete and return the record at the front of  
		//the list or return null if the list is empty 
		if(this.head == null)
			return null;
		
		Node<AnyType> temp = this.head;
		this.head = head.next;
		return temp.data;
	}
	
	/**
	 * Deletes node of a certain productID
	 * @param ID productID of the node to be deleted
	 * @return Node that is deleted
	 */
	public AnyType delete(int ID) {
		// find and delete the record with the given ID or returns null if it isn’t found
		Node<AnyType> temp = this.head;
		Node<AnyType> previous = null;
		Node<AnyType> ret;
		
		while(temp != null) {
			if(temp.getData().getID() == ID) {
				if(previous == null) {
					deleteFromFront();
					return temp.data;
				}
				ret = temp;
				previous.next = temp.next;
				return ret.data;
			}
			
			else {
				previous = temp;
				temp = temp.next;
			}
		}
		
		return null;
	}
	
	/**
	 * Loops through the list and prints contents of each node
	 */
	public void printAllRecords() {
		Node<AnyType> temp = this.head;
		while(temp != null) {
			System.out.println(temp.data.toString()+ "\n");
			temp = temp.next;
		}
	}

}
