package it.syncroweb.template.domain.model.tables;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "first_name", nullable = false)
    private String firstname;

    @Column(name = "last_name", nullable = false)
    private String lastname;

    @Column(name = "password", nullable = false)
    private String password;
/*
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean active;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Token> tokens;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tracking> trackings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Orders> orders;

    @JsonManagedReference(value = "users-trackings")
    public List<Tracking> getTrackings() {
        return trackings;
    }

    @JsonManagedReference(value = "users-orders")
    public List<Orders> getOrders() {
        return orders;
    }

    @JsonManagedReference(value = "user-token")
    public List<Token> getTokens(){
        return tokens;
    }*/
}
