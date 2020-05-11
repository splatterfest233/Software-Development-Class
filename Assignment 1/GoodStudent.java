
public class GoodStudent extends Thread{
	public void run() {
		for(int i=0; i<20; i++) {
			System.out.println("I am working hard");
			try {
				Thread.sleep(1000);
			}catch(Exception ex) {
				ex.getStackTrace();
			}
		}
	}

}
