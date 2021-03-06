
package jcg.zheng.demo.service.employee.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "employeeLookupService", targetNamespace = "http://bestpay.payroll/employee")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EmployeeLookupService {


    /**
     * 
     * @param employeeIdList
     * @return
     *     returns jcg.zheng.demo.service.employee.generated.EmployeeInfoWrapper
     * @throws UserDefinedException
     */
    @WebMethod(action = "http://bestpay.payroll/employee/employeeLookup")
    @WebResult(name = "EmployeeInfoList", targetNamespace = "http://bestpay.payroll/employee", partName = "employeeInfoList")
    public EmployeeInfoWrapper employeeLookup(
        @WebParam(name = "EmployeeIdList", targetNamespace = "http://bestpay.payroll/employee", partName = "employeeIdList")
        EmployeeIdWrapper employeeIdList)
        throws UserDefinedException
    ;

}
