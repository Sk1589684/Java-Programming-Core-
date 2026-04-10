package AbstractClass;



public abstract class Hospital {
abstract void emergency();
abstract void admit();
abstract void appointment();
abstract void billing();
}

class MyHospital extends Hospital{
	MyHospital(){
		System.out.print("constr of My Hospial");
	}

	@Override
	void emergency() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void admit() {
		System.out.print("Please fill out the form for admitting a patient:");
		
	}

	@Override
	void appointment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void billing() {
		// TODO Auto-generated method stub
		
	}
	
}




