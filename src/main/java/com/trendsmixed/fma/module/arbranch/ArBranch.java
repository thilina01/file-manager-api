package com.trendsmixed.fma.module.arbranch;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "ar_branch")
public class ArBranch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ArBranchView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ArBranchView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ArBranchView.Name.class)
    @Column(name = "name")
    private String name;

    public ArBranch(Integer id) {
        this.id = id;
    }

    @JsonView(ArBranchView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
