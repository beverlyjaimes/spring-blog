package com.codeup.blog.blog;

import javax.persistence.*;

@Entity
@Table(name="dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "Int(11) UNSIGNED", nullable = false)
    private long id;

    @Column(columnDefinition = "Int(3) UNSIGNED", nullable = false, unique = true )
    private int age;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(columnDefinition =  "char(2) default 'XX'")
    private String reside_state;


//    CREATE TABLE dogs (
//            id int(11) unsigned NOT NULL AUTO_INCREMENT,
//    age tinyint(3) unsigned NOT NULL,
//    name varchar(200) NOT NULL,
//    reside_state char(2) DEFAULT 'XX',
//    PRIMARY KEY (id),
//    UNIQUE KEY UK_????????????????? (age)
//            ) ENGINE=MyISAM DEFAULT CHARSET=utf8


    public Dog() {
//        we need an empty constructor for spring to work
    }

    public Dog(long id, int age, String name, String reside_state) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.reside_state = reside_state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReside_state() {
        return reside_state;
    }

    public void setReside_state(String reside_state) {
        this.reside_state = reside_state;
    }
}
