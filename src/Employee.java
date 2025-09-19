public class Employee {
    private int srNo;

    private String name;



    private String department;

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSrNo() {
        return srNo;
    }

    public String getName() {
        return name;
    }

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", srNo=" + srNo +
                '}';
    }

}
