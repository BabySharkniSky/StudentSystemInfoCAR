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
    // Private fields - dito natin isi-store yung student info
    private String id;      // Student ID, halimbawa: C2025184921
    private String name;    // Full name ng student
    private String email;   // Email address ng student
    private String phone;   // Contact number
    private String course;  // Course kung saan enrolled
    private String status;  // Enrollment status (Active, Inactive, Graduated)
    
    // Constructor - tatawagin kapag gagawa ng bagong Student object
    // Required lahat ng fields dito
    public Student(String id, String name, String email, String phone, String course, String status) {
        // I-assign yung values ng parameters sa fields ng object
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.status = status;
    }
    
    // Getter methods - para makuha yung value ng bawat field
    
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
    
    public String getStatus() { 
        return status; 
    }
    
    // Setter methods - para ma-update yung value ng fields
    // Useful kapag kailangan baguhin yung info ng student
    
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
    
    public void setStatus(String status) { 
        this.status = status; 
    }
}
