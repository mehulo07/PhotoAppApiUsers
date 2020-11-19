package com.mehulsblog.photoapp.api.users.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mehulsblog.photoapp.api.users.data.UserEntity;
import com.mehulsblog.photoapp.api.users.data.UsersRepository;
import com.mehulsblog.photoapp.api.users.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService {

	UsersRepository usersRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UsersServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.usersRepository = usersRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDto createUser(UserDto usersDetails) throws Exception {
		usersDetails.setUserId(UUID.randomUUID().toString());
		usersDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(usersDetails.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(usersDetails, UserEntity.class);
		//userEntity.setEncryptedPassword("test");
		usersRepository.save(userEntity);
		return usersDetails;
	}

}
