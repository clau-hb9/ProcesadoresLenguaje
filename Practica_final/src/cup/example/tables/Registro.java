package cup.example.tables;

import java.util.ArrayList;

public class Registro {

    private String name;
    private ArrayList<String> fields;
    private String scope;

    public Registro(String name, ArrayList<String> fields, String scope) {
        this.name = name;
        this.fields = fields;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getFields() {
        return fields;
    }

    public void setFields(ArrayList<String> fields) {
        this.fields = fields;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
    
    public String toString() {
        return name + fields.toString();
    }
}