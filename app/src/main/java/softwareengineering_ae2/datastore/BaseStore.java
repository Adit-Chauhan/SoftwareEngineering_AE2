package softwareengineering_ae2.datastore;

import java.io.IOException;
import java.util.List;

// Base Class that is to be extended by all subclasses
public abstract class BaseStore<T> implements DatabaseOperations<T> {
    // Keep a static copy of Database class
   static private Database database;
   // Local copy of the database to prevent unnecessary R/W operations
   List<T> localData;
   // May need fixing
   protected BaseStore() throws IOException {
       if((database == null)) database = Database.getInstance();
   }
    //  expose the data method of database class
    protected FullData data(){
       return database.data();
    }

    // Add new Value to local Database
  protected void add(T val){
     localData.add(val);
   }
   // expose register user of database
  protected void registerUser(DatabaseOperations<?> usr){
       database.registerUser(usr);
   }
}


interface DatabaseOperations<T>{
    // Get relevant Data
    List<T> getData();
    // Update main copy with local copies
    void update();

};