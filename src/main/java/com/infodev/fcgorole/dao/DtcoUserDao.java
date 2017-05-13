/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.DtcoUser;
import java.util.List;

/**
 *
 * @author mansubh
 */
public interface DtcoUserDao {
    
    List<DtcoUser> getAll();
    String getDistrictByUsername(String username);
}
