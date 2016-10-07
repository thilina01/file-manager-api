package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.PurchaseOrderHasItemView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PurchaseOrderHasItem {
	@Id
	@GeneratedValue
	private Integer id;
	
        @JsonView(PurchaseOrderHasItemView.Qty.class)
        double Qty;
       
        
    
       
        

}
