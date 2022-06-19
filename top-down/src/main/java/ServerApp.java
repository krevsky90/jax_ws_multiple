import javax.xml.ws.Endpoint;

public class ServerApp {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9990/EmployeeLookupService", new EmployeeLookupServiceImpl_WSDL());

        System.out.println("EmployeeLookupService Started!");
    }
}
