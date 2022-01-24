package pdp.uz.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appclickup.entity.SpaceUser;

public interface SpaceUserRepository extends JpaRepository<SpaceUser,Integer> {
}
