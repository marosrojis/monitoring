package cz.inventi.monitoring.service;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PingController {

  Random rand = new Random();

  @GetMapping("/ping")
  public Hello hello() {
    log.trace("Trace log message");
    log.debug("Debug log message");
    log.info("Info log message");
    if (rand.nextInt(10) % 3 == 0) {
      log.error("Return error");
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Simulated error");
    }
    return new Hello("World");
  }

  public record Hello(String hello) {

  }

}
