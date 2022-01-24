package pdp.uz.appclickup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.appclickup.entity.template.AbstractIntegerEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SpaceView extends AbstractIntegerEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Space space;

    @ManyToOne(fetch = FetchType.LAZY)
    private View view;
}
