package praktikum_5;

public class Bus extends Kendaraan implements TransportasiUmum {
	private String kelasBus;
	
	public Bus (String merk, String model, int tahunProduksi, String kelasBus) {
		super(merk, model, tahunProduksi);
		this.kelasBus = kelasBus;
	}
	
	public void nyalakanMesin() {
        System.out.println("Nyalakan Mesin : Putar Kunci unutk menyalakan");
    }
	
	public String jenisBahanBakar() {
		return "Solar";
	}
	
	public int kapasitasPenumpang() {
        return 45;
    }
	
	public void fiturBus() {
        System.out.println("Fitur bus: Dilengkapi kursi nyaman dan fasilitas hiburan (Wifi).");
    }
	
	//inner class
	public class JadwalPerjalanan {
		private String rute;
		private String waktuBerangkat;
		
		public JadwalPerjalanan (String rute, String waktuBerangkat) {
			this.rute = rute;
			this.waktuBerangkat = waktuBerangkat;
		}
		
		public void tampilkanJadwal() {
			System.out.println("Rute perjalanan : " + rute + ", " + waktuBerangkat);
		}
	}
	

}
