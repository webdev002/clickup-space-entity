package pdp.uz.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.appclickup.entity.enums.WorkspacePermissionName;
import pdp.uz.appclickup.entity.template.AbstractIntegerEntity;


import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpacePermission extends AbstractIntegerEntity {

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private WorkSpaceRole workSpaceRole;//O'rinbosar


    @Enumerated(value = EnumType.STRING)
    private WorkspacePermissionName workspacePermissionName;//add members,remove members


}
