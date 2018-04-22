
public class CommaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] arr = {"hello","world"};
				
	
		StringBuilder s = new StringBuilder();
		
		for(int i = 0; i < arr.length; i++ )
		{
		 s.append(arr[i].toString());
		 s.append(',');
		 
		}
		
		s.deleteCharAt(s.length()-1);
		System.out.println(s);
	}

}
