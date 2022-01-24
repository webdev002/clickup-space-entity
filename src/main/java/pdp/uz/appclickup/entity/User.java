package pdp.uz.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pdp.uz.appclickup.entity.enums.SystemRoleName;
import pdp.uz.appclickup.entity.template.AbstractIntegerEntity;
import pdp.uz.appclickup.entity.template.AbstractLongEntity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User extends AbstractIntegerEntity implements UserDetails {



    @Column(nullable = false)
    private String fullName;

    @Column(unique = true,nullable = false)
    @Email
    private String email;

    @Column(unique = true,nullable = false)
    private String password;


    private String color;


    private String initialLetter;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment attachment;

    private String emailCode;


    private boolean enabled;

    private boolean accountNonExpired=true;

    private boolean accountNonLocked=true;

    private boolean credentialsNonExpired=true;

    @Enumerated(value = EnumType.STRING)
    private SystemRoleName systemRoleName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(this.systemRoleName.name());
        return Arrays.asList(simpleGrantedAuthority);
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public User(String fullName, String email, String password, SystemRoleName systemRoleName) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.systemRoleName = systemRoleName;
    }
}
