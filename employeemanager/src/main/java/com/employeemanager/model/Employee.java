package com.employeemanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {
    /*
      The id field is annotated with the JPA @Id and @GeneratedValue annotations,
     indicating that it is the primary key of the entity and that its value is generated automatically.
      The @Column annotation is used to specify the column name in the database table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    // The name field represents the name of the employee.
     
    private String name;

    // The email field represents the email address of the employee.
   
    private String email;

    // The jobTitle field represents the job title of the employee.
     
    private String jobTitle;

   // The phone field represents the phone number of the employee.
    
    private String phone;

    // The imageUrl field represents the URL of an image of the employee.
    
    private String imageUrl;

    // The employeeCode field represents the employee code of the employee.
    
    @Column(nullable = false, updatable = false)
    private String employeeCode;

    // The default constructor for the Employee class.
    
    public Employee() {
    }

    // The constructor for the Employee class.
     
    public Employee(String name, String email, String jobTitle, String phone, String imageUrl, String employeeCode) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }

    // Getter for the id field.
    
    public Long getId() {
        return id;
    }

    //Setter for the id field.
    
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the name field.
    
    public String getName() {
        return name;
    }

   // Setter for the name field.
    
    public void setName(String name) {
        this.name = name;
    }

   // Getter for the email field.
     
    public String getEmail() {
        return email;
    }

   //Setter for the email field.
     
    public void setEmail(String email) {
        this.email = email;
    }

   //* Getter for the jobTitle field.
    
    public String getJobTitle() {
        return jobTitle;
    }

    // Setter for the jobTitle field.
     
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

   // Getter for the phone field.
    
    public String getPhone() {
        return phone;
    }

    // Setter for the phone field.
     
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter for the imageUrl field.
     
    public String getImageUrl() {
        return imageUrl;
    }

   // Setter for the imageUrl field.
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

   //* Getter for the employeeCode field.
     
    public String getEmployeeCode() {
        return employeeCode;
    }

    // Setter for the employeeCode field.
    
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    //Returns a string representation of the Employee object.

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}