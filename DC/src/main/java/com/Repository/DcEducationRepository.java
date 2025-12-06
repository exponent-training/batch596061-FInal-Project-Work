package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Entity.DcEducation;


@Repository
public interface DcEducationRepository extends JpaRepository<DcEducation,Integer>{
	 DcEducation findByCitizenApplicationAppNumber(Integer appNumber);

	DcEducation findByCitizenApplication_AppNumber(Integer appNum);
}