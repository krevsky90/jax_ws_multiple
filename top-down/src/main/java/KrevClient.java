import jcg.zheng.demo.service.employee.generated.*;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class KrevClient {
    public static void main(String[] args) throws MalformedURLException, UserDefinedException {
        URL urlToWSDL = new URL("http://localhost:9990/EmployeeLookupService?wsdl");
        //serviceName (localPart) should be taken from WSDL, see tag like <service name="EmployeeServiceImplService">
        String serviceName = "EmployeeLookupServiceImpl_WSDLService";
        //namespaceURI should be taken from WSDL,
        //see tag like <definitions targetNamespace="...
        //to know the difference between xsd namespace and targetNamespace - read https://stackoverflow.com/questions/28008214/targetnamespace-and-namespace-in-wsdl
        String namespaceURI = "http://bestpay.payroll/employee";

        callWebService(urlToWSDL, serviceName, namespaceURI);
    }

    private static void callWebService(URL urlToWSDL, String serviceName, String namespaceURI) throws UserDefinedException {
        QName qName = new QName(namespaceURI, serviceName);
        Service krevService = Service.create(urlToWSDL, qName);
        EmployeeLookupService service = krevService.getPort(EmployeeLookupService.class);

        //use WebService
        EmployeeIdWrapper employeeIdWrapper = new EmployeeIdWrapper();
        employeeIdWrapper.getEid().addAll(Arrays.asList("1", "5"));
        EmployeeInfoWrapper employeeInfoWrapper = service.employeeLookup(employeeIdWrapper);
        List<EmployeeInfo> employees = employeeInfoWrapper.getEmployeeInfo();
        for (EmployeeInfo ei : employees) {
            System.out.println(ei.toString());
        }
    }
}
