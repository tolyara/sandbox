package interview.streamAPI.letsCode.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString(of = {"id", "child"})
public class Department {

	private int id;
    
    private int parent;
    
    private String name;

    private Set<Department> child = new HashSet<>();

	public Department(int id, int parent, String name) {
		this.id = id;
		this.parent = parent;
		this.name = name;
	} 
    
	
}
