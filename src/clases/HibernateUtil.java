
package clases;

import com.mysql.cj.xdevapi.SessionFactory;
import javax.security.auth.login.Configuration;
import org.hibernate.*;


/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author node
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
