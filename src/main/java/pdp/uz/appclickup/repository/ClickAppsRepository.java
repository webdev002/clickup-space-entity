package pdp.uz.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appclickup.entity.ClickApps;

import java.util.Optional;

public interface ClickAppsRepository extends JpaRepository<ClickApps,Integer> {

}
