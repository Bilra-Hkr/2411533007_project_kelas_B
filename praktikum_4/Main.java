package praktikum_4;

public class Main {
	public static void main(String[] args) {
		//Membuat objek buku dari berbagai jenis
		Book novel = new Novel("Laskar Pelangi", "Andrea Hirata", "Drama");
		Book magazine = new Magazine("National Geographic", "Variuos Authors", "Science");
		Book textbook = new Textbook("Pemrograman Java", "Anonimus", "Informatika");
		
		//Membuat objek user
		User user = new User();
		
		//Menampilkan detail buku menggunakna polymorphism
		System.out.println("=== Detail Buku ===");
		user.viewBookDetails(novel);
		System.out.println();
		user.viewBookDetails(magazine);
		System.out.println();
		user.viewBookDetails(textbook);
		System.out.println();
		
		//Meminjam buku
		System.out.println("=== Proses Peminjaman Buku ===");
		user.borrowBook(novel);
		user.borrowBook(magazine);
		
		//Menampilkan status ketersedian
		System.out.println("\n=== Status Buku Setelah Dipinjam ===");
		System.out.println(novel.getTitle() + " tersedia: " + novel.isAvailable());
		System.out.println(magazine.getTitle() + " tersedia: " + magazine.isAvailable());
		
		//Mengembalikan buku
		System.out.println("\n=== Proses Pengembalian Buku ===");
		user.returnBook(novel);
		
		//Menampilkan status ketersedian setelah pengembalian
		System.out.println("\n=== Status Buku Setelah Dikembalikan ===");
		System.out.println(novel.getTitle() + " tersedia : " + novel.isAvailable());
	}

}
