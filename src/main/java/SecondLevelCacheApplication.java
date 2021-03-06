import entity.Member;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SecondLevelCacheApplication {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("l2test");
        Cache cache = emf.getCache();
        System.out.println("Second Level Cache Test");

        String name = "joy";

        /** 최초 조회 **/
        EntityManager em1 = emf.createEntityManager();
        System.out.println("========>최초 조회 - L2 cache contains " + name + " : " + cache.contains(Member.class, name));
        Member joy = em1.find(Member.class, "joy");
        em1.close();

        System.out.println(joy.toString());


        /** 2 번째 조회 **/
        EntityManager em2 = emf.createEntityManager();
        System.out.println("========>2 번째 조회 - L2 cache contains " + name + " : " + cache.contains(Member.class, name));
        joy = em2.find(Member.class, "joy");
        em2.close();

        System.out.println(joy.toString());
    }
}
