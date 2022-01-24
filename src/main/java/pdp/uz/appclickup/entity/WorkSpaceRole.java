package pdp.uz.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.appclickup.entity.enums.WorkSpaceRoleName;
import pdp.uz.appclickup.entity.template.AbstractIntegerEntity;


import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpaceRole extends AbstractIntegerEntity {

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private WorkSpace workSpace;


    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    private WorkSpaceRoleName extendsRole;


}
