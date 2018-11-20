package wojtek.net.jpaRelations.oneToOneBiRel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Engine")
public class EngineDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column( name = "engine_name", length = 20 )
    private String engineName;

    @OneToOne
//    @JoinColumn(name = "Car_dao_id")
    @PrimaryKeyJoinColumn
    private CarDao carDaoRel;

    @Override
    public String toString(){
        return " ENGINE= id: " + id + " - engine name: " + engineName;
    }

}
