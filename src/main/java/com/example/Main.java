package com.example;

import com.microsoft.applicationinsights.attach.ApplicationInsights;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    ApplicationInsights.attach();

    SpringApplication.run(Main.class, args);

    LoggerFactory.getLogger("io.lettuce.abc.Xyz").info("info message that should be suppressed");
    LoggerFactory.getLogger("io.lettuce.abc.Xyz").error("error message that should not be suppressed");

    System.exit(0);
  }
}
