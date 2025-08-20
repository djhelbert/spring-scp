package org.example.scan;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import org.example.service.DateService;
import org.example.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("serviceFacade")
public class ServiceFacade {

  DateService dateService;
  UidService uidService;

  /**
   * @param dateService Date Service
   * @param uidService  UID Service
   * @Qualifier can be used if there are more than one bean defined for the same type
   * @Autowired not required if there is only ONE constructor
   */
  @Autowired
  public ServiceFacade(@Qualifier("dateService") DateService dateService, UidService uidService) {
    this.dateService = dateService;
    this.uidService = uidService;
  }

  public String getUid() {
    return uidService.getUid();
  }

  public Map<String, String> uidMap() {
    Map<String, String> map = new HashMap<>();
    map.put(uidService.getUid(), dateService.getDate().toString());
    return map;
  }

  @PostConstruct
  void postConstruct() {
    System.out.println("Service Facade Post Construct");
  }
}
