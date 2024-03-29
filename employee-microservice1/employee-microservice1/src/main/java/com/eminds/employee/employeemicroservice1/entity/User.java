package com.eminds.employee.employeemicroservice1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import org.joda.time.DateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}),
                                  @UniqueConstraint(columnNames = {"email"}) })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name;
    private String username;
    private String email;
    private String password;
    private Integer loginCounbt = 0;
    private Boolean isActive =true;
    private String ssoType;
    private DateTime loginAt;
    private DateTime createdAt;
    private DateTime updatedAt;


   @ManyToMany(fetch =  FetchType.EAGER , cascade = CascadeType.ALL )
   @JoinTable(name ="user_roles",
              joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
              inverseJoinColumns = @JoinColumn(name = "role_id" , referencedColumnName = "id"))

    private Set<Role> roles;


   @PrePersist
    public void onSave(){

       // created at and updated at

       DateTime currentDateTime = new DateTime();

       this.createdAt = currentDateTime;
       this.updatedAt = currentDateTime;
   }
   @PostPersist
   public void onUpdate(){
       //update At

       DateTime currentDateTime = new DateTime();
       this.updatedAt = currentDateTime;

   }

}
