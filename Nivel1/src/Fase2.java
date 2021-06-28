
public class Fase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int bisiesto= 1948;
		int any= 0;
		int actual= 0;
		System.out.println("Años bisiestos entre 1948 y 1994: ");
		for (int i= 1948; i<=1994;i++) {
			if(i==bisiesto || i== actual+4) {
				actual=i;
				System.out.print(i+" ");
				any++;
				
			}
		}
		System.out.println("\nNúmero de años bisiestos entre 1948 y 1994: "+ any);
	}

}
