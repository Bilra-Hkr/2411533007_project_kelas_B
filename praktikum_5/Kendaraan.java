package praktikum_5;

public abstract class Kendaraan {
	private String merk;
	private String model;
	private int tahunProduksi;
	
	public Kendaraan (String merk, String model, int tahunProduksi) {
		this.merk = merk;
		this.model = model;
		this.tahunProduksi = tahunProduksi;
	}
	
	//abstract method
	public abstract void nyalakanMesin();
	
	//method final 
	public final void tampilkanInfo() {
		System.out.println("Merek : " + this.merk);
		System.out.println("Model : " + this.model);
		System.out.println("Tahun Produksi : " + this.tahunProduksi);
	}
	

}
