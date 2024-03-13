package com.project.tpathshala.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.tpathshala.exceptions.ResourceNotFoundException;
import com.project.tpathshala.model.User;
import com.project.tpathshala.payload.UserCreateRequest;
import com.project.tpathshala.repository.UserRepository;
import com.project.tpathshala.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserCreateRequest createUser(UserCreateRequest user) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		User save = userRepository.saveAndFlush(dtoToUser(user));
		
		return UserToDto(save);
	}

	@Override
	public UserCreateRequest updateUser(UserCreateRequest user,Integer id) {
		// TODO Auto-generated method stub
		User findById = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", " Id ", id));
		
		findById.setId(id);
		findById.setEmail(user.getEmail());
		findById.setName(user.getName());
		findById.setPassword(user.getPassword());
		
		User save = userRepository.saveAndFlush(findById);
		
		return UserToDto(save);
	}

	@Override
	public UserCreateRequest getUserById(Integer id) {
		// TODO Auto-generated method stub
		User findById = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", " Id ", id));
		return UserToDto(findById);
	}

	@Override
	public List<UserCreateRequest> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> findAll = userRepository.findAll();
		List<UserCreateRequest> collect = findAll.stream().map(user->this.UserToDto(user)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		User findById = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", " Id ", id));
		userRepository.delete(findById);
	}
	
	private User dtoToUser(UserCreateRequest userRequest)
	{
		User user = modelMapper.map(userRequest, User.class);
		return user;
	}
	
	private UserCreateRequest UserToDto(User user)
	{
		UserCreateRequest userCreateRequest = modelMapper.map(user, UserCreateRequest.class);
		return userCreateRequest;
	}

}
