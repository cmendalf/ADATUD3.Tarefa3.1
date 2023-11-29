package clases;

import org.hibernate.Session;

/**
 *
 * @author node
 */
/*
a) Crea un método que reciba o nome dun departamento e o insira na base de datos.
b) Crea un método que reciba un obxecto empregado e o insira na base de datos.
c) Crea un método que reciba o nss dun empregado e visualice os seus datos.
d) Crea un método que reciba o número dun departamento e o borre da base de datos.
e) Crea un método que reciba o número dun departamento e un nome, e cambie o nome do departamento
polo nome do parámetro introducido.
 */
public class Operaciones {

    private static Session sesion;
    //Abrir y cerrar sesión 

    public static void abrirSesion() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    public static void cerrarSesion() {
        sesion.close();
        HibernateUtil.getSessionFactory().close();
    }

    public static void addDepartmento(int idDepa, String nombreDepa) {
        Departamento depa = new Departamento(idDepa, nombreDepa);
        sesion.beginTransaction();
        sesion.save(depa);
        sesion.getTransaction().commit();
    }

    public static void addEmpregado(Empregado emp) {
        sesion.beginTransaction();
        sesion.save(emp);
        sesion.getTransaction().commit();
    }

    public static String verEmpregado(String idEmp) {
        StringBuilder sb = new StringBuilder();
        sesion.beginTransaction();
        Empregado empregado = (Empregado) sesion.get(Empregado.class, idEmp);
        sesion.getTransaction().commit();
        return sb.toString(); 
    }
    //

}
