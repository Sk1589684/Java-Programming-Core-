package Interface;

public class CollectionOp implements Comparable<CollectionOp>{
	private int id;
	private String name;
	/**
	 * @param id
	 * @param name
	 */
	public CollectionOp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(CollectionOp obj) {
		// TODO Auto-generated method stub
		return this.id-obj.id;
	}
	
	public void display() {
		System.out.println("----------------------");
		System.out.println("Id is :"+id);
		System.out.println("Name is :"+name);
		System.out.println("----------------------");
	}
	
	}


