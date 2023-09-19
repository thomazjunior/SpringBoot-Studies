package com.studies.springdesingpatterns.FactoryPattern;

import java.util.EnumMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public @interface BetterWay {

    public enum AnimalType {
        CAT,
        DOG,
        ;
    }

    public interface Animal {
        AnimalType getType();

        String makeNoise();
    }

    @Component
    public class Cat implements Animal {

        @Override
        public AnimalType getType() {
            return AnimalType.CAT;
        }

        @Override
        public String makeNoise() {
            return "Meow!";
        }
    }

    @Component
    public class Dog implements Animal {

        @Override
        public AnimalType getType() {
            return AnimalType.DOG;
        }

        @Override
        public String makeNoise() {
            return "Bark!";
        }
    }

    @Component
    public class AnimalFactory {

        private EnumMap<AnimalType, Animal> animalsMap;

        @Autowired
        public AnimalFactory(List<Animal> animals) {
            this.animalsMap = new EnumMap<>(AnimalType.class);
            for (Animal animal : animals) {
                this.animalsMap.put(animal.getType(), animal);
            }
        }

        public Animal getAnimal(AnimalType animalType) {
            return this.animalsMap.get(animalType);
        }
    }
}
