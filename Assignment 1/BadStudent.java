
public class BadStudent extends Thread{
	public void run() {
		for(int i=0; i<20; i++) {
			System.out.println("I am playing games");
			try {
				Thread.sleep(1000);
			}catch(Exception ex) {
				System.out.println(ex.getStackTrace());
			}
		}
	}
}
