package com.example.demo.form;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.Client;
import com.example.demo.map.ClientMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreationClientTest {
	
	@Mock
	HttpServletRequest request;
	@Mock
    ClientMapper client;
    @InjectMocks
    CreationClientForm form = new CreationClientForm();
    boolean isThatOk = false;
    
    
    @Before
    public void setUp() {
        if (!isThatOk) {
            MockitoAnnotations.initMocks(this);
            isThatOk = true;
        }
    }
    @After
    public void validate() {
        Mockito.validateMockitoUsage();
    }



@Test
public void CreerClientTest() throws Exception {
//	Client c = new Client();
//	c.setId(10);
//	c.setAdresse("test");
//	c.setEmail("test@test.fr");
//	c.setNom("valentin");
//	c.setPrenom("degauche");
//	c.setTelephone("000000");
//
//	request.setAttribute("client", c);
//
	Client c = form.creerClient(request);
	 this.client.insert(c);
    
    Mockito.verify(client, Mockito.times(1)).insert(c);
}
}
