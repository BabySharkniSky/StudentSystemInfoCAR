/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.model;

/**
 *
 * @author Maine
 */
public class Student {
  
    private String id;      
    private String name;    
    private String email;   
    private String phone;   
    private String course;  


    public Student(String id, String name, String email, String phone, String course) {
        
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.course = course;
    }
    

    
    public String getId() { 
        return id; 
    }
    
    public String getName() { 
        return name; 
    }
    
    public String getEmail() { 
        return email; 
    }
    
    public String getPhone() { 
        return phone; 
    }
    
    public String getCourse() { 
        return course; 
    }
   

    
    public void setId(String id) { 
        this.id = id; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }
    
    public void setPhone(String phone) { 
        this.phone = phone; 
    }
    
    public void setCourse(String course) { 
        this.course = course; 
    }
    

