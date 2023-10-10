package interview.livecoding.fintex;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModelExample {

    public static void main(String[] args) {
        List<Model> models = List.of(
                new Model(List.of(new SubModel(1, "111"), new SubModel(2, "222"))),
                new Model(List.of(new SubModel(3, "333"), new SubModel(4, "444"), new SubModel(5, "555")))
        );

        Map<Integer, SubModel> subModelMap = models.stream().flatMap(m -> m.getSubModels().stream()).collect(Collectors.toMap(sm -> sm.getId(), sm -> sm, (sm1, sm2) -> sm1));
        subModelMap.forEach((k, v) -> {
            System.out.println("key - " + k + ", value - " + v);
        });
    }

}

class Model {

    List<SubModel> subModels;

    public Model(List<SubModel> subModels) {
        this.subModels = subModels;
    }

    public List<SubModel> getSubModels() {
        return subModels;
    }

    public void setSubModels(List<SubModel> subModels) {
        this.subModels = subModels;
    }
}

class SubModel {

    private int id;

    private String name;

    public SubModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
