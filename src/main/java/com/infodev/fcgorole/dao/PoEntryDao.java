/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.PO_TRAN_ENTRY;
import java.util.List;

/**
 *
 * @author mansubh
 */
public interface PoEntryDao {
    
    int insert(PO_TRAN_ENTRY p);
    int update(PO_TRAN_ENTRY p);
    int delete(int id);
    List<PO_TRAN_ENTRY> getAll();
    
    
    
}
