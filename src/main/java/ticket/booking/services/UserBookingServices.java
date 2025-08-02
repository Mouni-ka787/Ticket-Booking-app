package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserBookingServices {

    private User user;
   private List<User> userList;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String USER_PATH = "src/main.java.localDB/user.json";

    public UserBookingServices(User user1) throws IOException
    {
        this.user = user1;
        File users = new File(USER_PATH);
        userList = objectMapper.readValue(users,new TypeReference<List<User>>() {});
    }

    public Boolean loginUser(){
        optional<User>  foundUser = userList.stream().filter( user1 -> {
            return user1.getName().equals(user.getName()) &&  UserServiceUtil.checkPassword(user.getPassword(),user1)
        }
    }
}
