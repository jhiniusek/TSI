package Animal_Factory;
public class AnimalFactory {

    public static Animal createAnimal(String animalRequired) {
        if(animalRequired.equals("Dog")) {
            return new Dog();
        }
        if(animalRequired.equals("Cat")){
            return new Cat();
        }
        if(animalRequired.equals("Mouse")) {
            return new Mouse();
        } else {
            return new Snake();
        }
    }
}
