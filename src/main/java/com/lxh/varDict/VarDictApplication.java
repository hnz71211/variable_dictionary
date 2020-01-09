package com.lxh.varDict;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lxh.varDict.**.mapper")
public class VarDictApplication {

  public static void main(String[] args) {
    SpringApplication.run(VarDictApplication.class, args);
  }

}
