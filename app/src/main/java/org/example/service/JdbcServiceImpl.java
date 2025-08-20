package org.example.service;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcServiceImpl implements JdbcService {

  JdbcTemplate jdbcTemplate;

  public JdbcServiceImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void createPersonTable() {
    String sql = "CREATE TABLE person (id INT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100), age INT)";
    jdbcTemplate.execute(sql);
    System.out.println("Table 'person' created successfully.");
  }
}
