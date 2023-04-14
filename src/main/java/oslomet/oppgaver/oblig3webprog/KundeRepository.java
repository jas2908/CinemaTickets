package oslomet.oppgaver.oblig3webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Repository
public class KundeRepository {
    @Autowired
    private JdbcTemplate db;

    public void lagreBillett(Billett enBillett){
        String sql= "INSERT INTO Billett (kino, antall, fornavn, etternavn, telefonnr, epost) VALUES(?,?,?,?,?,?)";
        db.update(sql,enBillett.getKino(),enBillett.getAntall(),enBillett.getFornavn(),
                enBillett.getEtternavn(),enBillett.getTelefonnr(),enBillett.getEpost());
    }

    public List<Billett> hentAlle(){
        String sql ="SELECT * FROM Billett";

        List<Billett> billetter= db.query(sql,new BeanPropertyRowMapper(Billett.class));
        Comparator<Billett> sortByEtternavn=
                Comparator.comparing(Billett::getEtternavn);
        Collections.sort(billetter,sortByEtternavn);
        return billetter;
    }

    public void slettAlle(){
        String sql="DELETE FROM Billett";
        db.update(sql);
    }
}
