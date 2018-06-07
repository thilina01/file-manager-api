package com.trendsmixed.fma.module.tool;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.toolbreakdown.ToolBreakdown;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "tool")
@NamedQueries({
    @NamedQuery(name = "Tool.findAll", query = "SELECT m FROM Tool m")})
public class Tool implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ToolView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ToolView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ToolView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "tool")
    private List<ToolBreakdown> toolBreakdownList;

    public Tool(int anId) {
        this.id = anId;
    }


    @JsonView(ToolView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
