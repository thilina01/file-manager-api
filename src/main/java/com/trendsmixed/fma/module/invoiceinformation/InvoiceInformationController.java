package com.trendsmixed.fma.module.invoiceinformation;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.InvoiceInformation;
import com.trendsmixed.fma.dao.view.*;
import com.trendsmixed.fma.utility.Format;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.trendsmixed.fma.utility.Page;
import org.springframework.data.domain.Pageable;
import java.text.ParseException;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/invoiceInformations")
public class InvoiceInformationController {

    private final InvoiceInformationService invoiceInformationService;
 
    @JsonView(InvoiceInformationView.All.class)
    @GetMapping("/invoiceInformation")
    public Page<InvoiceInformation> getInvoiceInformation(
            @RequestParam(value = "startDate",required = false, defaultValue = "1970-01-01") String startDate,
            @RequestParam(value = "endDate",required = false, defaultValue = "2100-12-31") String endDate,
            @RequestParam(value = "job",required = false, defaultValue = "0") Integer jobId,
            @RequestParam(value = "customer",required = false, defaultValue = "0") Integer customerId,
            @RequestParam(value = "invoiceNumber",required = false, defaultValue = "0") String invoiceNumber ,
            Pageable pageable) throws ParseException{
            Page<InvoiceInformation> page;

            if (!invoiceNumber.equals("0")){
                page = new Page(invoiceInformationService.getInvoiceInformationByInvoiceNumber(invoiceNumber, pageable));    
            } 
            else if(jobId != 0){
                page = new Page(invoiceInformationService.getInvoiceInformationByJobId(Format.toStartDate(startDate), Format.toEndDate(endDate),jobId,pageable));    
            }             
            else if(customerId != 0){
                page = new Page(invoiceInformationService.getInvoiceInformationByCustomerId(Format.toStartDate(startDate), Format.toEndDate(endDate),customerId, pageable));    
            }   
            else {
                page = new Page(invoiceInformationService.getInvoiceInformationByDateBetween(Format.toStartDate(startDate), Format.toEndDate(endDate), pageable));    
            }

            return page;
    }
}







