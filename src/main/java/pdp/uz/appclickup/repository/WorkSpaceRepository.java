package pdp.uz.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appclickup.entity.User;
import pdp.uz.appclickup.entity.WorkSpace;

import java.util.Optional;

public interface WorkSpaceRepository extends JpaRepository<WorkSpace,Integer> {
    boolean existsByName(String name);
    boolean existsByOwnerIdAndName(Integer owner_id, String name);
    boolean existsByNameAndIdNot(String name, Integer id);
    Optional<WorkSpace> findByIdAndOwnerId(Integer id, Integer owner_id);

}
