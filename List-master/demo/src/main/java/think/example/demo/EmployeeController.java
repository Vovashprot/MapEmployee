
package think.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping( "/employee")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public Employee createEmployee(
            @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
    {
        return service.add(firstName, lastName);
    }
    @GetMapping(path = "/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
    {
        return service.find(firstName, lastName);
    }
    @GetMapping(path = "/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
    {
        return service.remove(firstName, lastName);
    }
    @GetMapping
    public Collection<Employee> find(){
        return service.findall();
    }

}
