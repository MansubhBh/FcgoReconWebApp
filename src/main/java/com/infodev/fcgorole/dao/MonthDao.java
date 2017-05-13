/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.C_MONTH;
import java.util.List;

/**
 *
 * @author mansubh
 */
public interface MonthDao {
    
    List<C_MONTH> getAll();
   C_MONTH getById(int id); 
    
}
