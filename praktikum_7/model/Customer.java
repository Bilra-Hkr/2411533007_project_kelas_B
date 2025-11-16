package model;

public class Customer {
	private String id, nama, email, alamat, noHp;
	
	public Customer (String id, String nama, String email, String alamat, String noHp) {
		super();
		this.id = id;
		this.nama = nama;
		this.email = email;
		this.alamat = alamat;
		this.noHp = noHp;
	}

	public String getId() {
		return id;
	}

	public String getNama() {
		return nama;
	}

	public String getEmail() {
		return email;
	}

	public String getAlamat() {
		return alamat;
	}

	public String getNoHp() {
		return noHp;
	}
}
