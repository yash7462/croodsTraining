package com.springbatchwithjpa.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.springbatchwithjpa.model.User;
@Component
public class Processor implements ItemProcessor<User, User> {

	@Override
	public User process(User user) throws Exception {
		// TODO Auto-generated method stub
		return user;
	}

}
