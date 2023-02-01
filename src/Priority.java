abstract class Priority {
    protected String name;
    protected String color;

    @Override
    public String toString() {
        return  name;
    }
}

class PriorityLight extends Priority {
    PriorityLight(){
        super.name = "Low priority";
        super.color = "Blue";
    }
}

class PriorityMedium extends Priority {
    PriorityMedium(){
        super.name = "Medium priority";
        super.color = "Yellow";
    }
}

class PriorityHigh extends Priority {
    PriorityHigh(){
        super.name = "High priority";
        super.color = "Red";
    }

}
