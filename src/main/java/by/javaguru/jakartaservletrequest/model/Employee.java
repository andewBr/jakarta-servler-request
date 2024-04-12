package by.javaguru.jakartaservletrequest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee{
    public String id;
    public String name;
    public int salary;
    public int tax;
}
