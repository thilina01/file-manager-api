package com.trendsmixed.fma.module.containersize;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.packinglist.PackingList;
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
@Table(name = "container_size")
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
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "containerSize")
    private List<PackingList> packingListList;

    @JsonView(ContainerSizeView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
