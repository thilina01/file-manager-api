package com.trendsmixed.fma.module.menutype;

import com.trendsmixed.fma.module.menu.Menu;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "menu_type")
public class MenuType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(MenuTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(MenuTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(MenuTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "menuType")
    private List<Menu> menuList;

}
