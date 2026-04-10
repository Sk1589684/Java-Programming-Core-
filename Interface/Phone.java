package Interface;

public class Phone {
void call() {
	System.out.println("Do You want to make a call ?");
}
void sms() {
	System.out.println("Do you want to make a SMS?");
}
}

interface Camera{
	void click();
	void record();
}
interface MusicPlayer{
	void play();
	void pause();
	void stop();
	
}
