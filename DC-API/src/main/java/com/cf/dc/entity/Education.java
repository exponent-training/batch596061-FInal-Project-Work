package com.cf.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dc_edu")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Education {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edu_id")
    private Integer eduId;

    @NotBlank
    @Column(name = "highest_degree", nullable = false)
    private String highestDegree;

    @NotNull
    @Column(name = "grad_year", nullable = false)
    private Integer gradYear;

    @NotBlank
    @Column(name = "uni_name", nullable = false)
    private String uniName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_no", nullable = false)
    private Citizen citizenApplication;
}



