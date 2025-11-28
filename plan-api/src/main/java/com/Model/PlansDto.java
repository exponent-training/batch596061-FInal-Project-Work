package com.Model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class PlansDto {

	
	 @NotBlank(message = "Plan name is mandatory")
	    @Size(min = 3, max = 100, message = "Plan name must be between 3 and 100 characters")
	    @Column(name = "plan_name", nullable = false)
	    private String planName;
	 
	 @Size(max = 255, message = "Comments cannot be more than 255 characters")
	    @Column(name = "comments")
	    private String comments;
}
