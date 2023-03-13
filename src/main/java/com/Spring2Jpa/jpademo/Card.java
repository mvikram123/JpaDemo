package com.Spring2Jpa.jpademo;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int cardNo;
 //  private String name;
   @Column(nullable = false,unique = true)//dob can not be null.
   private String dob;
    @Enumerated(EnumType.STRING)//it converts enum datatype into varchar(status is conerted from class into varchar)
   private Status status;
    @OneToOne
    @JoinColumn// to add an extra column of userId as a foreign key in child table card
    User user;
    public Card()
    {

    }
    public Card(int cardNo, String dob, Status status) {
        this.cardNo = cardNo;
       // this.name = name;
        this.dob = dob;
        this.status = status;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
