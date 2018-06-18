package com.trendsmixed.fma.module.subcontractor;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "subcontractor")
public class Subcontractor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SubcontractorView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SubcontractorView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(SubcontractorView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(SubcontractorView.Address.class)
    @Column(name = "address")
    private String address;
    @JsonView(SubcontractorView.Contact.class)
    @Column(name = "contact")
    private String contact;

    public Subcontractor(Integer id) {
        this.id = id;
    }

}
