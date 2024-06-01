package com.apipractice.domain.study.api;

import com.apipractice.domain.study.service.GreetingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : iyeong-gyo
 * @package : com.apipractice.domain.study.api
 * @since : 24.05.24
 *
 *  - REST api 접근제어 테스트를 위한 클래스
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/study")
@RestController
public class StudyApiController {

  private final GreetingService greetingService;

  @GetMapping("/guest/{param}")
  public ResponseEntity<String> guest(@PathVariable String param) {

    log.info("########################################");
    log.info("call guest + {}", param);
    log.info("########################################");

    return ResponseEntity
        .ok()
        .body("hello" + param);
  }

  @GetMapping("/user/{param}")
  public ResponseEntity<String> user(@PathVariable String param) {

    log.info("########################################");
    log.info("call user + {}", param);
    log.info("########################################");

    return ResponseEntity
        .ok()
        .body(greetingService.greet(param));
  }

}
