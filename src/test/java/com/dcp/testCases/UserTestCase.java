package com.dcp.testCases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dcp.entity.User;
import com.dcp.repository.UserRepository;
import com.dcp.serviceImpl.UserService;




@SpringBootTest
class UserTestCase {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    UserService userservice = new UserService();
    static User user = new User();

    static List<User> userList;
    static List<User> userList1;

    @BeforeAll
    public static void setUp() {

        userList = new ArrayList<>();
        userList1 = new ArrayList<>();


        user.setPassword("meghana");
        user.setRole("Sql developer");
        userList.add(user);

    }

    @Test
    public void testAddUser() {

        Mockito.when(userRepository.saveAndFlush(user)).thenReturn(user);
        assertNotNull(userService.addUser(user));
    }

    @Test
    void testValidateUser() {
        Mockito.when(userRepository.findAll()).thenReturn(userList);
    }

    

}