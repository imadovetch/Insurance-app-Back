package com.programming.techie.Services;

import com.programming.techie.Dao.JpaDao;
import com.programming.techie.Model.Assurance;
import com.programming.techie.Model.AssuranceAutomobile;
import com.programming.techie.Model.Certif;
import org.springframework.stereotype.Component;


@Component
public class CertifService {
    private JpaDao<Assurance> AutomobileDao = new JpaDao<>(Assurance.class); ;

    private JpaDao<Certif> daoCertif = new JpaDao<>(Certif.class); ;
    public int  addCertif(String path, String asid){
        Certif certif = new Certif();
        certif.setPath(path);

        certif.setAssurance(AutomobileDao.findById(Long.valueOf(asid)));
        daoCertif.save(certif);
        return 0;
    }

}
