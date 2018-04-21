import java.util.ArrayList;
import java.util.List;

public class checkUserName {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		/*You are updating the username policy on your company's internal networking 
		 * platform. According to the policy, a username is considered valid if all the 
		 * following constraints are satisfied:
		•	The username consists 8 to 30  characters inclusive. If the username 
		consists of less than 8 or greater than 30 characters, then it is an invalid 
		username.
		•	The username can only contain alphanumeric characters and underscores (_). 
		Alphanumeric characters describe the character set consisting of lowercase 
		characters [a-z] , uppercase[A-Z] characters , and digits[0-9] .
		•	The first character of the username must be an alphabetic character, 
		i.e., either lowercase character[a-z] or uppercase character[A-Z] .
		For example:
		User Name:
		  Julia  - Invalid.(Username<8)
		Samanta- Valid
		Samantha_21-Valid
		1Samantha-Invalid
		Samantha?10_2A(Invalid) (? Not allowed)
		JuliaZ007*/

	
	List<String> input = new ArrayList<String>();
	input.add("Julia");
	input.add("Samanta");
	input.add("Samantha_21");
	input.add("Samantha?10_2A");
	input.add("JuliaZ007");
	
	for (String name : input) {
		if (name.matches("^[a-zA-Z]\\w{7,29}$")) 
		{
			System.out.println("Found good name: " + name);
		}
	}
	

	}

}
