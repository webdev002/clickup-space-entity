package pdp.uz.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.appclickup.entity.template.AbstractIntegerEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Space extends AbstractIntegerEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    private WorkSpace workSpace;

    private String initialLetter;

    @ManyToOne(fetch = FetchType.LAZY)
    private Icons icons;

    @ManyToOne(fetch = FetchType.LAZY)
    private Attachment attachment;

    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;

    @Column(nullable = false)
    private String accessType;

    @PrePersist
    @PreUpdate
    public void setInitialLetterMyMethod(){
        this.initialLetter=name.substring(0,1)+this.name.substring(name.length()-1);
    }

}
