import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		boolean flag = true;
		Scanner s = new Scanner(System.in);
		UserDetails user = new UserDetails();
		while(flag) {
			System.out.println("Please choose one of the below options:");
			System.out.println("1. Login");
			System.out.println("2. Register as a new user");
			int input = s.nextInt();
			if(input == 2) {
				System.out.println("You have chosen to register as a user");
				System.out.println("Please enter the following details");
				
				System.out.println("Enter your first name: ");
				String firstName = s.next();
				user.setFirstName(firstName);
				
				System.out.println("Enter your last name: ");
				String lastName = s.next();
				user.setLastName(lastName);
				
				System.out.println("Please enter age: ");
				int age = s.nextInt();
				user.setAge(age);
				
				System.out.println("Please enter your gender");
				char gender = s.next().charAt(0);
				user.setGender(gender);
				
				System.out.println("Your UserId is: ");
				StringBuilder sb = new StringBuilder();
				sb.append(firstName.substring(0, 2).toUpperCase());
				sb.append(lastName.substring(lastName.length()-2).toUpperCase());
				sb.append(Integer.toString(age));
				String userid = sb.toString();
				System.out.println(userid);
				user.setUserid(userid);
				
				System.out.println("Your password is: ");
				String password = userid;
				System.out.println(password);
				user.setPassword(password);
				
				System.out.println("You have successfully registered as a user");	
			} else {
				System.out.println("You have chosen to login");
				System.out.println("Please enter userId: ");
				String userid = s.next();
				
				System.out.println("Please enter your password: ");
				String password = s.next();
				
				boolean validation = UserValidate.validate(userid,password,user);
				if(validation) {
					System.out.println("You have successfully logged in: ");
					System.out.println("Please choose one of the options below: ");
					System.out.println("1. Update Password");
					System.out.println("2. View my details");
					System.out.println("3. Update my details");
					System.out.println("4. Logout");
					
					int logicInput = s.nextInt();
					if(logicInput == 1) {
						UserLogic.updatePassword(user);
					} else if( logicInput == 2) {
						UserLogic.viewDetails(user);
					} else if(logicInput == 3) {
						UserLogic.updateDetails(user);
					} else {
						flag = false;
					}
					
				} else {
					System.out.println("You have entered incorrect information");
				}
				
			}
		}
		
	}
}

class UserDetails{
	private String firstName;
	private String lastName;
	private int age;
	private char gender;
	private String userid;
	private String password;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

class UserLogic{

	public static void updatePassword(UserDetails user) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the old Password");
		String oldPassword = s.next();
		System.out.println("Enter the new password:");
		String newPassword = s.next();
		System.out.println("Confirm your new Password");
		String confirmNewPass = s.next();
		
		if(!user.getPassword().equals(oldPassword)) {
			System.out.println("Please enter your valid password");
		}
		else if(!newPassword.equals(confirmNewPass)) {
			System.out.println("Passwords are not matching");
		} else {
			user.setPassword(newPassword);
		}
	}

	public static void updateDetails(UserDetails user) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the new first name");
		String newFirstName = s.next();
		System.out.println("Enter the new last name");
		String newLastName = s.next();
		System.out.println("Enter your new age");
		int age = s.nextInt();
       		
		user.setFirstName(newFirstName);
		user.setLastName(newLastName);
		user.setAge(age);
	}

	public static void viewDetails(UserDetails user) {
		System.out.println("First Name is:" + " " + user.getFirstName());
		System.out.println("Last Name is:" + " " + user.getLastName());
		System.out.println("Age is:" + " " + user.getAge());
		System.out.println("Gender is: " + " " + user.getGender());
	}
	
}

class UserValidate {
	public static boolean validate(String userid, String password,UserDetails user) {
		if(user.getUserid().equals(userid) && user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
