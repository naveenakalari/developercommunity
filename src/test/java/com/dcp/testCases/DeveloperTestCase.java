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

import com.dcp.entity.Developer;
import com.dcp.exception.DeveloperNotFoundException;
import com.dcp.repository.DeveloperRepository;
import com.dcp.serviceImpl.DeveloperService;




@SpringBootTest
class DeveloperTestCase {

    @Autowired
    private DeveloperService developerService;

    @MockBean
    private DeveloperRepository developerRepository;

    @InjectMocks
    DeveloperService dservice = new DeveloperService();
    static Developer developer = new Developer();

    static List<Developer> developerList;
    static List<Developer> developerList1;

    @BeforeAll
    public static void setUp() {

        developerList = new ArrayList<>();
        developerList1 = new ArrayList<>();


        developer.setDevId(1);
        developer.setDeveloperName("Meghana");
        developer.setEmail("meghana@gmail.com");
        developer.setSkillLevel("Excellent");
        developer.setTotalFeeds(10);
        developerList.add(developer);

    }

    @Test
    public  void testAddDeveloper() {

        Mockito.when(developerRepository.saveAndFlush(developer)).thenReturn(developer);
        assertNotNull(developerService.addDeveloper(developer));
    }

    @Test
     void testGetAllDeveloper() throws DeveloperNotFoundException {
        Mockito.when(developerRepository.findAll()).thenReturn(developerList);
    }

    @Test
    public  void testDeveloperNotFound() throws DeveloperNotFoundException {

        Mockito.when(developerRepository.findAll()).thenReturn(developerList1);
        try {
            assertNotNull(developerService.getAllDeveloper());
        } catch (DeveloperNotFoundException de) {
            assertEquals("Developer not found", de.getMessage());
        }

    }

}