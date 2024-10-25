import com.programming.techie.Dao.JpaDao;

import com.programming.techie.Model.AssuranceAutomobile;
import com.programming.techie.Model.AssuranceHabitation;
import com.programming.techie.Model.AssuranceSante;
import com.programming.techie.Model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        JpaDao<AssuranceAutomobile> assuranceAutomobileDao = new JpaDao<>(AssuranceAutomobile.class);
        JpaDao< AssuranceHabitation> assuranceHabitationDao = new JpaDao<>(AssuranceHabitation.class);
        JpaDao<AssuranceSante> assuranceSanteDao = new JpaDao<>(AssuranceSante.class);



            Map<String, List<?>> assurancesMap = new HashMap<>();

            List<AssuranceAutomobile> automobileAssurances = assuranceAutomobileDao.fetchByUserId("user.id", 1L);
            assurancesMap.put("AssuranceAutomobile", automobileAssurances);

            List<AssuranceHabitation> habitationAssurances = assuranceHabitationDao.fetchByUserId("user.id", 1L);
            assurancesMap.put("AssuranceHabitation", habitationAssurances);

            List<AssuranceSante> santeAssurances = assuranceSanteDao.fetchByUserId("user.id", 1L);
            assurancesMap.put("AssuranceSante", santeAssurances);

        System.out.println(assurancesMap.toString());
        }


    }

