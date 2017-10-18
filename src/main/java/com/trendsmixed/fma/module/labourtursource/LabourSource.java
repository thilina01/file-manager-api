package com.trendsmixed.fma.module.labourtursource;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.labourturnover.LabourTurnover;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "labour_source")
@NamedQueries({
    @NamedQuery(name = "LabourSource.findAll", query = "SELECT c FROM LabourSource c")})
public class LabourSource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(LabourSourceView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(LabourSourceView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(LabourSourceView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "labourSource")
    private List<LabourTurnover> labourTurnoverList;

}
