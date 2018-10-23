package com.prdx.admin.repo.custom.impl;
/*package com.prdx.web.repo.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.ktb.anyid.adjust.portal.bean.MenuBean;
import com.ktb.anyid.adjust.portal.constant.DBConstants;
import com.ktb.anyid.adjust.portal.repo.builder.SqlMenuBuilder;
import com.ktb.anyid.adjust.portal.repo.custom.MenuCustom;

@Repository
public class MenuCustomImpl implements MenuCustom {

    @PersistenceContext(unitName = DBConstants.EDNS_UNIT)
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	@Override
    public List<MenuBean> getMenuList() {
        Query nativeQuery = entityManager.createNativeQuery(SqlMenuBuilder.sqlGetMenuList()).unwrap(Query.class);
        nativeQuery.setResultTransformer(Transformers.aliasToBean(MenuBean.class));
        return (List<MenuBean>) nativeQuery.list();
    }
    
}*/