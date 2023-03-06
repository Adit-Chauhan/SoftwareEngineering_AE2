package softwareengineering_ae2.datastore;

import java.io.IOException;
import java.util.List;


public abstract class BaseStore<T> implements DatabaseOperations<T> {
   static private Database database;
   List<T> localData;
   protected BaseStore() throws IOException {
       if((database == null)) database = Database.getInstance();
   }

    protected FullData data(){
       return database.data();
    }
  protected void add(T val){
     localData.add(val);
   }
  protected void registerUser(DatabaseOperations<?> usr){
       database.registerUser(usr);
   }
}


interface DatabaseOperations<T>{
    List<T> getData();
    void update();

};