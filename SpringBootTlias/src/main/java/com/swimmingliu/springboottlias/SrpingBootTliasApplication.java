package com.swimmingliu.springboottlias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SrpingBootTliasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrpingBootTliasApplication.class, args);
	}

}
