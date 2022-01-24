package pdp.uz.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appclickup.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
