package com.mehulsblog.photoapp.api.users.service;

import com.mehulsblog.photoapp.api.users.shared.UserDto;

public interface UsersService {

	UserDto createUser(UserDto usersDetails) throws Exception ;

}
