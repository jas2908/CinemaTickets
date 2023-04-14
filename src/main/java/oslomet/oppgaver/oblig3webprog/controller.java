package oslomet.oppgaver.oblig3webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class controller {
    @Autowired
    private KundeRepository rep;


    @PostMapping("/lagre")
    public void lagreBillett(Billett enBillett){
        rep.lagreBillett(enBillett);
    }
    @GetMapping("/hentAlle")
    public List<Billett> hentAlle(){
        return rep.hentAlle();
    }
    @GetMapping("/slettAlle")
    public void slettAlle(){
        rep.slettAlle();
    }
}
