/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.controller;

import com.infodev.fcgorole.dao.DonorDao;
import com.infodev.fcgorole.dao.DtcoUserDao;
import com.infodev.fcgorole.dao.EconomicDao;
import com.infodev.fcgorole.dao.MonthDao;
import com.infodev.fcgorole.dao.PoDao;
import com.infodev.fcgorole.dao.PoEntryDao;
import com.infodev.fcgorole.dao.PoStatusDao;
import com.infodev.fcgorole.dao.PoUserDao;
import com.infodev.fcgorole.dao.ProjectDao;
import com.infodev.fcgorole.dao.SourceTypeDao;
import com.infodev.fcgorole.dao.TransactionDao;
import com.infodev.fcgorole.model.ApiListResponse;
import com.infodev.fcgorole.model.ApiResponse;
import com.infodev.fcgorole.model.C_DONOR;
import com.infodev.fcgorole.model.C_MONTH;
import com.infodev.fcgorole.model.C_PROJECT;
import com.infodev.fcgorole.model.C_SOURCE_TYPE;
import com.infodev.fcgorole.model.DECSTSA_TRANSACTION;
import com.infodev.fcgorole.model.DECSTSA_TRANSACTION_ENTRY;
import com.infodev.fcgorole.model.PO_TRAN_ENTRY;
import com.infodev.fcgorole.model.PayinOffice;
import com.infodev.fcgorole.model.PoStatus;
import com.infodev.fcgorole.model.TranIncorrectRequest;
import com.infodev.fcgorole.model.TranResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mansubh
 */
@RestController
@CrossOrigin
public class ApiController {
    
