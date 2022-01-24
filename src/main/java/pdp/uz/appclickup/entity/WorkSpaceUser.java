package pdp.uz.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.appclickup.entity.template.AbstractIntegerEntity;


import javax.persistence.*;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpaceUser extends AbstractIntegerEntity {

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private WorkSpace workSpace;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private WorkSpaceRole workSpaceRole;

    @Column(nullable = false)
    private Timestamp dateInvited;


    private Timestamp dateJoined;

}
