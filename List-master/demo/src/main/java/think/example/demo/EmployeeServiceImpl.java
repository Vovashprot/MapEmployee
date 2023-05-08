package think.example.demo;

import exceptions.EmployeeAlreadyAddedException;
import exceptions.EmployeeNotFoundException;
import exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import think.example.demo.Employee;
import think.example.demo.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    int mapLimit = 200;
    private final Map<String, Employee> employeeList = new HashMap<>(mapLimit);

    @Override
    public Employee add(String firstName, String lastname) {
        Employee employee = new Employee(firstName,lastname);
        if (employeeList.size()>mapLimit){
            throw new EmployeeStorageIsFullException();
        }
        String key = (firstName +"_"+ lastname).toLowerCase();
        if (employeeList.containsKey(key)){
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.put(key,employee);
        return employee;
    }
    @Override
    public Employee remove(String firstName, String lastname) {
        String key = (firstName+"_"+lastname).toLowerCase();
        Employee employee = employeeList.remove(key);
        if (employee == null){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastname) {
        String key = (firstName+"_"+lastname).toLowerCase();
        Employee employee = employeeList.get(key);
        if (employee == null){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findall() {
        return employeeList.values();
    }
}
