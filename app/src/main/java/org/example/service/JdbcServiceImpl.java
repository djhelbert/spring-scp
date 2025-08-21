package org.example.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

  public void createPerson(int id, String name, String email, int age) {
    String sql = "insert into person (id, name, email, age) values (?, ?, ?, ?)";
    jdbcTemplate.update(sql, id, name, email, age);
  }

  public int getPersonCount() {
    String sql = "SELECT COUNT(*) FROM person";
    return jdbcTemplate.queryForObject(sql, Integer.class);
  }

  public Map<String, Object> getPersonMap(int id) {
    return jdbcTemplate.queryForMap("SELECT * FROM person WHERE id = ?", id);
  }

  public List<Person> getPersonList() {
    String sql = "SELECT * FROM person";
    return jdbcTemplate.query(sql, new PersonMapper());
  }

  public Person findPersonById(int id) {
    String sql = "SELECT * FROM person WHERE id = ?";
    return jdbcTemplate.queryForObject(sql, new PersonMapper(), id);
  }

  class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
      Person person = new Person();
      person.setId(rs.getInt("id"));
      person.setName(rs.getString("name"));
      person.setEmail(rs.getString("email"));
      person.setAge(rs.getInt("age"));
      return person;
    }
  }
}
