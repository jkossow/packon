package org.kossowski.packon.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "users")
public class User extends  BaseEntity<String> {

    private String nazwisko;
    private String imie;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "roles", joinColumns = {@JoinColumn(name = "login")},  foreignKey = @ForeignKey( name = "FK_user__role") )
    private Set<Role> roles = new HashSet<>();


    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", roles=" + roles +
                "} " + super.toString();
    }
}
