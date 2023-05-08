package think.example.demo;

import think.example.demo.Employee;

import java.util.Collection;

public interface EmployeeService {
    public Employee add(String firstName, String lastname);
    public Employee remove(String firstName, String lastname);
    public Employee find(String firstName, String lastname);

    Collection<Employee> findall();
}
