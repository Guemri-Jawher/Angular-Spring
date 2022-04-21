package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserControler {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	 public String register(@RequestBody Users user) {
		service.saveUser(user);
		 return "Hi " + user.getEmail() + " your Registration process successfully completed";
	 }
	
	@PostMapping("/login")
	 public String login(@RequestBody Users loginDto){
		 return service.login(loginDto);
	 }
	
	@PostMapping("/change/{pwd}")
	 public String changepwdUser(@PathVariable String pwd){
		service.changepwdUser(pwd);
		return "change sucess";
	 }
	
	@GetMapping("/getAllUsers")
	 public List<Users> findAllUsers() {
		return service.findAllUsers();
	 }
	
	@GetMapping("/findUser/{id}")
	 public Users findUserByid(@PathVariable Long id) {
		 return service.findUserById(id);
	 }
	
	@GetMapping("/findUser/{role}")
	 public List<Users> findUserByid(@PathVariable String role) {
		 return service.findUserByRole(role);
	 }
	
	@GetMapping("/findUser/{email}")
	 public Users findUser(@PathVariable String email) {
		 return service.findUserByEmail(email);
	 }
	
	 @DeleteMapping("/cancel/{id}")
	 public List<Users> cancelRegistration(@PathVariable Long id) {
		 service.deleteUserById(id);
		 return service.findAllUsers();
	 }


}
