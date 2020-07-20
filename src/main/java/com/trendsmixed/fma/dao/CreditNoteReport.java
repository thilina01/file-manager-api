package com.trendsmixed.fma.dao;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.view.CreditNoteReportView;
import com.trendsmixed.fma.module.creditnote.CreditNote;
import com.trendsmixed.fma.module.creditnoteitem.CreditNoteItem;
import com.trendsmixed.fma.module.invoice.Invoice;
import com.trendsmixed.fma.module.invoicetype.InvoiceType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 *
 * @author Thilina
 */
@Data
public class CreditNoteReport {

    @JsonView(CreditNoteReportView.Id.class)
    private Integer id;
    @JsonView(CreditNoteReportView.DateOfCreditNote.class)
    private Date dateOfCreditNote;
    @JsonView(CreditNoteReportView.CreditNoteNumber.class)
    private String creditNoteNumber;
    @JsonView(CreditNoteReportView.InvoiceNumber.class)
    private String invoiceNumber;
    @JsonView(CreditNoteReportView.InvoiceTypeName.class)
    private String invoiceTypeName;
    @JsonView(CreditNoteReportView.ExchangeRate.class)
    private Double exchangeRate;
    @JsonView(CreditNoteReportView.TaxRate.class)
    private Double taxRate;
    @JsonView(CreditNoteReportView.InvoiceTypeId.class)
    private Integer invoiceTypeId;
    @JsonView(CreditNoteReportView.CustomerName.class)
    private String customerName;
    @JsonView(CreditNoteReportView.VatNo.class)
    private String vatNo;
    @JsonView(CreditNoteReportView.SVatNo.class)
    private String sVatNo;
    @JsonView(CreditNoteReportView.Consignee.class)
    private String consignee;
    @JsonView(CreditNoteReportView.EmployeeName.class)
    private String employeeName;
    @JsonView(CreditNoteReportView.PaymentTermName.class)
    private String paymentTermName;
    @JsonView(CreditNoteReportView.IncotermName.class)
    private String incotermName;
    @JsonView(CreditNoteReportView.CurrencyName.class)
    private String currencyName;
    
    // @JsonView(CreditNoteReportView.CreditNoteItem.class)
    // private Collection<CreditNoteItem> creditNoteItemList;
    @JsonView(CreditNoteReportView.CreditNoteItemRow.class)
    private Collection<CreditNoteItemRow> creditNoteItemRowList = new ArrayList<>();
    
    public CreditNoteReport(Integer id,Date dateOfCreditNote,String creditNoteNumber,Invoice invoice,InvoiceType invoiceType,CreditNote creditNote) {
        super();
        this.id = id != null ? id :  0;
        this.dateOfCreditNote = dateOfCreditNote;
        this.creditNoteNumber = creditNoteNumber != null ? creditNoteNumber : "NA";
         
        if(invoice != null){  
            this.invoiceNumber = invoice.getInvoiceNumber();
            this.taxRate = invoice.getTaxRate() != null ? invoice.getTaxRate() :  0.0;
            this.exchangeRate = invoice.getExchangeRate() != null && invoice.getExchangeRate().getExchangeRate() != null ? invoice.getExchangeRate().getExchangeRate() : 0.0;
            this.customerName = invoice.getCustomer() != null && invoice.getCustomer().getName() != null ? invoice.getCustomer().getName(): "NA";
            this.vatNo = invoice.getCustomer() != null && invoice.getCustomer().getVatNo() != null ? invoice.getCustomer().getVatNo(): "NA";
            this.sVatNo = invoice.getCustomer() != null && invoice.getCustomer().getSVatNo() != null ? invoice.getCustomer().getSVatNo(): "NA";
            this.consignee = invoice.getCustomer() != null && invoice.getCustomer().getConsignee() != null ? invoice.getCustomer().getConsignee(): "NA";
            this.employeeName = invoice.getCustomer() != null && invoice.getCustomer().getEmployee()!= null && invoice.getCustomer().getEmployee().getCallingName() != null ? invoice.getCustomer().getEmployee().getCallingName(): "NA";
            this.paymentTermName = invoice.getCustomer() != null && invoice.getCustomer().getPaymentTerm()!= null && invoice.getCustomer().getPaymentTerm().getName() != null ? invoice.getCustomer().getPaymentTerm().getName(): "NA";
            this.incotermName = invoice.getCustomer() != null && invoice.getCustomer().getIncoterm()!= null && invoice.getCustomer().getIncoterm().getName() != null ? invoice.getCustomer().getIncoterm().getName(): "NA";
            this.currencyName = invoice.getCustomer() != null && invoice.getCustomer().getCurrency()!= null && invoice.getCustomer().getCurrency().getName() != null ? invoice.getCustomer().getCurrency().getName(): "NA";
        }
        if(invoiceType != null){
            this.invoiceTypeName =  invoiceType.getName(); 
            this.invoiceTypeId = invoiceType.getId(); 
        }

        if(creditNote != null){
            List<CreditNoteItem> creditNoteItemList =  creditNote.getCreditNoteItemList();

            for (CreditNoteItem creditNoteItem : creditNoteItemList) {
                creditNoteItemRowList.add(new CreditNoteItemRow(creditNoteItem));
            }
        }
    }
  
}
