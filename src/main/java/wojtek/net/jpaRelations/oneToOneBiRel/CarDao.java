package wojtek.net.jpaRelations.oneToOneBiRel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Car")
public class CarDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column( name = "car_name", length = 20 )
    private String carName;

    @OneToOne(mappedBy = "carDaoRel", cascade = CascadeType.ALL)
    private EngineDao engineDao;

    @Override
    public String toString(){
        return "CAR= id " + id + " - carName: " + carName + "||  engineDao: " + engineDao.toString();
    }

}
