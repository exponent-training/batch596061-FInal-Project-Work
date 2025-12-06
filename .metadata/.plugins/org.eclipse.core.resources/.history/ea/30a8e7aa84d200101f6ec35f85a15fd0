package com.DTO;



import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Data
public class EducationDTO {

	@NotBlank
    @Column(name = "highest_degree", nullable = false)
    private String highestDegree;

    @NotNull
    @Column(name = "grad_year", nullable = false)
    private Integer gradYear;

    @NotBlank
    @Column(name = "uni_name", nullable = false)
    private String uniName;
}
