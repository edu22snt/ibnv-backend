package com.br.ibnv_backend.service.dto;

import java.io.Serializable;
import java.util.Set;

public class UsuarioDTO implements Serializable {

    private Long id;
    private String username;
    private String useremail;
    private String password;
    private Set<String> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UsuarioDTO)) {
            return false;
        }
        return id != null && id.equals(((UsuarioDTO) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + getId() +
                ", username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                ", roles='" + getRoles() + "'" +
                "}";
    }
}
