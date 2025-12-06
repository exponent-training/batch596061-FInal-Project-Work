package com.DTO;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import com.Entity.CitizenApplication;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Data
public class IncomeDTO {
	
	@NotNull(message = "salaryIncome is required")
    @Min(value = 0, message = "salaryIncome cannot be negative")
    private Integer salaryIncome;

    @NotNull(message = "propertyIncome is required")
    @Min(value = 0, message = "propertyIncome cannot be negative")
    private Integer propertyIncome;
}
