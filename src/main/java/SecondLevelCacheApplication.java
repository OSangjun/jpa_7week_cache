import entity.Member;
import entity.Team;
import org.ehcache.CacheManager;

import javax.persistence.*;
import java.util.List;

public class SecondLevelCacheApplication {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("l2test");
        Cache cache = emf.getCache();
        System.out.println("Second Level Cache Test");

        /** 최초 조회 **/
        EntityManager em1 = emf.createEntityManager();
        System.out.println("========> Query 조회");
        em1.createNamedQuery("findTeenager").setHint("org.hibernate.cacheable", true).getResultList();
        em1.close();



        /** 2 번째 조회 **/
        EntityManager em2 = emf.createEntityManager();
        System.out.println("========> Query 재조회");
        em2.createNamedQuery("findTeenager").setHint("org.hibernate.cacheable", true).getResultList();
        em2.close();
    }
}
