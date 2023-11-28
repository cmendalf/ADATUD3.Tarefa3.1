/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import org.hibernate.Session;

/**
 *
 * @author node
 */
public class Main {

    public static void main(String[] args) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();

        Departamento departamento = (Departamento) sesion.get(Departamento.class, 1);
        System.out.println(departamento.getNomeDepartamento());

        sesion.getTransaction().commit();
        sesion.close();
        HibernateUtil.getSessionFactory().close();
    }
}
