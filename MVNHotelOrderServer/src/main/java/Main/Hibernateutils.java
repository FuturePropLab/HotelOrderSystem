package Main;
    import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;
 
	public class Hibernateutils {
        private static SessionFactory sessionFactory;
        static {
            try {
            	Configuration cfg = new Configuration().configure();
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(cfg.getProperties()).build();
                 sessionFactory = cfg
                        .buildSessionFactory(serviceRegistry);
//            	sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
               
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }
        public static SessionFactory getSessionFactory() {
            // Alternatively, you could look up in JNDI here
            return sessionFactory;
        }
        public static void shutdown() {
            // Close caches and connection pools
            getSessionFactory().close();
        }
    }
