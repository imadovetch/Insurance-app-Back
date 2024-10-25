package com.programming.techie.Services;

import com.programming.techie.Dao.JpaDao;
import com.programming.techie.Model.AssuranceAutomobile;
import com.programming.techie.Model.AssuranceHabitation;
import com.programming.techie.Model.AssuranceSante;
import com.programming.techie.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AssuranceService {

    private JpaDao<AssuranceAutomobile> AutomobileDao = new JpaDao<>(AssuranceAutomobile.class); ;

    private JpaDao<AssuranceHabitation> HabitationDao  = new JpaDao<>(AssuranceHabitation.class); ;

    private JpaDao<AssuranceSante> SanteDao = new JpaDao<>(AssuranceSante.class);   ;
    private JpaDao<AssuranceAutomobile> assuranceAutomobileDao;
    private JpaDao<AssuranceHabitation> assuranceHabitationDao;
    private JpaDao<AssuranceSante> assuranceSanteDao;

    public AssuranceService() {
        this.assuranceAutomobileDao = new JpaDao<>(AssuranceAutomobile.class);
        this.assuranceHabitationDao = new JpaDao<>(AssuranceHabitation.class);
        this.assuranceSanteDao = new JpaDao<>(AssuranceSante.class);
    }

    public Map<String, List<?>> getAssurancesOfUser(Long userId) {
        Map<String, List<?>> assurancesMap = new HashMap<>();

        List<AssuranceAutomobile> automobileAssurances = assuranceAutomobileDao.fetchByUserId("user.id", userId);
        assurancesMap.put("AssuranceAutomobile", automobileAssurances);

        List<AssuranceHabitation> habitationAssurances = assuranceHabitationDao.fetchByUserId("user.id", userId);
        assurancesMap.put("AssuranceHabitation", habitationAssurances);
// get
        List<AssuranceSante> santeAssurances = assuranceSanteDao.fetchByUserId("user.id", userId);
        assurancesMap.put("AssuranceSante", santeAssurances);

        return assurancesMap;
    }
    public void addAssuranceAutomobile(AssuranceAutomobile user) {
        AutomobileDao.save(user); // Save new user
    }
    public void addAssuranceHabitation(AssuranceHabitation user) {
        HabitationDao.save(user); // Save new user
    }
    public void addAssuranceSante(AssuranceSante user) {
        SanteDao.save(user); // Save new user
    }
}
