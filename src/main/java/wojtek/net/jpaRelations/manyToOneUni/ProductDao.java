package wojtek.net.jpaRelations.manyToOneUni;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Product")
public class ProductDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column( name = "product_name", length = 20 )
    private String productName;

    @Override
    public String toString(){

        return "PRODUCT = id: " + id + " - product_name: " + productName;
    }
}
