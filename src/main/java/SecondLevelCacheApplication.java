import entity.Member;
import entity.Team;
import org.ehcache.CacheManager;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SecondLevelCacheApplication {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("l2test");
        Cache cache = emf.getCache();
        System.out.println("Second Level Cache Test");

        String name = "joy";
        /** 최초 조회 **/
        EntityManager em1 = emf.createEntityManager();
        List<Member> members = em1.createQuery("select m from Member m")
                                    .setHint("org.hibernate.cacheable", true).getResultList();
        em1.close();

        /** 2 번째 조회 **/
        EntityManager em2 = emf.createEntityManager();
        System.out.println("========>2 번째 조회 - L2 cache contains " + name + " : " + cache.contains(Member.class, name));
        Member joy = em2.find(Member.class, "joy");
        em2.close();


        System.out.println(joy.toString());
    }
}
