package wojtek.net.jpaRelations.oneToOneUniRel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Item")
@Getter
@Setter
public class ItemDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column( name = "item_name", length = 20 )
    private String itemName;

    @Column( name = "quantity", length = 20 )
    private int quantity;

    @Override
    public String toString(){
        return "id: " + id + " - itemName: " + itemName + " - quantity: " + quantity;
    }

}
