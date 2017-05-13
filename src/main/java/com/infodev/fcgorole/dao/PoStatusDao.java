/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.PoStatus;
import java.util.List;

/**
 *
 * @author mansubh
 */
public interface PoStatusDao {
    
    List<PoStatus> getAll();
    void insert(PoStatus p);
    void update(PoStatus p);
    boolean checkPo(String pocode);
    
    
}
