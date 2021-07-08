
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]= {1,2,3,4,5,6,7,8,9,10};
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("\n"+"-------------------------------");
		int length= array.length-1;
		for(int i=0; i<array.length; i++) {
			System.out.print(array[length]+" ");
			length--;
		}

}
}
