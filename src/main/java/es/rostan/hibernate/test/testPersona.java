package es.rostan.hibernate.test;

import es.rostan.hibernate.dao.personaDAO;

/**
 * Created by Rostan on 21/05/2017.
 */
public class testPersona {

    public static void main(String[] args){
        listarPersonas();
    }

    public static void listarPersonas(){
        personaDAO pd = new personaDAO();
        pd.listarPersonas();
    }
}
