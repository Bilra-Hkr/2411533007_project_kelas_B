package praktikum_4;

public class User {
	private String name;
	//Ketika buat objek tanpa parameter nama maka default
	public User() {
		this.name = "Pengguna Umum";
	}
	//Ketika buat object, maka nama sesuai parameter
	public User(String name) {
		this.name = name;
	}
	
	//Method Menampilkan detail buku menggunakna polymorphism
	public void viewBookDetails (Book book) {
		System.out.println("Judul    : " + book.getTitle());
		System.out.println("Penulis  : " + book.getAuthor());
		System.out.println("Tersedia : " + (book.isAvailable()
				? "Ya" : "Tidak"));
		//Polimorphism : cek tipe buku novel
		if (book instanceof Novel) {
			Novel novel = (Novel) book;
			System.out.println("Genre    : " + novel.getGenre());
		}
		//Polimorphism : cek tipe buku Magazine
		if (book instanceof Magazine) {
			Magazine novel = (Magazine) book;
			System.out.println("Kategori : " + novel.getKategori());
		}
		//Polimorphism : cek tipe buku Textbook
		if (book instanceof Textbook) {
			Textbook novel = (Textbook) book;
			System.out.println("Bidang Studi: " + novel.getStudi());
		}
	}
	
	//Method Meminjam buku
	public void borrowBook(Book book) {
	    if (book.isAvailable()) {
	        book.borrowBook();
	        System.out.println("Buku \"" + book.getTitle() + "\" berhasil dipinjam"
	                           + " oleh " + this.name + ".");
	    } else {
	        System.out.println("Maaf " + this.name + ", buku \"" + book.getTitle() + 
	                           "\" sedang tidak tersedia.");
	    }
	}
	
	// Method Mengembalikan buku
	public void returnBook(Book book) {
	    if (!book.isAvailable()) {
	        book.returnBook();
	        System.out.println("Buku \"" + book.getTitle() + "\" berhasil"
	                           + " dikembalikan.");
	    } else {
	        System.out.println("Buku \"" + book.getTitle() + "\" sudah tersedia.");
	    }
	}
	
	

}
