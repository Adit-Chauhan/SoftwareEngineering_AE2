package softwareengineering_ae2.datastore;

import java.io.IOException;
import java.util.List;

// Base Class that is to be extended by all subclasses
public abstract class BaseStore<T>  {
    // Keep a static copy of Database class
    static private Database database;
    // Local copy of the database to prevent unnecessary R/W operations
    List<T> localData;

    protected BaseStore() throws IOException {
        if ((database == null)) database = Database.getInstance(this);
    }

    //  expose the data method of database class
    protected FullData data() {
        return database.data();
    }
    // Add new Value to local Database
    public abstract void add(T val);

    // Get relevant Data
    public abstract List<T> getData();

    // Update main copy with local copies
    public abstract void update();
}