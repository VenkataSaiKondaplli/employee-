package com.sai.emp.Service;

import com.sai.emp.Model.User;
import com.sai.emp.UserRegistrationDto.UserRegistrationDto;

public interface Userservice {
	User save(UserRegistrationDto registrationDto);
}
