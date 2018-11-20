package wojtek.net.jpaRelations.manyToOneUni;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "Orders")
public class OrderDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column( name = "order_name", length = 20 )
    private String orderName;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id") // to mozna wykomentowac i tak hinernate utworzy domysle ta kolumne
    private ProductDao product;

    @Override
    public String toString(){
        return "ORDER = id: " + id + " - order_name: " + orderName + product.toString();
    }

}
