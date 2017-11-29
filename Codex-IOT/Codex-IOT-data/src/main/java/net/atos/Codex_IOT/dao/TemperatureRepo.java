package net.atos.Codex_IOT.dao;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import net.atos.Codex_IOT.pojo.Temperature;


/**
 * @author a631080
 *
 */
@Component
@Repository
public interface TemperatureRepo extends JpaRepository<Temperature, Integer>{

	/*public List<Temperature> findbyId(int id);
	
	public List<Temperature> findByDate(Date date);
	
	 @Query("select c from temperature c where c.temp_id = :id")
	    Stream<Temperature> findByid(@Param("id") int id);*/
	
	 //@Query("select c from temperature c JOIN FETCH c.sensor_id where c.")
	   
}
