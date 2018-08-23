package com.trendsmixed.fma.module.drawingchangerequest;

import com.trendsmixed.fma.module.drawingversion.DrawingVersion;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
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
@Table(name = "drawing_change_request")
public class DrawingChangeRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(DrawingChangeRequestView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(DrawingChangeRequestView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(DrawingChangeRequestView.ChangeRequestDate.class)
    @Column(name = "change_request_date")
    private Date changeRequestDate;
    @JsonView(DrawingChangeRequestView.DrawingVersion.class)
    @JoinColumn(name = "drawing_version_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private DrawingVersion drawingVersion;

    public DrawingChangeRequest(Integer id) {
        this.id = id;
    }

    @JsonView(DrawingChangeRequestView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }

}
