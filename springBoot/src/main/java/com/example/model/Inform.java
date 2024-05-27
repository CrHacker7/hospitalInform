package com.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Inform {

    @Id
    private String id;
    private String inform;
    private String dateCompleted;
    private int gravityOfIncidence;
    private boolean completed;
   @JsonIgnore
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="GROUP_INCIDENCE_FK") //CAMBIO DE NOMBRE DE USER A GROUP
    private GroupIncidence groupIncidence;

}
