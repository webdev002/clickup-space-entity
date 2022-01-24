package pdp.uz.appclickup.entity.template;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
//
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class  AbstractIntegerEntity extends AbstractMainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
