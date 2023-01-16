import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {

  // Declare variables to hold employee data
  public employees: Employee[];
  public editEmployee: Employee;
  public deleteEmployee: Employee;

  // Inject the EmployeeService
  constructor(private employeeService: EmployeeService){}

  // Get all employees on initialization
  ngOnInit() {
    this.getEmployees();
  }

  // Get all employees from the EmployeeService
  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        // Set the employee data to the response
        this.employees = response;
        console.log(this.employees);
      },
      (error: HttpErrorResponse) => {
        // Handle errors
        alert(error.message);
      }
    );
  }

  // Add a new employee
  public onAddEmloyee(addForm: NgForm): void {
    // Open the add employee modal
    document.getElementById('add-employee-form').click();
    // Send the employee data to the EmployeeService
    this.employeeService.addEmployee(addForm.value).subscribe(
      (response: Employee) => {
        console.log(response);
        // Get the updated employee data
        this.getEmployees();
        // Reset the add form
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        // Handle errors
        alert(error.message);
        addForm.reset();
      }
    );
  }

  // Update an existing employee
  public onUpdateEmloyee(employee: Employee): void {
    // Send the employee data to the EmployeeService
    this.employeeService.updateEmployee(employee).subscribe(
      (response: Employee) => {
        console.log(response);
        // Get the updated employee data
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        // Handle errors
        alert(error.message);
      }
    );
  }

  // Delete an existing employee
  public onDeleteEmloyee(employeeId: number): void {
    // Send the employee id to the EmployeeService
    this.employeeService.deleteEmployee(employeeId).subscribe(
      (response: void) => {
        console.log(response);
        // Get the updated employee data
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        // Handle errors
        alert(error.message);
      }
    );
  }

  // Search for employees based on name, email, phone, or job title
  public searchEmployees(key: string): void {
    console.log(key);
    const results: Employee[] = [];
    for (const employee of this.employees) {
      // Check if key is in any of the employee's properties
      if (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.jobTitle.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(employee);
      }
    }
    this.employees = results;
    if (results.length === 0 || !key) {
      this.getEmployees();
    }
  }

  // Open the add, edit, or delete modal for a specific employee
  public onOpenModal(employee: Employee, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal');
    }
    if (mode === 'edit') {
      this.editEmployee = employee;
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
    if (mode === 'delete') {
      this.deleteEmployee = employee;
      button.setAttribute('data-target', '#deleteEmployeeModal');
    }
    container.appendChild(button);
    button.click();
  }
}