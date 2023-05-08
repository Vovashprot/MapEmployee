package think.example.demo;

import exceptions.EmployeeAlreadyAddedException;
import exceptions.EmployeeNotFoundException;
import exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import think.example.demo.Employee;
import think.example.demo.EmployeeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    int listLimit = 5;
    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastname) {
        if (employeeList.size()>listLimit){
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastname);
        if (employeeList.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }
    @Override
    public Employee remove(String firstName, String lastname) {
        Employee employee = new Employee(firstName, lastname);
        if (employeeList.contains(employee)==false){
            throw new EmployeeNotFoundException();
        }
        employeeList.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastname) {
        Employee employee = new Employee(firstName, lastname);
        if (employeeList.contains(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findall() {
        return Collections.unmodifiableList(employeeList);
    }
}
