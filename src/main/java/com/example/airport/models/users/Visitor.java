package com.example.airport.models.users;

import com.example.airport.models.Flight;
import com.example.airport.models.Ticket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Visitor extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVisitor;
    @Column(name = "cpf", nullable = false)
    private String cpf;
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "visitor_tickets",
            joinColumns = @JoinColumn(name = "visitor_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_number"))
    private Set<Ticket> tickets ;

    public void setBirthDate(String birthDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.birthDate = dateFormat.parse(birthDate);
    }

}
