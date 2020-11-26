package com.capg.fms.us.service;


import java.util.Optional;

import com.capg.fms.us.dto.Users;

public interface IUsersService {
	public Users addUser(Users user);
	public Optional<Users> getUser(String username);
}


