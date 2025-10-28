package praktikum_5;

public class Main {

	public static void main(String[] args) {
		Mobil avanza = new Mobil ("Toyota", "Avanza", 2021, "Manual");
		avanza.tampilkanInfo();
		avanza.nyalakanMesin();
		System.out.println("Jenis Bahan Bakar : " + avanza.jenisBahanBakar());
		avanza.infoKonsumsi();
		avanza.fiturMobil();
		
		System.out.println();
		
		Bus busPariwisata = new Bus ("Mercedes-Benz", "Bus Pariwisata", 2018, "Bisnis");
		busPariwisata.tampilkanInfo();
		busPariwisata.nyalakanMesin();
		System.out.println("Jenis Bahan Bakar : " + busPariwisata.jenisBahanBakar());
		busPariwisata.infoKonsumsi();
		System.out.println("Kapasitas Penumpang : " + busPariwisata.kapasitasPenumpang() + " Penumpang");
		busPariwisata.fiturBus();
		
		Bus.JadwalPerjalanan jadwal = busPariwisata.new JadwalPerjalanan ("Jakarta - Bandung", "08:00 WIB");
		jadwal.tampilkanJadwal();
		
		System.out.println();
		
		Pesawat garuda = new Pesawat ("Garuda", "Boeing 737", 1987);
		System.out.println("Maskapai: " + garuda.namaMaskapai());
		garuda.tampilkanInfo();
		System.out.println("Bahan Bakar: " + garuda.jenisBahanBakar());
		System.out.println("Jenis Penerbangan: " + garuda.namaMaskapai());
		garuda.nyalakanMesin();
		
	}

}