    @Autowired
    private DonorDao donorDao;
    @Autowired
    private EconomicDao economicDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private SourceTypeDao sourceTypeDao;
    @Autowired
    private TransactionDao transactionDao;
    @Autowired
    private PoDao poDao;
    @Autowired
    private PoEntryDao poEntryDao;
    @Autowired
    private MonthDao monthDao;
    @Autowired
    private DtcoUserDao dtcoUserDao;
    @Autowired
    private PoUserDao poUserDao;
    @Autowired
    private PoStatusDao poStatusDao;
    
    
    @RequestMapping(value = "/api/payingoffice",method = RequestMethod.GET)
    public ResponseEntity<List<PayinOffice>> getPO(){
        List<PayinOffice> polist = poDao.getByDistrictCode("27");
        return new ResponseEntity<>(polist, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/donor",method = RequestMethod.GET)
    public ResponseEntity<List<C_DONOR>> getDonor(){
        List<C_DONOR> donorlist = donorDao.getAll();
        return new ResponseEntity<>(donorlist, HttpStatus.OK);
    }
    
    @RequestMapping(value = "api/project",method = RequestMethod.GET)
    public ResponseEntity<List<C_PROJECT>> getProject(){
        List<C_PROJECT> projectlist = projectDao.getAll();
        return new ResponseEntity<>(projectlist, HttpStatus.OK);
    }
    
    @RequestMapping(value = "api/sourcetype",method = RequestMethod.GET)
    public ResponseEntity<List<C_SOURCE_TYPE>> getSourceType(){
        List<C_SOURCE_TYPE> sourcetypelist = sourceTypeDao.getAll();
        return new ResponseEntity<>(sourcetypelist,HttpStatus.OK);
        
    }
    
    @RequestMapping(value= "api/getDescByCode",method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getNameByCode(@RequestParam(value = "code") String code){
       ApiResponse response = new ApiResponse();
       response.setStatus("success");
       response.setMessage("name fetched successfully");
       String name =  projectDao.getDescCode(code);
       response.setData(name);
       return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
    @RequestMapping(value = "api/getDonorByCode",method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getDonorByCode(@RequestParam(value = "code") String code){
        ApiResponse response = new ApiResponse();
        response.setStatus("success");
        response.setMessage("name fetched successfully");
        String name = donorDao.getDonorByCode(code);
        response.setData(name);
        
        return new ResponseEntity<>(response,HttpStatus.OK);
        
    }
    
    @RequestMapping(value = "api/getEconomicByCode",method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getEconomicByCode(@RequestParam(value = "code") String code){
    ApiResponse response = new ApiResponse();
    response.setStatus("success");
    response.setMessage("name fetched successfully");
    String name = economicDao.getEconomicByCode(code);
    response.setData(name);
    return new ResponseEntity<>(response,HttpStatus.OK);
    
}
    
   @RequestMapping(value = "api/getSourceByCode",method = RequestMethod.GET)
   public ResponseEntity<ApiResponse> getSourceByCode(@RequestParam(value = "code") String code){
       ApiResponse response = new ApiResponse();
       response.setStatus("success");
       response.setMessage("name fetched successfully");
       String name = sourceTypeDao.getSourceByCode(code);
       response.setData(name);
       return new ResponseEntity<>(response,HttpStatus.OK);
   }
   
   @RequestMapping(value = "api/getAllTransaction",method = RequestMethod.GET)
   public ResponseEntity<List<DECSTSA_TRANSACTION>> getAllTransaction(){
       List<DECSTSA_TRANSACTION> tranlist = transactionDao.getAll();
       if(tranlist != null){
           return new ResponseEntity<>(tranlist, HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   
   @RequestMapping(value = "api/reconcile",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<ApiResponse> checkTransaction(@RequestBody DECSTSA_TRANSACTION_ENTRY tranEntry ){
      ApiResponse response = new ApiResponse();
      PoStatus poStatus = new PoStatus();
       System.out.println(poStatusDao.checkPo("boolean value--->>"+tranEntry.getPoCode()));
      if(!(poStatusDao.checkPo(tranEntry.getPoCode()))){
          poStatus.setPo_code(tranEntry.getPoCode());
          poStatus.setCheck_flag(true);
          poStatus.setSubmit_flag(false);
          poStatus.setMonth(monthDao.getById(tranEntry.getMonthId()));
          poStatusDao.insert(poStatus);
      }else{
         poStatus.setCheck_flag(true);
         poStatusDao.update(poStatus);
      }
       
   for(DECSTSA_TRANSACTION t : transactionDao.getAll()){
       if((t.getBUD_YEAR().equals(tranEntry.getBudYear()))  
               && (t.getACC_CODE().equals(tranEntry.getAccCode())) 
               && (t.getECONOMIC_CODE5().equals(tranEntry.getEcoCode()))
               && (t.getSOURCE_TYPE_CODE().equals(tranEntry.getSourceType()))
               && (t.getDONOR_CODE().equals(tranEntry.getDonorCode())) 
               && (t.getEXPENDITURE_AMOUNT().equals(tranEntry.getAmount()))
               )
       {
          // boolean checkbool = t.getSOURCE_TYPE_CODE().equals("0");
          // System.out.println("Check param : " + checkbool);
           System.out.println("Acc code : "+ tranEntry.getAccCode());
           System.out.println("Source code : " + tranEntry.getSourceType());
           System.out.println("Expenditure Amount : "+ tranEntry.getAmount());
           response.setStatus("success");
           response.setMessage("all the inputs are correct");
           response.setData("true");
           
           return new ResponseEntity<>(response,HttpStatus.OK);
       }
   }
   response.setStatus("error");
   response.setMessage("Invalid input. please check your entry");
   response.setData("false");
   return new ResponseEntity<>(response, HttpStatus.OK);
}
   
   
   @RequestMapping(value = "api/evaluateIncorrect",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<ApiListResponse> getValueByParameter(@RequestBody TranIncorrectRequest tranrequest){
       ApiListResponse response = new ApiListResponse();
       List<TranResponse> tranreslist = new ArrayList<>();
       
       //getting all the data from transaction table whose parameter matches the parameter in request body
       
       for(DECSTSA_TRANSACTION t : transactionDao.getAll()){
            if((t.getBUD_YEAR().equals(tranrequest.getBud_year()))  
               && (t.getACC_CODE().equals(tranrequest.getAccCode())) 
               && (t.getECONOMIC_CODE5().equals(tranrequest.getEconomicCode()))
               && (t.getDONOR_CODE().equals(tranrequest.getDonorCode())) 
                 && (t.getPO_CODE().equals(tranrequest.getPoCode()))
               ){
                //if parameter matches add matches entity in a new object TranResponse
                TranResponse tranResponse = new TranResponse();
                tranResponse.setPoCode(t.getPO_CODE());
                tranResponse.setSourceCode(t.getSOURCE_TYPE_CODE());
                tranResponse.setSourceType(sourceTypeDao.getSourceByCode(t.getSOURCE_TYPE_CODE()));
                String accCode = t.getACC_CODE();
                int acclength = accCode.length();
                String accnew = accCode.substring(0, acclength-1);
                System.out.println("acc new -->>" + accnew);
                tranResponse.setEcoCode(t.getECONOMIC_CODE5());
                tranResponse.setEcoName(economicDao.getEconomicByCode(t.getECONOMIC_CODE5()));
                tranResponse.setExpenditure_amount(t.getEXPENDITURE_AMOUNT());
                tranResponse.setChequeNo(t.getCHEQUE_NO());
                tranResponse.setDonorCode(t.getDONOR_CODE());
                tranResponse.setDonorName(donorDao.getDonorByCode(t.getDONOR_CODE()));
                tranreslist.add(tranResponse);
            }
       }
       if(!tranreslist.isEmpty()){
       response.setStatus("success");
       response.setMessage("all transactions retrieved");
       response.setData(tranreslist);
       return new ResponseEntity<>(response, HttpStatus.OK);
       }
       response.setStatus("error");
       response.setMessage("empty data. nothing to retrieve");
       response.setData(null);
       return new ResponseEntity<>(response,HttpStatus.OK);
       
   }
   
   @RequestMapping(value = "api/savepotran", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<ApiResponse> savePoTransaction(@RequestBody DECSTSA_TRANSACTION_ENTRY tranrequest){
       
       ApiResponse response = new ApiResponse();
       if(tranrequest != null){
           PO_TRAN_ENTRY potran = new PO_TRAN_ENTRY();
           potran.setAccCode(tranrequest.getAccCode());
           potran.setBudYear(tranrequest.getBudYear());
           potran.setPoCode(tranrequest.getPoCode());
           int monthid = tranrequest.getMonthId();
           System.out.println("month id is -->>"+ monthid);
           C_MONTH month = monthDao.getById(monthid);
           System.out.println("month data"+ month.toString());
           potran.setMonth(month);
           potran.setEconomicCode(tranrequest.getEcoCode());
           potran.setDonorCode(tranrequest.getDonorCode());
           potran.setSourceTypeCode(tranrequest.getSourceType());
           potran.setAmount(tranrequest.getAmount());
           poEntryDao.insert(potran);
           response.setStatus("success");
           response.setMessage("Data Submitted successfully");
           response.setData(null);
           return new ResponseEntity<>(response, HttpStatus.OK);
       }
       response.setData("error");
       response.setMessage("Error inserting.. null input");
       response.setData(null);
       return new ResponseEntity<>(response, HttpStatus.OK);
       
   }
   
   @RequestMapping(value = "api/getuserdata",method = RequestMethod.GET)
   public ResponseEntity<ApiResponse> getUserInfo(@RequestParam(value = "username") String username){
       ApiResponse response = new ApiResponse();
       String districtname = dtcoUserDao.getDistrictByUsername(username);
       if(districtname != null){
           response.setStatus("success");
           response.setMessage("DTCO");
           response.setData(districtname);
           return new ResponseEntity<>(response, HttpStatus.OK);
       }
       String poname = poUserDao.getPoByUsername(username);
       if(poname != null){
           response.setStatus("success");
           response.setMessage("PO");
           response.setData(poname);
           return new ResponseEntity<>(response,HttpStatus.OK);
       }
       
       response.setStatus("error");
       response.setMessage("cannot retrieve data. Invalid user");
       response.setData(null);
       return new ResponseEntity<>(HttpStatus.OK);
   }
 
   
}