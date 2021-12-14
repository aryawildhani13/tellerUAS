import java.util.Scanner;
public class bank{
	static Scanner sc = new Scanner(System.in);
	static int kodeTab = 0; // data global
	static int menuAwal,menuNasabah, id, idTf, kodeTf;
	static int setor, tarik, transfer;
	static char nasabahTf, nasabahExit = 'T';
	static String[][] user =  {
    {"1.","Agus","malang","08123456789","sumriatin"},
    {"2.","arip","malang","08232223344","suliatin"},
   	{"3.","samsul","malang","08432432424","bella"},
   	{"","", "", "", ""} 
   	};

   	// String[][] riwayat = new String[4][3];

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
    System.out.println("== 3.Keluar menu teller ==");
    System.out.print("Masukkan menu (1/2/3) : ");
    menuAwal = sc.nextInt();

    switch(menuAwal) {
  	case 1:
  		//tampil semua data
	    System.out.print("\n");
	    System.out.print("Id| nama  |\n");
    	for (int i=0; i<user.length; i++){
    	 	for (int j=0; j<2; j++){
            System.out.print(user[i][j]+" ");
        }     
        System.out.println(" ");
	       }
		System.out.print("\n");

	    //memanggil id pada menu
	    System.out.print("Masukkan id nomor urut :");
	    id = sc.nextInt();

	    //menampilkan id yang di ambil
	    System.out.print("\n");
	    System.out.print("Id |	nama  | alamat | nomor Hp   |   Nama Ibu\n");
	    for (int a=0; a<user[0].length;) {
	    System.out.print(user[id-1][a] + "\t");
	    a++;
	    }
	    System.out.print("\n");

	    	do{
	    	//menu nasabah
		    System.out.print("\n");
	    	System.out.println("== Menu Nasabah ==");
	    	System.out.println("== 1.cek Saldo =="); 
	    	System.out.println("== 2.Setor tabungan ==");
	    	System.out.println("== 3.Ambil tabungan ==");
	    	System.out.println("== 4.Transfer tabungan ==");
	    	System.out.println("== 5.riwayat nasabah ==");
	    	System.out.println("== 6.Keluar menu nasabah ==\n");
	    	System.out.print("Masukkan menu (1/2/3/4/5) : ");
	    	menuNasabah = sc.nextInt();
	    	switch(menuNasabah){
	    	case 1:
	    		cekMenuTab();

	    			if (kodeTab == 1) {
	    				cekSaldo();
	    			} else if (kodeTab == 2) {
	    				cekSaldo();
	    			} else {
	    				System.out.print("Masukkan anda salah! / tidak Ada!");	
	    			}
	    		System.out.println("\n");
	    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
	    		nasabahExit = sc.next().charAt(0); 

	    	break;
	    	case 2: //setor
	    		cekMenuTab();
	    		
	    			if (kodeTab == 1) {
	    				System.out.println("\n");
	    				cekSaldo();
	    				System.out.println("\n");
	    				System.out.print("Masukkan nominal yang ingin disetor : Rp.");
	    				setor = sc.nextInt();

	    				setor(); // memanggil fungsi setor

			    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
			    		nasabahExit = sc.next().charAt(0); 

	    			} else if (kodeTab == 2) {
	    				System.out.println("\n");
	    				System.out.print("jumlah tabungan Giro anda sebesar : Rp." + userRek[id-1][kodeTab-1]);
	    				cekSaldo();
	    				System.out.println("\n");
	    				System.out.print("Masukkan nominal yang ingin disetor : Rp.");
	    				setor = sc.nextInt();

	    				setor();

	    				System.out.println("\n");
			    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
			    		nasabahExit = sc.next().charAt(0); 
	    			} else {
	    				System.out.print("Masukkan anda salah! / tidak Ada!");
	    			}

	    		System.out.println("\n");

	    	break;
	    	case 3: //tarik
	    		cekMenuTab();
	    		
	    			if (kodeTab == 1) { //menentukan tabungan atau giro
	    				System.out.println("\n");
	    				cekSaldo();
	    				System.out.println("\n");
	    				System.out.print("Masukkan nominal yang ingin ditarik : Rp.");
	    				tarik = sc.nextInt();

	    				if (userRek[id-1][kodeTab-1]>tarik) { //cek saldo apakah mencukupi
		    				tarik();

		    				System.out.println("\n");
	    					System.out.print("Saldo berhasil di tarik!. silahkan cek pada menu cek saldo!");
	    					System.out.println("\n");
				    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
				    		nasabahExit = sc.next().charAt(0); 
	    				} else {
	    					System.out.println("\n");
	    					System.out.print("Nominal saldo anda tidak mencukupi!, lakukan setor dahulu!");
	    					System.out.println("\n");
				    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
				    		nasabahExit = sc.next().charAt(0); 
	    				}
	    				

	    			} else if (kodeTab == 2) {
	    				System.out.println("\n");
	    				cekSaldo();
	    				System.out.println("\n");
	    				System.out.print("Masukkan Giro yang ingin ditarik : Rp.");
	    				tarik = sc.nextInt();

	    				if (userRek[id-1][kodeTab-1]>tarik) { //cek saldo apakah mencukupi
		    				tarik();

		    				System.out.println("\n");
	    					System.out.print("Saldo berhasil di tarik!. silahkan cek pada menu cek saldo!");
	    					System.out.println("\n");
				    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
				    		nasabahExit = sc.next().charAt(0); 

	    				} else {
	    					System.out.println("\n");
	    					System.out.print("Nominal Giro anda tidak mencukupi!, lakukan setor dahulu!");
	    					System.out.println("\n");
				    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
				    		nasabahExit = sc.next().charAt(0); 
	    				}

	    			} else {
	    				System.out.print("Masukkan anda salah! / tidak Ada!");
	    				System.out.println("\n");
			    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
			    		nasabahExit = sc.next().charAt(0); 
	    			}
	    		System.out.println("\n");

	    	break;
	    	case 4: //transfer 
	    		
	    		cekMenuTab();

	    		if (kodeTab == 1) { //cek tabungan
	    				System.out.println("\n");
	    				cekSaldo();
	    				System.out.println("\n");
	    				System.out.print("Masukkan nominal yang ingin ditransfer : Rp.");
	    				transfer = sc.nextInt();

	    				//cek saldo
	    				if (userRek[id-1][kodeTab-1] > transfer) { //cek saldo mencukupi
	    				System.out.println("\n");

				     	//input id yang ingin di transfer
	    				System.out.print("Masukkan id nomor urut :");
	    				idTf = sc.nextInt();
						System.out.println("apakah anda ingin transfer tabungan Rekening ke nama " + user[idTf-1][1]);
						System.out.print("transfer? (Y/T) : ");	
						nasabahTf = sc.next().charAt(0); 

						System.out.print("\n");

							if (nasabahTf == 'y' || nasabahTf == 'Y'){ 
								transfer();

								System.out.println("\n");
					    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
					    		nasabahExit = sc.next().charAt(0);
					    	} else {
					    		System.out.print("menu transfer dibatalkan !");
									System.out.println("\n");
						    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
						    		nasabahExit = sc.next().charAt(0); 
					    		}
						} else { // else cek saldo
				    		System.out.println("\n");
	    					System.out.print("Nominal saldo anda tidak mencukupi!, lakukan setor dahulu!");
	    			
	    					System.out.println("\n");
				    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
				    		nasabahExit = sc.next().charAt(0); 
				    		}

	    			} else if (kodeTab == 2) {
	    				System.out.println("\n");
	    				cekSaldo();
	    				System.out.println("\n");
	    				System.out.print("Masukkan nominal yang ingin ditransfer : Rp.");
	    				transfer = sc.nextInt();

	    				//cek saldo
	    				if (userRek[id-1][kodeTab-1] > transfer) { //cek saldo mencukupi
	    				System.out.println("\n");

				     	//input id yang ingin di transfer
	    				System.out.print("Masukkan id nomor urut :");
	    				idTf = sc.nextInt();
						System.out.println("apakah anda ingin transfer giro Rekening ke nama " + user[idTf-1][1]);
						System.out.print("transfer? (Y/T) : ");	
						nasabahTf = sc.next().charAt(0); 

						System.out.print("\n");

							if (nasabahTf == 'y' || nasabahTf == 'Y'){ 
								transfer();

								System.out.println("\n");
					    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
					    		nasabahExit = sc.next().charAt(0);
					    	} else {
					    		System.out.print("menu transfer dibatalkan !");
									System.out.println("\n");
						    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
						    		nasabahExit = sc.next().charAt(0); 
					    		}
						} else { // else cek saldo
				    		System.out.println("\n");
	    					System.out.print("Nominal giro anda tidak mencukupi!, lakukan setor dahulu!");
	    					System.out.println("\n");
				    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
				    		nasabahExit = sc.next().charAt(0); 
				    		}

	    			} else { //else bukan inputan tabungan 1/2
	    				System.out.print("Masukkan anda salah! / tidak Ada!");
	    				System.out.println("\n");
			    		System.out.println("Kembali ke menu Nasabah? (Y|T)");
			    		nasabahExit = sc.next().charAt(0); 
	    			}

	    		System.out.println("\n");

	    	break;
	    	case 5:
	    		// riwayat;
	    	break;
	    	case 6:
		    	System.out.println("===============================");
				System.out.println("Keluar menu nasabah....\n\n");
		    break;
	    	default : 
				System.out.print("menu Nasabah kosong!");
			break;
		    } //exit switch menu nasabah

		    } while(nasabahExit == 'y' || nasabahExit == 'Y');

    break;
  	case 2:
  		user[3][0] = user.length+".";
  		System.out.print("Masukkan nama :");
  		user[3][1] = sc.next();
  		System.out.print("Masukkan alamat :");
  		user[3][2] = sc.next();
  		System.out.print("Masukkan nomor Hp :");
  		user[3][3] = sc.next();
  		System.out.print("Masukkan nama ibu kandung :");
  		user[3][4] = sc.next();
  		System.out.print("masukkan nominal awal tabungan :");
  		userRek[3][0] = sc.nextInt();
  		System.out.print("Masukkan nominal awal Giro :");
  		userRek[3][1] = sc.nextInt();
    break;

  	case 3:
    System.out.println("===============================");
	System.out.println("Menu Keluar....\n\n");
    return;

    default : 
	System.out.print("menu kosong, program akan dikeluarkan");
	System.out.println("===============================");
	System.out.println("program keluar....\n\n");
	return;
}
}

} //close main

static void cekMenuTab(){ //fungsi menu nasabah
	System.out.println("Menu Setor Tabungan!!\n");
	System.out.println("== Pilih jenis rekening ==");
	System.out.println("1. tabungan ");
	System.out.println("2. Giro ");
	System.out.print("Masukkan kode rekening (1/2) : ");
	kodeTab = sc.nextInt();
} //close menutab

static void cekSaldo(){
	System.out.print("jumlah tabungan anda sebesar : Rp." + userRek[id-1][kodeTab-1]);
	} //close cekSaldo

static void tarik(){
	userRek[id-1][kodeTab-1] -= tarik; //tarik dengan mengurangi jumlah tabungan
}	

static void setor(){
	userRek[id-1][kodeTab-1] += setor; //setor dengan menambah jumlah tabungan
}

static void transfer(){
	userRek[idTf-1][kodeTab-1] += transfer; //nambah tabungan
	userRek[id-1][kodeTab-1] -= transfer; //mengurangi tabungan
}

} // close java

//ceklist setor,tarik,lihata,input kelar! merapikan rules menu ! 
//kurang riwayat transfer