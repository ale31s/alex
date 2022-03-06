
package model;


public class Customer {

    private int Id;
    private String Name;
    private String Surname;
    private String Email;
    private String Nationality;
    private String Address;
    private String Category;

    public Customer(int Id, String Name, String Surname, String Email, String Nationality, String Address, String Category) {
        this.Id = Id;
        this.Name = Name;
        this.Surname = Surname;
        this.Email = Email;
        this.Nationality = Nationality;
        this.Address = Address;
        this.Category = Category;
    }



    @Override
    public String toString() {
        return "Customer{" + "Id=" + Id + ", Name=" + Name + ", Surname=" + Surname + ", Email=" + Email + ", Nationality=" + Nationality + ", Address=" + Address + ", Category=" + Category + '}';
    }

    public Customer() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }



    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
    
    
            

}
