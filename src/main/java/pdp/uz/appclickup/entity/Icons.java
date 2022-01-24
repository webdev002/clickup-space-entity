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
public class Icons extends AbstractIntegerEntity {
    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    private Attachment attachment;

    @Column(nullable = false)
    private String initialLetter;

    @PrePersist
    @PreUpdate
    public void setInitialLetterMyMethod(){
        this.initialLetter=name.substring(0,1)+this.name.substring(name.length()-1);
    }

}
