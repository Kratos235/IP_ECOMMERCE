package SpringMVC.Controller;

import SpringMVC.Entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    //Temporary Database
    private List<Employee>employeeList = new ArrayList<>();

    @PostMapping("/register")
    public String registerEmployee(@RequestBody Employee employee){
        employeeList.add(employee);
        return "Employee Register Successfully";
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        for(Employee emp:employeeList){
            if(emp.getId()==id){
                return emp;
            }
        }
        return null;
    }
    @GetMapping("/search")
    public Employee searchEmployee(@RequestParam(required=false) String department){
        for(Employee emp:employeeList){
            if(emp.getDepartment().equalsIgnoreCase(department)){
                return emp;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id,@RequestBody Employee updatedemployee){
        for(Employee emp:employeeList){
            if(emp.getId()==id){
                emp.setName(updatedemployee.getName());
                emp.setDepartment(updatedemployee.getDepartment());
                emp.setSalary(updatedemployee.getSalary());
                return "Employee updated successfully";
            }
        }
        return "Employee Not Found";
    }

    @DeleteMapping("{id}")
    public String deleteEmployee(@PathVariable int id){
        for(Employee emp:employeeList){
            if(emp.getId()==id){
                employeeList.remove(emp);
                return "Employee Deleted Succesfully";
            }
        }
        return "Employee Not Found";
    }

     //Welcome API
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Employee Management System";
    }
}
