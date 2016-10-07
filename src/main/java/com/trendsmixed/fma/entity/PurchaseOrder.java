package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.PurchaseOrderView;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PurchaseOrder {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(PurchaseOrderView.PoNumber.class)
    String poNumber;
    
     @JsonView(PurchaseOrderView.OrderQty.class)
    double orderQty;
     
      @JsonView(PurchaseOrderView.CustomerRequestedDate.class)
    Date customerRequestedDate;
      
       @JsonView(PurchaseOrderView.TrwConfirmedDate.class)
    Date trwConfirmedDate;

}
