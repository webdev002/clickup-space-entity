package pdp.uz.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import pdp.uz.appclickup.entity.WorkSpaceUser;

import java.util.Optional;

public interface WorkSpaceUserRepository extends JpaRepository<WorkSpaceUser,Integer> {
    Optional<WorkSpaceUser> findByWorkSpaceIdAndUserId(Integer workSpace_id, Integer user_id);

    @Transactional
    @Modifying
    void deleteByWorkSpaceIdAndUserId(Integer workSpace_id, Integer user_id);

}
