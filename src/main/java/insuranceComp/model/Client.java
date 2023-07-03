package insuranceComp.model;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "client", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client implements Serializable {
    @SerializedName("firstname")
    @Column(name = "firstname")
    private String firstName;
    @SerializedName("lastname")
    @Column(name = "lastname")
    private String lastName;
    @Id
    @SerializedName("id")
    @Column(name = "id")
    private String id;
    @SerializedName("employer")
    @Column(name = "employer")
    private String employer;
    @SerializedName("email")
    @Column(name = "email")
    private String email;
    @SerializedName("phone")
    @Column(name = "phone")
    private String phone;
    @SerializedName("debt")
    @Column(name = "debt")
    private double debt;
    @SerializedName("address")
    @Column(name = "address")
    private String address;

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", employer='" + employer + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", debt=" + debt +
                ", address='" + address + '\'' +
                '}';
    }
}
