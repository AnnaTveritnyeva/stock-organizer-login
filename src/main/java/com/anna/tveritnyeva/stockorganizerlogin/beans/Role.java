package com.anna.tveritnyeva.stockorganizerlogin.beans;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int role_id;
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
