package main.java.models;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Destination: ").append(name).append("\n");
        sb.append("Activities:\n");
        for (Activity activity : activities) {
            sb.append("- ").append(activity.getName()).append(": ")
                    .append(activity.getDescription()).append(", ")
                    .append("Cost: ").append(activity.getCost()).append(", ")
                    .append("Capacity: ").append(activity.getCapacity()).append("\n");
        }
        return sb.toString();
    }
}
