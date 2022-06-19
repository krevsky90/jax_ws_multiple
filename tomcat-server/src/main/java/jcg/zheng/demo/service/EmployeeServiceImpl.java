package jcg.zheng.demo.service;

import jcg.zheng.demo.service.employee.generated.*;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebService(endpointInterface = "jcg.zheng.demo.service.employee.generated.EmployeeLookupService")
public class EmployeeServiceImpl implements EmployeeLookupService {
    ObjectFactory of = new ObjectFactory();

    @Override
    public EmployeeInfoWrapper employeeLookup(EmployeeIdWrapper employeeIdList) throws UserDefinedException {
        if (employeeIdList.getEid().isEmpty()) {
            UserDefinedFault e = of.createUserDefinedFault();
            e.setMessage("Empty Employee ID");

            throw new UserDefinedException("Please enter at lease one employee Id", e);
        }

        EmployeeInfoWrapper eWrapper = of.createEmployeeInfoWrapper();
        List allEmps = getEmployees(employeeIdList.getEid());
        eWrapper.getEmployeeInfo().addAll(allEmps);

        return eWrapper;
    }

    private List getEmployees(List<String> ids) {
        List emps = new ArrayList<>();
        for (String id : ids) {
            emps.add(buildDummyEmployee(id, EmployeeType.HOURLY));
        }

        return emps;
    }

    private EmployeeInfo buildDummyEmployee(String id, EmployeeType type) {
        EmployeeInfo emp = of.createEmployeeInfo();
        emp.setEid(id);
        Random rand = new Random();
        emp.setFirstName("FName_" + id);
        emp.setLastName("LName_" + id);
        emp.setType(type);
        emp.setHourlyRate(new BigDecimal(rand.nextInt(40)));
        return emp;
    }
}