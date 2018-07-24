package com.trendsmixed.fma.module.invoiceinformation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;

import com.trendsmixed.fma.dao.InvoiceInformation;

@AllArgsConstructor
@Service
public class InvoiceInformationService {

    private InvoiceInformationRepository invoiceInformationRepository;


    public  Page<InvoiceInformation> getInvoiceInformationByDateBetween(Date startDate, Date endDate,Pageable pageable) {
        return invoiceInformationRepository.getInvoiceInformationByDateBetween(startDate, endDate,pageable);
    }

    public  Page<InvoiceInformation> getInvoiceInformationByCustomerId(Date startDate, Date endDate, Integer customerId,Pageable pageable) {
        return invoiceInformationRepository.getInvoiceInformationByCustomerId(startDate, endDate, customerId,pageable);
    }

    public  Page<InvoiceInformation> getInvoiceInformationByJobId(Date startDate, Date endDate, Integer jobId,Pageable pageable) {
        return invoiceInformationRepository.getInvoiceInformationByJobId(startDate, endDate, jobId,pageable);
    }

    public  Page<InvoiceInformation> getInvoiceInformationByInvoiceNumber(String invoiceNumber,Pageable pageable) {
        return invoiceInformationRepository.getInvoiceInformationByInvoiceNumber(invoiceNumber,pageable);
    }

}
