package com.trendsmixed.fma.module.drawingversion;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.drawingchangerequest.DrawingChangeRequest;
import com.trendsmixed.fma.module.item.Item;

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
@Table(name = "drawing_version")
public class DrawingVersion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(DrawingVersionView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(DrawingVersionView.Version.class)
    @Column(name = "version")
    private String version;
    @JsonView(DrawingVersionView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(DrawingVersionView.FilePath.class)
    @Column(name = "file_path")
    private String filePath;
    @JsonView(DrawingVersionView.Item.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;
    @JsonView(DrawingVersionView.DrawingChangeRequest.class)
    @JoinColumn(name = "drawing_change_request_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private DrawingChangeRequest drawingChangeRequest;


    @JsonView(DrawingVersionView.All.class)
    public String getDisplay() {
        return version; 
        
    }
       
}
