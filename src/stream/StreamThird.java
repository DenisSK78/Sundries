package stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamThird {
    public static void main(String[] args) {



    }

    static Map<IEmployee, List<IDepartment>> depByChief(ICompany iCompany){
        return iCompany
                .departments()
                .collect(Collectors.groupingBy(IDepartment::chef));
    }

    static Map<IEmployee, List<String>> depNameByChief(ICompany iCompany){
        return iCompany
                .departments()
                .collect(Collectors.groupingBy(
                        IDepartment::chef,
                        Collectors.mapping(IDepartment::title, Collectors.toList())));
    }
}

interface IEmployee {
    String name();
}

interface IDepartment {
    String title();
    IEmployee chef();
    Stream<IEmployee> employees();
}

interface ICompany {
    Stream<IDepartment> departments();
}
