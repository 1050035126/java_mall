package com.forum.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class sessionFactory {
  public SessionFactory getSessionFactory() {
    Configuration configurlation = new Configuration();
    configurlation = configurlation.configure("/hibernate.cfg.xml");
    SessionFactory sessionFactory = configurlation.buildSessionFactory(); // 产生Session工厂
    return sessionFactory;
  }

}
