package pdp.uz.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pdp.uz.appclickup.entity.WorkSpaceRole;
import pdp.uz.appclickup.entity.enums.WorkSpaceRoleName;

import java.util.List;
import java.util.Optional;

public interface WorkSpaceRoleRepository extends JpaRepository<WorkSpaceRole,Integer> {
    Optional<WorkSpaceRole> findByWorkSpaceIdAndNameAndExtendsRole(Integer workSpace_id, String name, WorkSpaceRoleName extendsRole);

    @Query(value = "select * from work_space_role  where work_space_role.name='ROLE_MEMBER' and work_space_role.name='ROLE_GUEST'", nativeQuery = true)
    List<WorkSpaceRole> getAllByWorkSpace();
}
