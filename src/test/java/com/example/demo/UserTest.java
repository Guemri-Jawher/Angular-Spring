package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Role;
import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
    private UserRepository service ;
	
	@Test
    public void testCreateUser() {
		Role role = Role.admin;
        Users user = new Users();
        user.setEmail("jawher2222@gmail.com");
        user.setPassword("1414");
        user.setRole(role);
         
        Users savedUser = service.save(user);
         
        Users existUser = entityManager.find(Users.class, savedUser.getId());
         
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
         
    }

}
