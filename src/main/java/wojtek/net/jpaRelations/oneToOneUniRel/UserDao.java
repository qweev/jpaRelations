package wojtek.net.jpaRelations.oneToOneUniRel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Getter
@Setter
public class UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column( name = "name", length = 20 )
    private String name;

    @Column( name = "full_name", length = 20 )
    private String fullName;

    @OneToOne
    @JoinColumn(name="item_dao_id", unique = true)
    private ItemDao itemDao;

    @Override
    public String toString(){
        return "oneToOneUni -> USER: " + " id: " + id + " - name: " + name + " - fullName: " + fullName + " || ITEM: itemDao: " + itemDao.toString();
    }

}
