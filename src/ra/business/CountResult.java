package ra.business;

public class CountResult {
    private String typeName;
    private int total;

    public CountResult() {
    }

    public CountResult(String typeName, int total) {
        this.typeName = typeName;
        this.total = total;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void print() {
        System.out.println(typeName + " : " + total);
    }
}
