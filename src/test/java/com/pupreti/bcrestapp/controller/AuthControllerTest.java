package com.pupreti.bcrestapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pupreti.bcrestapp.model.AuthorizationRequest;
import com.pupreti.bcrestapp.model.Operation;
import com.pupreti.bcrestapp.service.EntitlementMgrService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
//@WebMvcTest(AuthController.class)
public class AuthControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @InjectMocks
//    AuthController authController;
//
//    @MockBean
//    EntitlementMgrService entitlementMgrService;
//
//    @Test
//    public void testAuthorize() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        System.out.println("step 1");
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//        System.out.println("step 2");
////        when(entitlementMgrService.validateEntitlementAccess(any(String.class), any(AuthorizationRequest.class))).thenReturn(true);
//        Mockito.when(
//                entitlementMgrService.validateEntitlementAccess(Mockito.anyString(),
//                        Mockito.any(AuthorizationRequest.class))).thenReturn(true);
//        System.out.println("step 3");
//        AuthorizationRequest req = new AuthorizationRequest();
//
//        List<String> accounts = new ArrayList<String>();
//        accounts.add("account001");
//        accounts.add("account005");
//        req.setAccountIds(accounts);
//        List<Operation> operations = new ArrayList<>();
//        List<String> resources = new ArrayList<>();
//        resources.add("video");
//        Operation opr = new Operation();
//        opr.setAction("WRITE");
//        opr.setResources(resources);
//        operations.add(opr);
//        req.setOperations(operations);
//        System.out.println("step 4");
////        ResponseEntity<?> responseEntity = authController.authorize(req, "user001");
////        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonInput = "";
//        try {
//            jsonInput = objectMapper.writeValueAsString(req);
//            System.out.println("json: " + jsonInput);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/users/user001/authorize")
//                .accept(MediaType.APPLICATION_JSON).content(jsonInput)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        try {
//                mockMvc.perform(requestBuilder)
//                    .andExpect(MockMvcResultMatchers.status()
//                    .isOk());
//
////            assertEquals(HttpStatus.CREATED.value(), response.getStatus());
////            assertEquals(HttpStatus.OK, response.getStatus());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
