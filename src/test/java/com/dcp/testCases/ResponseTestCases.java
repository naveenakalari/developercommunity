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

import com.dcp.entity.Response;
import com.dcp.exception.ResponseNotFoundException;
import com.dcp.repository.ResponseRepository;
import com.dcp.serviceImpl.ResponseService;




@SpringBootTest
class ResponseTestCase {

    @Autowired
    private ResponseService responseService;

    @MockBean
    private ResponseRepository responseRepository;

    @InjectMocks
    ResponseService responseservice = new ResponseService();
    static Response response = new Response();

    static List<Response> responseList;
    static List<Response> responseList1;

    @BeforeAll
    public static void setUp() {

        responseList = new ArrayList<>();
        responseList1 = new ArrayList<>();

        response.setRespId(1);
        response.setAnswer("Sql is a database.");
        response.setAccuracy(8);
        responseList.add(response);

    }

    @Test
    public void testAddResponse() {

        Mockito.when(responseRepository.saveAndFlush(response)).thenReturn(response);
        assertNotNull(responseService.addResponse(response));
    }

    @Test
    void testGetResponsebyFeed() throws ResponseNotFoundException {
        Mockito.when(responseRepository.findAll()).thenReturn(responseList);
    }

    

}