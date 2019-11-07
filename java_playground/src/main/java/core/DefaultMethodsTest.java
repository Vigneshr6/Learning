package core;

@FunctionalInterface
interface Singer {
	public void sing();
	default public void eat() {
		System.out.println("not hungry");
	}
}
@FunctionalInterface
interface Dancer {
	public void dance();
	default public void eat() {
		System.out.println("ok");
	}
}
 

public class DefaultMethodsTest  implements Singer,Dancer{

	@Override
	public void dance() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		
	}

	

}
