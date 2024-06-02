package com.apipractice.domain.member.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.apipractice.domain.member.application.service.MemberService;
import com.apipractice.domain.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author : iyeong-gyo
 * @package : com.apipractice.domain.member.api
 * @since : 01.06.24
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MemberApiControllerTestV2 {

  @Autowired private MockMvc mockMvc;
  @MockBean private MemberService memberService;
  @MockBean private AccessDeniedHandler accessDeniedHandler;

  @Test
  void findUserTest() throws Exception {
    Integer param = 1;
    String url = "/api/members/v1/find/" + param;

    when(memberService.findMember(1L))
        .thenReturn(Member.builder()
            .name("name-1")
            .email("email-1@gmail.com")
            .build());

    this.mockMvc.perform(get(url)).
        andDo(print())
        .andExpect(status().isOk())
    ;
  }
}
