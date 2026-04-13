package Interface;
interface Test{
	void meth1();
	void meth2();
}
public class interfacepractice implements Test {

	@Override
	public void meth1() {
		System.out.println("In method 1");
	}
	@Override
	public void  meth2() {
		System.out.println("In method 2");
	}
	public void meth3() {
		System.out.println("In method 3");
	}
	
}
