package pdp.uz.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appclickup.entity.Space;

public interface SpaceRepository extends JpaRepository<Space,Integer> {
    boolean existsByOwnerIdAndName(Integer owner_id, String name);
    boolean existsByNameAndIdNot(String name, Integer id);

}
