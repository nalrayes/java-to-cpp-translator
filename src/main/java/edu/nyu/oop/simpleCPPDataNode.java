package edu.nyu.oop;

public class simpleCPPDataNode {

    private String type;
    private String value;

    public simpleCPPDataNode(String type, String value){
        this.type = type;
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.type + " = " + this.value;
    }
}
