package insuranceComp.model;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "employee", schema = "public")
public class Employee implements Serializable {
    @SerializedName("firstName")
    @Column(name = "firstname")
    private String firstName;
    @SerializedName("lastName")
    @Column(name = "lastname")
    private String lastName;
    @SerializedName("email")
    @Column(name = "email")
    private String email;
    @SerializedName("password")
    @Column(name = "password")
    private String password;
    @Id
    @SerializedName("id")
    @Column(name = "id")
    private String id;

    public Employee(String firstName, String lastName, String email, String password, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
