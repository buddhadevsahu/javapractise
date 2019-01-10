package bernard.java8.practices;

public class Dish {

    private final String name;
    private final boolean vegiterian;
    private final int calories;
    private final Type type;

    public Dish(String name,boolean veg,int cal, Type type){
        this.name=name;
        this.vegiterian=veg;
        this.calories=cal;
        this.type=type;
    }

    public enum Type{
        MEAT,FISH,OTHER
    }

    public String getName() {
        return name;
    }

    public boolean isVegiterian() {
        return vegiterian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegiterian=" + vegiterian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }
}
