/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.techtrial.dto;

import java.time.LocalDate;
import java.util.Date;
import java.io.Serializable;

/**
 *
 * @author engprodigy
 */
public class MaxMinDate implements Serializable {
     
    private static final long serialVersionUID = 3605549522072828877L;
    
    private Date minDate;
    private Date maxDate;
    
    public Date getMinDate() {
    return minDate;
  }

  public void setMinDate(Date date) {
    this.minDate = date;
  }
  
  public Date getMaxDate() {
    return maxDate;
  }

  public void setMaxDate(Date date) {
    this.maxDate = date;
  }
    
}
