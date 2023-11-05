package project.service.criteria;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import project.entity.TaskEntity;
import project.entity.UserEntity;
import project.service.interfaces.DAO;

import java.time.LocalDate;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class searchByCriteria {
    public static List<UserEntity> personCriteria(UserEntity search) {
        Session session = DAO.openSessionAndTransaction();
        Criteria criteria = session.createCriteria(UserEntity.class, "ue");

        List list;

        if (isNotBlank(search.getName())) {
            criteria.add(Restrictions.eq("name", search.getName()));
        }
        if (nonNull(search.getSex())) {
            criteria.add(Restrictions.eq("sex", search.getSex()));
        }
        if (nonNull(search.getDateOfBirth())) {
            criteria.add(Restrictions.between("dateOfBirth", LocalDate.parse("1982-08-12"), LocalDate.parse("2010-11-12")));
        }

        list = criteria.list();

        DAO.closeSessionAndTransaction(session);
        return list;
    }

    public static List<UserEntity> getByTaskCriteria(TaskEntity search) {
        Session session = DAO.openSessionAndTransaction();
        Criteria criteria = session.createCriteria(UserEntity.class, "ue");
        Criteria criteriaPhone = criteria.createCriteria("ue.entityList", "pt");

        List list;

        if (nonNull(search.getStatus())) {
            criteriaPhone.add(Restrictions.eq("te.status", search.getStatus()));
        }
        if (isNotBlank(search.getTaskName())) {
            criteriaPhone.add(Restrictions.eq("te.taskName", search.getTaskName()));
        }
        list = criteria.list();
        DAO.closeSessionAndTransaction(session);
        return list;
    }
}
