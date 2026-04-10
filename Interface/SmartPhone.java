package Interface;

public class SmartPhone extends Phone implements Camera,MusicPlayer{
void videoCall() {
	System.out.println("Do you want to make a video call?");
	
}
@Override
 public void click() {
	System.out.println("Do you want to click a picture ?");
}
@Override
public void record() {
	System.out.println("Recording Started");
}
@Override
public void play() {
	System.out.println("Video Is Playing:");
}
@Override
public void pause() {
	System.out.println("Video Is Paused:");
}
@Override
public void stop(){
	
	System.out.println("video Stopped");
}
}

