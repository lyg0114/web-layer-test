package com.apipractice.domain.member.api;

import com.apipractice.domain.member.application.service.MemberService;
import com.apipractice.domain.member.dto.MemberDto;
import com.apipractice.domain.member.entity.Member;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : iyeong-gyo
 * @package : com.apipractice.domain.member.api
 * @since : 18.05.24
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/members/v1")
@RestController
public class MemberApiController {

  private final MemberService memberService;

  @GetMapping("/find/{memberId}")
  public ResponseEntity<Member> findUser(@PathVariable Long memberId) {
    return ResponseEntity.ok()
        .body(memberService.findMember(memberId));
  }

  @PostMapping("/signup")
  public ResponseEntity<Void> signup(
      @RequestBody @Valid MemberDto.SignUpRequest requestDto
  ) {
    memberService.signUp(requestDto);
    return ResponseEntity.ok().build();
  }
}
