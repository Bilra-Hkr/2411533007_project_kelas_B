package praktikum9;

class CookingTask extends Thread {
	private String task;
	
	CookingTask (String task) {
		this.task = task;
	}
	
	public void run() {
		System.out.println(task + " is being prepared by " + 
				Thread.currentThread().getName());
	}
}

public class RestaurantExtendsThread {
	public static void main(String[] args) {
		 Thread chef1 = new CookingTask("Nasgor");
		 Thread chef2 = new CookingTask("Mienas");
		 Thread chef3 = new CookingTask("Roti Bakar");
		 Thread chef4 = new CookingTask("Nasi Padang");
		 
		 chef1.start();
		 chef2.start();
		 chef3.start();
		 chef4.start();
	}
}
