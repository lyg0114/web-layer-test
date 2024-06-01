package com.apipractice.domain.study.api;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.apipractice.domain.study.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author : iyeong-gyo
 * @package : com.apipractice.domain.study.api
 * @since : 01.06.24
 */

//@MockBean(JpaMetamodelMappingContext.class)
@WebMvcTest(StudyApiController.class)
class StudyApiControllerTest {

  @Autowired private MockMvc mockMvc;
  @MockBean private GreetingService service;

  @Test
  void shouldReturnDefaultMessage() throws Exception {
    String param = "param1";
    String url = "/api/v1/study/guest/" + param;

    this.mockMvc.perform(get(url)).
        andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString(param)));
  }

  @Test
  void shouldReturnDefaultMessage2() throws Exception {
    String param = "param1";
    String url = "/api/v1/study/user/" + param;

    when(service.greet(param))
        .thenReturn("Hello, Mock" + param);

    this.mockMvc.perform(get(url)).
        andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString(param)));
  }
}