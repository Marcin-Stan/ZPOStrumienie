package Zad1;

public class Person
{
    private String name;
    private String surname;
    private  String country;
    private int pension;

    public Person(String name, String surname, String country, int pension) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.pension = pension;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getCountry() {
        return country;
    }
    public int getPension() {
        return pension;
    }

    @Override
    public String toString() {
        return  name +" "+ surname+" " +country +" "+ pension ;
    }
}

