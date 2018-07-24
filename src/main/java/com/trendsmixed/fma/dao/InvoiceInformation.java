package com.trendsmixed.fma.dao;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.view.InvoiceInformationView;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.job.Job;

import java.util.Calendar;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Thilina
 */
@Data
public class InvoiceInformation {
    @JsonView(InvoiceInformationView.CustomerCode.class)
    private String customerCode;
    @JsonView(InvoiceInformationView.InvoiceDate.class)
    private Date invoiceDate;
    @JsonView(InvoiceInformationView.InvoiceNumber.class)
    private String invoiceNumber;
    @JsonView(InvoiceInformationView.CustomerName.class)
    private String customerName;
    @JsonView(InvoiceInformationView.CustomerItemCode.class)
    private String customerItemCode;
    @JsonView(InvoiceInformationView.CustomerPoNumber.class)
    private String customerPoNumber;
    @JsonView(InvoiceInformationView.ItemCode.class)
    private String itemCode;
    @JsonView(InvoiceInformationView.Description.class)
    private String description;
    @JsonView(InvoiceInformationView.JobNo.class)
    private String jobNo;
    @JsonView(InvoiceInformationView.Weight.class)
    private Double weight;
    @JsonView(InvoiceInformationView.UnitPrice.class)
    private Double unitPrice;
    @JsonView(InvoiceInformationView.RejectedQuantity.class)
    private Double rejectedQuantity;
    @JsonView(InvoiceInformationView.Quantity.class)
    private Double quantity;
    @JsonView(InvoiceInformationView.Customer.class)
    Customer customer;
    @JsonView(InvoiceInformationView.Job.class)
    Job job;

    public InvoiceInformation(Date invoiceDate,String invoiceNumber, String customerCode, String customerName,String customerItemCode,String customerPoNumber,String itemCode,String description,String jobNo,Double weight,Double unitPrice,Double rejectedQuantity,Double quantity) {
        super();
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber != null ? invoiceNumber : "NA";
        this.customerCode = customerCode != null ? customerCode : "NA";
        this.customerName = customerName != null ? customerName : "NA";
        this.customerItemCode = customerItemCode != null ? customerItemCode : "NA";
        this.customerPoNumber = customerPoNumber != null ? customerPoNumber : "NA";
        this.itemCode = itemCode != null ? itemCode : "NA";
        this.description = description != null ? description : "NA";
        this.jobNo = jobNo != null ? jobNo : "NA";
        this.weight = weight != null ? weight : 0.0;
        this.unitPrice = unitPrice != null ? unitPrice : 0.0;
        this.rejectedQuantity = rejectedQuantity != null ? rejectedQuantity : 0.0;
        this.quantity = quantity != null ? quantity : 0.0;

    }
    
    public InvoiceInformation(Customer customer ,Date invoiceDate, String invoiceNumber, String customerCode, String customerName,String customerItemCode,String customerPoNumber,String itemCode,String description,String jobNo,Double weight,Double unitPrice,Double rejectedQuantity,Double quantity) {
        super();
        this.customer = customer ;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber != null ? invoiceNumber : "NA";
        this.customerCode = customerCode != null ? customerCode : "NA";
        this.customerName = customerName != null ? customerName : "NA";
        this.customerItemCode = customerItemCode != null ? customerItemCode : "NA";
        this.customerPoNumber = customerPoNumber != null ? customerPoNumber : "NA";
        this.itemCode = itemCode != null ? itemCode : "NA";
        this.description = description != null ? description : "NA";
        this.jobNo = jobNo != null ? jobNo : "NA";
        this.weight = weight != null ? weight : 0.0;
        this.unitPrice = unitPrice != null ? unitPrice : 0.0;
        this.rejectedQuantity = rejectedQuantity != null ? rejectedQuantity : 0.0;
        this.quantity = quantity != null ? quantity : 0.0;
    }

    public InvoiceInformation(Job job ,Date invoiceDate, String invoiceNumber, String customerCode, String customerName,String customerItemCode,String customerPoNumber,String itemCode,String description,String jobNo,Double weight,Double unitPrice,Double rejectedQuantity,Double quantity) {
        super();
        this.job = job ;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber != null ? invoiceNumber : "NA";
        this.customerCode = customerCode != null ? customerCode : "NA";
        this.customerName = customerName != null ? customerName : "NA";
        this.customerItemCode = customerItemCode != null ? customerItemCode : "NA";
        this.customerPoNumber = customerPoNumber != null ? customerPoNumber : "NA";
        this.itemCode = itemCode != null ? itemCode : "NA";
        this.description = description != null ? description : "NA";
        this.jobNo = jobNo != null ? jobNo : "NA";
        this.weight = weight != null ? weight : 0.0;
        this.unitPrice = unitPrice != null ? unitPrice : 0.0;
        this.rejectedQuantity = rejectedQuantity != null ? rejectedQuantity : 0.0;
        this.quantity = quantity != null ? quantity : 0.0;


    }
    
}
