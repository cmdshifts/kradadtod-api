package th.ac.utcc.kradadtodapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", table = "member")
    private Long id;
    @Column(name = "username", table = "member")
    private String username;
    @Column(name = "email", table = "member")
    private String email;
    @Column(name = "profile_url", table = "member")
    private String profileUrl;
    @Column(name = "display_name", table = "member")
    private String displayName;
    @Column(name = "password", table = "member")
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
