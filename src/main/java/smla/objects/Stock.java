package smla.objects;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by bobyk on 25/04/16.
 */

@Entity
@Table(name = "users")
public class Stock implements java.io.Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password")
    private String password;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString(){
        return "User [" + this.id + " " + this.name + " " + this.nickname + " " + this.password;
    }
}
