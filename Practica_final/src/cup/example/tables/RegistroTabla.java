package cup.example.tables;

import java.util.*;

import cup.example.SemanticException;


/* Almacenamiento de las variables de tipo vector */
public class RegistroTabla {

    private HashMap<String, Registro> registries;

    public RegistroTabla() {
        this.registries = new HashMap<String, Registro>();
    }

    public void insert(String name, String[] types, String scope) throws SemanticException {
        if (find(name + "," + scope) != null) {
            throw new SemanticException("Vector " + name + " has already been declared in " + scope + " scope");
        }
        ArrayList<String> fields_ = new ArrayList<>();
        for (int i = 0; i < types.length; i++) {
            String[] values = types[i].split(",");
            for (int j = 1; j < values.length; j++) {
                String fieldName = values[j];
                if (fields_.stream().anyMatch(f -> f.split("-")[1].equals(fieldName))) {
                    throw new SemanticException("You cannot define two fields with the same name in the same Vector : " + name + "." + fieldName);
                }
                fields_.add(values[0] + "-" + fieldName);
            }
        }
        this.registries.put(name + "," + scope, new Registro(name, fields_, scope));
    }

    public Registro find(String key) {
        return this.registries.get(key);
    }

    public void resetScope(String scope) {
        Iterator<String> it = registries.keySet().iterator();
        while (it.hasNext()) {
            String variable = it.next();
            if (registries.get(variable).getScope().equals(scope)) {
                it.remove();
            }
        }
    }

    public void reset() {
        this.registries.clear();
    }

    public void show() {
        System.out.println("\n<< TABLA DE REGISTROS >>");
        this.registries.entrySet().forEach(registry -> {
            System.out.println(registry.getValue());  
        });
    }
    
}