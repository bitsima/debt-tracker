package bitsima.debttracker.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import bitsima.debttracker.enums.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@MappedSuperclass
public abstract class Person implements UserDetails {

    @Id
    protected long idNumber = 0;

    @Column(nullable = false)
    protected String firstName = null;

    @Column(nullable = false)
    protected String lastName = null;

    @Column(nullable = false)
    protected String pass = null;

    @Column(nullable = false)
    protected long accountCreationTime = 0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Roles userRole = null;

    /**
     * @param userRole
     */
    public Person(Roles userRole) {
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.getDisplayName()));
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return String.valueOf(idNumber);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
