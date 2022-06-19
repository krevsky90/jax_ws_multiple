source: https://examples.javacodegeeks.com/enterprise-java/jws/jax-ws-tutorial-beginners/

чтобы сгенерить java сущности по wsdl и xsd, нужно:
1) создать папки, кы-е указаны в pom.xml:
    src/main/resources/wsdl
    src/main/java/jcg/zheng/demo/service/employee/generated
2) выбрать справа в idea employeeWsdlToJava и нажать кнопку Execute maven goal

РЕЗУЛЬТАТ:
1) на основе src/main/resources/xsd/employee.xsd сгенерятся Java-классы для сущностей
2) на основе src/main/resources/wsdl/employeeService.wsdl сгенерится EmployeeLookupService