package cl.dany.prueba2.models;

import com.orm.SugarRecord;

public class Place extends SugarRecord {

    private String name,description;
    private float ranking;
    private boolean visited;

    public Place(String name, String description, int ranking, boolean visited) {
        this.name = name;
        this.description = description;
        this.ranking = ranking;
        this.visited = visited;
    }

    public Place() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
