package pdp.uz.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.appclickup.entity.template.AbstractIntegerEntity;
import pdp.uz.appclickup.entity.template.AbstractLongEntity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attachment extends AbstractIntegerEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    @Size(min = 1,max = 500)
    private Long size;

    @Column(nullable = false)
    private String contentType;
}
