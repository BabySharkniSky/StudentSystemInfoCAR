/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.model;

/**
 * Staff - Model class para sa staff members
 * Nag-store ng basic staff information tulad ng pangalan, email, phone, at department
 */
public class Staff {

    // Fields - properties ng staff
    private String name;        // Full name ng staff
    private String email;       // Email address
    private String phone;       // Phone number
    private String department;  // Department (e.g., COECS, CAS)

    /**
     * Constructor - Gumagawa ng bagong Staff object
     * @param name - full name ng staff
     * @param email - email address
     * @param phone - contact number
     * @param department - department assignment
     */
    public Staff(String name, String email, String phone, String department) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
    }

    // Getter methods - para ma-access ang private fields
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDepartment() { return department; }

    // Setter methods - para mag-update ng staff info
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setDepartment(String department) { this.department = department; }
}

