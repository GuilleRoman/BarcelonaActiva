
public class Fase4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int bisiesto= 1948;
		int any= 0;
		int actual= 0;
		int nacimiento= 1994;
		boolean cumplea�os=false;
		String nombreCompleto= "Guillermo Rom�n Medrano";
		String fechaNacimiento= "21/8/1994";
		
		String verdadero= "El a�o 1994 ES un a�o bisiesto";
		String falso= "El a�o 1994 NO es un a�o bisiesto";
		System.out.println("A�os bisiestos entre 1948 y 1994: ");
		for (int i= 1948; i<=1994;i++) {
			if(i==bisiesto || i== actual+4) {
				actual=i;
				System.out.print(i+" ");
				any++;
				if(actual==nacimiento) {
					cumplea�os=true;
				}
			}
			
		}
		
		System.out.println("\nN�mero de a�os bisiestos entre 1948 y 1994: "+ any);
		System.out.println("Mi nombre es: "+nombreCompleto+"\n"+ "Mi fecha de nacimiento es: "+fechaNacimiento
				);
		if(cumplea�os==true) {
			System.out.println(verdadero);
		}else {
			System.out.println(falso);
		}
	}
}
