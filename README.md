## What is an ApplicationContext?

1. We can consider it as a map.
   1. You just have to provide the **bean name** or **bean id** or **class type** and it will give you the **bean object**.
   2. If ApplicationContext can provide the bean object, then it must have created it?
   3. It means you do not have to create object via calling its constructor. Application context will take the responsibility of creating object on your behalf.
   4. This is why ApplicationContext is called as a IOC (Inversion of control) container.




## How many ways ApplicationContext is created in Spring?

1. From xml file
2. From Java Annotations
   1. @Service
   2. @Controller
   3. @Component
   4. @RestController
   5. @Configuration
3. From Java Class
   1. @Bean

```

// beans.xml file constains all the beans information
ApplicationContext contextFromAnXmlFile =
                new ClassPathXmlApplicationContext("beans.xml");
                
                
// AppConfig.class contains all the bean information        
ApplicationContext contextFromAnnotation =
                new AnnotationConfigApplicationContext(AppConfig.class);

```

Installation Directory: C:\Program Files\PostgreSQL\15
Server Installation Directory: C:\Program Files\PostgreSQL\15
Data Directory: C:\Program Files\PostgreSQL\15\data
Database Port: 5432
Database Superuser: postgres
Operating System Account: NT AUTHORITY\NetworkService
Database Service: postgresql-x64-15
Command Line Tools Installation Directory: C:\Program Files\PostgreSQL\15
pgAdmin4 Installation Directory: C:\Program Files\PostgreSQL\15\pgAdmin 4
Installation Log: C:\Users\kumar\AppData\Local\Temp\install-postgresql.log