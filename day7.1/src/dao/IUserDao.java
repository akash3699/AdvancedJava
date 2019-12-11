package dao;

import java.util.Date;
import java.util.List;

import pojos.User;
import pojos.UserRole;

public interface IUserDao {
	// saving user dtls
	String registerUser(User u);

    //retrieve user dtls by id
	User getDetails(int id);// int --->Integer --->Serializable
	// get all user's details
	List<User> getAllUsers();
	//get selected user dtls
	List<User> getSelectedUsers(Date d1,Date d2,UserRole role);
	//get selected user names
		List<String> getSelectedUserNames(Date d1,Date d2,UserRole role);
		//get selected user names n reg amount
	List<Object[]> getSelectedUserNamesNAmount(Date d1,Date d2,UserRole role);
	//get selected user names n reg amount n reg date
	List<User> getSelectedUsersDetails(Date d1,Date d2,UserRole role);
}
