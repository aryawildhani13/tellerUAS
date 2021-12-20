import java.util.Scanner;
public class App{

	static Scanner sc = new Scanner(System.in);
	static int kodeTab = 0, indexR = 0; // data global
	static int menuAwal,menuNasabah, id, idTf, kodeTf;
	static int setor, tarik, transfer;
	static char nasabahTf, nasabahExit = 'T';
	static String[][] user =  {
    {"1","Agus","Medan","08123456789","Sumriatin"},
    {"2","Arip","Malang","08232223344","Suliatin"},
   	{"3","Samsul","Tuban","08432432424","Bella"},
   	{"","", "", "", ""} 
   	};

   	static String[] riwayat = new String[10];

    static int[][] userRek = {
   	{120000,240000}, // agus
    {150000,270000}, // arip
   	{170000,220000}, // samsul
   	{0 , 0} // inputan 	
   	};

	public static void main(String[] args) {

   	while(true){ //while1 menu teller
	System.out.print("\n");
    System.out.println("== Menu Teller ==");
    System.out.println("== 1.Lihat Data Nasabah ==");
    System.out.println("== 2.Input Data Nasabah ==");
    System.out.println("== 3.Keluar Menu Teller ==");
    System.out.print("Masukkan menu (1/2/3) : ");
    menuAwal = sc.nextInt();

    switch(menuAwal) {
  	case 1:
  		//tampil semua data
	    System.out.print("\n");
	    System.out.print("ID|nama  \n");
    	for (int i=0; i<user.length; i++){
    	 	for (int j=0; j<2; j++){
            System.out.print(user[i][j]+"  ");
        }     
        System.out.println(" ");
	       }
		System.out.print("\n");

	    //memanggil id pada menu
	    System.out.print("Masukkan id nomor urut :");
	    id = sc.nextInt();

	    //menampilkan id yang di ambil
	    System.out.print("\n");
	    System.out.print("\t\t DATA DETAIL NASABAH \n");
	    System.out.print("=================================================\n");
	    System.out.print("ID |\tNama  |\tAlamat |   Nomor HP   |   Nama Ibu\n");
	    System.out.print("=================================================\n");
	    for (int a=0; a<user[0].length;) {
	    System.out.print(user[id-1][a] + "\t");
	    a++;
	    }
	    System.out.print("\n\n\n");

	    	do{
	    	//menu nasabah
		    System.out.print("\n");
	    	System.out.println("== Menu Nasabah ==");
	    	System.out.println("== 1.Informasi Saldo =="); 
	    	System.out.println("== 2.Setor Tunai ==");
	    	System.out.println("== 3.Tarik Tunai ==");
	    	System.out.println("== 4.Transfer ==");
	    	System.out.println("== 5.Riwayat Transaksi ==");
	    	System.out.println("== 6.Kembali Ke Menu Teller ==\n");
	    	System.out.print("Masukkan menu (1/2/3/4/5) : ");
	    	menuNasabah = sc.nextInt();
	    	switch(menuNasabah){
	    	case 1:
	   			System.out.print("\n\n");
				System.out.println("===== Informasi Saldo =====");
	    		cekMenuTab();

	    			if (kodeTab == 1) {
	    				cekSaldo();
	    			} else if (kodeTab == 2) {
	    				cekSaldo();
	    			} else {
	    				System.out.print("Masukkan Anda Salah! / Tidak Ada!");	
	    			}
	    		riwayat[indexR] = String.format("%s Cek Tabungan",user[id-1][1]);
				indexR++;
	    		System.out.println("\n");
	    		System.out.println("Kembali ke Menu Nasabah? (Y|T)");
	    		nasabahExit = sc.next().charAt(0); 

	    	break;
	    	case 2: //setor
	    		System.out.print("\n\n");
				System.out.println("===== Menu Setor Tunai =====");
	    		cekMenuTab();
	    		setor();
	    		System.out.println("\n");

	    	break;
	    	case 3: //tarik
	    		System.out.print("\n\n");
				System.out.println("===== Menu Tarik Tunai =====");
	    		cekMenuTab();
	    		tarik();
	    		System.out.println("\n");

	    	break;
	    	case 4: //transfer 
	    		System.out.print("\n\n");
				System.out.println("===== Menu Transfer =====");
	    		cekMenuTab();
	    		transfer();
	    		System.out.println("\n");

	    	break;
	    	case 5:
	    		System.out.println("\n");
	    		System.out.print("=================================================\n");
	    		System.out.println("\t\t Riwayat Transaksi");
	    		System.out.print("=================================================\n");
	    		for (int i=0; i<indexR; i++){
					System.out.print(riwayat[i]+"\n");	            	
        		} // tutup for  
	    	break;
	    	case 6:
		    	System.out.println("===============================");
				System.out.println("Keluar Menu Nasabah....\n");
				nasabahExit = 't';
		    break;
	    	default : 
				System.out.print("Menu Nasabah Kosong!\n");
			break;
		    } //exit switch menu nasabah

		    } while(nasabahExit == 'y' || nasabahExit == 'Y');

    break;
  	case 2:
  		user[3][0] = user.length+"";
  		System.out.print("Masukkan Nama :");
  		user[3][1] = sc.next();
  		System.out.print("Masukkan Alamat :");
  		user[3][2] = sc.next();
  		System.out.print("Masukkan Nomor Hp :");
  		user[3][3] = sc.next();
  		System.out.print("Masukkan Nama Ibu Kandung :");
  		user[3][4] = sc.next();
  		System.out.print("Masukkan Nominal Awal Tabungan :");
  		userRek[3][0] = sc.nextInt();
  		System.out.print("Masukkan Nominal Awal Giro :");
  		userRek[3][1] = sc.nextInt();
    break;

  	case 3:
    System.out.println("===============================");
	System.out.println("Menu Keluar....\n\n");
    return;

    default : 
	System.out.print("Menu Kosong, Program Akan Dikeluarkan");
	System.out.println("===============================");
	System.out.println("Program Keluar....\n\n");
	return;
} // close switch
} // close while true

} //close main

static void cekMenuTab(){ //fungsi menu nasabah
	System.out.println("== Pilih Jenis Rekening ==");
	System.out.println("1. Tabungan ");
	System.out.println("2. Giro ");
	System.out.print("Masukkan Kode Rekening (1/2) :  ");
	kodeTab = sc.nextInt();
	System.out.println("=================================");
} //close menutab

static void cekSaldo(){
	System.out.println("Jumlah Tabungan Anda Sebesar : Rp." + userRek[id-1][kodeTab-1]);	
} //close cekSaldo

static void setor(){
	if (kodeTab == 1) { //rekening
	    				cekSaldo();
	    				System.out.print("Masukkan Nominal Yang Ingin Disetor : Rp.");
	    				setor = sc.nextInt();

	    				userRek[id-1][kodeTab-1] += setor; //setor dengan menambah jumlah tabungan
	    				riwayat[indexR] = String.format("%s Setor Tunai pada Rekening Tabungan Sejumlah = %d",user[id-1][1], setor);
						indexR++;
	    			} else if (kodeTab == 2) { //giro
	    				cekSaldo();
	    				System.out.print("Masukkan Nominal Yang Ingin Disetor : Rp.");
	    				setor = sc.nextInt();

	    				userRek[id-1][kodeTab-1] += setor; //setor dengan menambah jumlah tabungan
	    				riwayat[indexR] = String.format("%s Setor Tunai pada Rekening Giro Sejumlah = %d",user[id-1][1], setor);
						indexR++;
	    			} else {
	    				System.out.print("Masukkan Anda Salah! / Tidak Ada!");
	    			}
	System.out.println("================================================");				
	System.out.println("Sisa Saldo Anda Saat ini Adalah : Rp." + userRek[id-1][kodeTab-1]);    			
	System.out.println("\n");
	System.out.println("Kembali ke Menu Nasabah? (Y|T)");
	nasabahExit = sc.next().charAt(0);

} // close fungsi setor

static void tarik(){
	if (kodeTab == 1) { //menentukan tabungan atau giro
	    				cekSaldo();
	    				System.out.print("Masukkan Nominal Yang Ingin Ditarik : Rp.");
	    				tarik = sc.nextInt();

	    				if (userRek[id-1][kodeTab-1]>tarik) { //cek saldo apakah mencukupi
		    				
							userRek[id-1][kodeTab-1] -= tarik; //tarik dengan mengurangi jumlah tabungan
		    				riwayat[indexR] = String.format("%s Tarik Tunai pada Rekening Tabungan Sejumlah = %d",user[id-1][1], tarik);
							indexR++;
		    				System.out.println("\n");
	    					System.out.print("Saldo Berhasil di Tarik!\n");
							System.out.println("================================================");

	    				} else {
	    					System.out.println("\n");
	    					System.out.print("Nominal Saldo Anda Tidak Mencukupi!, Lakukan Setor Dahulu!");
	    				}
	    			} else if (kodeTab == 2) {
	    				cekSaldo();
	    				System.out.print("Masukkan Nominal Yang Ingin Ditarik : Rp.");
	    				tarik = sc.nextInt();

	    				if (userRek[id-1][kodeTab-1]>tarik) { //cek saldo apakah mencukupi
							userRek[id-1][kodeTab-1] -= tarik; //tarik dengan mengurangi jumlah tabungan
		    				riwayat[indexR] = String.format("%s Tarik Tunai pada Rekening Giro Sejumlah = %d",user[id-1][1], tarik);
							indexR++;
		    				System.out.println("\n");
	    					System.out.print("Saldo Berhasil di Tarik!\n");
							System.out.println("================================================");
	    				} else {
	    					System.out.println("\n");
	    					System.out.print("Nominal Anda Tidak Mencukupi!, Lakukan Setor Dahulu!");
	    				}

	    			} else {
	    				System.out.println("\n");
	    				System.out.print("Masukkan Anda Salah! / Tidak Ada!");
	    			}
	   			
	System.out.println("Sisa Saldo Anda Saat ini Adalah : Rp." + userRek[id-1][kodeTab-1]);System.out.println("\n");			
	System.out.println("Kembali ke Menu Nasabah? (Y|T)");
	nasabahExit = sc.next().charAt(0);

} //close fungsi tarik	


static void transfer(){
	if (kodeTab == 1) { //cek tabungan
	    				cekSaldo();
	    				System.out.print("Masukkan Nominal Yang Ingin Ditransfer : Rp.");
	    				transfer = sc.nextInt();

	    				//cek saldo
	    				if (userRek[id-1][kodeTab-1] > transfer) { //cek saldo mencukupi
	    				System.out.println("\n");

				     	//input id yang ingin di transfer
	    				System.out.print("Masukkan ID Rekening Tujuan :");
	    				idTf = sc.nextInt();

						System.out.printf("Apakah Anda Ingin Transfer Ke Rekening Atas Nama %s ? \n",user[idTf-1][1]);
						System.out.print("(Y/T) : ");	
						nasabahTf = sc.next().charAt(0); 

							if (nasabahTf == 'y' || nasabahTf == 'Y'){ 
								userRek[idTf-1][kodeTab-1] += transfer; //nambah tabungan
								userRek[id-1][kodeTab-1] -= transfer; //mengurangi tabungan
								System.out.print("Transfer Berhasil !!!\n");
								System.out.println("================================================");
			    				riwayat[indexR] = String.format("%s Transfer Rekening Tabungan ke Akun %s Sejumlah %d",user[id-1][1],user[idTf-1][1],transfer);
								indexR++;

					    	} else {
					    		System.out.print("Menu Transfer Dibatalkan !");
					    		}
						} else { // else cek saldo
				    		System.out.println("\n");
	    					System.out.print("Nominal Saldo Anda Tidak Mencukupi!, Lakukan Setor Dahulu!");
				    		}

	    			} else if (kodeTab == 2) {
	    				cekSaldo();
	    				System.out.print("Masukkan Nominal Yang Ingin Ditransfer : Rp.");
	    				transfer = sc.nextInt();

	    				//cek saldo
	    				if (userRek[id-1][kodeTab-1] > transfer) { //cek saldo mencukupi
	    				System.out.println("\n");

				     	//input id yang ingin di transfer
	    				System.out.print("Masukkan ID Rekening Tujuan :");
	    				idTf = sc.nextInt();
						System.out.printf("Apakah Anda Ingin Transfer Ke Rekening Giro Atas Nama %s ? \n",user[idTf-1][1]);
						System.out.print("(Y/T) : ");	
						nasabahTf = sc.next().charAt(0); 

							if (nasabahTf == 'y' || nasabahTf == 'Y'){ 
								userRek[idTf-1][kodeTab-1] += transfer; //nambah tabungan
								userRek[id-1][kodeTab-1] -= transfer; //mengurangi tabungan
								System.out.print("Transfer Berhasil !!!\n");
								System.out.println("================================================");
			    				riwayat[indexR] = String.format("%s Transfer Rekening Giro ke Akun %s Sejumlah %d",user[id-1][1],user[idTf-1][1],transfer);
								indexR++;

					    	} else {
					    		System.out.print("Menu Transfer Dibatalkan !");
					    		}
						} else { // else cek saldo
				    		System.out.println("\n");
	    					System.out.print("Nominal Anda Tidak Mencukupi!, Lakukan Setor Dahulu!\n");
							System.out.println("================================================");
				    		}

	    			} else { //else bukan inputan tabungan 1/2
	    				System.out.print("Masukkan Anda Salah! / Tidak Ada!");
	    			}
	
	System.out.println("Sisa Saldo Anda Saat ini Adalah : Rp." + userRek[id-1][kodeTab-1]);    			
	System.out.println("\n");
	System.out.println("Kembali ke Menu Nasabah? (Y|T)");
	nasabahExit = sc.next().charAt(0);
} // close fungsi transfer

} // close java

//ceklist setor,tarik,lihata,input kelar! merapikan rules menu ! 
//kurang riwayat transfer