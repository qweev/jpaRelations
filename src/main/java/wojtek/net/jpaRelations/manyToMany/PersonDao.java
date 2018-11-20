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
@Table(name = "Person")
public class PersonDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column( name = "person_name", length = 20 )
    private String personName;

    @ManyToMany(mappedBy = "persons")
    private List<GrupaDao> grupyDao = new ArrayList<>();


    @Override
    public String toString(){

        return "PERSON == id: " + id + " - person_name: " + personName ;
    }

    public String showGruops(){

        StringBuilder s = new StringBuilder();
        grupyDao.forEach(x->s.append(x));
        return s.toString();
    }
}
