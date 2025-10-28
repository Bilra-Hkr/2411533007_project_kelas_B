package praktikum_5;

public class Pesawat extends Kendaraan implements TransportasiUdara, Maskapai {

	public Pesawat(String merk, String model, int tahunProduksi) {
		super(merk, model, tahunProduksi);
	}

	@Override
	public void nyalakanMesin() {
		System.out.println("Nyalakan Mesin: Bersiap lepas Landas");
	}
	
	@Override
	public String jenisBahanBakar() {
		return "Avtur";
	}

	@Override
	public String namaMaskapai() {
		return "Garuda Indonesia";
	}

	@Override
	public String jenisPenerbangan() {
		return "Penerbangan Domestik";
	}
}
