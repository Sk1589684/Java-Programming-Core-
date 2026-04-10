package Interface;

public class TestPhone {

	public static void main(String[] args) {
		SmartPhone s=new SmartPhone();
		
		Phone p=s;
		
		Camera c=s;
		
		MusicPlayer m=s;
		
		s.call();
		
		s.click();
		
		s.pause();
		
		s.play();
		
		s.record();
		
		s.stop();
	
		s.videoCall();
		
		s.sms();
		
	}

}
