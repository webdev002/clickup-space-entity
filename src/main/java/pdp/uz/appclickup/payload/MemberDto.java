package pdp.uz.appclickup.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pdp.uz.appclickup.entity.enums.AddType;
import pdp.uz.appclickup.entity.enums.WorkSpaceRoleName;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private Integer id;

    private Integer roleId;

    private AddType addType;//ADD,EDIT,REMOVE
}
