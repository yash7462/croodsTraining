package com.springbatchwithjpa.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springbatchwithjpa.model.User;
import com.springbatchwithjpa.repository.UserRepository;

@Component
public class DatabaseWriter implements ItemWriter<User> {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void write(List<? extends User> users) throws Exception {
		System.out.println("Data Are Saved");;
		userRepository.saveAll(users);
	}
	

}
