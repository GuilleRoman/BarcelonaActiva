package Nivel3;

public class N3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int horas, minutos, segundos;
		horas= 00;
		minutos = 00;
		segundos=00;
		int numeroSegundos =0;
		int numeroMinutos=0;
		int numeroHoras=0;
		
		while(true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String minutosFormat= numeroMinutos+String.valueOf(minutos);
			String horasFormat=numeroHoras+String.valueOf(horas);
			String segundosFormat= numeroSegundos+String.valueOf(segundos);
			String cronometro = horasFormat+ ":"+minutosFormat+":"+segundosFormat;
			
			if(segundos>=10) {
				
				cronometro = horasFormat+ ":"+minutosFormat+":"+segundos;	
			}
				
			if(minutos>=10) {
					
				cronometro = horasFormat+ ":"+minutos+":"+segundos;
				if(segundos<10){
					cronometro = horasFormat+ ":"+minutos+":"+segundosFormat;
				}
					
				}
				if(horas>=10) {
					
					cronometro = horas+ ":"+minutos+":"+segundos;
					if(minutos<10 && segundos <10){
						cronometro = horas+ ":"+minutosFormat+":"+segundosFormat;
						
					}
					if(segundos<10 && minutos>10){
						cronometro = horas+ ":"+minutos+":"+segundosFormat;
					}
					if(minutos<10 && segundos>10) {
						cronometro = horas+ ":"+minutosFormat+":"+segundos;
					}
					
				}
				if(segundos==59) {
					segundos=00;
					minutos++;
					if(minutos==59) {
						minutos=00;
						horas++;
				}
			}
						System.out.println(cronometro);
						segundos++;
			}
		
				
				
			
		}
	}


