package interview.java8.lessons.suleimanov;

import java.util.List;

public class StreamAPI {

	public static void main(String[] args) {
		doDemo();
	}

	private static void doDemo() {
		 //List<Specialist> specialists = OldApproachUtil.getSpecialists();
        List<Specialist> specialists = StreamApproachUtil.getSpecialists();

        // Filter
//        List<Specialist> engineers = OldApproachUtil.filterBySpecialty(specialists, Specialty.ENGINEER);
//        List<Specialist> engineers = StreamApproachUtil.filterBySpecialty(specialists, Specialty.ENGINEER);
//        StreamApproachUtil.printSpecialists(engineers);	
        
        // Sorting
//        List<Specialist> sortedSpecialistsAsc = StreamApproachUtil.sortSpecialistsByNameAsc(specialists);
//        List<Specialist> sortedSpecialistsDesc = StreamApproachUtil.sortSpecialistsByNameDesc(specialists);
//        StreamApproachUtil.printSpecialists(sortedSpecialistsAsc);
//        StreamApproachUtil.printSpecialists(sortedSpecialistsDesc);
        
//        // Max salary
//        Specialist withMaxSalary = StreamApproachUtil.findWithMaxSalary(specialists);
//        System.out.println(withMaxSalary);
//        // Min salary
//        Specialist withMinSalary = StreamApproachUtil.findWithMinSalary(specialists);
//        System.out.println(withMinSalary);
        
        // Grouping
//        Map<Specialty, List<Specialist>> groupedBySpecialty = StreamApproachUtil.groupBySpecialty(specialists);
//        System.out.println(groupedBySpecialty);
        
        // All engineers
//        List<Specialist> engineers = StreamApproachUtil.groupBySpecialty(specialists).get(Specialty.ENGINEER);
//        boolean isAllEngineers = OldApproachUtil.matchAllEngineers(specialists);
//        boolean isAllEngineers = StreamApproachUtil.matchAllEngineers(specialists);
//        System.out.println(isAllEngineers);
        
        // Has any engineers
//        boolean hasAnyEngineer = OldApproachUtil.matchAnyEngineer(specialists);
        boolean hasAnyEngineer = OldApproachUtil.matchAnyEngineer(specialists);
        System.out.println(hasAnyEngineer);
	}
	
}



















