package com.vrpowerz.ServeBetR.resource;

import com.vrpowerz.ServeBetR.config.PasswordEncoder;
import com.vrpowerz.ServeBetR.model.User;
import com.vrpowerz.ServeBetR.model.UserRole;
import com.vrpowerz.ServeBetR.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

/**
 * @author Venkataraghavan Yanamandram
 *
 */

@RestController
@RequestMapping("/api/users/")
public class UserResource {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("{page}/{size}")
    public Response getAllUsers(@PathVariable("page") final Integer page, @PathVariable("size") final Integer size){
        try {
            Page<User> users = userRepository.findAll(PageRequest.of(page + 1,size));
            return new Response (users);
        }catch (Exception e){
            return new Response(null, "Unable to get users list.", false, e.toString());
        }
    }

    @GetMapping("/u/{username}")
    public Response viewUser(@PathVariable final String username){
        try {
            return new Response(userRepository.findByUsername(username));
        }catch (Exception e){
            return new Response(null, "Unable to get user " + username + ".", false, e.toString());
        }
    }

    @GetMapping("{id}")
    public Response viewUser(@PathVariable final Long id){
        try {
            return new Response(userRepository.findById(id).orElse(null));
        }catch (Exception e){
            return new Response(null, "Unable to get user for Id " + id + ".", false, e.toString());
        }
    }

    @PostMapping
    public Response saveUser(@RequestBody final User user){
        try {
            if(isUserExist(user.getUsername())){
                return new Response(null, "Username already exist", false);
            }else if(!isPasswordMatch(user.getPassword(), user.getRetypePassword())){
                return new Response(null, "Passwords do not match", false);
            }else {
                user.setActive(true);
                user.setTimeStamp(Calendar.getInstance().getTime());
                user.setPassword(encoder.getUserPasswordEncoder().encode(user.getPassword()));
                if(user.getRole() == null)
                    user.setRole(new UserRole(1));
                userRepository.save(user);
                return new Response(user, "User created successfully");
            }
        }catch (Exception e){
            return new Response(null, "Unable to create user.", false, e.toString());
        }
    }

    @PutMapping
    public Response updateUser(@RequestBody final User user){
        try {
            User user1 = userRepository.findById(user.getId()).orElse(null);
            user1.setFirstname(user.getFirstname());
            user1.setLastname(user.getLastname());
            user1.setGender(user.getGender());
            user1.setDateOfBirth(user.getDateOfBirth());
            user1.setEmail(user.getEmail());
            user1.setPhone(user.getPhone());
            user1.setAddress(user.getAddress());
            user1.setActive(user.isActive());
            user1.setRole(user.getRole());
            user1.setDescription(user.getDescription());

            if(isPasswordMatch(user.getPassword(), user.getRetypePassword())){
                user1.setPassword(encoder.getUserPasswordEncoder().encode(user.getPassword()));
            }

            userRepository.save(user1);
            return new Response(user1, "User updated successfully");

        }catch (Exception e){
            return new Response(null, "Unable to update user.", false, e.toString());
        }
    }

    @PutMapping("/changepass")
    public Response changePassword(@RequestBody final User user){
        if(isPasswordMatch(user.getPassword(), user.getRetypePassword())){
            try {
                User user1 = userRepository.findById(user.getId()).orElse(null);
                user1.setPassword(encoder.getUserPasswordEncoder().encode(user.getPassword()));
                return new Response(user, "Password changed successfully.");
            }catch (Exception e){
                return new Response(null, "Unable to change password.", false, e.toString());
            }
        }else {
            return new Response(null, "Passwords do not match", false);
        }
    }

    protected boolean isPasswordMatch(final String password, final String retypePassword) {
        return (((password != null && retypePassword != null) &&
                (!password.trim().equals("") && !retypePassword.trim().equals(""))) &&
                (password.trim().equals(retypePassword.trim())));
    }

    private boolean isUserExist(final String username) {
        return userRepository.findByUsername(username) != null;
    }


}
