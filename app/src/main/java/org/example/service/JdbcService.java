package org.example.service;

import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface JdbcService {
  void createPersonTable();
  int getPersonCount();
  void createPerson(int id, String name, String email, int age);
  Map<String, Object> getPersonMap(int id);
  Person findPersonById(int id);
  List<Person> getPersonList();
  void createCarTable();
  @Transactional(propagation = Propagation.REQUIRED)
  int createCar(int id, int personId, String make, String model);
  int updatePerson(int id, int cars);
  Map<String, Object> getCarMap(int id);
}
