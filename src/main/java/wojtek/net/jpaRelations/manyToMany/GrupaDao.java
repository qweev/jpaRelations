package wojtek.net.jpaRelations.manyToMany;

import lombok.Getter;
import lombok.Setter;
import wojtek.net.jpaRelations.oneToManyBi.PostDao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Grupa")
public class GrupaDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column( name = "grupa_name", length = 20 )
    private String grupaName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "GrupaPerson",
            joinColumns = { @JoinColumn(name = "grupa_dao_id") },
            inverseJoinColumns = { @JoinColumn(name = "person_dao_id") }
    )
    List<PersonDao> persons = new ArrayList<>();

    @Override
    public String toString(){

        return "GRUPA == id: " + id + " - grupaName: " + grupaName ;
    }

    public String showPersons(){

        StringBuilder s = new StringBuilder();
        persons.forEach(x->s.append(x));
        return s.toString();
    }


}
