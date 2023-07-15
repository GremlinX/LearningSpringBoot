package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

/**
 * <ul>
 * <li>This is an auxiliary class for configurations.</li>
 * <li>"@Configuration" indicates that the this class is a configuration
 * class.</li>
 * <li>"@Profile("test")" indicating that this class is a test profile.</li>
 * <li>This way, spring can identify that this config will be executed only when
 * you are in the test profile.</li>
 * <li>This class is useful for database seeding (populate the database)</li>
 * </ul>
 * 
 */
@Configuration //
@Profile("test") // This name must be exactly the same as configured in the
					// "spring.profiles.active=test"
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
