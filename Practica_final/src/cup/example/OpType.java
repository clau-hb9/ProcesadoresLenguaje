package cup.example;

public enum OpType {
    INT(0), 
    REAL(0.0), 
    BOOL(false), 
    CHAR(0), 
    VAR(null);

    private final Object initialValue;

    public Object getInitialValue() {
        return this.initialValue;
    }

    private OpType(Object initialValue) {
        this.initialValue = initialValue;
    }
}