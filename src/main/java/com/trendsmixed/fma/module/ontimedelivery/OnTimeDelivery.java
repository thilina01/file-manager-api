package com.trendsmixed.fma.module.ontimedelivery;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.customer.Customer;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "on_time_delivery")
@NamedQueries({
    @NamedQuery(name = "OnTimeDelivery.findAll", query = "SELECT c FROM OnTimeDelivery c")})
public class OnTimeDelivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(OnTimeDeliveryView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(OnTimeDeliveryView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(OnTimeDeliveryView.Actual.class)
    @Column(name = "actual")
    private double actual;
    @JsonView(OnTimeDeliveryView.Plan.class)
    @Column(name = "plan")
    private double plan;
    @JsonView(OnTimeDeliveryView.Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customer;

}
