package praktikum_4;

public class Textbook extends Book {
	private String studi;
	
	public Textbook(String title, String author, String studi) {
		super(title, author);
		this.studi = studi;
	}
	
	public String getStudi() {
		return studi;
	}
}