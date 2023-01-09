package com.assign.interviewassign;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface APIRepository  extends JpaRepository<APIEntity, Long> {

}
