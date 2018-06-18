package com.trendsmixed.fma.module.paint;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.item.Item;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "paint")
public class Paint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(PaintView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(PaintView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(PaintView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "paint")
    private List<Item> itemList;

    @JsonView(PaintView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
