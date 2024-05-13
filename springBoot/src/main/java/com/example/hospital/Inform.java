package com.example.hospital;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Inform {

    @Id
    private String inform;
    private String dateCompleted;
    private int gravityOfIncidence;
    private boolean completed;
   // @JsonIgnore
    //@ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name="USER_FK")

}
