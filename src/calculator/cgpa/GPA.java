package calculator.cgpa;

public class GPA {
    private String name;
    private double result;
    private double credit;

    public GPA(String name, double result, double credit) {
        this.name = name;
        this.result = result;
        this.credit = credit;
    }

    //<editor-fold defaultstate="collapsed" desc=" Getter-Setter Codes ">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
    //</editor-fold>
}
