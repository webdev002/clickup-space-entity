package pdp.uz.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import pdp.uz.appclickup.entity.template.AbstractIntegerEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SpaceUser extends AbstractIntegerEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Space space;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
