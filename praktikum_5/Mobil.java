package praktikum_5;

public final class Mobil extends Kendaraan implements BahanBakar {
	private String jenisTransmisi;
	
	public Mobil (String merk, String model, int tahunProduksi, String jenisTransmisi) {
		super(merk, model, tahunProduksi);
		this.jenisTransmisi = jenisTransmisi;
	}
	
	public void nyalakanMesin() {
		System.out.println("Nyalakan Mesin : Tekan tombol start engine");
	}
	
	public String jenisBahanBakar() {
		return "Bensin";
	}
	
	public void fiturMobil() {
		System.out.println("Fitur mobil: Air Conditioner, Sensor Parkir, dan audio premium.");		
	}
	
}
