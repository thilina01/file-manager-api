package com.trendsmixed.fma.module.salesperson;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "sales_person")
public class SalesPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SalesPersonView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SalesPersonView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(SalesPersonView.Name.class)
    @Column(name = "name")
    private String name;

    public SalesPerson(Integer id) {
        this.id = id;
    }

    @JsonView(SalesPersonView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
