package com.trendsmixed.fma.module.containersize;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "container_size")
@NamedQueries({
    @NamedQuery(name = "ContainerSize.findAll", query = "SELECT i FROM ContainerSize i")})
public class ContainerSize implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ContainerSizeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ContainerSizeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ContainerSizeView.Name.class)
    @Column(name = "name")
    private String name;

}
