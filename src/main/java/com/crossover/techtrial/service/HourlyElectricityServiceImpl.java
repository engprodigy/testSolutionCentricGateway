package com.crossover.techtrial.service;

import com.crossover.techtrial.model.HourlyElectricity;
import com.crossover.techtrial.repository.HourlyElectricityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.dto.MaxMinDate;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * HourlyElectricityServiceImpl will handle electricity generated by a Panel.
 *
 * @author Crossover
 *
 */

@Service
@Repository
@Transactional(readOnly = true)
public class HourlyElectricityServiceImpl implements HourlyElectricityService {
    
     @PersistenceContext private EntityManager em;
    
  @Autowired
  HourlyElectricityRepository hourlyElectricityRepository;
  
   @Override
  public HourlyElectricity save(HourlyElectricity hourlyElectricity) {
    return hourlyElectricityRepository.save(hourlyElectricity);
  }
  
   @Override
  public Page<HourlyElectricity> getAllHourlyElectricityByPanelId(Long panelId, Pageable pageable) {
    //return hourlyElectricityRepository.findAllByPanelIdOrderByReadingAtDesc(panelId, pageable);
    return hourlyElectricityRepository.findAll(pageable);
  }
  
   @Override
  public List<DailyElectricity> getAllDailyElectricityByPanelId(Long panelId) {
      
      String panel_id = Long.toString(panelId);
      
     List<Object[]> menuList = em.createNativeQuery("SELECT reading_at AS LocalDate,  \n" +
        "ROUND(AVG(generated_electricity),2) AS average, SUM(generated_electricity) AS sum,\n" +
         "MAX(generated_electricity) AS max, MIN(generated_electricity) AS min FROM hourly_electricity "
              + "where panel_id =:panel_id" )
          //.setParameter("reading_at", minDate)
               .setParameter("panel_id", panelId)
          .getResultList();
      
    /*  List<Object[]> menuList = em.createNativeQuery("SELECT reading_at AS LocalDate,  \n" +
        "ROUND(AVG(generated_electricity),2) AS average, SUM(generated_electricity) AS sum,\n" +
         "MAX(generated_electricity) AS max, MIN(generated_electricity) AS min FROM hourly_electricity" +
        "WHERE panel_id =:panel_id GROUP BY reading_at ")
          //.setParameter("reading_at", minDate)
         .setParameter("panel_id", 1)
          .getResultList();*/
       
      
      
        List<Object[]> MaxMinDate = em.createNativeQuery("SELECT MIN(reading_at) AS minDate, MAX(reading_at) AS maxDate  "
               + "FROM hourly_electricity").getResultList();
        
     
           
        List<Date> menuList2 = new ArrayList<>();
           MaxMinDate.forEach((m) -> {
            
               Date t = (Date) m[0] ; 
               Date t2 = (Date) m[1] ;
               menuList2.add(t);
               menuList2.add(t2);
              // maxDate = t;
             });
       
      Date todaysDate = new Date();     
      long diffInMillies = Math.abs(todaysDate.getTime() - menuList2.get(0).getTime());
      long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
      
      int noOfDays = (int)diff;
        
        Date minDate  = menuList2.get(0);
        Date maxDate  = menuList2.get(0);
        
         List<DailyElectricity> DailyElectricity = new ArrayList<>();
         
         
          List<Object[]> dateListOut = em.createNativeQuery("SELECT reading_at AS LocalDate,  \n" +
        "ROUND(AVG(generated_electricity),2) AS average, SUM(generated_electricity) AS sum,\n" +
         "MAX(generated_electricity) AS max, MIN(generated_electricity) AS min FROM hourly_electricity "
              + "where panel_id =:panel_id and reading_at =:reading_at")
           .setParameter("reading_at", maxDate)
            .setParameter("panel_id", panelId)
           .getResultList();
         
         for (int i= -1; i < noOfDays; i++){
            //minDate.
             if ( noOfDays != 0){
                 
            minDate = DateUtil.addDays(minDate, 1);
            
                   }
             
             for (int j= 0; j < 24; j++) {
            
            
            List<Object[]> dateList = em.createNativeQuery("SELECT reading_at AS LocalDate,  \n" +
        "ROUND(AVG(generated_electricity),2) AS average, SUM(generated_electricity) AS sum,\n" +
         "MAX(generated_electricity) AS max, MIN(generated_electricity) AS min FROM hourly_electricity "
              + "where panel_id =:panel_id")
           // .setParameter("reading_at", maxDate)
               .setParameter("panel_id", panelId)
          .getResultList();
            
           // DailyElectricity.addAll(DailyElectricityLatestList);
           
              }
            
              }
         
      
    
      
       return DailyElectricity;
   // return hourlyElectricityRepository.findAllByPanelIdOrderByReadingAtDesc(panelId, pageable);
   
  }

    private static class DateUtil {

        public static Date addDays(Date date, int days)
              {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
               }
    }
  
}