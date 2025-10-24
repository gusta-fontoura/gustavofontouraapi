package br.edu.infnet.vendas.domain.services;
import br.edu.infnet.venda.domain.model.*;
import java.util.List;
import java.util.*;

public class UserService {

	private List<User> userList = new ArrayList<>();
	

	public void createUser(User userData) {
		
		userList.add(userData);
		System.out.println("User has been activated.");
	}
	
	
	public User getUserProfile(int userId) {
	
		for (User currentUser : userList) {
			if (currentUser.getId() == userId) {
		
				return currentUser;
			}
		}
		
		return null;
	}
}
