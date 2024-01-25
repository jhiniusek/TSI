public class Shape {
    // 0 = null; 1 = square; 2 = rectangle; 3 = triangle; 4 = trapezium; 5 = circle piece
    int value = 0;
    double base = 0d;
    double base2 = 0d;
    double height = 0d;
    double degree = 0d;
    String color = " ";

    boolean wall = true;
    Integer wallIndex = null;

    public void setColor(String x){
        color = x;
    }
    public void setWallIndex(Integer x) {
        wallIndex = x;
    }
    public String getShape(){
        switch(value){
            case 1 -> {return "Square";}
            case 2 -> {return "Rectangle";}
            case 3 -> {return "Triangle";}
            case 4 -> {return "Trapezium";}
            case 5 -> {return "Circle piece";}
            default -> {return "";}
        }
    }
    public String getColor(){
        return color;
    }
    public double calculateArea(){
        double area = 0d;
        switch(value){
            case 1 -> {area = base * base;}
            case 2 -> {area = base * height;}
            case 3 -> {area = base * height / 2;}
            case 4 -> {area = (base + base2) * height / 2;}
            case 5 -> {area = (base * base * 3.14) * (degree / 360);}
            default -> {area = 0d;}
        }
        return area;
    }

    public boolean isWall(){
        return wall;
    }

    public String getMeasurements(){
        switch(value){
            case 1 -> {
                String x = "base: ";
                return(x + base);
            }
            case 2,3 -> {
                String x = "base: ";
                String y = " height: ";
                return(x + base + y + height);
            }
            case 4 -> {
                String x = "base1: ";
                String y = " base2: ";
                String z = " height: ";
                return(x + base + y + base2 + z + height);
            }
            case 5 -> {
                String x = "radius: ";
                String y = " degrees: ";
                return(x + base + y + degree);
            }
            default -> {return "not a shape";}
        }
    }

}