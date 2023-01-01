package com.rajendra.foodapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.rajendra.foodapp.MaBaseSQLite;

public class Dbuser {
    // Attributs
    private static final int VERSION_BDD = 4;
    private static final String NOM_BDD = "Bis2.db";

    private static final String TABLE_USER = "table_user";
    private static final String COL_First_Name = "Firstname";
    private static final int NUM_COL_First_Name = 1;
    private static final String COL_Last_Name = "Lastname";
    private static final int NUM_COL_Last_Name = 2;
    private static final String COL_PHONENUMBER = "phoneNumber";
    private static final int NUM_COL_PHONENUMBER = 3;
    private static final String COL_Password = "password";
    private static final int NUM_COL_Password = 4;


    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;

    public Dbuser(Context context){
        //On créer la BDD et sa table
        maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();

        //bdd = maBaseSQLite.getReadableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD() {
        return bdd;
    }

    public long insertUser(User user) {
        //Création d'un ContentValues
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_First_Name, user.getFirstName());
        values.put(COL_Last_Name, user.getLastName());
        values.put(COL_PHONENUMBER, user.getPhoneNumber());
        values.put(COL_Password, user.getPassword());
        //on insère l'objet dans la BDD via le ContentValues
        long res = bdd.insert(TABLE_USER, null, values);
        return res;
    }
    public int getUserWithlog(String phoneNumber, String password){
        //Récupère dans un Cursor les valeur correspondant à un etudiant contenu dans la BDD (ici on sélectionne le etudiant grâce à son prenom)
        Cursor z = bdd.rawQuery("select * from "+TABLE_USER+" where phoneNumber='"+phoneNumber+"' and password='"+password+"'", new String[] { });
        return z.getCount();
    }


}
