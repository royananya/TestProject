
public class Covid {
	
	public static void main (String args[]) throws ArrayIndexOutOfBoundsException
	{
		int[] arr = {1, 2,3,5,9,10};
		
		int length =arr.length;
		System.out.println(length);
		int max=0;
		int min=0;
		int i =0;
		//for (int i : length)
			System.out.println(i);
		{
	
		
		if(arr[i+1]-arr[i]<=2 )
			System.out.println(arr[i+1]);
			max=max+1;
		

		if(arr[i+1]-arr[i]>2)
			{max=0;
			min=min+1;}
			
		
		
	}
		System.out.println(max) ;
		System.out.println(min);

}
}