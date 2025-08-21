package org.example.service;

import java.util.List;
import java.util.Map;

public interface JdbcService {
  void createPersonTable();
  int getPersonCount();
  void createPerson(int id, String name, String email, int age);
  Map<String, Object> getPersonMap(int id);
  Person findPersonById(int id);
  List<Person> getPersonList();
}
