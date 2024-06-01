package com.apipractice.domain.member.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.apipractice.domain.member.application.service.MemberService;
import com.apipractice.domain.member.entity.Member;
import com.apipractice.global.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author : iyeong-gyo
 * @package : com.apipractice.domain.member.api
 * @since : 01.06.24
 */
@MockBean(JpaMetamodelMappingContext.class)
@WebMvcTest(controllers = MemberApiController.class)
@Import(SecurityConfig.class)
public class MemberApiControllerTest {

  @Autowired private MockMvc mockMvc;
  @MockBean private MemberService memberService;

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
        .andExpect(status().isOk());
  }
}
