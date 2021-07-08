#include<stdio.h>
#include<stdlib.h>
#include<string.h>
void bitis();
void hata();
struct bilgi{
	char filmler[30];
	int yil;
	char yonetmen[30];
	char senarist[30];
	char basoy[30];
};
int main(){
	system("color 3f");
	bilgi dizi[50];
	bilgi bilgi;
	system("cls");
	baslangic:
	 	int menu,sayi1,donus1,donus2,a,donus3,donus4;	
	printf("\n\t\t\t\t\t\t    MENU\n\n");	//
						
	printf("\t\t\t\t\t _________________________ \n");//
	printf("\t\t\t\t\t| 1. Film ekle            |\n");//
	printf("\t\t\t\t\t|_________________________|\n");//
	printf("\t\t\t\t\t| 2. Filmleri Listele     |\n");//
	printf("\t\t\t\t\t|_________________________|\n");//   
	printf("\t\t\t\t\t| 3. Film Guncelle        |\n");// Menünün görünümü
	printf("\t\t\t\t\t|_________________________|\n");//
	printf("\t\t\t\t\t| 4. Film Sil             |\n");//
	printf("\t\t\t\t\t|_________________________|\n");//
	printf("\t\t\t\t\t| 5. Film Ara             |\n");//
	printf("\t\t\t\t\t|_________________________|\n");//
	printf("\t\t\t\t\t| 6. Cikis                |\n");//
	printf("\t\t\t\t\t|_________________________|\n");//
	printf("\t\t\t\t\tLutfen menuden secim yapiniz:  ");
	scanf("%d",&menu);
	
	if(menu==1){//film ekleme menusu
		struct bilgi bilgi;
			FILE *fp=fopen("dosya.txt","a");			
			system("cls");
			printf("kac film eklemek istiyorsunuz?\n");
			scanf("%d",&sayi1);
			if(sayi1<=0){ bitis();
			}
			else{			
			for(a=0; a<sayi1; a++){
				printf("%d.filmin adini giriniz:  ",a+1);
				scanf("%s",&bilgi.filmler);
				fprintf(fp,"%s\t",bilgi.filmler);
				printf("%d.Filmin yonetmenini giriniz:  ",a+1);
				scanf("%s",bilgi.yonetmen);
				fprintf(fp,"%s\t",bilgi.yonetmen);
				printf("%d.Filmin senaristini giriniz:  ",a+1);
				scanf("%s",bilgi.senarist);
				fprintf(fp,"%s\t",bilgi.senarist);
				printf("%d.Filmin basrolunu giriniz:  ",a+1);
				scanf("%s",bilgi.basoy);
				fprintf(fp,"%s\t",bilgi.basoy);
				printf("%d.Filmin yapim yilini giriniz:  ",a+1);
				scanf("%d",&bilgi.yil);
				fprintf(fp,"%d\n",bilgi.yil);
				system("cls");
				 	} fclose(fp);
		
			system("cls");
			printf("Basariyla Eklenmistir!\n");
			bitis();
			}
			}
		else if(menu==2){//sýralama menusu 
			FILE *fp=fopen("dosya.txt","r");
			system("cls");
			int b=0,hold;			
				while(fscanf(fp,"%s%s%s%s%d",&bilgi.filmler,&bilgi.yonetmen,&bilgi.senarist,&bilgi.basoy,&bilgi.yil) !=EOF)
		/*		for(int i=0; i<SIZE; ++i){
				
				if(dizi[b].yil<dizi[b+1].yil){  //çalýþmýyor þimdilik....
					hold = dizi[b].yil;
					dizi[b] = dizi[b+1];
					dizi[b+1].yil = hold;
			}			
		}*/
		
		
		printf("Filmin Adi:\t\t%s\nFilmin Yonetmeni:\t%s\nFilmin Senaristi:\t%s\nFilminBasrolu:\t\t%s\nFilmin Yapim Yili:\t%d\n\n",bilgi.filmler,bilgi.yonetmen,bilgi.senarist,bilgi.basoy,bilgi.yil);
		     fclose(fp);
		bitis();	
	}
		else if(menu==3){  //guncelleme menusu
			system("cls");
			struct bilgi bilgi;
		char film1[30];	
			FILE *fp=fopen("dosya.txt","r");
			FILE *yeni=fopen("dosya1.txt","w");
			printf("guncellenicek film:");
			scanf("%s",film1);
		while(fscanf(fp,"%s%s%s%s%d",&bilgi.filmler,&bilgi.yonetmen,&bilgi.senarist,&bilgi.basoy,&bilgi.yil) !=EOF)
				
		if(strcmp(bilgi.filmler,film1) == 0){
			printf("filmin Yeni Adini Giriniz:  ");
			scanf("%s",&bilgi.filmler);
			fprintf(yeni,"%s\t",bilgi.filmler);
			printf("Filmin Yeni Yonetmenini Giriniz:  ");
			scanf("%s",bilgi.yonetmen);
			fprintf(yeni,"%s\t",bilgi.yonetmen);
			printf("Filmin Yeni Senaristini Giriniz:  ");
			scanf("%s",bilgi.senarist);
			fprintf(yeni,"%s\t",bilgi.senarist);
			printf("Filmin Yeni Basrolunu Giriniz:  ");
			scanf("%s",bilgi.basoy);
			fprintf(yeni,"%s\t",bilgi.basoy);
			printf("Filmin Yeni Yapim Yilini Giriniz:  ");
			scanf("%d",&bilgi.yil);
			fprintf(yeni,"%d\n",bilgi.yil);
			system("cls");
			printf("Filminiz guncellenmistir!\n\n");
			a=1;
			
		}else{
			fprintf(yeni,"%s %s %s %s %d",bilgi.filmler,bilgi.yonetmen,bilgi.senarist,bilgi.basoy,bilgi.yil);
		}		
		_fcloseall();
		remove("dosya.txt");//dosya.txt dosyasý silindi	
		rename("dosya1.txt", "dosya.txt");//Yeni açýlan dosya yeniden adlandýrýldý
			if (a == 0){
				printf("\nBu film bulunamadi!\n");
				}
		bitis();		
			}
			
		else if(menu==4)	{//silme menusu
			system("cls");
			int z;
			a=0;
			struct bilgi bilgi;
		char film2[30];			
			FILE *fp=fopen("dosya.txt","r");
			FILE *yeni=fopen("dosya1.txt","a");
			rewind(fp);
			rewind(yeni);
			printf("Silinecek film:");
			scanf("%s",film2);
			printf("%s filmini silmek istediginize emin misiniz ?\n",film2);
			printf("1. Evet\n");
			printf("2. Hayir\n");
			scanf("%d",&z);
			switch(z){
				case 1:
					break;
				case 2:
					bitis(); break;
				default:
					hata();		
			}
			while (!feof(fp))
			{
			fscanf(fp,"%s\t%s\t%s\t%s\t%d\n",&bilgi.filmler,&bilgi.yonetmen,&bilgi.senarist,&bilgi.basoy,&bilgi.yil);
			if(!strcmp(bilgi.filmler,film2))
		{
			printf("%s filmi basariyla silindi\n",film2);
				a = 1;			
		}
		else 		
			fprintf(yeni,"%s\t%s\t%s\t%s\t%d\n",bilgi.filmler,bilgi.yonetmen,bilgi.senarist,bilgi.basoy,bilgi.yil);
		}
		_fcloseall();
		remove("dosya.txt");//dosya.txt dosyasý silindi	
		rename("dosya1.txt", "dosya.txt");//Yeni açýlan dosya yeniden adlandýrýldý
			if (a == 0)
				printf("\nBu film bulunamadi!\n");
			
			bitis();
		}
					
		else if(menu==5){//Arama menusu
			system("cls");
			FILE *fp=fopen("dosya.txt","r");
			char film2[30],yon1[30],sen1[30],bas[30];
			int secim3,yil;
			printf("1. Filmin adina gore\n");//
			printf("2. Yonetmenine gore\n");//
			printf("3. Senaristine gore\n");//Arama Menusu
			printf("4. Basrolune gore\n");//
			printf("5. Yapim yilina gore\n");//
			scanf("%d",&secim3);
			system("cls");
			rewind(fp);
		switch(secim3){
			case 1:
				printf("Filmin adini giriniz: ");
				scanf("%s",film2);
				printf("Aradiginiz Filmin bilgileri:\n");
				printf("----------------------------\n");
				while(fscanf(fp,"%s",bilgi.filmler) !=EOF){
				fscanf(fp, "%s", &bilgi.yonetmen);		// 
				fscanf(fp, "%s", &bilgi.senarist);		//
				fscanf(fp, "%s", &bilgi.basoy);		//Dosyadan okunan diðer bilgiler
				fscanf(fp, "%d", &bilgi.yil);		//				
				if (!strcmp(bilgi.filmler, film2)){				
				printf("Filmin Adi:\t\t%s\nFilmin Yonetmeni:\t%s\nFilmin Senaristi:\t%s\nFilminBasrolu:\t\t%s\nFilmin Yapim Yili:\t%d\n\n",bilgi.filmler,bilgi.yonetmen,bilgi.senarist,bilgi.basoy,bilgi.yil);								
				}				
				}
				bitis();
				break;
			case 2:
				printf("Yonetmenin adini giriniz:");
				scanf("%s",yon1);	
				printf("Aradiginiz Filmin bilgileri:\n");
				printf("----------------------------\n");
				while(fscanf(fp,"%s",bilgi.filmler) !=EOF){
				fscanf(fp, "%s", &bilgi.yonetmen);		// 
				fscanf(fp, "%s", &bilgi.senarist);		//
				fscanf(fp, "%s", &bilgi.basoy);		//Dosyadan okunan diðer bilgiler
				fscanf(fp, "%d", &bilgi.yil);		//				
				if (!strcmp(bilgi.yonetmen, yon1)){				
				printf("Filmin Adi:\t\t%s\nFilmin Yonetmeni:\t%s\nFilmin Senaristi:\t%s\nFilminBasrolu:\t\t%s\nFilmin Yapim Yili:\t%d\n\n",bilgi.filmler,bilgi.yonetmen,bilgi.senarist,bilgi.basoy,bilgi.yil);								
				}				
				}
					bitis();
				break;		
		
			case 3:
				printf("Senaristin adini giriniz:");
				scanf("%s",sen1);	
				printf("Aradiginiz Filmin bilgileri:\n");
				printf("----------------------------\n");
				while(fscanf(fp,"%s",bilgi.filmler) !=EOF){
				fscanf(fp, "%s", &bilgi.yonetmen);		// 
				fscanf(fp, "%s", &bilgi.senarist);		//
				fscanf(fp, "%s", &bilgi.basoy);		//Dosyadan okunan diðer bilgiler
				fscanf(fp, "%d", &bilgi.yil);		//				
				if (!strcmp(bilgi.senarist, sen1)){				
				printf("Filmin Adi:\t\t%s\nFilmin Yonetmeni:\t%s\nFilmin Senaristi:\t%s\nFilminBasrolu:\t\t%s\nFilmin Yapim Yili:\t%d\n\n",bilgi.filmler,bilgi.yonetmen,bilgi.senarist,bilgi.basoy,bilgi.yil);								
				}				
				}
					bitis();
				break;
			case 4:
				printf("Basrolun adini giriniz:");
				scanf("%s",bas);	
				printf("Aradiginiz Filmin bilgileri:\n");
				printf("----------------------------\n");
				while(fscanf(fp,"%s",bilgi.filmler) !=EOF){
				fscanf(fp, "%s", &bilgi.yonetmen);		// 
				fscanf(fp, "%s", &bilgi.senarist);		//
				fscanf(fp, "%s", &bilgi.basoy);		//Dosyadan okunan diðer bilgiler
				fscanf(fp, "%d", &bilgi.yil);		//				
				if (!strcmp(bilgi.basoy, bas)){				
				printf("Filmin Adi:\t\t%s\nFilmin Yonetmeni:\t%s\nFilmin Senaristi:\t%s\nFilminBasrolu:\t\t%s\nFilmin Yapim Yili:\t%d\n\n",bilgi.filmler,bilgi.yonetmen,bilgi.senarist,bilgi.basoy,bilgi.yil);								
				}				
				}
					bitis();
				break;
			case 5:
				printf("Yapim yilini giriniz:");
				scanf("%d",&yil);	
				printf("Aradiginiz Filmin bilgileri:\n");
				printf("----------------------------\n");
				while(fscanf(fp,"%s",bilgi.filmler) !=EOF){
				fscanf(fp, "%s", &bilgi.yonetmen);		// 
				fscanf(fp, "%s", &bilgi.senarist);		//
				fscanf(fp, "%s", &bilgi.basoy);		//Dosyadan okunan diðer bilgiler
				fscanf(fp, "%d", &bilgi.yil);		//				
				if ((bilgi.yil==yil)){				
				printf("Filmin Adi:\t\t%s\nFilmin Yonetmeni:\t%s\nFilmin Senaristi:\t%s\nFilminBasrolu:\t\t%s\nFilmin Yapim Yili:\t%d\n\n",bilgi.filmler,bilgi.yonetmen,bilgi.senarist,bilgi.basoy,bilgi.yil);								
				}				
				}
					bitis();
				break;
			default:
				hata();
				break;			
								}//switch son	
				fclose(fp); 	}//menu 5 son
		else if(menu==6){
		
		goto cikis;}//cikis satýrýna gider
		
		else{	hata();				}
	cikis:
	return 0;
}//main fonksiyonu sonu
void hata(){//hatalý cevaplara karþý verilen cevap
	int donus2;
	system("cls");
			menu1donus:
			printf("Hatali Giris\n");
			printf("1. Menuye don\n");
			printf("2. Uygulamayi kapat\n");
			scanf("%d",&donus2);
			if(donus2==1){ main();}
			else if(donus2==2){ printf("Hoscakalin!");
			}
			else{ system("cls");
			
			printf("Lutfen belirtilen sayilari giriniz\n");
			goto menu1donus;}
}
void bitis(){//menu sonlarý için ana menüye dönüþ ya da kapatmak için fonksiyon
	int donus4;
	printf("1. Ana Menuye Don\n");
	printf("2. Uygulamayi kapat\n");
			scanf("%d",&donus4);
			switch(donus4){
				case 1:
					main(); break;
				case 2:
					printf("Hoscakalin!");	  break;
				default:
					hata(); break;}
}
